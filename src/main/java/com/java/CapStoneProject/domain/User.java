package com.java.CapStoneProject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class User {

    @Column(unique = true)
    private String username;
    private String password;
    @Id
    private String email;
    private String profileImageUrl;
    @ElementCollection
    private List<String> favoriteMoviesIds;

    public User() {
    }

    public User(String username, String password, String email, String profileImageUrl, List<String> favoriteMoviesIds) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.favoriteMoviesIds = favoriteMoviesIds;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public List<String> getFavoriteMoviesIds() {

        return favoriteMoviesIds;
    }

    public void setFavoriteMoviesIds(List<String> favoriteMoviesIds) {
        this.favoriteMoviesIds = favoriteMoviesIds;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", favoriteMoviesIds=" + favoriteMoviesIds +
                '}';
    }
}