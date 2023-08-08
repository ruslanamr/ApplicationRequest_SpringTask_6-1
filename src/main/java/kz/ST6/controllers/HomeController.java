package kz.ST6.controllers;

import java.util.List;
import kz.ST6.models.AppRequest;
import kz.ST6.repositories.RequestRepository;
import kz.ST6.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @Autowired
  public RequestService requestService;
  @Autowired
  public RequestRepository requestRepository;


  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("requests", requestService.getListRequests());
    return "home";
  }

  @GetMapping("/addreqform")
  public String addreqform(Model model) {
    model.addAttribute("courses", requestService.getListCourses());
    return "addreq";
  }

  @PostMapping("/addrequest")
  public String addrequest(AppRequest request) {
    requestService.addRequest(request);
    return "redirect:/";
  }

  @GetMapping("/details/{id}")
  public String details(@PathVariable Long id, Model model) {
    model.addAttribute("details", requestService.getReqById(id));
    model.addAttribute("operators", requestService.getListOperators());
    return "details";
  }

  @PostMapping("deleteoperator")
  public String deleteoperator(@RequestParam(name = "operator_id") Long operator_id,
      @RequestParam(name = "request_id") Long request_id) {
    requestService.deleteOperator(request_id, operator_id);
    return "redirect:/details/" + request_id;
  }

  @PostMapping("/delerequest/{id}")
  public String deletequest(@PathVariable Long id) {
    requestService.deleteRequest(id);
    return "redirect:/";
  }

  @PostMapping("/obrabotka/{id}")
  public String obrabotka(@PathVariable Long id,
      @RequestParam(name = "operators_name") List<Long> operators_name) {
    requestService.processingOperators(id, operators_name);
    AppRequest appRequest = requestService.getReqById(id);
    appRequest.setHandled(true);
    requestService.addRequest(appRequest);
    return "redirect:/details/" + id;
  }

  @GetMapping("/newreq")
  public String newreq(Model model) {
    model.addAttribute("requests", requestRepository.newreq());
    return "home";
  }

  @GetMapping("/oldreq")
  public String oldreq(Model model) {
    model.addAttribute("requests", requestRepository.oldreq());
    return "home";
  }

  @GetMapping("/search")
  public String search(@RequestParam(name = "search") String search, Model model) {
    model.addAttribute("requests", requestRepository.search(search));
    return "home";
  }


}
