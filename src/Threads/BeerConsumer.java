package Threads;

public class BeerConsumer extends Thread{
	
	 private final BeerHouse contenedor;
	    private final int idconsumidor;
	 
	    /**
	     * Constructor de la clase
	     * @param contenedor Contenedor común a los consumidores y el productor
	     * @param idconsumidor Identificador del consumidor
	     */
	    public BeerConsumer(BeerHouse contenedor, int idconsumidor) 
	    {
	        this.contenedor = contenedor;
	        this.idconsumidor = idconsumidor;
	    }
	 
	    @Override
	    /**
	     * Implementación de la hebra
	     */
	    public void run() 
	    {
	        while(Boolean.TRUE)
	        {
	            System.out.println("El consumidor " + idconsumidor + " consume: " + contenedor.get());
	        }
	    }

}
