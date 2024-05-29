package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Empleados_Dao implements IDao {

    public final String SQL_FIND_ALL = "SELECT * FROM EMPLEADOS";
    private final String SQL_DELETE = "DELETE FROM EMPLEADOS WHERE ID_EMPLEADO = ";
    private final String SQL_ADD = "INSERT INTO EMPLEADOS (ID_EMPLEADO, NOMBRE, APELLIDO, GMAIL, NUM_TELEFONO, ID_CATEGORIAEMPLEADO, CONTRASENA)";
    private final String SQL_UPDATE = "UPDATE EMPLEADOS SET  NOMBRE = ?, APELLIDO = ?, GMAIL = ?, NUM_TELEFONO = ?, ID_CATEGORIAEMPLEADO = ?, CONTRASENA = ? WHERE ID_EMPLEADO = ?";

    MotorSQL motor = new MotorSQL();

    public ArrayList<Empleados> findAll(Object bean) {
        ArrayList<Empleados> empleados = new ArrayList<>();
        try {
            motor.connect();
            String sql = SQL_FIND_ALL;
            /*if (bean != null) {
                if (((Empleados) bean).getId_empleado() != 0) {
                    sql += " WHERE id_empleado='" + ((Empleados) bean).getId_empleado() + "'";
                }
                if (((Empleados) bean).getId_categoriaEmpleado() != null) {
                    sql += " AND id_categoriaEmpleado='" + ((Empleados) bean).getId_categoriaEmpleado() + "'";
                }
                if (((Empleados) bean).getNombre_empleado() != null) {
                    sql += " AND nombre='" + ((Empleados) bean).getNombre_empleado() + "'";
                }
                if (((Empleados) bean).getApellido_empleado() != null) {
                    sql += " AND apellido='" + ((Empleados) bean).getApellido_empleado() + "'";
                }
                if (((Empleados) bean).getGmail_empleado() != null) {
                    sql += " AND gmail='" + ((Empleados) bean).getGmail_empleado() + "'";
                }
                if (((Empleados) bean).getNum_telefono() != null) {
                    sql += " AND num_telefono='" + ((Empleados) bean).getNum_telefono() + "'";
                }
                if (((Empleados) bean).getContrasena() != null) {
                    sql += " AND contrasena='" + ((Empleados) bean).getContrasena() + "'";
                }
            }*/
            ResultSet rs = motor.executeQuery(sql);

            while (rs.next()) {
                Empleados empleado = new Empleados();
                empleado.setId_empleado(rs.getInt("ID_EMPLEADO"));
                empleado.setNombre_empleado(rs.getString("NOMBRE"));
                empleado.setApellido_empleado(rs.getString("APELLIDO"));
                empleado.setGmail_empleado(rs.getString("GMAIL"));
                empleado.setNum_telefono(rs.getString("NUM_TELEFONO"));
                empleado.setId_categoriaEmpleado(rs.getString("ID_CATEGORIAEMPLEADO"));
                empleado.setContrasena(rs.getString("CONTRASENA"));
                empleados.add(empleado);
            }

        } catch (Exception ex) {
            empleados.clear();
        } finally {
            motor.disconnect();
        }
        return empleados;
    }

    public int add(Empleados empleado) {
        int rowsAffected = 1;
        MotorSQL motor = new MotorSQL();
        motor.connect();
        String sql = SQL_ADD + "VALUES ("
                + empleado.getId_empleado() + ", '"
                + empleado.getNombre_empleado() + "', '"
                + empleado.getApellido_empleado() + "', '"
                + empleado.getGmail_empleado() + "', '"
                + empleado.getNum_telefono() + "', '"
                + empleado.getId_categoriaEmpleado() + "', '"
                + empleado.getContrasena() + "')";

            motor.executeQuery(sql);
            motor.disconnect();
        return rowsAffected;
    }

    public int delete(int iIdElement) {
        int iRet = 0;
        try {
            motor.connect();
            String sql = SQL_DELETE + iIdElement;

            iRet = motor.executeUpdate(sql);

        }catch (Exception ex)
        {
            iRet = -1;
        }
        finally {
            motor.disconnect();
        }
        return iRet;
    }



    public int update(Empleados bean) {
        int resp = 0;
        String sql;
        MotorSQL motor = new MotorSQL();
        try {
            motor.conectStatement();
            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {
                PreparedStatement preparedStatement = motor.prepareStatement(SQL_UPDATE);

                preparedStatement.setString(1, bean.getNombre_empleado());
                preparedStatement.setString(2, bean.getApellido_empleado());
                preparedStatement.setString(3, bean.getGmail_empleado());
                preparedStatement.setString(4, bean.getNum_telefono());
                preparedStatement.setString(5, bean.getId_categoriaEmpleado());
                preparedStatement.setString(6, bean.getContrasena());
                preparedStatement.setInt(7, bean.getId_empleado());

                resp = motor.execute(preparedStatement);
            }

        } catch (Exception e) {

        } finally {
            motor.disconnect();
        }

        if (resp > 0) {
            System.out.println("Empleado actualizado con éxito.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
        return resp;
    }


}
