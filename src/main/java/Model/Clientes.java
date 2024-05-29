package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Clientes {
    private String nombre_Cliente, apellidos_Cliente , gmail_cliente, num_telefono, Direccion;
    private int id_cliente;

    public String getNombre_Cliente() {
        return nombre_Cliente;
    }

    public void setNombre_Cliente(String nombre_Cliente) {
        this.nombre_Cliente = nombre_Cliente;
    }

    public String getApellidos_Cliente() {
        return apellidos_Cliente;
    }

    public void setApellidos_Cliente(String apellidos_Cliente) {
        this.apellidos_Cliente = apellidos_Cliente;
    }

    public String getGmail_cliente() {
        return gmail_cliente;
    }

    public void setGmail_cliente(String gmail_cliente) {
        this.gmail_cliente = gmail_cliente;
    }

    public String getNum_telefono() {
        return num_telefono;
    }

    public void setNum_telefono(String num_telefono) {
        this.num_telefono = num_telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }


    @Override
    public String toString() {
        return "Clientes{" +
                "Nombre='" + nombre_Cliente + '\'' +
                ", Apellidos='" + apellidos_Cliente + '\'' +
                ", gmail='" + gmail_cliente + '\'' +
                ", num_telefono='" + num_telefono + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", ID_Cliente=" + id_cliente +
                '}';


    }

    public Clientes(String nombre_Cliente, String apellidos_Cliente, String gmail_cliente, String num_telefono, String Direccion, int id_cliente) {
        this.nombre_Cliente = nombre_Cliente;
        this.apellidos_Cliente = apellidos_Cliente;
        this.gmail_cliente = gmail_cliente;
        this.num_telefono = num_telefono;
        this.Direccion = Direccion;
        this.id_cliente = id_cliente;
    }

    public Clientes() {}

    public static String toArrayJSon(ArrayList<Clientes> clientes) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        return gson.toJson(clientes);
    }

}
