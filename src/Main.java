import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        int i;
    Conexion con = new Conexion();
        try {
            if(con.establecerConexion()){
                ResultSet rs = con.ejecutarSentencia("Select * from libros");
                System.out.println("Titulo: " + "\tAutor: " + "\tFecha de Edición: " + "\tEditorial: ");
                while(rs.next()){
                    System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" +rs.getString(4) + "\t" );
                }
                i = con.ejecutarInsert("delete * from socios where Fecha_alta like '%2012%'");
                System.out.println(i);
                i = con.ejecutarInsert("Insert into socios(IdSocio,Nombre,Telefono,Fecha_alta) values ('9', 'Lucia', '912654215', #2017-01-01 00:00:00#)");
                System.out.println(i);
            }else{
                System.out.println("error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
