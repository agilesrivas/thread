package Threads;

import java.util.Random;

public class BeerProducter extends Thread {
	
	 private final Random aleatorio;
	    private final BeerHouse contenedor;
	    private final int idproductor;
	    private final int TIEMPOESPERA = 1500;
	 
	    /**
	     * Constructor de la clase
	     * @param contenedor Contenedor común a los consumidores y el productor
	     * @param idproductor Identificador del productor
	     */
	    public BeerProducter(BeerHouse contenedor, int idproductor) 
	    {
	        this.contenedor = contenedor;
	        this.idproductor = idproductor;
	        aleatorio = new Random();
	    }
	 
	    @Override
	    /**
	     * Implementación de la hebra
	     */
	    public void run() 
	    {
	        while(Boolean.TRUE)
	        {
	            int poner = aleatorio.nextInt(10);
	            contenedor.put(poner);
	            System.out.println("El productor " + idproductor + " pone: " + poner);
	            try
	            {
	                Thread.sleep(TIEMPOESPERA);
	            } 
	            catch (InterruptedException e) 
	            {
	                System.err.println("Productor " + idproductor + ": Error en run -> " + e.getMessage());
	            }
	        }
	    }
}
