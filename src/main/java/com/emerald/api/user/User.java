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

    @Id
    private @GeneratedValue Long id;
    private String name;

    @Column(name = "email_address")
    private String emailAddress;

    User() {}

    public User(String name, String emailAddress) {

        this.emailAddress = emailAddress;
        this.name = name;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        return Objects.equals(this.id, user.id) && Objects.equals(this.name, user.name)
                && Objects.equals(this.emailAddress, user.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.emailAddress);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", name='" + this.name + '\'' + ", email='"
                + this.emailAddress + '\'' + '}';
    }
}
