
package sistemabotanico;


public class PlantasExcepcion extends Exception{
    
    
   
    private static final String  MESSAGE = "La planta esta repetida";

    public PlantasExcepcion() {
        super(MESSAGE);
    }
        
        
    }

