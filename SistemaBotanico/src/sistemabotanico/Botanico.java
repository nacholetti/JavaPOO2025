
package sistemabotanico;

import java.util.ArrayList;

public class Botanico  {
    
    public ArrayList<Planta>plantas;

    public Botanico() {
        this.plantas = new ArrayList<>();
    }
    
    public void agregarPlanta(Planta p) throws PlantasExcepcion{
        if(p == null){
        
            throw new NullPointerException("Me pasaste un null");
            
    }
        if(plantas.contains(p))
        {
            throw new PlantasExcepcion();
        }
        plantas.add(p);
    }
    
       
    public void mostrarPlanta(){
        
        if(plantas.isEmpty()){
            System.out.println("No hay autos");
        }  
        for(Planta p : plantas){
            System.out.println(p);
        }
    
    }
    
    
    
}
