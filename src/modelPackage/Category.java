package modelPackage;

public class Category {
    private Integer id;
    private String name;
    private String description;

    public Category(Integer id, String name, String description){
        setId(id);
        setName(name);
        setDescription(description);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
