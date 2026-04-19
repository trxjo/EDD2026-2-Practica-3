import java.util.ArrayList;
/**
 * Simulador de colisiones de asteroides usando pilas
 * @author Ozkar Trejo 
 * @version 2026-2
 */
public class Asteroide{
    
    /**
     * Simula las colisiones de asteroides y devuelve los sobrevivientes
     * @param asteroides arreglo de asteroides donde el valor absoluto es el tamaño
     *                   y el signo es la dirección (+ derecha, - izquierda)
     * @return arreglo con los asteroides que sobreviven
     */
    public static int[] asteroidCollision(int[] asteroides) {
        Stack<Integer> pila = new Stack<>();
        
        for (int asteroide : asteroides) {
            boolean sobrevive = true;

            while (asteroide < 0 && !pila.isEmpty() && pila.top() > 0) {
                int tope = pila.top();
                
                if (Math.abs(asteroide) > tope) {
                    
                    pila.pop();
                } else if (Math.abs(asteroide) == tope) {
                    pila.pop();
                    sobrevive = false;
                    break;
                } else {

                    sobrevive = false;
                    break;
                }
            }
            

            if (sobrevive) {
                pila.push(asteroide);
            }
        }
        
        int[] resultado = new int[pila.size()];
        for (int i = resultado.length - 1; i >= 0; i--) {
            resultado[i] = pila.pop();
        }
        
        return resultado;
    }
    
    /**
     * Metodo para imprimir un arreglo
     */
    private static void imprimirArreglo(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String args[]){
           // Caso 1: [5, 10, -5] -> [5, 10]
        System.out.println("Caso 1:");
        int[] caso1 = {5, 10, -5};
        System.out.print("Entrada: ");
        imprimirArreglo(caso1);
        System.out.print("Salida: ");
        imprimirArreglo(asteroidCollision(caso1));
        System.out.println("\n");
        
        // Caso 2: [8, -8] -> []
        System.out.println("Caso 2:");
        int[] caso2 = {8, -8};
        System.out.print("Entrada: ");
        imprimirArreglo(caso2);
        System.out.print("Salida: ");
        imprimirArreglo(asteroidCollision(caso2));
        System.out.println("\n");
        
        // Caso 3: [10, 2, -5] -> [10]
        System.out.println("Caso 3:");
        int[] caso3 = {10, 2, -5};
        System.out.print("Entrada: ");
        imprimirArreglo(caso3);
        System.out.print("Salida: ");
        imprimirArreglo(asteroidCollision(caso3));
        System.out.println("\n");
        
        // Caso 4: [-2, -1, 1, 2] -> [-2, -1, 1, 2]
        System.out.println("Caso 4");
        int[] caso4 = {-2, -1, 1, 2};
        System.out.print("Entrada: ");
        imprimirArreglo(caso4);
        System.out.print("Salida: ");
        imprimirArreglo(asteroidCollision(caso4));
    }
}
