import java.util.EmptyStackException;

/**
 * Implementacion de una pila usando nodos
 * @author Ozkar Trejo
 * @version 2026-2
 */
public class Stack<T> implements TDAStack<T>{

  /** Referencia al nodo en el tope de la pila */
  private Nodo<T> tope;
  
  /** Tamaño de la pila */
  private int tamanio;

  /**
   * Constructor que crea una pila vacía
   */
  public Stack() {
    this.tope = null;
    this.tamanio = 0;
  }

  @Override
  public void push(T e){

    Nodo<T> nuevoNodo = new Nodo<>(e);
    nuevoNodo.asignarSiguiente(tope);
    tope = nuevoNodo;
    tamanio++;
  }

  @Override
  public T pop() throws EmptyStackException{
    if(isEmpty()){
      throw new EmptyStackException();
    }
    T elemento = tope.obtenerElemento();
    tope = tope.obtenerSiguiente();
    tamanio--;
    return elemento;
  }

  @Override
  public T top() throws EmptyStackException{
    if(isEmpty()){
      throw new EmptyStackException();
    }
    return tope.obtenerElemento();
  }

  @Override
  public boolean isEmpty(){
    return tope == null;
  }

  @Override
  public void clear(){
    tope = null;
    tamanio = 0;
  }

  @Override
  public void show(){
    Nodo<T> actual = tope;
    while(actual != null){
      System.out.println(actual.obtenerElemento());
      actual = actual.obtenerSiguiente();
    }
  }
  
  /**
   * Obtiene el tamaño de la pila
   * @return el número de elementos en la pila
   */
  public int size() {
    return tamanio;
  }

}
