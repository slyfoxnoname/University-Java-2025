package HomeWorks.hw04.model;

public enum CompositionType {
    SONG("Пісня"),
    INSTRUMENTAL("Інструментал"),
    SYMPHONY("Симфонія");

    private final String description;

    CompositionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
