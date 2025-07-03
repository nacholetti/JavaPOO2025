
package sistemabotanico;

public class Flores extends Planta{

    public Flores(String nombre, String ubicacion, String clima) {
        super(nombre, ubicacion, clima);
    }
    
    
     @Override
    public boolean poderPlantas() {
        System.out.println("No puede ser podada");
        return false;
    }

    @Override
    public String toString() {
        return "Flores{" + '}';
    }
    
    
    
    
}
