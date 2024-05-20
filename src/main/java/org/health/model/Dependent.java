package org.health.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "dependent")
public class Dependent {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "birthday")
  @JdbcTypeCode(SqlTypes.DATE)
  private Date birthday;

  @Column(name = "name")
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private String name;

  @Column(name = "surname")
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private String surname;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "dependent", orphanRemoval = true)
  private Set<Vaccination> vaccinations = new LinkedHashSet<>();

  public Set<Vaccination> getVaccinations() {
    return vaccinations;
  }

  public void setVaccinations(Set<Vaccination> vaccinations) {
    this.vaccinations = vaccinations;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}