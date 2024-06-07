package Practica3.eje4;
public class AreaEmpresa {
 private String identificacion; 
 private int tardanza; 
 
    public AreaEmpresa(String identificacion, int tardanza){
        this.identificacion = identificacion; 
        this.tardanza = tardanza; 
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public int getTardanza() {
        return tardanza;
    }
 
    
}
