package me.thunderstorm010.vacefron4j;

import java.awt.*;

public class BackgroundResolvable {
    private BackgroundResolvable() { }
    private Integer color;
    private String url;

    public Integer getColor() {
        return color;
    }

    public String getUrl() {
        return url;
    }

    private BackgroundResolvable(int color) {
        this.color = color;
    }

    private BackgroundResolvable(String url) {
        this.url = url;
    }

    public static BackgroundResolvable fromColor(Color color) {
        return new BackgroundResolvable(Integer.parseInt(String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue())));
    }

    public static BackgroundResolvable fromUrl(String url) {
        return new BackgroundResolvable(url);
    }

}
