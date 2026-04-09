package dao;

//IMPORTACIONES DE LA LIBRERIAS QUE  VAMOS USAR
import modelo.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import conexion.Conexion;
import java.sql.ResultSet;

public class AlumnoDAO {

    Connection cn = Conexion.getConexion();

    public void agregar(Alumno a) {

        String sql = "INSERT INTO Alucmno VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, a.getCodigo());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApeliido());
            ps.setString(4, a.getCurso());
            ps.setDouble(5, a.getEc1());
            ps.setDouble(6, a.getEc2());
            ps.setDouble(7, a.getEc3());
            ps.setDouble(8, a.getFinali());
            ps.setDouble(9, a.getPromedio());
            ps.setString(10, a.getObser());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en listar:" + e.getMessage());

        }

    }

    
    // Listar   a los alucmno en la tabla
    
    
    public List<Alumno> listar() {

        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT * FROM Alucmno";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Alumno a = new Alumno();

                a.setCodigo(rs.getString("CODIGO"));
                a.setNombre(rs.getString("NOMBRE"));
                a.setApeliido(rs.getString("APELLIDOS"));
                a.setCurso(rs.getString("CURSO"));
                a.setEc1(rs.getDouble("NOTA1"));
                a.setEc2(rs.getDouble("NOTA2"));
                a.setEc3(rs.getDouble("NOTA3"));
                a.setFinali(rs.getDouble("FINAL"));
                a.setPromedio(rs.getDouble("PROMEDIO"));
                a.setObser(rs.getString("OBSERVACIONES"));

                lista.add(a);

            }

        } catch (Exception e) {
            System.out.println("Error en listar:" + e.getMessage());
        }
        return lista;

    }

    
    //   busrcar  aluscnos 
    
    public Alumno buscar(String codigo) {
        Alumno a = new Alumno();
        String sql = "SELECT * FROM Alucmno WHERE codigo=?";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                a.setCodigo(rs.getString("CODIGO"));
                a.setNombre(rs.getString("NOMBRE"));
                a.setApeliido(rs.getString("APELIDDO"));
                a.setCurso(rs.getString("CURSO"));
                a.setEc1(rs.getDouble("NOTA1"));
                a.setEc2(rs.getDouble("NOTA2"));
                a.setEc3(rs.getDouble("NOTA3"));
                a.setPromedio(rs.getDouble("FINAL"));
                a.setPromedio(rs.getDouble("PROMEDIO "));
                a.setObser(rs.getString("OBSERVACIONES"));

            }

        } catch (Exception e) {
            System.out.println("Error en Buscar:" + e.getMessage());
        }
        return a;

    }
    
    
   public void eliminar(String codigo) {
    String sql = "DELETE FROM Alucmno WHERE CODIGO = ?";
    try {
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, codigo);
        ps.executeUpdate();
    } catch (Exception e) {
        System.out.println("Error en eliminar: " + e.getMessage());
    }
}
    
    
    
    
    

}
