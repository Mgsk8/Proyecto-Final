/*
Proposito: Gestiona las interacciones del usuario en el formulario listado de Estado y Grupo Sanguineo.
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
import Vista.ListadoEstadoxSanguineo;

public class ControlFormListadoEstadoxSanguineo implements ActionListener, WindowListener {

    public FormListadoEstadoxSanguineo fles;

    public ControlFormListadoEstadoxSanguineo(FormListadoEstadoxSanguineo obj) {
        fles = obj;
    }

    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(fles,
                "¿Desea salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    public void volver() {
        fles.setVisible(false);
        fles.dispose();
        fles.l.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(fles.jbVolver)) {
            volver();
        }
        if (e.getSource().equals(fles.jbConsultar)) {
            String Estado_Buscar = (String) fles.jcEstado.getSelectedItem();
            String Grupo_Buscar = (String) fles.jcGrupoSanguineo.getSelectedItem();
            ListadoEstadoxSanguineo les = new ListadoEstadoxSanguineo(fles, Estado_Buscar, Grupo_Buscar);
            fles.setVisible(false);
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
