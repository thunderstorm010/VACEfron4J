package me.thunderstorm010.vacefron4j;

public enum EjectedColor {
    BLACK, BLUE, BROWN, CYAN, DARK_GREEN, LIME, ORANGE, PINK, PURPLE, RED, WHITE, YELLOW;

    @Override
    public String toString() {
        if (this == EjectedColor.DARK_GREEN) return "dark_green";
        return super.toString().toLowerCase();
    }
}
