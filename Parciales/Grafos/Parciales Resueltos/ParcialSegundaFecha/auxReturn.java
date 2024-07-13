package parcialesgrafos.ParcialSegundaFecha;
public class auxReturn {
    private int cantUsuariosDistancia;
    private boolean esPopular;
    
    public auxReturn()
    {
        
    }

    public auxReturn(int cantUsuariosDistancia, boolean esPopular) {
        this.cantUsuariosDistancia = cantUsuariosDistancia;
        this.esPopular = esPopular;
    }

    
    
    public int getCantUsuariosDistancia() {
        return cantUsuariosDistancia;
    }

    public void setCantUsuariosDistancia(int cantUsuariosDistancia) {
        this.cantUsuariosDistancia = cantUsuariosDistancia;
    }

    public boolean isEsPopular() {
        return esPopular;
    }

    public void setEsPopular(boolean esPopular) {
        this.esPopular = esPopular;
    }
    
    public String toString()
    {
        
        return "Tengo "+cantUsuariosDistancia+ " amigos en esa distancia "+ " soy popular? "+isEsPopular();
    }
}
