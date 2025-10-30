package hw04.src.model;

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
