/**
 * Blanaceador de  etiquetas HTML
 * @author Trejo Garcia Ozkar Maurico
 * @version 2026-2
 */
public class htmlbal {
    /**
     * Verifica si una cadena HTML tiene etiquetas balanceadas
     * @param html la cadena HTML a verificar
     * @return true si las etiquetas están balanceadas, false en caso contrario
     */
    public static boolean esHtmlBalanceo(String html) {
        Stack<String> pila = new Stack<>();
        int i = 0;
        
        while (i < html.length()) {
            if (html.charAt(i) == '<') {
                int j = i + 1;
            
                while (j < html.length() && html.charAt(j) != '>') {
                    j++;
                }
                
                if (j >= html.length()) {
                    return false; 
                }
                
                String etiqueta = html.substring(i + 1, j);

                if (etiqueta.startsWith("/")) {
                    
                    String nombreEtiqueta = etiqueta.substring(1).trim();
                    
                    
                    if (pila.isEmpty()) {
                        return false;
                    }
                    
                    
                    String etiquetaApertura = pila.top();
                    if (!etiquetaApertura.equals(nombreEtiqueta)) {
                        return false;
                    }
                    
                    pila.pop();
                } else {
                
                    String nombreEtiqueta = etiqueta.trim();
                    pila.push(nombreEtiqueta);
                }
                
                i = j + 1;
            } else {
                i++;
            }
        }
        return pila.isEmpty();
    }

    public static void main (String args []){
          // Caso 1: Etiquetas balanceadas
        String caso1 = "<body><h1></h1><p></p><p></p><h1></h1></body>";
        System.out.println("Caso 1:");
        System.out.println("HTML: " + caso1);
        System.out.println("Resultado: " + esHtmlBalanceo(caso1) + "\n");


        // Caso 2: Etiqueta </h1> sin abrir
        String caso2 = "<body></h1><p></p><p></p><h1></h1></body>";
        System.out.println("Caso 2:");
        System.out.println("HTML: " + caso2);
        System.out.println("Resultado: " + esHtmlBalanceo(caso2));
        System.out.println("Esperado: false (etiqueta </h1> sin abrir)\n");

         // Caso 3: Etiquetas mal anidadas
        String caso3 = "<body><h1></body></h1><p></p><p></p><h1></h1>";
        System.out.println("Caso 3:");
        System.out.println("HTML: " + caso3);
        System.out.println("Resultado: " + esHtmlBalanceo(caso3));
        System.out.println("Esperado: false (</body> en nivel incorrecto)\n");
    }
    
}
