package models;

public class Animal {
    private int id;
    private String name;
    private int LifeSpan;
    private Boolean Extinct;

    public Animal() {}

    public Animal(int id, String name, int lifeSpan, Boolean extinct) {
        this.id = id;
        this.name = name;
        LifeSpan = lifeSpan;
        Extinct = extinct;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifeSpan() {
        return LifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        LifeSpan = lifeSpan;
    }

    public Boolean getExtinct() {
        return Extinct;
    }

    public void setExtinct(Boolean extinct) {
        Extinct = extinct;
    }

    // ToString

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", LifeSpan=" + LifeSpan +
                ", Extinct=" + Extinct +
                '}';
    }
}
