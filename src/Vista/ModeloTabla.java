/**
 * La clase ModeloTabla extiende DefaultTableModel y se utiliza para crear
 * modelos de tabla personalizados en aplicaciones de interfaz gráfica de usuario.
 * Permite especificar datos iniciales y encabezados para la tabla, y deshabilita
 * la edición directa de celdas.
 *
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 * @since 11/12/2023
 * @version 1.4
 */

package Vista;

import javax.swing.table.DefaultTableModel;

     

/**
 * La clase ModeloTabla extiende DefaultTableModel y se utiliza para crear
 * modelos de tabla personalizados en aplicaciones de interfaz gráfica de usuario.
 * Permite especificar datos iniciales y encabezados para la tabla, y deshabilita
 * la edición directa de celdas.
 * */

public class ModeloTabla extends DefaultTableModel{
    
    /**
     * Constructor de la clase ModeloTabla.
     *
     * @param datos      Matriz de objetos que representa los datos iniciales de la tabla.
     * @param encabezados Arreglo de objetos que representa los encabezados de la tabla.
     */
    
    public ModeloTabla(Object datos[][], Object encabezados[]){
        super(datos, encabezados);
    }
     /**
     * Indica si la celda en la posición dada es editable o no. En este caso, se
     * devuelve false para deshabilitar la edición directa de celdas.
     *
     * @param row    Índice de fila.
     * @param column Índice de columna.
     * @return false para indicar que la celda no es editable.
     */
    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }
}
