package com.example.plantproj;



public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int score;


    public User(String input_first, String input_last, String input_email, String input_password) {
        this.firstName = input_first;
        this.lastName = input_last;
        this.email = input_email;
        this.password = input_password;
        this.score = 0;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }



    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setScore(int score) {
        this.score = score;
    }




}
