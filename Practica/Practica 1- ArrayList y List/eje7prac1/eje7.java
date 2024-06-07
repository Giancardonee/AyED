package practica1.eje7prac1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import practica1.Numeros;

public class eje7 {
    public static void main(String[] args) {
    //----------------------------------------------------------------------------
        // inciso d) i) 
        
        List <Estudiante> listaEstudiantes = new LinkedList<Estudiante>(); 
        // Dos formas distintas de agregar estudiantes: 
        // Forma 1: Agregando directamente pasandole el constructor
        
        listaEstudiantes.add(new Estudiante("nombre1", "apellido1", "3c", "email1", "direc1"));
        listaEstudiantes.add(new Estudiante("nombre2", "apellido2", "3c", "email2", "direc2"));
        listaEstudiantes.add(new Estudiante("nombre3", "apellido3", "3c", "email3", "direc3"));
        
        // Creando una instancia del objeto y almacenarla en una variable. 
        Estudiante estudiante1 = new Estudiante ("Lautaro", "Martinez", "1A", "Lauta@gmail", "44 y 18");
        listaEstudiantes.add(estudiante1); 
    //----------------------------------------------------------------------------    
        // inciso d) ii) genero una nueva lista que sea una copia de la lista anterior
        List <Estudiante> listaEstudiantes2 = new LinkedList<Estudiante>(listaEstudiantes); 
    //----------------------------------------------------------------------------
    
        // inciso d) iii) 
        // Imprimimos las listas
        
        Estudiante.imprimirListaEstudiante(listaEstudiantes);
        Estudiante.imprimirListaEstudiante(listaEstudiantes2);
        
        // inciso d ) iv) ==> modifique un dato en la lista
        // modificamos el primer estudiante.
        Estudiante estudiante_a_modificar = listaEstudiantes.get(0); 
        estudiante_a_modificar.setNombre("Raúl");
    
    //----------------------------------------------------------------------------    
        // inciso d) v) volvemos a imprimir las dos listas
        /*
            La conclusion es que, al estar copiando dos listas de objetos, se trabaja sobre
        referencias a ese objeto que se almacena en la heap. Entonces al modificar un objeto, 
        no se modifica la referencia, sino el valor. De esta manera un cambio se ve reflejado en 
        aquellos datos que compartan la direccion de la referencia (en este caso la listaEstudiantes y listaEstudiantes2)
        */
        Estudiante.imprimirListaEstudiante(listaEstudiantes);
        Estudiante.imprimirListaEstudiante(listaEstudiantes2);   
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
    //----------------------------------------------------------------------------        
        // inciso e) 
        // Agregar un estudiante en la lista. Antes de agregar verifique que el estudiante no se encuentre en la lista. 
        /*
        Primero se intenta agregar al estudiante1 (ya se encuentra, por lo tanto no lo agrega)
        Despues se intenta agregar a otro estudiante, se chequea que no exista, y se agrega en la lista.
        */ 
        
        Estudiante estudianteRepetido = estudiante1;
        Estudiante estudiante2 = new Estudiante("Leo", "Messi", "1A", "Leomessi@gmail.com", "x"); 
        
        Estudiante.agregarEstudiante(listaEstudiantes, estudianteRepetido);
        Estudiante.agregarEstudiante(listaEstudiantes, estudiante2);
        Estudiante.imprimirListaEstudiante(listaEstudiantes);
        
    //----------------------------------------------------------------------------
        // inciso f) Escribir un metodo que devuelva v o f, si una sentencia es capicua 
        // ==> Creamos el ArrayList para pasarselo por parametro.
        ArrayList<Integer> listaInt = new ArrayList();
        
        listaInt.add(1);
        listaInt.add(2);
        listaInt.add(1);
        
        if (Numeros.esCapicua(listaInt)){
            System.out.println("El ArrayList es capicua :) ");
        }
        else{System.out.println("El ArrayList no es capicua :(");}
    //----------------------------------------------------------------------------
        System.out.println("");
        System.out.println("");
        
        // inciso g) Crear una sucesion recursiva a partir de un numero n positivo 
        List <Integer> listaSucesion = Numeros.calcularSucesion(6);
        Numeros.imprimirListaSucesion(listaSucesion);

    //----------------------------------------------------------------------------
        System.out.println("");
        System.out.println("");
        
        // inciso h) Invertir un ArrayList en un metodo recursivo.
        ArrayList<Integer> arrayListInt = new ArrayList<>(); 
        arrayListInt.add(1); arrayListInt.add(2); arrayListInt.add(3);
        Numeros.imprimirArrayList(arrayListInt); // ==> Imprime 1,2,3
        Numeros.invertirArrayList(arrayListInt);        
        Numeros.imprimirArrayList(arrayListInt);    // ==> Imprime 3,2,1
    
//----------------------------------------------------------------------------
        System.out.println("");
        System.out.println("");
        
        // inciso i) Sumar los elementos de un LinkedList de manera recursiva
        LinkedList <Integer> linkedInteger = new LinkedList<>(); 
        linkedInteger.add(5); linkedInteger.add(15); linkedInteger.add(5);  
        System.out.println(Numeros.sumarLinkedList(linkedInteger));
        
    //----------------------------------------------------------------------------    
        System.out.println("");
        
        // inciso j) Combinar dos listas recibidas por parametro y devolver una lista, de forma ordenada. 
        ArrayList<Integer> listaOrdenada1 = new ArrayList<>();
        listaOrdenada1.add(1); listaOrdenada1.add(2); listaOrdenada1.add(6); listaOrdenada1.add(10);
        
        ArrayList<Integer> listaOrdenada2 = new ArrayList<>(); 
        listaOrdenada2.add(3); listaOrdenada2.add(5); listaOrdenada2.add(7); listaOrdenada2.add(11); listaOrdenada2.add(30);
        
        ArrayList <Integer> listaCombinada = new ArrayList<>(); 
        listaCombinada = Numeros.combinarOrdenado(listaOrdenada1, listaOrdenada2);
        
        Numeros.imprimirArrayList(listaCombinada);
    //----------------------------------------------------------------------------     
    } 
}



    // inciso a) se encuentra en:  TestArrayList
    
    /*
    inciso b) 
        No se a que se refiere con la diferencia respecto a la implementacion, si es 
    sobre codigo, en vez de declarar: 
    ArrayList <Integer> listaNumeros = new ArrayList(); 
    Se debe hacer:  LinkedList <Integer> listaNumeros = new LinkedList(); 
    
    Despues la forma de recorrerlo e imprimir es la misma usando un foreach o un iterator.
    */ 
    
    /*
      inciso c) 
        Se puede recorrer usando un iterator, un foreach, un for con get. 
    Ambas formas de recorrer fueron implementadas en el archivo TestArrayList
    */

      // inciso d) vi)
        /*
            Por lo menos en la teoria vimos 3 formas de copiar una lista.
        1. Crear, mediante su constructor, un nuevo ArrayList pasando la lista original
        como argumento al constructor.
            ArrayList<String> peliculas_copiadas1 = new ArrayList<String>(peliculas); 
        2. Crear un nuevo ArrayList y agregar todos los elementos del original usando el método addAll().
             ArrayList<String> peliculas_copiadas2 = new ArrayList<>();
             peliculas_copiadas2.addAll(peliculas);
        3. 3. Clonar el ArrayList usando el método clone()
            ArrayList<String> peliculas_clonadas = (ArrayList<String>)peliculas.clone();
     
        Generalmente se usan las dos primeras. La tercer opcion no se recomienda ya que 
        al usar el clone, se debe castear. 

        */