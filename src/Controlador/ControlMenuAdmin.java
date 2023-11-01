/*
Proposito: Nos permite controlar la acciones de la vista menu principal
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
    Fecha de ultima modificacion  20/10/2023
version: 1.1
*/
package Controlador;

import Vista.AcercaDe;
import Vista.ActualizarUsuario;
import Vista.ConsultarUsuario;
import Vista.CrearUsuario;
import Vista.Graficos;
import Vista.Listados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.MenuAdmin;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

public class ControlMenuAdmin implements ActionListener, WindowListener {

    MenuAdmin mp; // crea un obj de la clase que controla

    public ControlMenuAdmin(MenuAdmin obj) {
        mp = obj; // Guarda el objeto que recibe de MenuAdmin en la variable antes creado
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mp.jbNuevoUsuario)) {
            CrearUsuario cu = new CrearUsuario(mp);
            mp.setVisible(false);
        }
        if (e.getSource().equals(mp.jbAcerca)) {
            AcercaDe ad = new AcercaDe(mp);
            mp.setVisible(true);
        }

        if (e.getSource().equals(mp.jbConsultarUsuario)) {
            // System.out.println("Clic en jbGrafica");
            ConsultarUsuario cu = new ConsultarUsuario(mp);
            mp.setVisible(false);
        }
        if (e.getSource().equals(mp.jbListados)) {
            // System.out.println("Clic en jbGrafica");
            Listados l = new Listados(mp);
            mp.setVisible(false);
        }
        if (e.getSource().equals(mp.jbActualizar)) {
            // System.out.println("Clic en jbGrafica");
            ActualizarUsuario au = new ActualizarUsuario(mp);
            mp.setVisible(false);
        }
        if (e.getSource().equals(mp.jbEstadistica)) {
            // System.out.println("Clic en jbGrafica");
           Graficos g = new Graficos(mp);
            mp.setVisible(false);
        }
    }

    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(mp,
                "¿Desea salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION)
            System.exit(0);
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
