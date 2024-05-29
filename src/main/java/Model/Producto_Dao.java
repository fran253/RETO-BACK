package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Producto_Dao implements IDao<Producto, Integer> {

    private final String SQL_ADD = "INSERT INTO PRODUCTOS (ID_PRODUCTO, IMAGEN, NOMBRE, DESCRIPCION, ID_CATEGORIAPRODUCTO, PRECIO)";
    private final String SQL_DELETE = "DELETE FROM PRODUCTOS WHERE ID_PRODUCTO = ";
    private final String SQL_UPDATE = "UPDATE PRODUCTOS SET IMAGEN = ?, NOMBRE = ?, DESCRIPCION = ?, PRECIO = ?, ID_CATEGORIAPRODUCTO = ? WHERE ID_PRODUCTO = ?";
    private final String SQL_FIND_ALL = "SELECT * FROM PRODUCTOS";
    private final String SQL_FIND_HAMBURGER = "SELECT * FROM PRODUCTOS WHERE ID_CATEGORIAPRODUCTO = 1";
    private final String SQL_FIND_FITTINGS = "SELECT * FROM PRODUCTOS WHERE ID_CATEGORIAPRODUCTO = 2";
    private final String SQL_FIND_DESSERT = "SELECT * FROM PRODUCTOS WHERE ID_CATEGORIAPRODUCTO = 3";
    private final String SQL_FIND_DRIKS = "SELECT * FROM PRODUCTOS WHERE ID_CATEGORIAPRODUCTO = 4";
    private final String SQL_FIND_ZARAGOZASPECIAL = "SELECT * FROM PRODUCTOS WHERE ID_CATEGORIAPRODUCTO = 5";
    MotorSQL motor = new MotorSQL();


    public int add(Producto producto) {
        int rowsAffected = 1;
        MotorSQL motor = new MotorSQL();
        motor.connect();
        String sql = SQL_ADD + "VALUES ("
                + producto.getId_producto() + ", '"
                + producto.getImagen() + "', '"
                + producto.getNombreProducto() + "', '"
                + producto.getDescripcion() + "', "
                + producto.getId_categoria_producto() + ", "
                + producto.getPrecio() + ")";

            motor.executeQuery(sql);
            motor.disconnect();
        return rowsAffected;
    }





    public ArrayList<Producto> findAll(Producto bean) {
        ArrayList<Producto> productos = new ArrayList<>();
        MotorSQL motor = new MotorSQL();
        try {
            motor.connect();
            String sql = SQL_FIND_ALL;
            /*         if (bean != null) {
                if (((Producto) bean).getId_producto() != null) {
                    sql += " WHERE id_producto='" + ((Producto) bean).getId_producto() + "'";
                }
                if (((Producto) bean).getImagen() != null) {
                    sql += " AND imagen='" + ((Producto) bean).getImagen() + "'";
                }
                if (((Producto) bean).getNombreProducto() != null) {
                    sql += " AND nombreProducto='" + ((Producto) bean).getNombreProducto() + "'";
                }
                if (((Producto) bean).getDescripcion() != null) {
                    sql += " AND Descripcion='" + ((Producto) bean).getDescripcion() + "'";
                }
                if (((Producto) bean).getId_categoria_producto() != null) {
                    sql += " AND id_categoria_producto='" + ((Producto) bean).getId_categoria_producto() + "'";
                }
                if (((Producto) bean).getPrecio() != 0) {
                    sql += " AND precio='" + ((Producto) bean).getPrecio() + "'";
                }
            }*/
            ResultSet rs = motor.executeQuery(sql);

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("ID_PRODUCTO"));
                producto.setImagen(rs.getString("IMAGEN"));
                producto.setNombreProducto(rs.getString("NOMBRE"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                producto.setId_categoria_producto(rs.getInt("ID_CATEGORIAPRODUCTO"));
                producto.setPrecio(rs.getInt("PRECIO"));
                productos.add(producto);
            }

        } catch (Exception ex) {
            productos.clear();
        } finally {
            motor.disconnect();
        }
        return productos;
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






    public int update(Producto bean) {
        int resp = 0;
        String sql;
        MotorSQL motor = new MotorSQL();
        try {
            motor.conectStatement();
            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {
                PreparedStatement preparedStatement = motor.prepareStatement(SQL_UPDATE);

                preparedStatement.setString(1, bean.getImagen());
                preparedStatement.setString(2, bean.getNombreProducto());
                preparedStatement.setString(3, bean.getDescripcion());
                preparedStatement.setInt(4, bean.getPrecio());
                preparedStatement.setInt(5, bean.getId_categoria_producto());
                preparedStatement.setInt(6, bean.getId_producto());

                resp = motor.execute(preparedStatement);
            }

        } catch (Exception e) {

        } finally {
            motor.disconnect();
        }

        if (resp > 0) {
            System.out.println("Producto actualizada con éxito.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
        return resp;
    }




    public ArrayList<Producto> findHamburger(Producto objeto) {

        ArrayList<Producto>productos = new ArrayList<>();
        MotorSQL motor = new MotorSQL();

        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(SQL_FIND_HAMBURGER);
            while (rs.next())
            {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("ID_PRODUCTO"));
                producto.setImagen(rs.getString("IMAGEN"));
                producto.setNombreProducto(rs.getString("NOMBRE"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                producto.setId_categoria_producto(rs.getInt("ID_CATEGORIAPRODUCTO"));
                producto.setPrecio(rs.getInt("PRECIO"));
                productos.add(producto);
            }
        }catch (Exception ex)
        {
            productos.clear();
        }
        finally
        {
            motor.disconnect();
        }
        return productos;
    }

    public ArrayList<Producto> findFittings(Object bean) {

        ArrayList<Producto>products = new ArrayList<>();
        MotorSQL motor = new MotorSQL();

        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(SQL_FIND_FITTINGS);
            while (rs.next())
            {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("ID_PRODUCTO"));
                producto.setImagen(rs.getString("IMAGEN"));
                producto.setNombreProducto(rs.getString("NOMBRE"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                producto.setId_categoria_producto(rs.getInt("ID_CATEGORIAPRODUCTO"));
                producto.setPrecio(rs.getInt("PRECIO"));
                products.add(producto);
            }
        }catch (Exception ex)
        {
            products.clear();
        }
        finally
        {
            motor.disconnect();
        }
        return products;
    }

    public ArrayList<Producto> findDessert(Object o) {

        ArrayList<Producto>products = new ArrayList<>();
        MotorSQL motor = new MotorSQL();

        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(SQL_FIND_DESSERT);
            while (rs.next())
            {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("ID_PRODUCTO"));
                producto.setImagen(rs.getString("IMAGEN"));
                producto.setNombreProducto(rs.getString("NOMBRE"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                producto.setId_categoria_producto(rs.getInt("ID_CATEGORIAPRODUCTO"));
                producto.setPrecio(rs.getInt("PRECIO"));
                products.add(producto);
            }
        }catch (Exception ex)
        {
            products.clear();
        }
        finally
        {
            motor.disconnect();
        }
        return products;
    }

    public ArrayList<Producto> findDrink(Object o) {

        ArrayList<Producto>products = new ArrayList<>();
        MotorSQL motor = new MotorSQL();

        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(SQL_FIND_DRIKS);
            while (rs.next())
            {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("ID_PRODUCTO"));
                producto.setImagen(rs.getString("IMAGEN"));
                producto.setNombreProducto(rs.getString("NOMBRE"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                producto.setId_categoria_producto(rs.getInt("ID_CATEGORIAPRODUCTO"));
                producto.setPrecio(rs.getInt("PRECIO"));
                products.add(producto);
            }
        }catch (Exception ex)
        {
            products.clear();
        }
        finally
        {
            motor.disconnect();
        }
        return products;
    }

    public ArrayList<Producto> findSpecial(Object o) {

        ArrayList<Producto>products = new ArrayList<>();
        MotorSQL motor = new MotorSQL();

        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(SQL_FIND_ZARAGOZASPECIAL);
            while (rs.next())
            {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("ID_PRODUCTO"));
                producto.setImagen(rs.getString("IMAGEN"));
                producto.setNombreProducto(rs.getString("NOMBRE"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                producto.setId_categoria_producto(rs.getInt("ID_CATEGORIAPRODUCTO"));
                producto.setPrecio(rs.getInt("PRECIO"));
                products.add(producto);
            }
        }catch (Exception ex)
        {
            products.clear();
        }
        finally
        {
            motor.disconnect();
        }
        return products;
    }
}
