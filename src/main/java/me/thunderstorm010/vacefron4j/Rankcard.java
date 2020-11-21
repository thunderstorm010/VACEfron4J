package me.thunderstorm010.vacefron4j;

import me.thunderstorm010.vacefron4j.internal.Pair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static me.thunderstorm010.vacefron4j.internal.Pair.pair;

public class Rankcard {

    public Rankcard(String username, String avatar, int level, int rank, int currentXp, int nextLevelXp, int previousLevelXp) {
        requireNotNull(username,avatar,level,rank,currentXp,nextLevelXp,previousLevelXp);
        this.username = username;
        this.avatar = avatar;
        this.level = level;
        this.rank = rank;
        this.currentXp = currentXp;
        this.nextLevelXp = nextLevelXp;
        this.previousLevelXp = previousLevelXp;
    }

    public Rankcard(String username, String avatar, int level, int rank, int currentXp, int nextLevelXp, int previousLevelXp, BackgroundResolvable customBackground) {
        requireNotNull(username,avatar,level,rank,currentXp,nextLevelXp,previousLevelXp);
        this.username = username;
        this.avatar = avatar;
        this.level = level;
        this.rank = rank;
        this.currentXp = currentXp;
        this.nextLevelXp = nextLevelXp;
        this.previousLevelXp = previousLevelXp;
        this.customBackground = customBackground;
    }

    public Rankcard(String username, String avatar, int level, int rank, int currentXp, int nextLevelXp, int previousLevelXp, BackgroundResolvable customBackground, Integer xpColor) {
        requireNotNull(username,avatar,level,rank,currentXp,nextLevelXp,previousLevelXp);
        this.username = username;
        this.avatar = avatar;
        this.level = level;
        this.rank = rank;
        this.currentXp = currentXp;
        this.nextLevelXp = nextLevelXp;
        this.previousLevelXp = previousLevelXp;
        this.customBackground = customBackground;
        this.xpColor = xpColor;
    }

    public Rankcard(String username, String avatar, int level, int rank, int currentXp, int nextLevelXp, int previousLevelXp, BackgroundResolvable customBackground, Integer xpColor, Boolean isBoosting) {
        requireNotNull(username,avatar,level,rank,currentXp,nextLevelXp,previousLevelXp);
        this.username = username;
        this.avatar = avatar;
        this.level = level;
        this.rank = rank;
        this.currentXp = currentXp;
        this.nextLevelXp = nextLevelXp;
        this.previousLevelXp = previousLevelXp;
        this.customBackground = customBackground;
        this.xpColor = xpColor;
        this.isBoosting = isBoosting;
    }

    public Rankcard(String username, String avatar, int level, int rank, int currentXp, int nextLevelXp, int previousLevelXp, BackgroundResolvable customBackground, Boolean isBoosting) {
        requireNotNull(username,avatar,level,rank,currentXp,nextLevelXp,previousLevelXp);
        this.username = username;
        this.avatar = avatar;
        this.level = level;
        this.rank = rank;
        this.currentXp = currentXp;
        this.nextLevelXp = nextLevelXp;
        this.previousLevelXp = previousLevelXp;
        this.customBackground = customBackground;
        this.isBoosting = isBoosting;
    }

    public Rankcard(String username, String avatar, int level, int rank, int currentXp, int nextLevelXp, int previousLevelXp, Integer xpColor, Boolean isBoosting) {
        requireNotNull(username,avatar,level,rank,currentXp,nextLevelXp,previousLevelXp);
        this.username = username;
        this.avatar = avatar;
        this.level = level;
        this.rank = rank;
        this.currentXp = currentXp;
        this.nextLevelXp = nextLevelXp;
        this.previousLevelXp = previousLevelXp;
        this.xpColor = xpColor;
        this.isBoosting = isBoosting;
    }

    private final String username;
    private final String avatar;
    private final int level;
    private final int rank;
    private final int currentXp;
    private final int nextLevelXp;
    private final int previousLevelXp;

    // Nullables
    private BackgroundResolvable customBackground = null;
    private Integer xpColor = null;
    private Boolean isBoosting = null;


    static void requireNotNull(Object... objects) {
        for (Object object : objects) {
            if (object == null) throw new NullPointerException("Cannot be null");
        }
    }

    private String encode(String original) {
        try {
            return URLEncoder.encode(original,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    Pair<String, String>[] convert() throws IOException {
        List<Pair<String, String>> pairs = new ArrayList<>();
        pairs.add(pair("username", encode(username)));
        pairs.add(pair("avatar",encode(avatar)));
        pairs.add(pair("level",((Integer) level).toString()));
        pairs.add(pair("rank",((Integer) rank).toString()));
        pairs.add(pair("currentxp",((Integer) currentXp).toString()));
        pairs.add(pair("nextlevelxp", ((Integer) nextLevelXp).toString()));
        pairs.add(pair("previouslevelxp", ((Integer) previousLevelXp).toString()));
        if (customBackground != null) {
            String bg;
            if (customBackground.getColor() != null) {
                bg = Integer.toHexString(customBackground.getColor());
            } else {
                bg = URLEncoder.encode(customBackground.getUrl(),"UTF-8");
            }
            pairs.add(pair("custombg",bg));
        }
        if (xpColor != null) {
            pairs.add(pair("xpcolor",xpColor.toString()));
        }
        if (isBoosting != null) {
            pairs.add(pair("isboosting",isBoosting.toString()));
        }
        return (Pair<String,String>[]) pairs.toArray();
    }
}
