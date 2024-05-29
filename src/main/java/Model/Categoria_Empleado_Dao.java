package Model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Categoria_Empleado_Dao implements IDao {

    public final String SQL_FIND_ALL = "SELECT * FROM CATEGORIA_EMPLEADO";



    public ArrayList findAll(Object bean) {
        ArrayList<Categoria_Empleado> categoria_empleados = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            motor.connect();
            String sql = SQL_FIND_ALL;
            if (bean != null) {
                if (((Categoria_Empleado) bean).getIDCategoria_Empleado() != null) {
                    sql += " E IDCategoria_Empleado='" + ((Categoria_Empleado) bean).getIDCategoria_Empleado() + "'";
                }
                if (((Categoria_Empleado) bean).getNombre_CategoriaEmpleado() != null) {
                    sql += " Y NOMBRE='" + ((Categoria_Empleado) bean).getNombre_CategoriaEmpleado() + "'";
                }

            }
            ResultSet rs = motor.executeQuery(sql);

            while (rs.next()) {
                Categoria_Empleado categoria_empleado = new Categoria_Empleado();
                categoria_empleado.setIDCategoria_Empleado(rs.getString("ID_CATEGORIAEMPLEADO"));
                categoria_empleado.setNombre_CategoriaEmpleado(rs.getString("NOMBRE"));


                categoria_empleados.add(categoria_empleado);
            }

        } catch (Exception ex) {
            categoria_empleados.clear();
        } finally {
            motor.disconnect();
        }
        return categoria_empleados;
    }



}