/*
Proposito: Gestiona las interacciones del usuario en el submenú listados.
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

import Vista.FormListadoEstadoxSanguineo;
import Vista.FormListadoEstadoxUsuario;
import Vista.ListadoGeneral;
import Vista.Listados;

public class ControlListados implements ActionListener, WindowListener{
    
    public Listados l;

    public ControlListados(Listados obj){
        l = obj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(l.jbListadoGeneral)){
            ListadoGeneral lg = new ListadoGeneral(l);
            l.setVisible(false);
        }
        if(e.getSource().equals(l.jbListadoEstadoxSanguineo)){
            FormListadoEstadoxSanguineo fles = new FormListadoEstadoxSanguineo(l);
            l.setVisible(false);
        }
        if(e.getSource().equals(l.jbListadoEstadoxTipo)){
            FormListadoEstadoxUsuario fleu = new FormListadoEstadoxUsuario(l);
            l.setVisible(false); 
        }if(e.getSource().equals(l.jbVolver)){
            volver();
        }
    }
    public void evento_salir(){
       int respuesta = JOptionPane.showConfirmDialog(l,
               "¿Desea salir de la aplicación?",
               "Confirmación", 
               JOptionPane.YES_NO_OPTION);
       if(respuesta == JOptionPane.YES_OPTION) System.exit(0);
    }
    public void volver(){
        l.setVisible(false);
        l.dispose();
        l.mp.setVisible(true);
    }  

    @Override
    public void windowOpened(WindowEvent e) {

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
