
package sistemabotanico;


public class Arbustos extends Planta {
    
    
    private static final int MAX_DENSIDAD = 10;
    private static final int MIN_DENSIDAD = 1;

    public Arbustos(String nombre, String ubicacion, String clima) {
        super(nombre, ubicacion, clima);
    }
    
    
    
     @Override
    public boolean poderPlantas() {
        System.out.println("Puede ser podada");
        return true;
    }

    @Override
    public String toString() {
        return "Arbustos{" + '}';
    }
    
    
}
