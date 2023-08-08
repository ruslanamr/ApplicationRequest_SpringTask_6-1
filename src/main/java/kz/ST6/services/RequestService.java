package kz.ST6.services;

import java.util.List;
import java.util.TreeSet;
import kz.ST6.models.AppRequest;
import kz.ST6.models.Course;
import kz.ST6.models.Operator;


public interface RequestService {



  AppRequest addRequest(AppRequest request);
  List<AppRequest> getListRequests();
  void deleteRequest(Long id);
  AppRequest getReqById(Long id);
  AppRequest updateRequest(AppRequest request);
  List<Course> getListCourses();
  List<Operator> getListOperators();
  void processingOperators(Long id, List<Long> operatorsName);
  void deleteOperator(Long requestId, Long operatorId);

}
