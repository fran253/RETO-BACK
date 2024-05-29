package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
public class Detalle {

    private int id_detalle ,id_pedido, id_producto ,cantidad;
    private double precio_detalle;

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_cliente) {
        this.id_detalle = id_cliente;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public double getPrecio_detalle() {
        return precio_detalle;
    }

    public void setPrecio_detalle(double precio_detalle) {
        this.precio_detalle = precio_detalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Detalle{" +
                "id_detalle=" + id_detalle +
                ", id_pedido=" + id_pedido +
                ", id_producto=" + id_producto +
                ", precio=" + precio_detalle +
                ", cantidad=" + cantidad +
                '}';
    }

    public Detalle (int id_detalle, int id_pedido , int id_producto , double precio_detalle , int cantidad){
    this.id_detalle = id_detalle;
    this.id_pedido = id_pedido;
    this.id_producto = id_producto;
    this.precio_detalle = precio_detalle;
    this.cantidad = cantidad;

    }

    public Detalle(){}

    public static String toArrayJSon(ArrayList<Detalle> detalles) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        return gson.toJson(detalles);


    }

}
