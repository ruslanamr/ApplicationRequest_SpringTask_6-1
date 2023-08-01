package kz.ST6.services.impl;

import java.util.List;
import kz.ST6.models.AppRequest;
import kz.ST6.repositories.RequestRepository;
import kz.ST6.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

  @Autowired
  private RequestRepository requestRepository;

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
}
