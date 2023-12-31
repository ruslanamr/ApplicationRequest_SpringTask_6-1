package kz.ST6.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import java.util.TreeSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "app_request")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AppRequest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String userName;

  @Column(columnDefinition = "TEXT")
  private String comments;
  private String phone;

  @Column(name = "handled", columnDefinition = "boolean default false")
  private boolean handled;

  @ManyToOne(fetch = FetchType.EAGER)
  private Course course;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Operator> operators;

}
