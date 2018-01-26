package com.JavaTests.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private boolean lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private int password;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "roleId")
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Statistic> listStatistics = new ArrayList<>();

    public User() {
    }

    public User(String firstName, boolean lastName, String login, int password, Role role, List<Statistic> listStatistics) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = role;
        this.listStatistics = listStatistics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isLastName() {
        return lastName;
    }

    public void setLastName(boolean lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Statistic> getListStatistics() {
        return listStatistics;
    }

    public void setListStatistics(List<Statistic> listStatistics) {
        this.listStatistics = listStatistics;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", role=" + role +
                ", listStatistics=" + listStatistics +
                '}';
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//
//        User user = (User) o;
//
//        if (getId() != user.getId()) return false;
//        if (isLastName() != user.isLastName()) return false;
//        if (getPassword() != user.getPassword()) return false;
//        if (!getFirstName().equals(user.getFirstName())) return false;
//        if (!getLogin().equals(user.getLogin())) return false;
//        if (!getRole().equals(user.getRole())) return false;
//        return getListStatistics() != null ? getListStatistics().equals(user.getListStatistics()) : user.getListStatistics() == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getId();
//        result = 31 * result + getFirstName().hashCode();
//        result = 31 * result + (isLastName() ? 1 : 0);
//        result = 31 * result + getLogin().hashCode();
//        result = 31 * result + getPassword();
//        result = 31 * result + getRole().hashCode();
//        result = 31 * result + (getListStatistics() != null ? getListStatistics().hashCode() : 0);
//        return result;
//    }
}
