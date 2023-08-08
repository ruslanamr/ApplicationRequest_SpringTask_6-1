package kz.ST6.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import kz.ST6.models.AppRequest;
import kz.ST6.models.Course;
import kz.ST6.models.Operator;
import kz.ST6.repositories.CoursesRepository;
import kz.ST6.repositories.OperatorsRepository;
import kz.ST6.repositories.RequestRepository;
import kz.ST6.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

  @Autowired
  private RequestRepository requestRepository;
  @Autowired
  private CoursesRepository coursesRepository;
  @Autowired
  private OperatorsRepository operatorsRepository;

  @Override
  public AppRequest addRequest(AppRequest request) {
    return requestRepository.save(request);
  }

  @Override
  public List<AppRequest> getListRequests() {
    return requestRepository.findAll();
  }

  @Override
  public void deleteRequest(Long id) {
    requestRepository.deleteById(id);
  }

  @Override
  public AppRequest getReqById(Long id) {
    return requestRepository.getOne(id);
  }

  @Override
  public AppRequest updateRequest(AppRequest request) {
    return requestRepository.save(request);
  }

  @Override
  public List<Course> getListCourses() {
    return coursesRepository.findAll();
  }

  @Override
  public List<Operator> getListOperators() {
    return operatorsRepository.findAll();
  }

  @Override
  public void processingOperators(Long id, List<Long> operatorsId) {
    List<Operator> req_operators = new ArrayList<>();
    for (Long operId : operatorsId){
      Operator operator = operatorsRepository.findById(operId).orElse(null);
      req_operators.add(operator);
    }
    AppRequest appRequest = getReqById(id);
    appRequest.setOperators(req_operators);
    updateRequest(appRequest);
  }

  @Override
  public void deleteOperator(Long requestId, Long operatorId) {
    AppRequest request = getReqById(requestId);
    Operator operator = operatorsRepository.findById(operatorId).orElse(null);
    List<Operator> operators = request.getOperators();
    operators.remove(operator);
    request.setOperators(operators);
    updateRequest(request);
    }


}
