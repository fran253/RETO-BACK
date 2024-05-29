package Model;

        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;

        import java.util.ArrayList;
        import java.util.Date;

public class Pedidos {
    private String id_pedido, id_cliente, id_empleado;
    private Date fecha;

    // Getters y Setters
    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    // Constructor con parámetros
    public Pedidos(String id_pedido, String id_cliente, Date fecha, String id_empleado) {
        this.id_pedido = id_pedido;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.id_empleado = id_empleado;
    }

    // Constructor vacío
    public Pedidos() {}

    // Método toString
    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido=" + id_pedido +
                ", id_cliente=" + id_cliente +
                ", fecha=" + fecha +
                ", id_empleado=" + id_empleado +
                '}';
    }

    // Método para convertir una lista de Pedido a JSON
    public static String toArrayJSon(ArrayList<Pedidos> pedidos) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        return gson.toJson(pedidos);
    }
}
