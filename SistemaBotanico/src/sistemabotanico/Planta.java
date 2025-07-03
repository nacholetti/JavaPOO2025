
package sistemabotanico;


public abstract class Planta implements Podar {
    private String nombre;
    private String ubicacion;
    private String clima;

    public Planta(String nombre, String ubicacion, String clima) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.clima = clima;
    }

    @Override
    public boolean poderPlantas(){
        return true;
    }

    
    
    
    
    
   
    
    
    
    @Override
    public String toString() {
        return "Planta{" + "nombre=" + nombre + ", ubicacion=" + ubicacion + ", clima=" + clima + '}';
    }
    
    
    
   
}
