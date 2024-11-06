package floor;

//responsibilities:
// - initialize fields during creating object,
// - change exactly field
// - pass exactly field
public class Floor {

    private String name;

    public Floor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }
}