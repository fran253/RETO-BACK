package Model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Detalle_Dao implements IDao {

    public final String SQL_FIND_ALL = "SELECT * FROM Detalle";


    public ArrayList<Detalle> findAll(Object bean) {
        ArrayList<Detalle> detalles = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            motor.connect();
            String sql = SQL_FIND_ALL;
            if (bean != null) {
                if (((Detalle) bean).getId_detalle() != 0) {
                    sql += " WHERE id_detalle='" + ((Detalle) bean).getId_detalle() + "'";
                }
                if (((Detalle) bean).getId_pedido() != 0) {
                    sql += " AND id_pedido='" + ((Detalle) bean).getId_pedido() + "'";
                }
                if (((Detalle) bean).getId_producto() != 0) {
                    sql += " AND id_producto='" + ((Detalle) bean).getId_producto() + "'";
                }
                if (((Detalle) bean).getPrecio_detalle() != 0) {
                    sql += " AND precio='" + ((Detalle) bean).getPrecio_detalle() + "'";
                }
                if (((Detalle) bean).getCantidad() != 0) {
                    sql += " AND cantidad='" + ((Detalle) bean).getCantidad() + "'";
                }
            }
            ResultSet rs = motor.executeQuery(sql);

            while (rs.next()) {
                Detalle detalle = new Detalle();
                detalle.setId_detalle(rs.getInt("ID_DETALLE"));
                detalle.setId_pedido(rs.getInt("ID_PEDIDO"));
                detalle.setId_producto(rs.getInt("ID_PRODUCTO"));
                detalle.setPrecio_detalle(rs.getInt("PRECIO"));
                detalle.setCantidad(rs.getInt("CANTIDAD"));

                detalles.add(detalle);
            }

        } catch (Exception ex) {
            detalles.clear();
        } finally {
            motor.disconnect();
        }
        return detalles;
    }




}
