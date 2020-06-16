package Clases;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author AA2020
 */
public class Conexion {
    private Connection conectar;

    public Conexion() {
        try {

            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/neveria_franchise",
                    "postgres", "laam");
        } catch (Exception e) {
        }
    }   

    public Connection getConectar() {
        return conectar;
    }
}
