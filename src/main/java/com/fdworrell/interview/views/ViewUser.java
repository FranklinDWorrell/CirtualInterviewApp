package com.fdworrell.interview.views;

public class ViewUser {

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

        ViewUser viewUser = (ViewUser) o;

        return userName.equals(viewUser.userName);
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }

    @Override
    public String toString() {
        return "ViewUser{" +
                "userName='" + userName + '\'' +
                '}';
    }

}
