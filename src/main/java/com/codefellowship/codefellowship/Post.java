package com.codefellowship.codefellowship;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  long id;
    private String body;
    private Date createdAt;
    public Post(){}
    public Post(String body, Date createdAt){this.body = body; this.createdAt = createdAt;}
}
