package org.project2.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;

    public User(){
        this.id = 0;
        this.username = "";
        this.password = "";
        this.firstname = "";
        this.lastname = "";
        this.email = "";
    }

    public User(String user,String pswrd){
        this.id = 0;
        this.username = user;
        this.password = pswrd;
        this.firstname = "";
        this.lastname = "";
        this.email = "";
    }

    public User(int id,String user,String pswrd,String firstname,String lastname,String email){
        this.id = id;
        this.username = user;
        this.password = pswrd;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }


    // Getter methods
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }



    //Setter methods

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
