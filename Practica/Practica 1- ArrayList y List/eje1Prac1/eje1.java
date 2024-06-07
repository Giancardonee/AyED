package practica1.eje1Prac1;


import practica1.Numeros;

public class eje1 {
    public static void main(String[] args) {
        System.out.println("Usando un for:");
        Numeros.imprimirValoresIntermedios_For(5, 10);
        System.out.println("Usando un while:");
        Numeros.imprimirValoresIntermedios_While(10, 15);
        System.out.println("Usando recursividad:");
        Numeros.imprimirValoresIntermedios_sinEstructuras(15, 20);
    }
}
    
