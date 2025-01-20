package models;

import jakarta.validation.constraints.*;

public class Animal {
    private int id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String name;

    @Min(value = 1, message = "La esperanza de vida debe ser al menos 1 año")
    @Max(value = 100, message = "La esperanza de vida no puede superar 100 años")
    private int lifeSpan;

    private Boolean extinct;

    public Animal() {}

    public Animal(int id, String name, int lifeSpan, Boolean extinct) {
        this.id = id;
        this.name = name;
        this.lifeSpan = lifeSpan;
        this.extinct = extinct;
    }

    // Getters y Setters
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
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public Boolean getExtinct() {
        return extinct;
    }

    public void setExtinct(Boolean extinct) {
        this.extinct = extinct;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lifeSpan=" + lifeSpan +
                ", extinct=" + extinct +
                '}';
    }
}
