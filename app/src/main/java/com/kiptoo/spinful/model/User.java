package com.kiptoo.spinful.model;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String email;
    private String username;
    private String avatarUrl;
    private boolean isPremium;
    private boolean isAgeVerified;
    private long createdAt;

    // Required empty constructor for Firebase
    public User() {
    }

    public User(String id, String email, String username, boolean isAgeVerified) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.isAgeVerified = isAgeVerified;
        this.isPremium = false;
        this.createdAt = System.currentTimeMillis();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public boolean isPremium() { return isPremium; }
    public void setPremium(boolean premium) { isPremium = premium; }

    public boolean isAgeVerified() { return isAgeVerified; }
    public void setAgeVerified(boolean ageVerified) { isAgeVerified = ageVerified; }

    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }
}