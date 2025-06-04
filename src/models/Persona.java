package models;

import interfaces.IPersona;

public class Persona implements IPersona{
    private String nombre;
    private int dni;
    private int edad;

    public Persona(String nombre, int dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }
    public int getDni() {
        return dni;
    }
    public int getEdad() {
        return edad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + "]";
    }

    
}
