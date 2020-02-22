package task01;

public enum NumberProperty {

    EVEN("even"),
    ODD("odd"),
    PRIME("prime"),
    COMPOSITE("composite");

    private String title;

    NumberProperty(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
