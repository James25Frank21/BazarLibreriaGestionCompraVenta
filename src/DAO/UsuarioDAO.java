
package DAO;

import UTIL.DbBean;
import BEAN.Usuario;
import java.sql.ResultSet;

public class UsuarioDAO {
    public boolean validarUsuario(String user){
        DbBean con = new DbBean();
        String sql;
        boolean sw = false;
        sql = "select nameUser from Usuario where Usuario = '"+ user +"'";
        System.out.println(sql);
        
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                if(user.equals(resultado.getString(1).toString())){
                    sw = true;
                }
            }
            resultado.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch (java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return sw;
    }
    
    public boolean validaContraseña(String user, String contra){
        DbBean con = new DbBean();
        String sql;
        boolean sw = false;
        
        sql = "select nameUser, Contraseña from Usuario where Usuario = '"+ user +"' and Contraseña = '"+ contra +"'";
        System.out.println(sql);
        
        try{
            ResultSet resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                if(user.equals(resultado.getString(1)) && contra.equals(resultado.getString(2))){
                    sw = true;
                }
            }
            resultado.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch (java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return sw;
    }    
}
