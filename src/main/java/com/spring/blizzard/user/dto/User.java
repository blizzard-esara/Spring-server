package com.spring.blizzard.user.dto;

public class User {
    private String id;
    private String password;
    private String phone;
    private String gender;
    private int age;
    private String email;
    private int subscription;
    private String startDate;

    public User(String id, String pw, String phone, String gender, int age, String email, int subscription, String startDate) {
        this.id = id;
        this.password = pw;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.subscription = subscription;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSubscription() {
        return subscription;
    }

    public void setSubscription(int subscription) {
        this.subscription = subscription;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
