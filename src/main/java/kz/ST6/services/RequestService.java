package kz.ST6.services;

import java.util.List;
import kz.ST6.models.AppRequest;
import kz.ST6.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

  @Autowired
  public RequestRepository requestRepository;

  public void addRequest(AppRequest appRequest) {
    requestRepository.save(appRequest);
  }

  public List<AppRequest> getRequests() {
    return requestRepository.findAll();
  }

  public AppRequest getRequestById(Long id) {
    return requestRepository.getReferenceById(id);
  }

  public void deleteRequestById(Long id) {
    requestRepository.deleteById(id);
  }
}
