package com.kiptoo.spinful.model;

import java.io.Serializable;

public class UserStats implements Serializable {
    private String userId;
    private int totalSpins;
    private int daresCompleted;
    private int daresPassed;
    private String mostCommonCategory;
    private int longestStreak;
    private int currentStreak;

    // Required empty constructor for Firebase
    public UserStats() {
    }

    public UserStats(String userId) {
        this.userId = userId;
        this.totalSpins = 0;
        this.daresCompleted = 0;
        this.daresPassed = 0;
        this.longestStreak = 0;
        this.currentStreak = 0;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public int getTotalSpins() { return totalSpins; }
    public void setTotalSpins(int totalSpins) { this.totalSpins = totalSpins; }

    public int getDaresCompleted() { return daresCompleted; }
    public void setDaresCompleted(int daresCompleted) { this.daresCompleted = daresCompleted; }

    public int getDaresPassed() { return daresPassed; }
    public void setDaresPassed(int daresPassed) { this.daresPassed = daresPassed; }

    public String getMostCommonCategory() { return mostCommonCategory; }
    public void setMostCommonCategory(String mostCommonCategory) { this.mostCommonCategory = mostCommonCategory; }

    public int getLongestStreak() { return longestStreak; }
    public void setLongestStreak(int longestStreak) { this.longestStreak = longestStreak; }

    public int getCurrentStreak() { return currentStreak; }
    public void setCurrentStreak(int currentStreak) { this.currentStreak = currentStreak; }
}