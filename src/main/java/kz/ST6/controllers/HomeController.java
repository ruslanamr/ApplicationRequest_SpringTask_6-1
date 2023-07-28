package kz.ST6.controllers;

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
    model.addAttribute("requests", requestService.getRequests());
    return "home";
  }

  @PostMapping("/addrequest")
  public String addrequest(AppRequest request) {
    requestService.addRequest(request);
    return "redirect:/";
  }

  @GetMapping("/details/{id}")
  public String details(@PathVariable Long id, Model model) {
    model.addAttribute("details", requestService.getRequestById(id));
    return "details";
  }

  @PostMapping("/delerequest/{id}")
  public String deletequest(@PathVariable Long id) {
    requestService.deleteRequestById(id);
    return "redirect:/";
  }

  @PostMapping("/obrabotka/{id}")
  public String obrabotka(@PathVariable Long id) {
    AppRequest appRequest = requestService.getRequestById(id);
    appRequest.setHandled(true);
    requestService.addRequest(appRequest);
    return "redirect:/";
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
