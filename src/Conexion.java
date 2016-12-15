import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Conexion {
    private Connection conexion;
    private Statement sentencia;
    private final String controlador;
    private final String nombre_bd;
    private final String usuarioBD;
    private final String passwordBD;

    public Conexion(){
        this.controlador="sun.jdbc.odbc.JdbcOdbcDriver";
        this.nombre_bd="biblioteca1.accdb";
        this.usuarioBD="";
        this.passwordBD="";
    }

    public boolean EstablecerConexion() throws SQLException{
        String url = "jdbc:ucanaccess://" + nombre_bd;

        try{
            conexion=DriverManager.getConnection(url);
        } catch (SQLException e){
            System.out.println(e);
            return false;
        }
        try {
            this.sentencia=this.conexion.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        }
        catch (SQLException e) {
            return false;
        }
        return true;
    }
    public ResultSet EjecutarSentencia( String sql) throws SQLException{
        ResultSet rs;
        rs = this.sentencia.executeQuery(sql);
        return rs;
    }
}