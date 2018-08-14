package com.example.async.hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Spring uses the Jackson JSON library to convert GitHub’s JSON response into a User object. The @JsonIgnoreProperties annotation signals Spring to ignore any attributes not listed in the class. This makes it easy to make REST calls and produce domain objects.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    private String name;
    private String blog;

    @Override
    public String toString() {
        return "User [name=" + name + ", blog=" + blog + "]";
    }
}
