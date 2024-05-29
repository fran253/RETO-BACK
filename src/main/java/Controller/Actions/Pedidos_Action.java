package Controller.Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;

import java.util.ArrayList;

public class Pedidos_Action implements IAction {
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
            default:
                strReturn = "ERROR. Invalid Action";
        }
        return strReturn;
    }



    private String findAll() {

        Pedidos_Dao pedidosDao = new Pedidos_Dao();
        //ArrayList<Pelicula> peliculas = peliculaDao.findAll(peli);
        ArrayList<Pedidos> pedidos = pedidosDao.findAll(null);
        return Pedidos.toArrayJSon(pedidos);
    }
}
