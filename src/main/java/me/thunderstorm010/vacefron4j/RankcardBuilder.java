package me.thunderstorm010.vacefron4j;

import java.io.IOException;

import static me.thunderstorm010.vacefron4j.Rankcard.requireNotNull;

public class RankcardBuilder {

    private String username;
    private String avatar;
    private int level;
    private int rank;
    private int currentXp;
    private int nextLevelXp;
    private int previousLevelXp;

    // Nullables
    private BackgroundResolvable customBackground = null;
    private Integer xpColor = null;
    private Boolean isBoosting = null;


    public String getUsername() {
        return username;
    }

    public RankcardBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public RankcardBuilder setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public RankcardBuilder setLevel(int level) {
        this.level = level;
        return this;
    }

    public int getRank() {
        return rank;
    }

    public RankcardBuilder setRank(int rank) {
        this.rank = rank;
        return this;
    }

    public int getCurrentXp() {
        return currentXp;
    }

    public RankcardBuilder setCurrentXp(int currentXp) {
        this.currentXp = currentXp;
        return this;
    }

    public int getNextLevelXp() {
        return nextLevelXp;
    }

    public RankcardBuilder setNextLevelXp(int nextLevelXp) {
        this.nextLevelXp = nextLevelXp;
        return this;
    }

    public int getPreviousLevelXp() {
        return previousLevelXp;
    }

    public RankcardBuilder setPreviousLevelXp(int previousLevelXp) {
        this.previousLevelXp = previousLevelXp;
        return this;
    }

    public BackgroundResolvable getCustomBackground() {
        return customBackground;
    }

    public RankcardBuilder setCustomBackground(BackgroundResolvable customBackground) {
        this.customBackground = customBackground;
        return this;
    }

    public Integer getXpColor() {
        return xpColor;
    }

    public RankcardBuilder setXpColor(Integer xpColor) {
        this.xpColor = xpColor;
        return this;
    }

    public Boolean getBoosting() {
        return isBoosting;
    }

    public RankcardBuilder setBoosting(Boolean boosting) {
        isBoosting = boosting;
        return this;
    }

    public Rankcard build() {
        requireNotNull(username,avatar,level,rank,currentXp,nextLevelXp,previousLevelXp);
        return new Rankcard(username,avatar,level,rank,currentXp,nextLevelXp,previousLevelXp,customBackground,xpColor,isBoosting);
    }
}
