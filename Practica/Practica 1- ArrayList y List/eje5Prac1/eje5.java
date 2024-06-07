package practica1.eje5Prac1;

import practica1.Numeros;

public class eje5 {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // inciso a) 
        int [] vectorNumeros = {1,2,3,4,5,6,100,4,5,7,50,90,-10};
        String stringMaxMin = Numeros.devolverMaxMinArray(vectorNumeros); 
        System.out.println(stringMaxMin);
        
        // inciso b) 
        // usando un objeto de la clae Dato
        Dato dato1 = new Dato();
        Numeros.devolverMaxMinEnObjDato(vectorNumeros, dato1);
        System.out.println(dato1.toString());
        
        // inciso c) 
        Numeros.incisoC();
        System.out.println("Maximo: "+Numeros.d.getMaximo());
        System.out.println("Minimo: "+Numeros.d.getMinimo());
        System.out.println("Promedio: "+Numeros.d.getPromedio());
    }
    
}
