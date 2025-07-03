
package sistemabotanico;


public class Arboles extends Planta{
    private static final int ALTURA_MAX = 20;

    public Arboles(String nombre, String ubicacion, String clima) {
        super(nombre, ubicacion, clima);
    }

    @Override
    public boolean poderPlantas() {
        System.out.println("Puede ser podada");
        return true;
    }

   
    
    
    
    
    
}
