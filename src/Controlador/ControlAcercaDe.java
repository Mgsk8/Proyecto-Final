/*
Proposito: Gestiona las interacciones del usuario en la vista AcercaDe.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/
package Controlador;

import Vista.AcercaDe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlAcercaDe implements ActionListener{
    
    AcercaDe ad;
    
    public ControlAcercaDe(AcercaDe obj){
        ad = obj;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ad.jbVolver)) {
            volver();
        }
    }
    public void volver(){
        ad.setVisible(false);
        ad.dispose();
    }     
    
}
