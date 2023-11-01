/*
Proposito: Modelo de tabla simple que permite la creación de una tabla de manera sencilla y general
donde se necesite.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/

package Vista;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel{
    public ModeloTabla(Object datos[][], Object encabezados[]){
        super(datos, encabezados);
    }

    public boolean isCellEditable(int row, int column){
        return false;
    }
}
