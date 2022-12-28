package tests.domain;

public enum HeaderMainMenu {
    BOOKS("Книги", "/books/"),
    FOREIGNBOOKS("Иностранные", "/foreignbooks/"),
    BEST("Главное", "/best/"),
    SCHOOL("Школа", "/school/"),
    OFFICE("Канцтовары", "/office/"),
    GAMES("Игрушки", "/games/"),
    CLUB("Клуб", "/club/");

    public final String name;
    public final String link;

    HeaderMainMenu(String name, String link) {
        this.name = name;
        this.link = link;
    }
}
