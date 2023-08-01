package kz.ST6.services;

import java.util.List;
import kz.ST6.models.AppRequest;
import org.springframework.stereotype.Service;

@Service
public interface RequestService {
  AppRequest addRequest(AppRequest request);
  List<AppRequest> getListRequests();
  void deleteRequest(Long id);
  AppRequest getReqById(Long id);
  AppRequest updateRequest(AppRequest request);

}
