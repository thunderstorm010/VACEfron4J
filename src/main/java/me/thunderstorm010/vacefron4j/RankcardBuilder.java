/*
 * Copyright 2020 Yiğit Özdemir
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.thunderstorm010.vacefron4j;

import java.awt.Color;

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
    private Color xpColor = null;
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

    public Color getXpColor() {
        return xpColor;
    }

    public RankcardBuilder setXpColor(Color xpColor) {
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
