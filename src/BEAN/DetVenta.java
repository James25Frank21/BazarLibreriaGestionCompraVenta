
package BEAN;

public class DetVenta {
    private int IdVenta;
    private int IdProducto;
    private String descripcion;
    private double precioVenta;
    private int cantidadV;
    private double costoTotal;
    private String fecha;

    public DetVenta() {
    }

    public DetVenta(int IdVenta, int IdProducto, String descripcion, double precioVenta, int cantidad, double costoTotal, String fecha) {
        this.IdVenta = IdVenta;
        this.IdProducto = IdProducto;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.cantidadV = cantidad;
        this.costoTotal = costoTotal;
        this.fecha = fecha;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidadv() {
        return cantidadV;
    }

    public void setCantidad(int cantidad) {
        this.cantidadV = cantidad;
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
