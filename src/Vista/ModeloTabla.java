/*
Proposito: Nos permite construir un modelo de tabla por defecto e indicar si cada celda de la tabla es editable o no.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  27/09/2023
version: 1.0
*/

package Vista;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel{
    
    public ModeloTabla(Object datos[][], Object encazados[]){
        super(datos, encazados);
    }
    
    public boolean isCellEditable(int row, int column){
        //return true;
        return false;
    }
}
