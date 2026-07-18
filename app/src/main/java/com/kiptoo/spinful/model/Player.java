package com.kiptoo.spinful.model;

import java.io.Serializable;

public class Player implements Serializable {
    private String id; // local session id or user id if logged in
    private String name;
    private String avatarUrl; // Optional
    private int score;
    private boolean isActive;

    // Required empty constructor for Firebase
    public Player() {
    }

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
        this.score = 0;
        this.isActive = true;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public void addScore(int points) {
        this.score += points;
    }
}