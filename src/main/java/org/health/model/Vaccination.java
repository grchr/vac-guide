package org.health.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Date;

@Entity
@Table(name = "vaccination")
public class Vaccination {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "notification_date")
  @JdbcTypeCode(SqlTypes.DATE)
  private Date notificationDate;

  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "vaccine_type_id")
  private VaccineType vaccineType;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "dependent_id")
  private Dependent dependent;

  public Dependent getDependent() {
    return dependent;
  }

  public void setDependent(Dependent dependent) {
    this.dependent = dependent;
  }

  public VaccineType getVaccineType() {
    return vaccineType;
  }

  public void setVaccineType(VaccineType vaccineType) {
    this.vaccineType = vaccineType;
  }

  public Date getNotificationDate() {
    return notificationDate;
  }

  public void setNotificationDate(Date notificationDate) {
    this.notificationDate = notificationDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}