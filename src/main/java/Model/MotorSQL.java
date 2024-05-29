package Model;

import java.sql.*;

public class MotorSQL {
    /*Objetos necesarios para hablar con la BD*/
    //1º--> Conexión - Connection
    //2º--> Hablar en SQL - Statement
    //3º--> Recoger datos - Resultset
    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;
    private static final String URL  = "jdbc:oracle:thin:@bbddbummeat.c92e2yqsy0g1.us-east-1.rds.amazonaws.com:1521:orcl";
    private static final String USER  = "admin";
    private static final String PASSWORD  = "12345678";

    public void connect()
    {
        try {
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            st = conn.createStatement();
            // Do something with the Connection
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }


    public void conectStatement(){
        try {
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // Do something with the Connection
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public int execute(PreparedStatement pst){
        int resp = 0;
        try {
            resp = pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }

    public ResultSet executeQuery(String sql) {
        try {
            rs = st.executeQuery(sql);
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return rs;
    }

    public int executeUpdate(String sql) {
        int iResults = 0;
        try {
            iResults = st.executeUpdate(sql);
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return iResults;
    }

    public void disconnect()
    {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) { } // ignore
            rs = null;
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException sqlEx) { } // ignore
            st = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {}
        }

    }

    public PreparedStatement prepareStatement(String sqlAdd) {
        PreparedStatement st = null;
        try {
             st = this.conn.prepareStatement(sqlAdd);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return st;
    }
}
