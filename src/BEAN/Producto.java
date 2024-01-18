
package BEAN;


public class Producto  {
    private int IdProducto;
    private String nombreProducto;
    private int IdCategoria;
    private double precioProducto;
    private int cantidad;
    private double costoTotal;
    private String  fecha;

    public Producto() {
    }

    public Producto(int IdProducto, String nombreProducto, int IdCategoria, double precioProducto, int cantidad, double costoTotal, String fecha) {
        this.IdProducto = IdProducto;
        this.nombreProducto = nombreProducto;
        this.IdCategoria = IdCategoria;
        this.precioProducto = precioProducto;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.fecha = fecha;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
