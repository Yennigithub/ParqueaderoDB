
package clases;
import java.sql.*;

public class Conexion {
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/parqueadero_db", "root", "Salud2014.");
            System.out.println("Conectado BD");
        } catch (Exception e) {
            System.out.println("Error al conectar BD");
        }
    }
    public int Reusuario(String nombre, String correo, String placa, String marca, String modelo) {
        int res=0;
        try {
            ps=cn.prepareStatement("insert into usuarios(nombre,correo,placa,marca,modelo)values(?,?,?,?,?) ");
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setString(3, placa);
            ps.setString(4, marca);
            ps.setString(5, modelo);
            res=ps.executeUpdate();
            System.out.println("Usuario registrado correctamente");
        } catch (Exception e) {
            System.out.println("Error al registrar");
        }
        return res;
    }
}
