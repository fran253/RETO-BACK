package Controller.Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;

import java.util.ArrayList;

public class Clientes_Action implements IAction {
    @Override
    //ACTION=PELICULA.FIND_ALL+Title="La Perseguida hasta el catre"+Duracion="12"
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        String strReturn ="";
        switch (action)
        {
            case "FIND_FIRST":
                //strReturn
                break;
            case "FIND_ALL":
                /*Pelicula peli = new Pelicula();
                peli.setTitulo("La Perseguida hasta el catre");
                peli.setDuracion(12);
                strReturn = findAll(peli);*/
                strReturn = findAll();
                break;
            case "DELETE":
                strReturn = delete(request);
                break;
            case "UPDATE":
                strReturn = update(request);
                break;
            case "ADD":
                strReturn = add(request);
                break;
            default:
                strReturn = "ERROR. Invalid Action";
        }
        return strReturn;
    }

    private String add(HttpServletRequest request) {
        String nombre = request.getParameter("NOMBRE");
        String id_cliente = request.getParameter("ID_CLIENTE");
        String apellido = request.getParameter("APELLIDO");
        String gmail = request.getParameter("GMAIL");
        String num_telefono = request.getParameter("NUM_TELEFONO");
        String direccion = request.getParameter("DIRECCION");



        Clientes cliente = new Clientes();
        cliente.setNombre_Cliente(nombre);
        cliente.setId_cliente(Integer.parseInt(id_cliente));
        cliente.setApellidos_Cliente(apellido);
        cliente.setGmail_cliente(gmail);
        cliente.setNum_telefono(num_telefono);
        cliente.setDireccion(direccion);

        Clientes_Dao clienteDao = new Clientes_Dao();
        int Realizado = clienteDao.add(cliente);

        if (Realizado<=0){
            return "Ha ido mal";

        }
        else {
            return "Ha ido bien";
        }

    }

    private String update(HttpServletRequest request) {
        String nombre = request.getParameter("NOMBRE");
        String id_cliente = request.getParameter("ID_CLIENTE");
        String apellido = request.getParameter("APELLIDO");
        String gmail = request.getParameter("GMAIL");
        String num_telefono = request.getParameter("NUM_TELEFONO");
        String direccion = request.getParameter("DIRECCION");



        Clientes cliente = new Clientes();
        cliente.setNombre_Cliente(nombre);
        cliente.setId_cliente(Integer.parseInt(id_cliente));
        cliente.setApellidos_Cliente(apellido);
        cliente.setGmail_cliente(gmail);
        cliente.setNum_telefono(num_telefono);
        cliente.setDireccion(direccion);

        Clientes_Dao clienteDao = new Clientes_Dao();
        int Realizado = clienteDao.update(cliente);

        if (Realizado<=0){
            return "Ha ido mal";

        }
        else {
            return "Ha ido bien";
        }

    }

    public String delete(HttpServletRequest request) {

        Clientes_Dao clienteDao = new Clientes_Dao();

        int id_cliente = Integer.parseInt(request.getParameter("ID_CLIENTE"));

        Integer iRet = clienteDao.delete(id_cliente);
        return iRet.toString();
    }




    private String findAll() {

        Clientes_Dao clienteDao = new Clientes_Dao();
        //ArrayList<Pelicula> peliculas = peliculaDao.findAll(peli);
        ArrayList<Clientes> clientes = clienteDao.findAll(null);
        return Clientes.toArrayJSon(clientes);
    }


}
