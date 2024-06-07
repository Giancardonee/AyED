package practica1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import practica1.eje5Prac1.Dato;

public class Numeros {
    public static Dato d;
    
    private static int valorMin; 
    private static int valorMax; 
    private static double promedio; 
    
    private static int[] vectorNumeros; 
    
    
    private String datos;
 //---------- METODOS PARA eje1
  //Como no sabemos cual valor es el mas grande, debemos evaluar  
    private static void calcularMinMax(int a , int b){
        if (a>=b){valorMin= b; valorMax= a;}
        else {valorMax = b; valorMin = a;}
    }
    
    private static void procesarArray(int []v){
        valorMin = 9999;
        valorMax = 0;
        int sumaNumeros = 0;
        for (int i=0; i < v.length; i++){
           if (v[i] > valorMax){valorMax = v[i];}
           if (v[i] < valorMin) {valorMin = v[i];}
           sumaNumeros+= v[i]; 
        }
       promedio = (sumaNumeros / v.length); 
    }
    
    public static void imprimirValoresIntermedios_For (int a, int b){
        calcularMinMax(a,b); 
        for (int i = valorMin; i<= valorMax; i++){
            System.out.println(i+"");
        }
    }
    
    public static void imprimirValoresIntermedios_While(int a, int b){
         calcularMinMax(a,b); 
         int i=valorMin;
         while (i <= valorMax) {
             System.out.println(i+"");
             i++; 
        }   
    }
    
    public static void imprimirValoresIntermedios_sinEstructuras(int a , int b){
        calcularMinMax(a,b);
        System.out.println(valorMin+"");
        if (valorMin<valorMax){imprimirValoresIntermedios_sinEstructuras((valorMin+1),valorMax);}
    }
 //---------- METODOS PARA eje2
    public static int[] devolver_n_multiplos(int n){
         int [] vectorMultiplos = new int[n]; 
         for (int i=1; i <=n; i++){
             vectorMultiplos[i-1] = n * i; 
         }
       return vectorMultiplos; 
    }
    
    public static void imprimirVector (int [] v){
        for (int i=0; i<v.length; i++){
            System.out.print(v[i]+" ");
        }
    }
  //----- METODOS PARA EL EJE 5
    // inciso a
    // devolver un obj 
   public static String  devolverMaxMinArray(int [] v){
       procesarArray(v);
       String st = "Maximo: "+valorMax+ " Minimo: "+valorMin+ " Promedio: "+promedio; 
     return st;
   }
   // inciso b
  public static void devolverMaxMinEnObjDato(int [] vec, Dato obj){
      procesarArray(vec);
      obj.setMaximo(valorMax);
      obj.setMinimo(valorMin);
      obj.setPromedio(promedio);
  }
  // inciso c
  public static void incisoC(){
       vectorNumeros = new int[]{5,6,7,8,100,4,5,88,233,43,33,0,4,5,94};
       procesarArray(vectorNumeros);
       d = new Dato(); 
       d.setMaximo(valorMax);
       d.setMinimo(valorMin);
       d.setPromedio(promedio);
  }
  
  
  //----- MODULOS PARA EL EJE 7 
  // 7) f) Recibe un ArrayList de integer y devuelve si es capicua o no.
  
// tener en cuenta que la funcion lista.size devuelve la cantidad de elementos y no el ultimo indice.
// para tener el ultimo indice debemos restarle 1.  
  public static boolean esCapicua (ArrayList <Integer> lista){
      boolean cumple = true;
      // chequeamos que al menos tenga dos elementos, sino no valdria la pena que entre al while
      if (lista.size() >=2){ 
        int indicePri, indiceUlt; 
        int valorPri,valorUlt;
        indicePri = 0;
        indiceUlt = (lista.size()-1); 
        
        while ( (indicePri < indiceUlt) && (cumple)){
               valorPri = lista.get(indicePri); 
               valorUlt = lista.get(indiceUlt); 
               if (valorPri == valorUlt){
                   indicePri++;
                   indiceUlt--;
               }else { cumple = false ;}
        }          
        
      }
      else{
          cumple = false; 
      }
      return cumple; 
  }
  //-- 7) g) 
   public static  List<Integer> calcularSucesion (int n){
       List <Integer> lista = new LinkedList<>();
       calcularSucesionRecursiva(lista,n); 
       return lista; 
   }
  
   private static void calcularSucesionRecursiva(List <Integer> lista, int n){
       if (n>1){
           int aux; 
            if ((n%2)==0){
                aux = n/2;
            }
            else{
                aux = ( (3*n )+ 1); 
            }
         lista.add(aux); 
           calcularSucesionRecursiva(lista, aux);
       }
   }
  
  public static void imprimirListaSucesion (List <Integer> lista){
      for(Integer num : lista){
          System.out.print(num+" ");
      }
  }
  
  
  //----------------------------------------------------------------------------
    // 7) h) 
    public static void invertirArrayList (ArrayList<Integer> lista){
        invertirArrayListRecursivo(lista,0,lista.size()-1);
    }
  
    //usamos la funcion set del ArrayList, esta funcion setea un valor en un indice recibido por parametro
    private static void invertirArrayListRecursivo(ArrayList<Integer> lista, int pri, int ult){
        if (pri < ult){
            int tmp = lista.get(pri); 
            lista.set(pri, lista.get(ult));
            lista.set(ult, tmp); 
            invertirArrayListRecursivo(lista, pri+1, ult-1);
        }
    }
    
    public static void imprimirArrayList(ArrayList <Integer> lista){
        System.out.println("");
        for (Integer nro : lista){
            System.out.print(nro+" ");
        }
    }
   //----------------------------------------------------------------------------
   // 7) i) 
    
    public static int sumarLinkedList(LinkedList <Integer> lista){
        int suma=0;
        return calcularSumaLinkedist(lista,suma,0,lista.size()-1); 
    }
     
    private static int calcularSumaLinkedist (LinkedList <Integer> lista, int suma,int elemAct, int ult){
        if (elemAct <= ult){
            suma+= lista.get(elemAct); 
            return calcularSumaLinkedist(lista,suma,elemAct+1,ult);
        }else { return suma;}
      }
   // 7) j) 
    public static ArrayList<Integer>  combinarOrdenado (ArrayList<Integer> lista1, ArrayList<Integer> lista2){
        int sizeLista1 = lista1.size();  int sizeLista2 = lista2.size(); 
        int indexLista1 = 0;  int indexLista2 = 0;
        int valorLista1,valorLista2; 
        
        ArrayList <Integer> listaReturn = new ArrayList <>(); 
        while ( (indexLista1 < sizeLista1) && (indexLista2 < sizeLista2) ){
            valorLista1 = lista1.get(indexLista1); 
            valorLista2 = lista2.get(indexLista2); 
          // agregamos en la lista el valor menor.
            if (valorLista1 < valorLista2){listaReturn.add(valorLista1); indexLista1++;}
            else {listaReturn.add(valorLista2); indexLista2++; }        
        } 
        
    // va a salir del while porque se llego al final en una de las dos listas 
    // como no sabemos cual de las dos es, si entra al while de abajo, termina de agregar los elementos faltantes
        
        while (indexLista1 < sizeLista1){
            valorLista1 = lista1.get(indexLista1); 
            listaReturn.add(valorLista1); 
            indexLista1++; 
        }
        
        while (indexLista2 < sizeLista2){ 
            valorLista2 = lista2.get(indexLista2); 
            listaReturn.add(valorLista2); 
            indexLista2++; 
        } 
        
     return listaReturn;    
    }
    
    
}
