package Model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

    public class Clientes_Dao implements IDao {

        public final String SQL_FIND_ALL = "SELECT * FROM CLIENTES";
        private final String SQL_DELETE = "DELETE FROM CLIENTES WHERE ID_CLIENTE = ";
        private final String SQL_UPDATE = "UPDATE CLIENTES SET NOMBRE = ?, APELLIDO = ?, GMAIL = ?, NUM_TELEFONO = ?, DIRECCION = ? WHERE ID_CLIENTE = ?";
        private final String SQL_ADD = "INSERT INTO CLIENTES (ID_CLIENTE, NOMBRE, APELLIDO, GMAIL, NUM_TELEFONO, DIRECCION)";


        MotorSQL motor = new MotorSQL();


        public ArrayList findAll(Object bean) {
            ArrayList<Clientes> clientes = new ArrayList<>();

            try {
                motor.connect();
                String sql = SQL_FIND_ALL;
                if (bean != null) {
                    if (((Clientes) bean).getId_cliente() != 0) {
                        sql += " WHERE ID_Cliente='" + ((Clientes) bean).getId_cliente() + "'";
                    }
                    if (((Clientes) bean).getNombre_Cliente() != null) {
                        sql += " AND Nombre='" + ((Clientes) bean).getNombre_Cliente() + "'";
                    }
                    if (((Clientes) bean).getApellidos_Cliente() != null) {
                        sql += " AND Apellidos='" + ((Clientes) bean).getApellidos_Cliente() + "'";
                    }
                    if (((Clientes) bean).getGmail_cliente() != null) {
                        sql += " AND Gmail='" + ((Clientes) bean).getGmail_cliente() + "'";
                    }
                    if (((Clientes) bean).getNum_telefono() != null) {
                        sql += " AND Num_telefono='" + ((Clientes) bean).getNum_telefono() + "'";
                    }
                    if (((Clientes) bean).getDireccion() != null) {
                        sql += " AND Direccion='" + ((Clientes) bean).getDireccion() + "'";
                    }
                }
                ResultSet rs = motor.executeQuery(sql);

                while (rs.next()) {
                    Clientes cliente = new Clientes();
                    cliente.setId_cliente(rs.getInt("ID_CLIENTE"));
                    cliente.setNombre_Cliente(rs.getString("NOMBRE"));
                    cliente.setApellidos_Cliente(rs.getString("APELLIDO"));
                    cliente.setGmail_cliente(rs.getString("GMAIL"));
                    cliente.setNum_telefono(rs.getString("NUM_TELEFONO"));
                    cliente.setDireccion(rs.getString("DIRECCION"));
                    //AÑADIR CONTRASEÑA

                    clientes.add(cliente);
                }

            } catch (Exception ex) {
                clientes.clear();
            } finally {
                motor.disconnect();
            }
            return clientes;
        }


        public int add(Clientes cliente) {
            int rowsAffected = 1;
            MotorSQL motor = new MotorSQL();
            motor.connect();
            String sql = SQL_ADD + "VALUES ("
                    + cliente.getId_cliente() + ", '"
                    + cliente.getNombre_Cliente() + "', '"
                    + cliente.getApellidos_Cliente() + "', '"
                    + cliente.getGmail_cliente() + "', '"
                    + cliente.getNum_telefono() + "', '"
                    + cliente.getDireccion() + "')";

            motor.executeQuery(sql);
            motor.disconnect();
            return rowsAffected;
        }



        public int update(Clientes bean) {
            int resp = 0;
            String sql;
            MotorSQL motor = new MotorSQL();
            try {
                motor.conectStatement();
                if (bean == null) {
                    System.out.println("Introduzca datos a modificar");
                } else {
                    PreparedStatement preparedStatement = motor.prepareStatement(SQL_UPDATE);

                    preparedStatement.setString(1, bean.getNombre_Cliente());
                    preparedStatement.setString(2, bean.getApellidos_Cliente());
                    preparedStatement.setString(3, bean.getGmail_cliente());
                    preparedStatement.setString(4, bean.getNum_telefono());
                    preparedStatement.setString(5, bean.getDireccion());
                    preparedStatement.setInt(6, bean.getId_cliente());

                    resp = motor.execute(preparedStatement);
                }

            } catch (Exception e) {

            } finally {
                motor.disconnect();
            }

            if (resp > 0) {
                System.out.println("Cliente actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar.");
            }
            return resp;
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



    }


