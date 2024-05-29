package Controller;


import Controller.Actions.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    @Override
    //de dentro a fuera
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    //de fuera a dentro
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plan");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        String strAction = request.getParameter("ACTION");
        String[] arrayAction = new String[2];


        if(strAction != "")
        {
            arrayAction = strAction.split("\\.");
        }
        switch (arrayAction[0].toUpperCase())
        {
            case "CATEGORIA_EMPLEADO":
            {
                out.print(new Categoria_Empleado_Action().execute(request,response, arrayAction[1]));
                break;
            }
            case "CATEGORIA_PRODUCTO":
            {
                out.print(new Categoria_Producto_Action().execute(request,response, arrayAction[1]));
                break;
            }
            case "CLIENTES":
            {
                out.print(new Clientes_Action().execute(request,response, arrayAction[1]));
                break;
            }
            case "DETALLE":
            {
                out.print(new Detalle_Action().execute(request,response, arrayAction[1]));
                break;
            }
            case "EMPLEADOS":
            {
                out.print(new Empleados_Action().execute(request,response, arrayAction[1]));
                break;
            }
            case "PEDIDOS":
            {
                out.print(new Pedidos_Action().execute(request,response, arrayAction[1]));
                break;
            }
            case "PRODUCTO":
            {
                out.print(new Producto_Action().execute(request,response, arrayAction[1]));
                break;
            }

            default:
            {
                System.out.println(arrayAction[0]);
                throw new ServletException ("Acción " + arrayAction[0] +" no valida");
            }
        }

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException

    {
        response.setContentType("text/plain;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Max-Age", "3600");

        PrintWriter out = response.getWriter();

        String strAction = request.getParameter("ACTION");
        String[] arrayAction= new String[2];
        if (strAction != "")
        {
            arrayAction = strAction.split("\\.");
        }
        switch (arrayAction[0].toUpperCase())
        {
            case "CATEGORIA_EMPLEADO":
            {
                out.print(new Categoria_Empleado_Action().execute(request,response, arrayAction[1]));
                break;
            }
            case "CATEGORIA_PRODUCTO":
            {
                out.print(new Categoria_Producto_Action().execute(request,response, arrayAction[1]));
                break;
            }
            case "CLIENTES":
            {
                out.print(new Clientes_Action().execute(request,response, arrayAction[1]));
                break;
            }
            case "DETALLE":
            {
                out.print(new Detalle_Action().execute(request,response, arrayAction[1]));
                break;
            }
            case "EMPLEADOS":
            {
                out.print(new Empleados_Action().execute(request,response, arrayAction[1]));
                break;
            }
            case "PEDIDOS":
            {
                out.print(new Pedidos_Action().execute(request,response, arrayAction[1]));
                break;
            }
            case "PRODUCTO":
            {
                out.print(new Producto_Action().execute(request,response, arrayAction[1]));
                break;
            }
            default:
            {
                System.out.println(arrayAction[0]);
                throw new ServletException ("Acción " + arrayAction[0] +" no valida");
            }
        }


    }
    public static String GetBody (HttpServletRequest request) {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }else {
                stringBuilder.append("");
            }
        }catch (IOException ex){
            return "";
        }finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }catch (IOException exception) {

                }
            }
        }
        body = stringBuilder.toString();
        return body;
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }



}
