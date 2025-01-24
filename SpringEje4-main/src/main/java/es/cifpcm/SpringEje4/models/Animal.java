package es.cifpcm.SpringEje4.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @NotNull(message = "Este campo no puede quedar vacío")
    @Size(min=3, max=15, message="El nombre ha de tener entre 3 y 15 caracteres")
    @NotBlank(message = "Este campo no puede estar en blanco")
    private String Nombre;
    @NotNull
    @Min(value = 0, message = "La edad media ha de ser un número positivo")
    @Max(value = 600, message = "La edad media no puede ser mayor de 600")
    private int VidaMedia;
    @NotNull(message = "Este campo no puede ser vacío")
    private boolean Extinto;

    public Animal() {
    }

    public Animal(String nombre, int vidaMedia, boolean extinto) {
        Nombre = nombre;
        VidaMedia = vidaMedia;
        Extinto = extinto;
    }

    public Animal(int id, String nombre, int vidaMedia, boolean extinto) {
        Id = id;
        Nombre = nombre;
        VidaMedia = vidaMedia;
        Extinto = extinto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getVidaMedia() {
        return VidaMedia;
    }

    public void setVidaMedia(int vidaMedia) {
        VidaMedia = vidaMedia;
    }

    public boolean isExtinto() {
        return Extinto;
    }

    public void setExtinto(boolean extinto) {
        Extinto = extinto;
    }
}
