package practica1.eje7prac1;

import java.util.Iterator;
import java.util.List;
import practica1.eje3Prac1.PersonaUniversitaria;

public class Estudiante extends PersonaUniversitaria{ 
    private String comision; 
    private String direccion; 

    
    //------METODOS ESTATICOS-----------------------------------------------------
    private static boolean estudiantesIguales(Estudiante est1, Estudiante est2){
        return (est1.equals(est2));
    }
    
    
        
    //-------------------------------------------------------------------------
    /*              PREGUNTAR 
    Tengo dudas si está bien hacerlo con el break, o hay que usar un while.
    */
    public static boolean existeEstudiante (List <Estudiante> lista, Estudiante estParametro){
        boolean existeEstudiante = false; 
        for (Estudiante estAct : lista){
            if (estudiantesIguales(estAct, estParametro)){
                existeEstudiante = true; 
                break; 
            }
        }        
      return existeEstudiante;    
    }
    
    public static boolean existeEstudiante2 (List <Estudiante> lista, Estudiante estParametro){
        boolean existeEstudiante = false; 
        Iterator <Estudiante> it = lista.iterator(); 
        while ( (it.hasNext()) && (!existeEstudiante)){
            if (estudiantesIguales(it.next(), estParametro)){
                existeEstudiante = true; 
            }
        }
       return existeEstudiante;
    }
            
    //-------------------------------------------------------------------------
    public static void agregarEstudiante (List<Estudiante> lista, Estudiante estParametro){
        if (!existeEstudiante(lista, estParametro)){
            lista.add(estParametro);
            System.out.println("Se agrego el estudiante Correctamente!");
        }
        else{System.out.println("El estudiante ya existe."); }
    }
    
    public static void imprimirListaEstudiante(List<Estudiante> lista){
        for(Estudiante estudianteAct : lista){
            System.out.println(estudianteAct);
        }
    }
    
    //-----------------------------------------------------------------------------
    public Estudiante(String nombre, String apellido, String comision, String email, String direccion) {
        super(nombre,apellido,email); 
        this.comision = comision;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        String st = super.toString()+"comision:  " + comision + ", direccion:  " + direccion ; 
        return st;
    }

    
    
    public Estudiante(String nombre, String apellido, String email) {
        super(nombre, apellido, email);
    }
   
    public String tusDatos(){
        String st = super.toString()+" "+this.getComision()+" "+this.getDireccion();
        return st;
    }
    
    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
}
