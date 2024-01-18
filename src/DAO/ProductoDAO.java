
package DAO;
import UTIL.DbBean;
import BEAN.Producto;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {

    public ProductoDAO() {
    }
    
    //read
    public Vector<Producto> listaProductos(boolean sw,String cod){
        System.out.println("esto es read");
        DbBean con = new DbBean();
        Vector<Producto> listaProd;
        listaProd = new Vector<Producto>();
        String sql;
        sql = "select * from producto";
        if(sw == true){
            sql = sql + " where descripcion like '"+ cod +"%'";
        }
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            
            while(resultado.next()){
                Producto  prod = new Producto();
                prod.setIdProducto(resultado.getInt(1));
                prod.setNombreProducto(resultado.getString(2));
                prod.setIdCategoria(resultado.getInt(3));
                prod.setPrecioProducto(resultado.getDouble(4));
                prod.setCantidad(resultado.getInt(5));
                prod.setCostoTotal(resultado.getDouble(6));
                prod.setFecha(resultado.getString(7));
                listaProd.addElement(prod);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            
        }try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        
       return listaProd; 
    }
    
    //insert and update
    public int procesaItems(Producto e, String pc){
        int resultado = 0;
        String sql = "";
        System.out.println("procesa");
        DbBean con = new DbBean();
        if(pc.equals("insert")){
            System.out.println("Se esta insertando" + sql);
            double importe = e.getCantidad() * e.getPrecioProducto();

            sql = " INSERT INTO Producto values ( '"+ e.getNombreProducto() +"' , "+ e.getIdCategoria() +" , "+ e.getPrecioProducto() + ", "+ e.getCantidad()+ " , "+ importe+ " , '"+ e.getFecha() + "')";
        }
        if(pc.equals("update")){
             double importe = e.getCantidad() * e.getPrecioProducto();
             
            sql = " UPDATE Producto set NombreProducto = '"+ e.getNombreProducto() +"' , IdCategoria = "+
                    e.getIdCategoria()+" , precioProducto = "+ e.getPrecioProducto() + ", cantidad = "+
                    e.getCantidad()+ " , costoTotal = "+ importe + " ,fecha =  '"+
                    e.getFecha() + "' where  IdProducto = "+ e.getIdProducto()+"";
        }
        System.out.println("analizando el estado de la sentencia sql: "+ sql);
        
        try{
            resultado = con.ejecutaSQL(sql);
            
        }catch(java.sql.SQLException ex){
            ex.printStackTrace();
        }try{
            con.desconecta();
        }catch(SQLException ex){
            
        }
        return resultado;
    }
    //delete
    public void eliminarProducto(Producto prod){
        DbBean con;
        con = new DbBean();
        String sql;
        sql = "delete from Producto where IdProducto = "+ "'"+ prod.getIdProducto()+"'";
        
        System.out.println("Se esta eliminando: " + sql);
        try{
            con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }



    
}
