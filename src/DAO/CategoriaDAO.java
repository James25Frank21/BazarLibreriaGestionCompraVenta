
package DAO;

import BEAN.Categoria;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class CategoriaDAO {

    public CategoriaDAO() {
    }
    
    //read
    public Vector<Categoria> listaCategoria(boolean sw,String cod){
        System.out.println("esto es read");
        DbBean con = new DbBean();
        Vector<Categoria> listaCate;
        listaCate = new Vector<Categoria>();
        String sql;
        sql = "SELECT * FROM categoria ";
        if(sw == true){
            sql = sql + " where descripcion like '"+ cod +"%'";
        }
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            
            while(resultado.next()){
                Categoria  cate = new Categoria();
                cate.setIdCategoria(resultado.getInt(1));
                cate.setNameCategoria(resultado.getString(2));
                cate.setDescripcion(resultado.getString(3));
                
                listaCate.addElement(cate);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            
        }try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        
       return listaCate; 
    }
    
    //insert and update
    public int procesaItems(Categoria e, String pc){
        int resultado = 0;
        String sql = "";
        System.out.println("procesa");
        DbBean con = new DbBean();
        if(pc.equals("insert")){
            System.out.println("Se esta insertando" + sql);
            sql = " INSERT INTO Categoria values ( '"+ e.getNameCategoria() +"' , '"+ e.getDescripcion() +"')";
        }
            if(pc.equals("update")){
            sql = " UPDATE categoria set NombreCategoria = '"+ e.getNameCategoria() +"' , descripcion = '"+ e.getDescripcion()+ "' where IdCategoria = '"+ e.getIdCategoria()+ "'";
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
    public void eliminarCategoria(Categoria cate){
        DbBean con;
        con = new DbBean();
        String sql;
        sql = "delete from Categoria where IdCategoria = "+ "'"+ cate.getIdCategoria()+"'";
        
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
