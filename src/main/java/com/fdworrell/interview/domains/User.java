package com.fdworrell.interview.domains;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_name")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
