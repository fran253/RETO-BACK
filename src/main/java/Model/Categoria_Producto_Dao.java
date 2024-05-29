package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Categoria_Producto_Dao implements IDao<Categoria_Producto, String> {

    public final String SQL_FIND_ALL = "SELECT * FROM CATEGORIA_PRODUCTO WHERE 1=1";


    @Override
    public ArrayList<Categoria_Producto> findAll(Categoria_Producto filtro) {
        ArrayList<Categoria_Producto> categoria_productos = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            motor.connect();
            StringBuilder sqlBuilder = new StringBuilder(SQL_FIND_ALL);

            // Construimos la consulta SQL dinámicamente según los filtros proporcionados
            if (filtro != null) {
                if (filtro.getID_CategoriaProducto() != 0) {
                    sqlBuilder.append(" AND ID_CATEGORIAPRODUCTO = '")
                            .append(filtro.getID_CategoriaProducto()).append("'");
                }
                if (filtro.getNombre_CategoriaProducto() != null) {
                    sqlBuilder.append(" AND NOMBRE = '")
                            .append(filtro.getNombre_CategoriaProducto()).append("'");
                }
            }

            ResultSet rs = motor.executeQuery(sqlBuilder.toString());

            while (rs.next()) {
                Categoria_Producto categoria_producto = new Categoria_Producto();
                categoria_producto.setID_CategoriaProducto(rs.getInt("ID_CATEGORIAPRODUCTO"));
                categoria_producto.setNombre_CategoriaProducto(rs.getString("NOMBRE"));

                categoria_productos.add(categoria_producto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            categoria_productos.clear();
        } finally {
            motor.disconnect();
        }
        return categoria_productos;
    }




}
