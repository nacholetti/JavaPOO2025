
package sistemabotanico;


public class SistemaBotanico {

  
    public static void main(String[] args) {
            
        
        Botanico jardin = new Botanico();
        jardin.agregarPlanta(new Arboles("Sauce","Norte","Calor"));
        jardin.mostrarPlanta();
        
    }
    
}
