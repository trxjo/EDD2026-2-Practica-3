/**
 * Clase Nodo para la implementación de la pila 
 * @author Ozkar Trejo
 * @version 12026-2
 */
public class Nodo<T> {
    
    private T elemento;
    
    private Nodo<T> siguiente;
    
    /**
     * Metodo constructor del nodo
     * @param elemento el elemento a almacenar
     */
    public Nodo(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }
    
    /**
     * Obtiene el elemento del nodo
     * @return el elemento almacenado
     */
    public T obtenerElemento() {
        return elemento;
    }
    
    /**
     * Asigna el elemento del nodo
     * @param elemento el nuevo elemento
     */
    public void asiganrElemento(T elemento) {
        this.elemento = elemento;
    }
    
    /**
     * Obtiene el siguiente nodo
     * @return el siguiente nodo
     */
    public Nodo<T> obtenerSiguiente() {
        return siguiente;
    }
    
    /**
     * Asigna el siguiente nodo
     * @param siguiente el nuevo siguiente nodo
     */
    public void asignarSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}
