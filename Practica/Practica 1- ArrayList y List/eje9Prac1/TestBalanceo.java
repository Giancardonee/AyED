package practica1.eje9Prac1;
public class TestBalanceo {
public static boolean estaBalanceado(String st) {
        Stack pila = new Stack();
        // Verificamos si la longitud de la cadena es par y mayor a 0
        boolean ok = st.length() > 0 && st.length() % 2 == 0;
        // índice del carácter actual
        int charAct = 0;
        // Mientras ok sea verdadero y haya caracteres en la cadena
        while (ok && charAct < st.length()) {
            char cString = st.charAt(charAct); // nos traemos el caracter correspondiente
            // Si es un carácter de apertura, lo apilamos
            if (esCaracterApertura(cString)) {
                pila.push(cString);
            } else if (esCaracterCierre(cString)) { // Si es un carácter de cierre
                // Si la pila está vacía, no hay una apertura correspondiente
                if (pila.isEmpty()){
                    ok = false;
                } else {
                    // Obtenemos el carácter de apertura de la pila
                    Character cPila = pila.pop();
                    // Verificamos si el cierre es correcto
                    if (cPila == null || !esCierreCorrecto(cPila, cString)) {
                        ok = false;
                    }
                }
            } else { // Si es un carácter que no es de apertura ni de cierre, la cadena no está balanceada
                ok = false;
            }
            // Incrementar el índice del carácter actual
            charAct++;
        }

        // La cadena estará balanceada si ok es verdadero y la pila está vacía al final
        return ok && pila.isEmpty();
    }

    private static boolean esCaracterApertura(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean esCaracterCierre(char c) {
        return c == ')' || c == ']' || c == '}';
    }
    
    private static boolean esCierreCorrecto(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '[' && cierre == ']') ||
               (apertura == '{' && cierre == '}');
    }

    public static void main(String[] args) {
        System.out.println(estaBalanceado("({})")); 
    }

}
