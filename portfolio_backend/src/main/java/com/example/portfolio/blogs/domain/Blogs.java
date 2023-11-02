package com.example.portfolio.blogs.domain;

import com.example.portfolio.comments.domain.Comments;
import com.example.portfolio.user.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blogs {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "blogs_generator"
    )
    @SequenceGenerator(
            name="blogs_generator",
            sequenceName = "blogs_seq",
            allocationSize=5
    )
    private Long blogId;

    private String blogTitle;

    private Date publishDate;

    @Column(
            length = 3000
    )
    private String content;

    @OneToMany(
            mappedBy = "blog" ,
            cascade =  CascadeType.ALL
    )
    @JsonIgnore
    private List<Comments> commentsList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(
            name = "author" ,
            referencedColumnName = "userId"
    )

    private User author;

    private List<String> codingLanguage;

    @JsonIgnore
    private boolean isActive = true;

}
