package Model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Pedidos_Dao implements IDao {

    public final String SQL_FIND_ALL = "SELECT * FROM Pedido";


    public ArrayList<Pedidos> findAll(Object bean) {
        ArrayList<Pedidos> pedidos = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            motor.connect();
            String sql = SQL_FIND_ALL;
            if (bean != null) {
                if (((Pedidos) bean).getId_pedido() != null) {
                    sql += " WHERE id_pedido='" + ((Pedidos) bean).getId_pedido() + "'";
                }
                if (((Pedidos) bean).getId_cliente() != null) {
                    sql += " AND id_cliente='" + ((Pedidos) bean).getId_cliente() + "'";
                }
                if (((Pedidos) bean).getFecha() != null) {
                    sql += " AND fecha='" + new java.sql.Date(((Pedidos) bean).getFecha().getTime()) + "'";
                }
                if (((Pedidos) bean).getId_empleado() != null) {
                    sql += " AND id_empleado='" + ((Pedidos) bean).getId_empleado() + "'";
                }
            }
            ResultSet rs = motor.executeQuery(sql);

            while (rs.next()) {
                Pedidos pedido = new Pedidos();
                pedido.setId_pedido(rs.getString("ID_PEDIDO"));
                pedido.setId_cliente(rs.getString("ID_CLIENTE"));
                pedido.setFecha(rs.getDate("FECHA"));
                pedido.setId_empleado(rs.getString("ID_EMPLEADO"));

                pedidos.add(pedido);
            }

        } catch (Exception ex) {
            pedidos.clear();
        } finally {
            motor.disconnect();
        }
        return pedidos;
    }




}
