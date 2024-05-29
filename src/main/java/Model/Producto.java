package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Producto {

    private String  Imagen , nombreProducto , Descripcion;

    private int precio;
    private int id_categoria_producto, id_producto;


    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId_categoria_producto() {
        return id_categoria_producto;
    }

    public void setId_categoria_producto(int id_categoria_producto) {
        this.id_categoria_producto = id_categoria_producto;
    }


    @Override
    public String toString() {
        return "Producto{" +
                " id_producto=" + id_producto +
                ", Imagen='" + Imagen + '\'' +
                ", Nombre='" + nombreProducto + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", id_categoria_producto=" + id_categoria_producto +
                ", precio=" + precio +
                '}';
    }

    public static String fromArrayToJson(ArrayList<Producto> productos){
        String resp = "[";
        for (Producto producto : productos) {
            resp+= "{" +
                    "'Id_Prod':'" + producto.getId_producto() + "', "
                    + "'Nombre':'" + producto.getNombreProducto() + "',"
                    + "'Descripcion':'" + producto.getDescripcion() + "',"
                    + "'Precio':'" + producto.getPrecio() + "',"
                    + "'Img':'" + producto.getImagen() + "',"
                    + "'Id_categoria':'" + producto.getId_categoria_producto() + "',"
                    +"}";
            resp+=",";
        }
        resp = resp.substring(0, resp.length()-1);
        resp+="]";
        return resp;
    }

    public Producto(String Imagen , String nombreProducto , String Descripcion , int id_producto , int precio, int id_categoria_producto){
        this.Imagen = Imagen;
        this.nombreProducto = nombreProducto;
        this.Descripcion = Descripcion;
        this.id_producto = id_producto;
        this.precio = precio;
        this.id_categoria_producto = id_categoria_producto;

    }

public Producto (){}

    public static String toArrayJSon(ArrayList<Producto> productos) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        return gson.toJson(productos);
    }

}
