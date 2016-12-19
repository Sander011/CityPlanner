package hci.cityplanner;

/**
 * Created by Sander on 19-12-2016.
 */

public class Highlight {
    private String city;
    private Category category;
    private String name;
    private String description;
    private String lattitude;
    private String longtitude;

    public Highlight(String city, Category category, String name, String description, String lattitude, String longtitude) {
        this.city = city;
        this.category = category;
        this.name = name;
        this.description = description;
        this.lattitude = lattitude;
        this.longtitude = longtitude;
    }

    @Override
    public String toString() {
        return "Highlight{" +
                "city='" + city + '\'' +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", lattitude='" + lattitude + '\'' +
                ", longtitude='" + longtitude + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLattitude() {
        return lattitude;
    }

    public String getLongtitude() {
        return longtitude;
    }
}
