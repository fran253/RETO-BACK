package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;


public class Categoria_Empleado {

    private String nombre_CategoriaEmpleado;
    private String ID_CategoriaEmpleado;


    public String getNombre_CategoriaEmpleado() {
        return nombre_CategoriaEmpleado;
    }

    public void setNombre_CategoriaEmpleado(String nombre_CategoriaEmpleado) {
        this.nombre_CategoriaEmpleado = nombre_CategoriaEmpleado;
    }

    public String getIDCategoria_Empleado() {
        return ID_CategoriaEmpleado;
    }

    public void setIDCategoria_Empleado(String IDCategoria_Empleado) {
        this.ID_CategoriaEmpleado = IDCategoria_Empleado;
    }

    @Override
    public String toString() {
        return "Categoria_Empleado{" +
                "nombre='" + nombre_CategoriaEmpleado + '\'' +
                ", IDCategoria_Empleado=" + ID_CategoriaEmpleado +
                '}';
    }

    public Categoria_Empleado (String  ID_CategoriaEmpleado, String nombre_CategoriaEmpleado) {
        this.ID_CategoriaEmpleado = ID_CategoriaEmpleado;
        this.nombre_CategoriaEmpleado = nombre_CategoriaEmpleado;
    }
    public Categoria_Empleado(){}

    public static String toArrayJSon(ArrayList<Categoria_Empleado> categoria_empleados) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        return gson.toJson(categoria_empleados);
    }

}
