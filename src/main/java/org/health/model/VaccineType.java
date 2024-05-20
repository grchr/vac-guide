package org.health.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "vaccine_type")
public class VaccineType {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "malady")
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private String malady;

  @Column(name = "recommended_age")
  @JdbcTypeCode(SqlTypes.INTEGER)
  private Integer recommendedAge;

  public Integer getRecommendedAge() {
    return recommendedAge;
  }

  public void setRecommendedAge(Integer recommendedAge) {
    this.recommendedAge = recommendedAge;
  }

  public String getMalady() {
    return malady;
  }

  public void setMalady(String malady) {
    this.malady = malady;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}