package BEAN;


public class Categoria {
    private int IdCategoria;
    private String nameCategoria;
    private String descripcion;

    public Categoria() {
    }

    public Categoria(int IdCategoria, String nameCategoria, String descripcion) {
        this.IdCategoria = IdCategoria;
        this.nameCategoria = nameCategoria;
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNameCategoria() {
        return nameCategoria;
    }

    public void setNameCategoria(String nameCategoria) {
        this.nameCategoria = nameCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
