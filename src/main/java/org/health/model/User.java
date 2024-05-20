package org.health.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name")
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private String name;

  @Column(name = "surname")
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private String surname;

  @Column(name = "email")
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private String email;

  @Column(name = "password")
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private String password;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = true)
  private List<Dependent> dependents = new ArrayList<>();

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public List<Dependent> getDependents() {
    return dependents;
  }

  public void setDependents(List<Dependent> dependents) {
    this.dependents = dependents;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}