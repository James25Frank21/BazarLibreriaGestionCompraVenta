
package DAO;

import UTIL.DbBean;
import BEAN.DetVenta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DetVentaDAO {

    public DetVentaDAO() {
    }
    
    public Vector<DetVenta> ListaItem(boolean sw, String cod){
        System.out.println("salida de read");
        DbBean con = new DbBean();
        Vector<DetVenta> item;
        item = new Vector<DetVenta>();        
        String sql = "SELECT * FROM  detVenta ";
        if(sw == true){
            sql = sql + " where descripcion like '"+ cod +"%'";
        }
        try{
            ResultSet resultado = con.resultadoSQL(sql);

            while(resultado.next()){
                DetVenta detVenta = new DetVenta();
                detVenta.setIdVenta(resultado.getInt(1));
                detVenta.setIdProducto(resultado.getInt(2));
                detVenta.setDescripcion(resultado.getString(3));
                detVenta.setPrecioVenta(resultado.getDouble(4));
                detVenta.setCantidad(resultado.getInt(5));
                detVenta.setCostoTotal(resultado.getDouble(6));
                detVenta.setFecha(resultado.getString(7));
                item.addElement(detVenta);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return item;
    }
    
    public void eliminarDeta(String idVe){
       int resultado=0;
       String sql= "";
       DbBean con=new DbBean();
       sql="delete * from detVenta  WHERE (IdDetaVenta = "+ idVe +")";
       System.out.println("Del dv "+sql);
       try{
          resultado=con.ejecutaSQL(sql);
        }
        catch(java.sql.SQLException e){e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
    }
    public int procesaItem(DetVenta dv, String proc){
       int resultado=0;
       String sql= "";
       System.out.println("procesa");
       DbBean con=new DbBean();
       if(proc.equals("insert")){
           System.out.println("se esta insertando: " + sql);
            double importe = dv.getCantidadv() * dv.getPrecioVenta();
            
            sql="INSERT INTO detVenta VALUES ("+ dv.getIdProducto()+", '"+
                    dv.getDescripcion()+"', "+ dv.getPrecioVenta()+", "+ 
                    dv.getCantidadv()+", "+ importe +", '"+dv.getFecha()+ "')";
            
            
       }
       if(proc.equals("update")){
            double importe = dv.getCantidadv() * dv.getPrecioVenta();
            sql="UPDATE detVenta SET IdProducto  = "+ dv.getIdProducto() +
                    ", Descripcion = '"+dv.getDescripcion()+
                    "', precioVenta = "+ dv.getPrecioVenta()+
                    ", cantidad = "+ dv.getCantidadv()+
                    ", costoTotal = " + importe +
                    ", fecha = '"+dv.getFecha()+ 
                    "' WHERE IdDetaVenta = "+ dv.getIdVenta()+ "" ;
       }
       System.out.println("Observando el estado de la sentencia sql: "+sql);

       try{
          resultado=con.ejecutaSQL(sql);
        }
        catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
        con.desconecta();
        }
        catch(java.sql.SQLException e){
            e.printStackTrace();
        }
          return resultado;
      } 
    
}
