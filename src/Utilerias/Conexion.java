package Utilerias;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    Connection conn = null; // Objeto para la conexion
    Statement stmt = null;// Objeto para ejecutar la consulta
    ResultSet rs = null; // Objeto para recuperar los resultados de la consulta

    public Conexion() {
        conn = null;
        stmt = null;
        rs = null;
    }

    //----------------------------------------------- MySQL -------------------------------------------------------
    public boolean conectarMySQL(String bd, String login, String password, String host) {
        boolean error = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            error = true;
            JOptionPane.showMessageDialog(null,
                    "No se encuentra la referencia del conector de MySQL.\n" + e.getMessage(),
                    "Error de Conexión",
                    JOptionPane.ERROR_MESSAGE);
        }

        if (!error) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + bd, login, password);
            } catch (SQLException ex) {
                error = true;
                JOptionPane.showMessageDialog(null,
                        "Error al tratar de conectar con la base de datos '" + bd + "'.\n\n"
                        + "MySQL dice: " + ex.getMessage(),
                        "Error de Conexión",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        return error;
    }

    //----------------------------------------------- PostgreSQL -------------------------------------------------------
    public boolean conectarPostgres(String bd, String login, String password, String host) {
        boolean error = false;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            error = true;
            JOptionPane.showMessageDialog(null,
                    "No se encuentra la referencia del conector de PostgreSQL.\n" + ex.getMessage(),
                    "Error de Conexión",
                    JOptionPane.ERROR_MESSAGE);
        }

        if (!error) {
            try {
                conn = DriverManager.getConnection("jdbc:postgresql://" + host + ":5432/" + bd, login, password);
            } catch (SQLException ex) {
                error = true;
                JOptionPane.showMessageDialog(null,
                        "Error al tratar de conectar con la base de datos '" + bd + "'.\n\n"
                        + "PostgreSQL dice: " + ex.getMessage(),
                        "Error de Conexión",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        return error;
    }

    //----------------------------------------------- FireBird -------------------------------------------------------
    public boolean conectarFB(String bd, String login, String password, String host) {
        boolean error = false;

        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
        } catch (ClassNotFoundException ex) {
            error = true;
            JOptionPane.showMessageDialog(null,
                    "No se encuentra la referencia del conector de FireBird.\n" + ex.getMessage(),
                    "Error de Conexión",
                    JOptionPane.ERROR_MESSAGE);
        }

        if (!error) {
            try {
                conn = DriverManager.getConnection("jdbc:firebirdsql:" + host + "/3050:" + bd, login, password);
            } catch (SQLException ex) {
                error = true;
                JOptionPane.showMessageDialog(null,
                        "Error al tratar de conectar con la base de datos '" + bd + "'.\n\n"
                        + "FireBird dice: " + ex.getMessage(),
                        "Error de Conexión",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        return error;
    }

    //----------------------------------------------- Oracle -------------------------------------------------------
    public boolean conectarOracle(String login, String password, String host) {
        boolean error = false;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            error = true;
            JOptionPane.showMessageDialog(null,
                    "No se encuentra la referencia del conector de Oracle.\n" + ex.getMessage(),
                    "Error de Conexión",
                    JOptionPane.ERROR_MESSAGE);
        }

        if (!error) {
            try {
                conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":1521",
                        login,
                        password);
                //conn = DriverManager.getConnection("jdbc:oracle:oci8:@", login, password);
            } catch (SQLException ex) {
                error = true;
                JOptionPane.showMessageDialog(null,
                        "Error al tratar de conectar con la base de datos '" + login + "'.\n\n"
                        + "Oracle dice: " + ex.getMessage(),
                        "Error de Conexión",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        return error;
    }

    //http://acodigo.blogspot.com/2013/06/conectar-sql-server-con-java.html
    //https://docs.microsoft.com/en-us/sql/connect/jdbc/step-3-proof-of-concept-connecting-to-sql-using-java?view=sql-server-2017
    //https://docs.microsoft.com/en-us/sql/connect/jdbc/connection-url-sample?view=sql-server-2017
    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,
                    "Error al tratar de cerrar la conexión con la base de datos.\n\n"
                    + "SQL Error: " + sqle.getMessage(),
                    "Error de Conexión",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean insertar(String tabla, String datos[]) {
        String sql = "INSERT INTO " + tabla + " VALUES('";
        for (String campo : datos) {
            sql += campo + "','";
        }
        //System.out.println(sql);
        sql = sql.substring(0, sql.length() - 2);
        //System.out.println(sql);
        sql += ");";
        //System.out.println(sql);	
        return actualizar(sql);
    }

    public boolean insertar(String tabla, ArrayList<String> datos) {
        String sql = "INSERT INTO " + tabla + " VALUES('";
        for (String campo : datos) {
            sql += campo + "','";
        }
        //System.out.println(sql);
        sql = sql.substring(0, sql.length() - 2);
        //System.out.println(sql);
        sql += ");";
        //System.out.println(sql);	
        return actualizar(sql);
    }

    public boolean actualizar(String sql) {
        int resultado = 0;
        boolean error = false;
        stmt = null;//Objeto para ejecutar la consulta

        if (conn != null) {
            try {
                stmt = conn.createStatement();
                resultado = stmt.executeUpdate(sql);
                stmt.close();
            } catch (SQLException sqle) {
                error = true;
                JOptionPane.showMessageDialog(null,
                        "Error al tratar de actualizar la tabla.\n\n"
                        + "SQL Error: " + sqle.getMessage(),
                        "Error de actualización",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        return error;
    }

    public ResultSet consulta(String sql) {
        stmt = null;//Objeto para ejecutar la consulta
        rs = null;//Objeto para recuperar los resultados de la consulta

        if (conn != null) {
            try {
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(sql);
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null,
                        "Error al tratar de consultar la tabla.\n\n"
                        + "SQL Error: " + sqle.getMessage(),
                        "Error de consulta",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        return rs;
    }

    //consultaFila("datos_personales", "cc", "94")
    public String[] consultaFila(String tabla, String campo, String valor) {
        stmt = null;//Objeto para ejecutar la consulta
        rs = null;//Objeto para recuperar los resultados de la consulta
        String fila[] = null;

        if (conn != null) {
            try {
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("SELECT * FROM " + tabla + " WHERE " + campo + " = '" + valor + "'");

                if (getSizeQuery(rs) > 0) {//si la cantidad de filas (registros) resultantes de la consulta es mayor a cero, es porque el valor a buscar existe

                    int cantColumnas = rs.getMetaData().getColumnCount();//obtener cantidad de columnas (campos) resultantes de la consulta									
                    fila = new String[cantColumnas];//dar tama�o al array dependiendo de la cantidad de columnas (campos) resultantes de la consulta

                    while (rs.next()) {//recorrer la consulta
                        for (int i = 1; i <= cantColumnas; i++) {
                            fila[i - 1] = rs.getString(i);//y llenar el array String con los campos a retornar
                        }
                        break;
                    }
                }
                cerrarConsulta();
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null,
                        "Error al tratar de consultar la tabla.\n\n"
                        + "SQL Error: " + sqle.getMessage(),
                        "Error de consulta",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return fila;
    }

    public boolean actualizarFila(String tabla, ArrayList<String> datos, String condicion) {
        String sql = "update " + tabla + " set ";

        for (int i = 0; i < datos.size(); i++) {
            sql += datos.get(i);
            if (i < datos.size() - 1) {
                sql += ",";
            }
        }

        sql += " where " + condicion;
        System.out.println(sql);	
        return actualizar(sql);
    }
    

    public String[] ActualizarTabla(String tabla, String campo, String valor) {
        stmt = null;//Objeto para ejecutar la consulta
        rs = null;//Objeto para recuperar los resultados de la consulta
        String fila[] = null;

        if (conn != null) {
            try {
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("update " + tabla + " set " + campo + " where '" + valor + "'");

                if (getSizeQuery(rs) > 0) {//si la cantidad de filas (registros) resultantes de la consulta es mayor a cero, es porque el valor a buscar existe

                    int cantColumnas = rs.getMetaData().getColumnCount();//obtener cantidad de columnas (campos) resultantes de la consulta									
                    fila = new String[cantColumnas];//dar tama�o al array dependiendo de la cantidad de columnas (campos) resultantes de la consulta

                    while (rs.next()) {//recorrer la consulta
                        for (int i = 1; i <= cantColumnas; i++) {
                            fila[i - 1] = rs.getString(i);//y llenar el array String con los campos a retornar
                        }
                        break;
                    }
                }
                cerrarConsulta();
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null,
                        "Error al tratar de consultar la tabla.\n\n"
                        + "SQL Error: " + sqle.getMessage(),
                        "Error de consulta",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return fila;
    }

    public String[][] consultaMatriz(String tabla, String sql) {
        String tmp = "SELECT * FROM " + tabla + " WHERE " + sql;
        String matrizRegistros[][] = consultaMatriz(tmp);
        return matrizRegistros;
    }

    public String[][] consultaMatriz(String sql) {
        stmt = null;//Objeto para ejecutar la consulta
        rs = null;//Objeto para recuperar los resultados de la consulta
        String matrizRegistros[][] = null;

        if (conn != null) {
            try {
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(sql);
                int canFilas = getSizeQuery(rs);
                if (canFilas > 0) {
                    int canColumnas = rs.getMetaData().getColumnCount();
                    matrizRegistros = new String[canFilas][canColumnas];
                    int f = 0;
                    while (rs.next()) {
                        for (int c = 0; c < canColumnas; c++) {
                            matrizRegistros[f][c] = rs.getString(c + 1);
                        }
                        f++;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No hay registros que cumplan con la condición");
                }

                cerrarConsulta();
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null,
                        "Error al tratar de consultar la tabla.\n\n"
                        + "SQL Error: " + sqle.getMessage(),
                        "Error de consulta",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return matrizRegistros;
    }

    public int getSizeQuery(ResultSet rs) {
        int cantFilas = -1;
        try {
            rs.last(); //Desplazar el puntero de lectura a la ultima fila (registro)
            cantFilas = rs.getRow(); //Calcular la cantidad de filas (registros) que arroja la consulta
            rs.beforeFirst(); //Desplazar el puntero de lectura a la primera fila (registro)
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,
                    "Error al tratar de obtener la cantidad de registros resultantes de la consulta.\n\n"
                    + "SQL Error: " + sqle.getMessage(),
                    "Error de consulta",
                    JOptionPane.ERROR_MESSAGE);
        }
        return cantFilas;
    }

    public void cerrarConsulta() {
        try {
            rs.close(); //Cerrar el objeto que recupero los resultados de la consulta				
            stmt.close();//Cerrar el objeto que ejecuto la consulta
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,
                    "Error al tratar de cerrar la consulta en la base de datos.\n\n"
                    + "SQL Error: " + sqle.getMessage(),
                    "Error de Consulta",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public int contar(String tabla, String sql) {
        int cont = -1;
        ResultSet rs = consulta("SELECT COUNT(*) FROM " + tabla + " WHERE " + sql);
        try {
            while (rs.next()) {
                cont = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,
                    "Error al tratar de leer la consulta de la base de datos.\n\n" + "SQL Error: " + sqle.getMessage(),
                    "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return cont;
    }

    // contar cuantos registros tiene una tabla
    public int contar(String tabla) {
        int cont = -1;
        ResultSet rs = consulta("SELECT COUNT(*) FROM " + tabla);
        try {
            while (rs.next()) {
                cont = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,
                    "Error al tratar de leer la consulta de la base de datos.\n\n" + "SQL Error: " + sqle.getMessage(),
                    "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return cont;
    }

    public int sumar(String tabla, String campo) {
        int cont = -1;
        ResultSet rs = consulta("SELECT sum(" + campo + ") FROM " + tabla);
        try {
            while (rs.next()) {
                cont = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,
                    "Error al tratar de leer la consulta de la base de datos.\n\n" + "SQL Error: " + sqle.getMessage(),
                    "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return cont;
    }
}
