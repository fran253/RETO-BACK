package Controller.Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;

import java.util.ArrayList;

public class Empleados_Action implements IAction {
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
            case "ADD":
                strReturn = add(request);
                break;
            case "UPDATE":
                strReturn = update(request);
                break;
            default:
                strReturn = "ERROR. Invalid Action";
        }
        return strReturn;
    }


    private String update(HttpServletRequest request) {
        String id_empleado = request.getParameter("ID_EMPLEADO");
        String nombre = request.getParameter("NOMBRE");
        String apellido = request.getParameter("APELLIDO");
        String gmail = request.getParameter("GMAIL");
        String num_telefono = request.getParameter("NUM_TELEFONO");
        String id_categoria_empleado = request.getParameter("ID_CATEGORIAEMPLEADO");
        String contrasena = request.getParameter("CONTRASENA");



        Empleados empleado = new Empleados();
        empleado.setId_empleado(Integer.parseInt(id_empleado));
        empleado.setNombre_empleado(nombre);
        empleado.setApellido_empleado(apellido);
        empleado.setGmail_empleado(gmail);
        empleado.setNum_telefono(num_telefono);
        empleado.setId_categoriaEmpleado(id_categoria_empleado);
        empleado.setContrasena(contrasena);

        Empleados_Dao empleadoDao = new Empleados_Dao();
        int Realizado = empleadoDao.update(empleado);

        if (Realizado<=0){
            return "Ha ido mal";

        }
        else {
            return "Ha ido bien";
        }

    }



    public String delete(HttpServletRequest request) {

        Empleados_Dao empleadoDao = new Empleados_Dao();

        int id_empleado = Integer.parseInt(request.getParameter("ID_EMPLEADO"));

        Integer iRet = empleadoDao.delete(id_empleado);
        return iRet.toString();
    }


    private String findAll() {

        Empleados_Dao empleadoDao = new Empleados_Dao();
        //ArrayList<Pelicula> peliculas = peliculaDao.findAll(peli);
        ArrayList<Empleados> empleados = empleadoDao.findAll(null);
        return Empleados.toArrayJSon(empleados);
    }

    private String add(HttpServletRequest request) {
        String id_empleado = request.getParameter("ID_EMPLEADO");
        String nombre = request.getParameter("NOMBRE");
        String apellido = request.getParameter("APELLIDO");
        String gmail = request.getParameter("GMAIL");
        String num_telefono = request.getParameter("NUM_TELEFONO");
        String id_categoria_empleado = request.getParameter("ID_CATEGORIAEMPLEADO");
        String contrasena = request.getParameter("CONTRASENA");




        Empleados empleado = new Empleados();
        empleado.setId_empleado(Integer.parseInt(id_empleado));
        empleado.setNombre_empleado(nombre);
        empleado.setApellido_empleado(apellido);
        empleado.setGmail_empleado(gmail);
        empleado.setNum_telefono(num_telefono);
        empleado.setId_categoriaEmpleado(id_categoria_empleado);
        empleado.setContrasena(contrasena);


        Empleados_Dao empleadosDao = new Empleados_Dao();
        int Realizado = empleadosDao.add(empleado);

        if (Realizado<=0){
            return "Ha ido mal";

        }
        else {
            return "Ha ido bien";
        }

    }

}
