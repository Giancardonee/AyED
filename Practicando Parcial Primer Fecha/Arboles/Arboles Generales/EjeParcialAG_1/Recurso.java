package EjeParcialAG_1;
public class Recurso {
     String nombre;
    String tipo; // archivo o carpeta
    
 public Recurso(String nombre, String tipo) {
    this.nombre = nombre;
    this.tipo = tipo;
 }
 
 public boolean esImagen() {
    if (tipo.equals("archivo")) {
        String ext = nombre.substring(nombre.indexOf('.') + 1);
        if (ext.equals("jpg") || ext.equals("png") || ext.equals("jpeg"))
            return true;
    }
 return false;
 }

}
