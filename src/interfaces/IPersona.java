package interfaces;

public interface IPersona {

    public String getNombre();
    public void setNombre(String nombre);

    public int getDni();
    public void setDni(int dni);

    public int getEdad();
    public void setEdad(int edad);
    
    @Override
    public String toString();
    
    
}
