package Controller.Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;

import java.util.ArrayList;

public class Producto_Action implements IAction {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        String strReturn ="";
        switch(action) {
            case "HAMBURGUESAS":
                strReturn = findHamburger();
                break;
            case "GUARNICIONES":
                strReturn = findFittings();
                break;
            case "POSTRES":
                strReturn = findDessert();
                break;
            case "BEBIDAS":
                strReturn = findDrink();
                break;
            case "ZARAGOZASPECIAL":
                strReturn = findSpecial();
                break;
            case "DELETE":
                strReturn = delete(request);
                break;
            case "FIND_ALL":
                strReturn = findAll();
                break;
            case "ADD":
                strReturn = add(request);
                break;
            case "UPDATE":
                strReturn = update(request);
                break;
            default:
                strReturn = "ERROR.Invalid Action";
        }

        return strReturn;
    }


    private String update(HttpServletRequest request) {
        String imagen = request.getParameter("IMAGEN");
        String id_producto = request.getParameter("ID_PRODUCTO");
        String nombre = request.getParameter("NOMBRE");
        String descripcion = request.getParameter("DESCRIPCION");
        String id_categoria_producto = request.getParameter("ID_CATEGORIAPRODUCTO");
        String precio = request.getParameter("PRECIO");



        Producto producto = new Producto();
        producto.setImagen(imagen);
        producto.setId_producto(Integer.parseInt(id_producto));
        producto.setNombreProducto(nombre);
        producto.setDescripcion(descripcion);
        producto.setId_categoria_producto(Integer.parseInt(id_categoria_producto));
        producto.setPrecio(Integer.parseInt(precio));

        Producto_Dao productoDao = new Producto_Dao();
        int Realizado = productoDao.update(producto);

        if (Realizado<=0){
            return "Ha ido mal";

        }
        else {
            return "Ha ido bien";
        }

    }

    public String delete(HttpServletRequest request) {

        Producto_Dao productoDao = new Producto_Dao();

        int id_producto = Integer.parseInt(request.getParameter("ID_PRODUCTO"));

        Integer iRet = productoDao.delete(id_producto);
        return iRet.toString();
    }





    ///////////////////FILTRADO///////////////
    private String findHamburger()
    {
        Producto_Dao productsDao = new Producto_Dao();
        ArrayList<Producto> productos = productsDao.findHamburger(null);
        return Producto.toArrayJSon(productos);
    }

    private String findFittings()
    {
        Producto_Dao productsDao = new Producto_Dao();
        ArrayList<Producto> productos = productsDao.findFittings(null);
        return Producto.toArrayJSon(productos);
    }



    private String findDessert()
    {
        Producto_Dao productsDao = new Producto_Dao();
        ArrayList<Producto> productos = productsDao.findDessert(null);
        return Producto.toArrayJSon(productos);
    }

    private String findDrink()
    {
        Producto_Dao productsDao = new Producto_Dao();
        ArrayList<Producto> productos = productsDao.findDrink(null);
        return Producto.toArrayJSon(productos);
    }

    private String findSpecial()
    {
        Producto_Dao productsDao = new Producto_Dao();
        ArrayList<Producto> productos = productsDao.findSpecial(null);
        return Producto.toArrayJSon(productos);
    }
    /////////////////////////////////////////


    private String findAll() {

        Producto_Dao productoDao = new Producto_Dao();
        ArrayList<Producto> productos = productoDao.findAll(null);
        return Producto.toArrayJSon(productos);
    }

    private String add(HttpServletRequest request) {
        String imagen = request.getParameter("IMAGEN");
        String id_producto = request.getParameter("ID_PRODUCTO");
        String nombre = request.getParameter("NOMBRE");
        String descripcion = request.getParameter("DESCRIPCION");
        String id_categoria_producto = request.getParameter("ID_CATEGORIAPRODUCTO");
        String precio = request.getParameter("PRECIO");



            Producto producto = new Producto();
            producto.setImagen(imagen);
            producto.setId_producto(Integer.parseInt(id_producto));
            producto.setNombreProducto(nombre);
            producto.setDescripcion(descripcion);
            producto.setId_categoria_producto(Integer.parseInt(id_categoria_producto));
            producto.setPrecio(Integer.parseInt(precio));

            Producto_Dao productoDao = new Producto_Dao();
            int Realizado = productoDao.add(producto);

            if (Realizado<=0){
                return "Ha ido mal";

            }
            else {
                return "Ha ido bien";
            }

    }






}
