/**
 * Clase Conexion que proporciona métodos para la conexión y manipulación de bases de datos.
 *
 * @version 1.4
 * @since 11/12/2023
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 */
package Utilerias;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase Conexion que proporciona métodos para la conexión y manipulación de bases de datos.
 */

public class Conexion {

    Connection conn = null; // Objeto para la conexion
    Statement stmt = null;// Objeto para ejecutar la consulta
    ResultSet rs = null; // Objeto para recuperar los resultados de la consulta

     /**
     * Constructor de la clase Conexion.
     */
    
    public Conexion() {
        conn = null;
        stmt = null;
        rs = null;
    }

    //----------------------------------------------- MySQL -------------------------------------------------------
    /**
     * Establece una conexión con una base de datos MySQL.
     *
     * @param bd      Nombre de la base de datos.
     * @param login   Usuario para la conexión.
     * @param password Contraseña para la conexión.
     * @param host    Dirección del servidor de la base de datos.
     * @return true si hay algún error en la conexión, false si la conexión es exitosa.
     */
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
    /**
     * Establece una conexión con una base de datos PostgreSQL.
     *
     * @param bd      Nombre de la base de datos.
     * @param login   Usuario para la conexión.
     * @param password Contraseña para la conexión.
     * @param host    Dirección del servidor de la base de datos.
     * @return true si hay algún error en la conexión, false si la conexión es exitosa.
     */
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
    /**
     * Establece una conexión con una base de datos FireBird.
     *
     * @param bd      Nombre de la base de datos.
     * @param login   Usuario para la conexión.
     * @param password Contraseña para la conexión.
     * @param host    Dirección del servidor de la base de datos.
     * @return true si hay algún error en la conexión, false si la conexión es exitosa.
     */
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
    /**
     * Establece una conexión con una base de datos Oracle.
     *
     * @param login   Usuario para la conexión.
     * @param password Contraseña para la conexión.
     * @param host    Dirección del servidor de la base de datos.
     * @return true si hay algún error en la conexión, false si la conexión es exitosa.
     */
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
    
    /**
     * Cierra la conexión con la base de datos.
     */
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

    /**
     * Inserta datos en una tabla.
     *
     * @param tabla Nombre de la tabla.
     * @param datos Datos a insertar.
     * @return true si hay algún error en la inserción, false si la inserción es exitosa.
     */
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

    /**
     * Inserta datos en una tabla.
     *
     * @param tabla Nombre de la tabla.
     * @param datos Datos a insertar.
     * @return true si hay algún error en la inserción, false si la inserción es exitosa.
     */
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

     /**
     * Actualiza la base de datos con una consulta SQL.
     *
     * @param sql Consulta SQL para actualizar la base de datos.
     * @return true si hay algún error en la actualización, false si la actualización es exitosa.
     */
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

    /**
     * Realiza una consulta a la base de datos.
     *
     * @param sql Consulta SQL a ejecutar.
     * @return ResultSet con los resultados de la consulta.
     */
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

    /**
     * Método que realiza una consulta para obtener una fila específica de la tabla.
     *
     * @param tabla Nombre de la tabla.
     * @param campo Campo para la condición.
     * @param valor Valor a buscar en el campo.
     * @return Arreglo de strings con los campos de la fila encontrada.
     */
    public String[] consultaFila(String tabla, String campo, String valor) {
        stmt = null;
        rs = null;
        String fila[] = null;

        if (conn != null) {
            try {
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("SELECT * FROM " + tabla + " WHERE " + campo + " = '" + valor + "'");

                if (getSizeQuery(rs) > 0) {
                    int cantColumnas = rs.getMetaData().getColumnCount();
                    fila = new String[cantColumnas];

                    while (rs.next()) {
                        for (int i = 1; i <= cantColumnas; i++) {
                            fila[i - 1] = rs.getString(i);
                        }
                        break;
                    }
                }
                cerrarConsulta();
            } catch (SQLException sqle) {
                // Manejo de errores
                JOptionPane.showMessageDialog(null,
                        "Error al tratar de consultar la tabla.\n\n"
                                + "SQL Error: " + sqle.getMessage(),
                        "Error de consulta",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return fila;
    }

    /**
     * Método que realiza una consulta para obtener una fila específica de la tabla con un complemento adicional.
     *
     * @param tabla Nombre de la tabla.
     * @param campo Campo para la condición.
     * @param valor Valor a buscar en el campo.
     * @param complemento Complemento adicional para la consulta SQL.
     * @return Arreglo de strings con los campos de la fila encontrada.
     */
    public String[] consultaFila(String tabla, String campo, String valor, String complemento) {
        stmt = null;
        rs = null;
        String fila[] = null;

        if (conn != null) {
            try {
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("SELECT * FROM " + tabla + " WHERE " + campo + " = '" + valor + "' " + complemento);

                if (getSizeQuery(rs) > 0) {
                    int cantColumnas = rs.getMetaData().getColumnCount();
                    fila = new String[cantColumnas];

                    while (rs.next()) {
                        for (int i = 1; i <= cantColumnas; i++) {
                            fila[i - 1] = rs.getString(i);
                        }
                        break;
                    }
                }
                cerrarConsulta();
            } catch (SQLException sqle) {
                // Manejo de errores
                JOptionPane.showMessageDialog(null,
                        "Error al tratar de consultar la tabla.\n\n"
                                + "SQL Error: " + sqle.getMessage(),
                        "Error de consulta",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return fila;
    }

    /**
     * Método que actualiza una fila en la base de datos.
     *
     * @param tabla Nombre de la tabla.
     * @param datos Lista de datos a actualizar.
     * @param condicion Condición para la actualización.
     * @return `true` si la actualización fue exitosa, `false` en caso contrario.
     */
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

    /**
     * Método que actualiza un valor en una tabla específica.
     *
     * @param tabla Nombre de la tabla.
     * @param campo Campo a actualizar.
     * @param valor Nuevo valor para el campo.
     * @return Arreglo de strings con los campos de la fila actualizada.
     */
    public String[] ActualizarTabla(String tabla, String campo, String valor) {
        stmt = null;
        rs = null;
        String fila[] = null;

        if (conn != null) {
            try {
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("update " + tabla + " set " + campo + " where '" + valor + "'");

                if (getSizeQuery(rs) > 0) {
                    int cantColumnas = rs.getMetaData().getColumnCount();
                    fila = new String[cantColumnas];

                    while (rs.next()) {
                        for (int i = 1; i <= cantColumnas; i++) {
                            fila[i - 1] = rs.getString(i);
                        }
                        break;
                    }
                }
                cerrarConsulta();
            } catch (SQLException sqle) {
                // Manejo de errores
                JOptionPane.showMessageDialog(null,
                        "Error al tratar de consultar la tabla.\n\n"
                                + "SQL Error: " + sqle.getMessage(),
                        "Error de consulta",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return fila;
    }

    /**
     * Método que realiza una consulta SQL y devuelve los resultados como una matriz de strings.
     *
     * @param tabla Nombre de la tabla.
     * @param sql Consulta SQL a ejecutar.
     * @return Matriz de strings con los resultados de la consulta.
     */
    public String[][] consultaMatriz(String tabla, String sql) {
        String tmp = "SELECT * FROM " + tabla + " WHERE " + sql;
        String matrizRegistros[][] = consultaMatriz(tmp);
        return matrizRegistros;
    }

    /**
     * Método que realiza una consulta SQL y devuelve los resultados como una matriz de strings.
     *
     * @param sql Consulta SQL a ejecutar.
     * @return Matriz de strings con los resultados de la consulta.
     */
    public String[][] consultaMatriz(String sql) {
        stmt = null;
        rs = null;
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
                // Manejo de errores
                JOptionPane.showMessageDialog(null,
                        "Error al tratar de consultar la tabla.\n\n"
                                + "SQL Error: " + sqle.getMessage(),
                        "Error de consulta",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return matrizRegistros;
    }

    /**
     * Método que obtiene la cantidad de filas resultantes de una consulta.
     *
     * @param rs Resultados de la consulta.
     * @return Cantidad de filas resultantes.
     */
    public int getSizeQuery(ResultSet rs) {
        int cantFilas = -1;
        try {
            rs.last(); // Desplazar el puntero de lectura a la última fila (registro)
            cantFilas = rs.getRow(); // Calcular la cantidad de filas (registros) que arroja la consulta
            rs.beforeFirst(); // Desplazar el puntero de lectura a la primera fila (registro)
        } catch (SQLException sqle) {
            // Manejo de errores
            JOptionPane.showMessageDialog(null,
                    "Error al tratar de obtener la cantidad de registros resultantes de la consulta.\n\n"
                            + "SQL Error: " + sqle.getMessage(),
                    "Error de consulta",
                    JOptionPane.ERROR_MESSAGE);
        }
        return cantFilas;
    }

    /**
     * Método que cierra la consulta, liberando los recursos.
     */
    public void cerrarConsulta() {
        try {
            rs.close(); // Cerrar el objeto que recupera los resultados de la consulta
            stmt.close(); // Cerrar el objeto que ejecuta la consulta
        } catch (SQLException sqle) {
            // Manejo de errores
            JOptionPane.showMessageDialog(null,
                    "Error al tratar de cerrar la consulta en la base de datos.\n\n"
                            + "SQL Error: " + sqle.getMessage(),
                    "Error de Consulta",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método que cuenta la cantidad de registros que cumplen con una condición.
     *
     * @param tabla Nombre de la tabla.
     * @param sql Condición SQL.
     * @return Cantidad de registros que cumplen con la condición.
     */
    public int contar(String tabla, String sql) {
        int cont = -1;
        ResultSet rs = consulta("SELECT COUNT(*) FROM " + tabla + " WHERE " + sql);
        try {
            while (rs.next()) {
                cont = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException sqle) {
            // Manejo de errores
            JOptionPane.showMessageDialog(null,
                    "Error al tratar de leer la consulta de la base de datos.\n\n" + "SQL Error: " + sqle.getMessage(),
                    "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return cont;
    }

    /**
     * Método que cuenta la cantidad de registros en una tabla.
     *
     * @param tabla Nombre de la tabla.
     * @return Cantidad de registros en la tabla.
     */
    public int contar(String tabla) {
        int cont = -1;
        ResultSet rs = consulta("SELECT COUNT(*) FROM " + tabla);
        try {
            while (rs.next()) {
                cont = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException sqle) {
            // Manejo de errores
            JOptionPane.showMessageDialog(null,
                    "Error al tratar de leer la consulta de la base de datos.\n\n" + "SQL Error: " + sqle.getMessage(),
                    "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return cont;
    }

    /**
     * Método que suma los valores de un campo en una tabla.
     *
     * @param tabla Nombre de la tabla.
     * @param campo Campo a sumar.
     * @return Suma de los valores del campo.
     */
    public int sumar(String tabla, String campo) {
        int cont = -1;
        ResultSet rs = consulta("SELECT sum(" + campo + ") FROM " + tabla);
        try {
            while (rs.next()) {
                cont = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException sqle) {
            // Manejo de errores
            JOptionPane.showMessageDialog(null,
                    "Error al tratar de leer la consulta de la base de datos.\n\n" + "SQL Error: " + sqle.getMessage(),
                    "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return cont;
    }
}