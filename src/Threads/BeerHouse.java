package Threads;

public class BeerHouse {
	
	private int contenido;
    private boolean contenedorlleno = Boolean.FALSE;
 
    /**
     * Obtiene de forma concurrente o s�ncrona el elemento que hay en el contenedor
     * @return Contenido el contenedor
     */
    public synchronized int get()
    {
        while (!contenedorlleno)
        {
            try
            {
                wait();
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        contenedorlleno = Boolean.FALSE;
        notify();
        return contenido;
    }
 
    /**
     * Introduce de forma concurrente o s�ncrona un elemento en el contenedor
     * @param value Elemento a introducir en el contenedor
     */
    public synchronized void put(int value) 
    {
        while (contenedorlleno) 
        {
            try
            {
                wait();
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        contenido = value;
        contenedorlleno = Boolean.TRUE;
        notify();
    }

}
