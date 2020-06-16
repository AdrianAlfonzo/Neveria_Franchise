package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author AA2020
 */
public class Franquicia {
    private String IDFra;
    private String nameFra;
    private String lastFra;
    private String countryFra;
    private String directFra;
    private String phoneFra;
    private String cellFra;
    private String emailFra;
    private Connection conn;
    
    public Franquicia(Connection conn)
    {
        this.conn = conn;
    }
    
    public Franquicia(String ID, String nombre, String apellido, String pais, String direccion, String tel, String cel, String mail, Connection conn)
    {
        this.IDFra = ID;
        this.nameFra = nombre;
        this.lastFra = apellido;
        this.countryFra = pais;
        this.directFra = direccion;
        this.phoneFra = tel;
        this.cellFra = cel;
        this.emailFra = mail;
        this.conn = conn;
    }
    
    public ResultSet consultar() {
        try {
            Statement stmt = this.conn.createStatement();
            return stmt.executeQuery("SELECT * FROM interesado_franchise ORDER BY id_interesado;");
        } catch (Exception e) {
            return null;
        }
    }

    public int siguienteId() {
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(id_interesado)+1 FROM interesado_franchise;");
            int tID = 0;
            if (rs.next()) {
                tID = rs.getInt(1);
            }
            return rs.getInt(1);
        } catch (Exception e) {
            return 0;

        }
    }

    public void insertar() {
        try {
            String query = "INSERT INTO interesado_franchise (id_interesado, nombre_interesado, apellido_interesado, pais_interesado, direccion_interesado, telefono_interesado, celular_interesado, correo_interesado)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = this.conn.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(this.IDFra));
            pst.setString(2, this.nameFra);
            pst.setString(3, this.lastFra);
            pst.setString(4, this.countryFra);
            pst.setString(5, this.directFra);
            pst.setInt(6, Integer.parseInt(this.phoneFra));
            pst.setInt(7, Integer.parseInt(this.cellFra));
            pst.setString(8, this.emailFra);

            // execute the preparedstatement
            pst.execute();
        } catch (Exception e) {

        }
    }

    public void borrar() {
        try {
            Statement stm = conn.createStatement();
            stm.executeQuery("DELETE FROM interesado_franchise WHERE id_interesado=" + this.IDFra.toString());
        } catch (Exception ee) {
        }
    }

    public void actualizar(int id, Franquicia editar) {
        try {
            String query = "update interesado_franchise set nombre_interesado=?, apellido_interesado=?, pais_interesado=?, direccion_interesado=?, telefono_interesado=?, celular_interesado=?, correo_interesado=?"
                    + "where id_interesado = " + this.IDFra.toString();

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, editar.GetNameFra());
            pst.setString(2, editar.GetLastFra());
            pst.setString(3, editar.GetCountryFra());
            pst.setString(4, editar.GetDirectFra());
            pst.setInt(5, Integer.parseInt(editar.GetPhoneFra()));
            pst.setInt(6, Integer.parseInt(editar.GetCellFra()));
            pst.setString(7, editar.GetEmailFra());

            pst.execute();

        } catch (Exception e) {
        }
    }

    public ResultSet BuscarUser(int id) {
        try {
            Statement stmt = conn.createStatement();
            String query = "select * from interesado_franchise where id_interesado = " + id;
            ResultSet rs = stmt.executeQuery(query);           
            return rs;
        } catch (Exception e) {
            return null;
        }
    }
    
    public String GetID()
    {
        return IDFra;
    }
    public void SetID(String ID)
    {
        this.IDFra = ID;
    }
    public String GetNameFra()
    {
        return nameFra;
    }
    
    public void SetNameFra(String nameFra)
    {
        this.nameFra = nameFra;
    }
    
    public String GetLastFra()
    {
        return lastFra;
    }
    
    public void SetLastFra(String lastFra)
    {
        this.lastFra = lastFra;
    }
    
    public String GetCountryFra()
    {
        return countryFra;
    }
    
    public void SetCountryFra(String countryFra)
    {
        this.countryFra = countryFra;
    }
    
    public String GetDirectFra()
    {
        return directFra;
    }
    
    public void SetDirectFra(String directFra)
    {
        this.directFra = directFra;
    }
    
    public String GetPhoneFra()
    {
        return phoneFra;
    }
    
    public void SetPhoneFra(String phoneFra)
    {
        this.phoneFra = phoneFra;
    }
    
    public String GetCellFra()
    {
        return cellFra;
    }
    
    public void SetCellFra(String cellFra)
    {
        this.cellFra = cellFra;
    }
    
    public String GetEmailFra()
    {
        return emailFra;
    }
    
    public void SetEmailFra(String emailFra)
    {
        this.emailFra = emailFra;
    }
    
    public Connection getConn() {
        return conn;
    }
}
