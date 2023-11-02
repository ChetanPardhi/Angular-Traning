package com.example.portfolio.user.domain;

//import com.example.portfolio.blogs.domain.Blogs;
//import com.example.portfolio.comments.domain.Comments;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long userId;

    private String userName;

    private String userPassword;

    private String email;

//    @OneToMany(
//            mappedBy = "user" ,
//            cascade =  CascadeType.ALL
//    )
//    private Set<Comments> commentsList = new HashSet<>();

//    @OneToMany(
//            mappedBy = "author",
//            cascade = CascadeType.ALL
//    )
//    private Set<Blogs> blogsList = new HashSet<>();
}


