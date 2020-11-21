package me.thunderstorm010.vacefron4j;

import me.thunderstorm010.vacefron4j.internal.HttpUtil;
import me.thunderstorm010.vacefron4j.internal.Pair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static me.thunderstorm010.vacefron4j.internal.Pair.pair;

public class VACEfronClient {
    @SafeVarargs
    static byte[] api(String endpoint, Pair<String, String>... params) throws IOException {
        StringBuilder paramBuilder = new StringBuilder();
        for (Pair<String, String> entry : params) {
            if (paramBuilder.length() == 0) {
                paramBuilder
                        .append("?");
            } else {
                paramBuilder
                        .append("&");
            }
            try {
                paramBuilder
                        .append(URLEncoder.encode(entry.first, "UTF-8"))
                        .append("=")
                        .append(URLEncoder.encode(entry.second, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return HttpUtil.request("https://vacefron.nl/api/" + endpoint + paramBuilder.toString());
    }

    public static byte[] carReverse(String text) throws IOException {
        return api("carreverse", pair("text",text));
    }
    public static byte[] changeMyMind(String text) throws IOException {
        return api("changemymind", pair("text",text));
    }
    public static byte[] distractedBoyfriend(String boyfriendAvatar, String womanAvatar, String girlfriendAvatar) throws IOException {
        return api("changemymind", pair("boyfriend",boyfriendAvatar), pair("woman",womanAvatar), pair("girlfriend",girlfriendAvatar));
    }


    public static byte[] ejected(String name, Boolean impostor, EjectedColor crewmateColor) throws IOException {
        return api("ejected",pair("name",name), pair("impostor", impostor.toString()), pair("crewmate",crewmateColor.toString()));
    }

    public static byte[] emergencyMeeting(String text) throws IOException {
        return api("emergencymeeting", pair("text",text));
    }

    public static byte[] firstTime(String avatar) throws IOException {
        return api("firsttime", pair("user",avatar));
    }

    public static byte[] grave(String avatar) throws IOException {
        return api("grave",pair("user",avatar));
    }

    public static byte[] iAmSpeed(String avatar) throws IOException {
        return api("iamspeed",pair("user",avatar));
    }

    public static byte[] iCanMilkYou(String firstUserAvatar, String secondUserAvatar) throws IOException {
        return api("icanmilkyou",pair("user1",firstUserAvatar), pair("user2",secondUserAvatar));
    }

    public static byte[] heaven(String avatar) throws IOException {
        return api("heaven",pair("user",avatar));
    }

    public static byte[] npc(String firstText, String secondText) throws IOException {
        return api("npc",pair("text1",firstText), pair("text2",secondText));
    }

    public static byte[] rankcard(Rankcard card) throws IOException {
        return api("rankcard",card.convert());
    }

    public static byte[] stonks(String userAvatar) throws IOException {
        return api("stonks",pair("user",userAvatar));
    }

    public static byte[] stonks(String userAvatar, Boolean notStonks) throws IOException {
        return api("stonks",pair("user",userAvatar), pair("notstonks",notStonks.toString()));
    }

    public static byte[] tableflip(String userAvatar) throws IOException {
        return api("tableflip",pair("user",userAvatar));
    }

    public static byte[] water(String text) throws IOException {
        return api("water", pair("text",text));
    }

    public static byte[] wide(String imageUrl) throws IOException {
        return api("wide",pair("user",imageUrl));
    }
}
