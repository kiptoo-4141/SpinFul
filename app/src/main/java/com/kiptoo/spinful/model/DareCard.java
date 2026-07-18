package com.kiptoo.spinful.model;

import java.io.Serializable;

public class DareCard implements Serializable {
    private String id;
    private String text;
    private String category; // Mild, Spicy, Extreme, Truth, Challenge, Couple, Group
    private int difficultyLevel; // 1-5 flames
    private int timeLimitSeconds; // 0 if no time limit
    private boolean isPremium;
    private String authorId; // null if system-generated, userId if custom

    // Required empty constructor for Firebase
    public DareCard() {
    }

    public DareCard(String id, String text, String category, int difficultyLevel, int timeLimitSeconds, boolean isPremium, String authorId) {
        this.id = id;
        this.text = text;
        this.category = category;
        this.difficultyLevel = difficultyLevel;
        this.timeLimitSeconds = timeLimitSeconds;
        this.isPremium = isPremium;
        this.authorId = authorId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getDifficultyLevel() { return difficultyLevel; }
    public void setDifficultyLevel(int difficultyLevel) { this.difficultyLevel = difficultyLevel; }

    public int getTimeLimitSeconds() { return timeLimitSeconds; }
    public void setTimeLimitSeconds(int timeLimitSeconds) { this.timeLimitSeconds = timeLimitSeconds; }

    public boolean isPremium() { return isPremium; }
    public void setPremium(boolean premium) { isPremium = premium; }

    public String getAuthorId() { return authorId; }
    public void setAuthorId(String authorId) { this.authorId = authorId; }
}