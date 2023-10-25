/*
Proposito: Gestiona las interacciones del usuario en la vista ListadoUsuarios.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  26/09/2023
version: 1.0
*/

package Controlador;

import Vista.ListadoUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlListadoUsuarios implements ActionListener{

    ListadoUsuarios lu;
    
    public ControlListadoUsuarios(ListadoUsuarios obj){
        lu = obj;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(lu.jbVolver)) volver();
    }
    
    private void volver() {
        lu.setVisible(false);
        lu.dispose();
        lu.mp.setVisible(true);
    }
}
