package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
 

public class Conexion {

    public static Connection getConexion() {
        Connection cn = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

           String url = "jdbc:sqlserver://localhost:1433;"
           + "databaseName=Colegio;"
           + "encrypt=false;"
           + "trustServerCertificate=true;";


            cn = DriverManager.getConnection(url, "sa", "1234");
            System.out.println("Conexion exitosa");

        } catch (Exception e) {
            System.out.println("ERROS DE CONECION " + e.getMessage());
        }
        return cn;
    }

}
