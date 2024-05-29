package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Empleados {


    private String nombre_empleado ,apellido_empleado , gmail_empleado , num_telefono, id_categoriaEmpleado, contrasena;

    private int id_empleado;

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getId_categoriaEmpleado() {
        return id_categoriaEmpleado;
    }

    public void setId_categoriaEmpleado(String id_categoriaEmpleado) {
        this.id_categoriaEmpleado = id_categoriaEmpleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }

    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    public String getGmail_empleado() {
        return gmail_empleado;
    }

    public void setGmail_empleado(String gmail_empleado) {
        this.gmail_empleado = gmail_empleado;
    }

    public String getNum_telefono() {
        return num_telefono;
    }

    public void setNum_telefono(String num_telefono) {
        this.num_telefono = num_telefono;
    }
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    public Empleados(int id_empleado, String id_categoriaEmpleado, String nombre_empleado, String apellido_empleado, String gmail_empleado, String num_telefono, String contrasena) {
        this.id_empleado = id_empleado;
        this.id_categoriaEmpleado = id_categoriaEmpleado;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.gmail_empleado = gmail_empleado;
        this.num_telefono = num_telefono;
        this.contrasena = contrasena;
    }

    public Empleados() {}


    @Override
    public String toString() {
        return "Empleado{" +
                "id_empleado=" + id_empleado +
                ", id_categoriaEmpleado=" + id_categoriaEmpleado +
                ", nombre='" + nombre_empleado + '\'' +
                ", apellido='" + apellido_empleado + '\'' +
                ", gmail='" + gmail_empleado + '\'' +
                ", num_telefono='" + num_telefono + '\'' +
                ", contraseña='" + contrasena + '\'' +

                '}';
    }

    public static String toArrayJSon(ArrayList<Empleados> empleados) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        return gson.toJson(empleados);
    }
}
