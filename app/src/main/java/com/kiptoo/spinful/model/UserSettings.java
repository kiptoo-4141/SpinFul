package com.kiptoo.spinful.model;

import java.io.Serializable;

public class UserSettings implements Serializable {
    private String userId;
    private boolean isDarkTheme;
    private boolean soundEffectsEnabled;
    private boolean hapticFeedbackEnabled;
    private boolean safeModeEnabled; // Disables extreme categories
    private String language;

    // Required empty constructor for Firebase
    public UserSettings() {
    }

    public UserSettings(String userId) {
        this.userId = userId;
        this.isDarkTheme = true;
        this.soundEffectsEnabled = true;
        this.hapticFeedbackEnabled = true;
        this.safeModeEnabled = false;
        this.language = "en";
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public boolean isDarkTheme() { return isDarkTheme; }
    public void setDarkTheme(boolean darkTheme) { isDarkTheme = darkTheme; }

    public boolean isSoundEffectsEnabled() { return soundEffectsEnabled; }
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) { this.soundEffectsEnabled = soundEffectsEnabled; }

    public boolean isHapticFeedbackEnabled() { return hapticFeedbackEnabled; }
    public void setHapticFeedbackEnabled(boolean hapticFeedbackEnabled) { this.hapticFeedbackEnabled = hapticFeedbackEnabled; }

    public boolean isSafeModeEnabled() { return safeModeEnabled; }
    public void setSafeModeEnabled(boolean safeModeEnabled) { this.safeModeEnabled = safeModeEnabled; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
}