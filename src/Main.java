import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
    Conexion con = new Conexion();
        try {
            if(con.EstablecerConexion()){
                ResultSet rs = con.EjecutarSentencia("Select * from libros");
                System.out.println("Titulo: " + "\tAutor: " + "\tFecha de Edición: " + "\tEditorial: ");
                while(rs.next()){
                    System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" +rs.getString(4) + "\t" );
                }
            }else{
                System.out.println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
