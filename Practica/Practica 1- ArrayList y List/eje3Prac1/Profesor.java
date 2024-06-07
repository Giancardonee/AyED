package practica1.eje3Prac1;

public class Profesor extends PersonaUniversitaria {
    private String catedra;
    private String facultad;

    public Profesor(String catedra, String facultad, String nombre, String apellido, String email) {
        super(nombre, apellido, email);               
        this.catedra = catedra;
        this.facultad = facultad;
    }

    public Profesor(String nombre, String apellido, String email) {
        super(nombre, apellido, email);
    }
    
    
    
    public String tusDatos(){
       String st = super.toString()+" "+this.getCatedra()+" "+this.getFacultad(); 
       return st;
    }
    
    public String getCatedra() {
        return catedra;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

}
