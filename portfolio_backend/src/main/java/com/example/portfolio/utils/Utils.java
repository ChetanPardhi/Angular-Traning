package com.example.portfolio.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Utils {

    public static final String COMMENT_TYPE_REPLY = "reply";

    public static final String COMMENT_TYPE_NEW_COMMENT = "newComment";
}
