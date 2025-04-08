package com.emerald.api.user;

import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // user is keyword and causes issues
public class User {

  @Id private @GeneratedValue Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email_address")
  private String emailAddress;

  User() {}

  public User(String firstName, String lastName, String emailAddress) {

    this.emailAddress = emailAddress;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getEmailAddress() {
    return this.emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getName() {
    return this.firstName + " " + this.lastName;
  }

  public void setName(String name) {
    String[] names = name.split(" ");
    this.firstName = names[0];
    this.lastName = names[0];
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }
    if (!(o instanceof User user)) {
      return false;
    }

    return Objects.equals(this.id, user.id)
        && Objects.equals(this.firstName, user.firstName)
        && Objects.equals(this.lastName, user.lastName)
        && Objects.equals(this.emailAddress, user.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.firstName, this.lastName, this.emailAddress);
  }

  @Override
  public String toString() {
    return "User{"
        + "id="
        + this.id
        + ", firstName='"
        + this.firstName
        + '\''
        + ", lastName='"
        + this.lastName
        + '\''
        + ", email='"
        + this.emailAddress
        + '\''
        + '}';
  }
}
