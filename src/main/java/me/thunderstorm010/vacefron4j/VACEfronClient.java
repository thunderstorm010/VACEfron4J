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

import me.thunderstorm010.vacefron4j.internal.HttpUtil;
import me.thunderstorm010.vacefron4j.internal.Pair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static me.thunderstorm010.vacefron4j.internal.Pair.pair;

public class VACEfronClient {
    /**
     * Internal method to create requests to the API by a friendly way.
     *
     * @param endpoint The endpoint to contact.
     * @param params   The URL parameters for the endpoint.
     * @return A byte[] of the gotten data.
     * @throws IOException If some kind of connectivity issues ocurrs, or the endpoint url is malformed, or if the endpoint doesn't exists overall.
     */
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

    /**
     * Creates a car reverse image.
     *
     * @param text The written text in the right corner of the image.
     * @return A byte[] of the image.
     */
    public static byte[] carReverse(String text) throws IOException {
        return api("carreverse", pair("text", text));
    }

    /**
     * Creates a change my mind image.
     *
     * @param text The text to appear on the change my mind banner.
     * @return A byte[] of the image.
     */
    public static byte[] changeMyMind(String text) throws IOException {
        return api("changemymind", pair("text", text));
    }

    /**
     * Creates a distracted boyfriend image.
     * @param boyfriendAvatar The boyfriend's avatar.
     * @param womanAvatar The woman's avatar.
     * @param girlfriendAvatar The girlfriend's avatar.
     * @return A byte[] of the image.
     */
    public static byte[] distractedBoyfriend(String boyfriendAvatar, String womanAvatar, String girlfriendAvatar) throws IOException {
        return api("changemymind", pair("boyfriend", boyfriendAvatar), pair("woman", womanAvatar), pair("girlfriend", girlfriendAvatar));
    }

    /**
     * Creates an Among Us ejected image.
     * @param name Name of the crewmate.
     * @param isImpostor If the crewmate is an ipostor
     * @param crewmateColor The color of the crewmate that will be ejected on the image.
     * @return A byte[] of the image.
     */
    public static byte[] ejected(String name, Boolean isImpostor, EjectedColor crewmateColor) throws IOException {
        return api("ejected", pair("name", name), pair("isImpostor", isImpostor.toString()), pair("crewmate", crewmateColor.toString()));
    }


    /**
     * Creates an Among Us emergency meeting image with the text at the top.
     * @param text Text to display on the top section of the image.
     * @return A byte[] of the image.
     */
    public static byte[] emergencyMeeting(String text) throws IOException {
        return api("emergencymeeting", pair("text", text));
    }

    /**
     * Creates a "first time?" image with the avatar specified.
     * @param avatar The avatar to be in the image.
     * @return A byte[] of the image.
     */
    public static byte[] firstTime(String avatar) throws IOException {
        return api("firsttime", pair("user", avatar));
    }

    /**
     * Creates a grave image with the avatar specified.
     * @param avatar The avatar to be in the image.
     * @return A byte[] of the image.
     */
    public static byte[] grave(String avatar) throws IOException {
        return api("grave", pair("user", avatar));
    }

    /**
     * Creates a "I am speed." image with the avatar specified.
     * @param avatar The avatar to be in the image.
     * @return A byte[] of the image.
     */
    public static byte[] iAmSpeed(String avatar) throws IOException {
        return api("iamspeed", pair("user", avatar));
    }


    /**
     * Creates an "I can milk you" image with the two avatar specified.
     * @param firstUserAvatar The milking user's avatar URL.
     * @param secondUserAvatar The milked user's avatar URL.
     * @return A byte[] of the image.
     */
    public static byte[] iCanMilkYou(String firstUserAvatar, String secondUserAvatar) throws IOException {
        return api("icanmilkyou", pair("user1", firstUserAvatar), pair("user2", secondUserAvatar));
    }

    /**
     * Creates a heaven image with the avatar specified.
     * @param avatar The avatar to be in the image.
     * @return A byte[] of the image.
     */
    public static byte[] heaven(String avatar) throws IOException {
        return api("heaven", pair("user", avatar));
    }

    /**
     * Creates a NPC image with the two texts specified.
     * @param firstText The text that the first NPC says.
     * @param secondText The text that the second NPC says.
     * @return A byte[] of the image.
     */
    public static byte[] npc(String firstText, String secondText) throws IOException {
        return api("npc", pair("text1", firstText), pair("text2", secondText));
    }


    /**
     * Creates a rankcard image.
     * @param card The Rankcard instance. This could be created with [RankcardBuilder#build]
     * @return A byte[] of the image.
     */
    public static byte[] rankcard(Rankcard card) throws IOException {
        return api("rankcard", card.convert());
    }

    /**
     * Creates a stonks image.
     * @param userAvatar User in the stonks image.
     * @return A byte[] of the image.
     */
    public static byte[] stonks(String userAvatar) throws IOException {
        return api("stonks", pair("user", userAvatar));
    }


    /**
     * Creates a stonks image.
     * @param userAvatar User in the stonks image.
     * @param notStonks If false, the image will be "not stonks" instead of stonks.
     * @return A byte[] of the image.
     */
    public static byte[] stonks(String userAvatar, Boolean notStonks) throws IOException {
        return api("stonks", pair("user", userAvatar), pair("notstonks", notStonks.toString()));
    }

    /**
     * Creates a "flipping tables" image with the given avatar.
     *
     * @param userAvatar Avatar URL of the user.
     * @return A byte[] of the image.
     */
    public static byte[] tableflip(String userAvatar) throws IOException {
        return api("tableflip", pair("user", userAvatar));
    }

    /**
     * Creates a "water (1/4 miles) or [text] 25 miles" image.
     *
     * @param text The text that will be on the sign.
     * @return A byte[] of the image.
     */
    public static byte[] water(String text) throws IOException {
        return api("water", pair("text", text));
    }

    /**
     * Creates a wide image.
     *
     * @param imageUrl Image to stretch and make it wider.
     * @return A byte[] of the image.
     */
    public static byte[] wide(String imageUrl) throws IOException {
        return api("wide", pair("image", imageUrl));
    }
}
