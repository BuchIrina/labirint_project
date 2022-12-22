package tests.domain;

public enum HeaderSecondMenu {
    HOUSEHOLD("Товары для дома", "/household/"),
    MULTIMEDIA("CD/DVD", "/multimedia/"),
    SOUVENIR("Сувениры", "/souvenir/"),
    JOURNALS("Журналы", "/journals/");

    public final String name;
    public final String link;

    HeaderSecondMenu(String name, String link) {
        this.name = name;
        this.link = link;
    }
}
