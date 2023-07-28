package kz.ST6.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
  private String courseName;

  @Column(columnDefinition = "TEXT")
  private String comments;
  private String phone;
  private boolean handled;

}
