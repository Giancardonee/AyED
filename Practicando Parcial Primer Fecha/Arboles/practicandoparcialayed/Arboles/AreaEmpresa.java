package practicandoparcialayed.Arboles;
public class AreaEmpresa {
    int tardanza;
    String area;
    
    public AreaEmpresa (String area, int tardanza)
    {
        this.tardanza = tardanza;
        this.area = area;
    }

    public int getTardanza() {
        return tardanza;
    }
    
    public String getArea() {
        return area;
    }
    
    
}
