package practica1.eje3Prac1;

import practica1.eje7prac1.Estudiante;

public class Test {
    public static void main(String[] args) {
          /*
            No entendi la parte que tenemos que asignarle los valores usando
            los metodos settes. Si se debe hacer en el programa principal o desde el constructor de la clase? 
        */
        
        // creamos el arreglo de 3 profesores
        Profesor [] vecP = new Profesor[3];
        vecP[0] = new Profesor("nombre1", "apellido1", "email1"); 
        vecP[0].setCatedra("catedra1"); vecP[0].setFacultad("facultad1"); // <== Tipo hacer esto con los set?  
        vecP[1] = new Profesor("catedra2", "facultad2", "nombre2", "apellido2", "email2");
        vecP[2] = new Profesor("catedra3", "facultad3", "nombre3", "apellido3", "email3");
       // recorremos el arreglo de profesores imprimiendo los datos
       for (int i=0; i<3; i++){
           System.out.println(vecP[i].tusDatos());
       }
       
        // creamos el arreglo de 2 estudiantes
        Estudiante [] vecE = new Estudiante[2]; 
        vecE[0] = new Estudiante("nombreEst1", "apellidoEst1", "comisionEst1", "emailEst1", "direccion1");
        vecE[1] = new Estudiante("nombreEst2", "apellidoEst2", "comisionEst2", "emailEst2", "direccion2");
       for (int i=0; i<2; i++){
           System.out.println(vecE[i].tusDatos());
       }
    }
    
}
