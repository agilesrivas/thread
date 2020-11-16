package Threads;

public class Main {

	 private static BeerHouse contenedor;
	    private static Thread productor;
	    private static Thread [] consumidores;
	    private static final int CANTIDADCONSUMIDORES = 5;
	     
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) 
	    {
	        contenedor = new BeerHouse();
	        productor = new Thread(new BeerProducter(contenedor, 1));
	        consumidores = new Thread[CANTIDADCONSUMIDORES];
	 
	        for(int i = 0; i < CANTIDADCONSUMIDORES; i++)
	        {
	            consumidores[i] = new Thread(new BeerConsumer(contenedor, i));
	            consumidores[i].start();
	        }
	         
	        productor.start();
	    }    

}
