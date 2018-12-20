package com.codefellowship.codefellowship;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  long id;
private String firstname;
private String lastname;
private Date dateOfBirth;
private String username;
private String password;
private String bio;

public ApplicationUser() {
}

    public ApplicationUser(String firstname, String lastname, Date dateOfBirth, String username, String password, String bio){
         this.firstname = firstname;
         this.lastname = lastname;
         this.dateOfBirth = dateOfBirth;
         this.username = username;
         this.password = password;
         this.bio = bio;
    }

}
