/*
Proposito: Gestiona las interacciones del usuario en la vista listado General.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/

package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import Vista.ListadoGeneral;

public class ControlListadoGeneral implements ActionListener, WindowListener{
    
    public ListadoGeneral lg;

    public ControlListadoGeneral(ListadoGeneral obj){
        lg = obj;
    }

    public void evento_salir(){
       int respuesta = JOptionPane.showConfirmDialog(lg,
               "¿Desea salir de la aplicación?",
               "Confirmación", 
               JOptionPane.YES_NO_OPTION);
       if(respuesta == JOptionPane.YES_OPTION) System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(lg.jbVolver)){
            volver();
        } 
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    public void volver(){
        lg.setVisible(false);
        lg.dispose();
        lg.l.setVisible(true);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        evento_salir();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
