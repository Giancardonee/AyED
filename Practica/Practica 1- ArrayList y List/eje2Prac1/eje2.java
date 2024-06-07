package practica1.eje2Prac1;
import practica1.Numeros;

import java.util.Scanner;

public class eje2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       System.out.print("Ingrese un valor n para devolver un array con los n multiplos: ");
       Scanner teclado = new Scanner (System.in); 
       int n = teclado.nextInt(); 
       
       int[] v = Numeros.devolver_n_multiplos(n);
       Numeros.imprimirVector(v);
    }
    
}
