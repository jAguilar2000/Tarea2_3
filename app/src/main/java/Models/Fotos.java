package Models;

public class Fotos {
    private Integer Id;
    private String Descripcion;
    private String Fotografia;

    public Fotos(Integer id, String descripcion, String fotografia) {
        this.Id = id;
        this.Descripcion = descripcion;
        this.Fotografia = fotografia;
    }

    public Fotos(){

    }

    public Integer getId(){return Id;}
    public void setId(Integer id){ Id = id;}
    public String getDescripcion(){return Descripcion;}
    public void setDescripcion(String descripcion){ Descripcion = descripcion;}
    public String getFotografia(){return Fotografia;}
    public void setFotografia(String fotografia){ Fotografia = fotografia;}
}
