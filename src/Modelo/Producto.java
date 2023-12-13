/**
 * Clase que representa un Producto en el sistema.
 * 
 * Autores:
 *
 * @author John Alejandro Vallarino - 2264332
 * @author Jhon Alex Rodriguez - 2264363
 * @author Miguel Ángel Escobar Marín - 2264305
 *
 * @version 1.4
 * @since 4-12-2023
 * Fecha de última modificación: 11/12/2023
 */
package Modelo;

/**
 * La clase Producto representa un artículo en el sistema, con atributos como idProducto, nombre, precio y cantidad.
 */
public class Producto {
    
    /** 
     * Atributo que representa el identificador del Producto.
     */
    String idProducto, nombre, precio, cantidad;
    
    /**
     * Constructor por defecto de la clase Producto.
     * Inicializa todos los atributos a cadenas vacías.
     */
    public Producto() {
        idProducto = nombre = precio = cantidad = "";
    }

    /**
     * Obtiene el identificador del Producto.
     *
     * @return El identificador del Producto.
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el identificador del Producto.
     *
     * @param idProducto El nuevo identificador a asignar.
     */
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Obtiene el nombre del Producto.
     *
     * @return El nombre del Producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del Producto.
     *
     * @param nombre El nuevo nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del Producto.
     *
     * @return El precio del Producto.
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del Producto.
     *
     * @param precio El nuevo precio a asignar.
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad disponible del Producto.
     *
     * @return La cantidad disponible del Producto.
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad disponible del Producto.
     *
     * @param cantidad La nueva cantidad disponible a asignar.
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
