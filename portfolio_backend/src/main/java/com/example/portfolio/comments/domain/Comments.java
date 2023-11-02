package com.example.portfolio.comments.domain;

import com.example.portfolio.blogs.domain.Blogs;
import com.example.portfolio.user.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long commentId;

    @ManyToOne
    @JoinColumn(
            name = "user",
            referencedColumnName = "userId"
    )
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "blogs" ,
            referencedColumnName = "blogId"
    )
    @JsonIgnore
    private Blogs blog;

    private String commentText;

    private String commentType;

    @JsonIgnore
    private boolean isActive = true;
}
