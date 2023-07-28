package kz.ST6.repositories;

import java.util.List;
import kz.ST6.models.AppRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<AppRequest, Long> {

  @Query("select a from AppRequest a where a.handled = false")
  List<AppRequest> newreq();

  @Query("select a from AppRequest a where a.handled = true")
  List<AppRequest> oldreq();

  @Query("select a from AppRequest a "
      + "where a.userName ilike concat('%', :search, '%') "
      + "or a.comments ilike concat('%', :search, '%') "
      + "or a.phone ilike concat('%', :search, '%') ")
  List<AppRequest> search(String search);

}
