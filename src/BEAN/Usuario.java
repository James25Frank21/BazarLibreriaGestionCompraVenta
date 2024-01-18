
package BEAN;


public class Usuario {
    private int IdUsuario;
    private String nameUser;
    private String contrasenia;

    public Usuario() {
    }

    public Usuario(int IdUsuario, String nameUser, String contrasenia) {
        this.IdUsuario = IdUsuario;
        this.nameUser = nameUser;
        this.contrasenia = contrasenia;
    }
    

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}

