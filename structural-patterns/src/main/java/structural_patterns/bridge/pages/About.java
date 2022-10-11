package structural_patterns.bridge.pages;

import structural_patterns.bridge.themes.Theme;

public class About implements WebPage {

    Theme theme;

    public About(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "About page in " + theme.getColor();
    }
}
