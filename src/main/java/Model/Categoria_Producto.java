package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Categoria_Producto {


    private String nombre_CategoriaProducto;
    private int ID_CategoriaProducto;

    public String getNombre_CategoriaProducto() {
        return nombre_CategoriaProducto;
    }

    public void setNombre_CategoriaProducto(String nombre_CategoriaProducto) {
        this.nombre_CategoriaProducto = nombre_CategoriaProducto;
    }

    public int getID_CategoriaProducto() {
        return ID_CategoriaProducto;
    }

    public void setID_CategoriaProducto(int ID_CategoriaProducto) {
        this.ID_CategoriaProducto = ID_CategoriaProducto;
    }

    @Override
    public String toString() {
        return "Categoria_Producto{" +
                "nombre='" + nombre_CategoriaProducto + '\'' +
                ", ID_CategoriaProducto=" + ID_CategoriaProducto +
                '}';
    }

    public Categoria_Producto (int ID_CategoriaProducto, String nombre_CategoriaProducto){
        this.ID_CategoriaProducto = ID_CategoriaProducto;
        this.nombre_CategoriaProducto=nombre_CategoriaProducto;}

    public Categoria_Producto(){}

    public static String toArrayJSon(ArrayList<Categoria_Producto> categoria_productos) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        return gson.toJson(categoria_productos);
    }

}







