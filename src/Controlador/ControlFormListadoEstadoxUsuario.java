/*
Proposito: Gestiona las interacciones del usuario en el formulario listado de Estado y Tipo de Usuario.
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

import Vista.FormListadoEstadoxUsuario;
import Vista.ListadoEstadoxUsuario;

public class ControlFormListadoEstadoxUsuario implements ActionListener, WindowListener {

    public FormListadoEstadoxUsuario fleu;

    public ControlFormListadoEstadoxUsuario(FormListadoEstadoxUsuario obj) {
        fleu = obj;
    }

    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(fleu,
                "¿Desea salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    public void volver() {
        fleu.setVisible(false);
        fleu.dispose();
        fleu.l.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(fleu.jbVolver)) {
            volver();
        }
        if (e.getSource().equals(fleu.jbConsultar)) {
            String Estado_Buscar = (String) fleu.jcEstado.getSelectedItem();
            String Usuario_Buscar = (String) fleu.jcUsuario.getSelectedItem();
            ListadoEstadoxUsuario leu = new ListadoEstadoxUsuario(fleu, Estado_Buscar, Usuario_Buscar);
            fleu.setVisible(false);
        }
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
