package wooteco.subway.reopository.entity;

public class LineEntity {

    private Long id;
    private String name;
    private String color;
    private int extraFare;

    public LineEntity(Long id, String name, String color, int extraFare) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.extraFare = extraFare;
    }

    public LineEntity(String name, String color, int extraFare) {
        this(null, name, color, extraFare);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getExtraFare() {
        return extraFare;
    }
}
