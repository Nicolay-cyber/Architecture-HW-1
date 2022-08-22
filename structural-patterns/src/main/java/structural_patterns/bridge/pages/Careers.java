package structural_patterns.bridge.pages;

import structural_patterns.bridge.themes.Theme;

public class Careers implements WebPage{
    Theme theme;

    public Careers(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "Careers page in " + theme.getColor();
    }
}
