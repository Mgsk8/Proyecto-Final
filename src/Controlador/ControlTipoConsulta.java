/**
 * Proposito: Gestiona las interacciones con la interfaz de Tipo Consulta
 *
 * @author John Alejandro Vallarino - 2264332
 * @author Jhon Alex Rodriguez - 2264363
 * @author Miguel Ángel Escobar Marín - 2264305
 * @version 1.3
 * @since 4-12-2023
 */
package Controlador;

import Vista.ConsultaQR;
import Vista.ConsultarUsuario;
import Vista.TipoConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 * Proposito: Gestiona las interacciones con la interfaz de Tipo Consulta
 */

public class ControlTipoConsulta implements ActionListener, WindowListener{
    /**
     * Objeto TipoConsulta asociado al controlador.
     */    
    TipoConsulta tc;
    /**
     * Privilegios del usuario.
     */    
    String privilegios = "";
    /**
     * Constructor de ControlTipoConsulta.
     *
     * @param tc Objeto TipoConsulta asociado al controlador.
     * @param privi Privilegios del usuario.
     */    
    public ControlTipoConsulta(TipoConsulta tc, String privi){
        privilegios = privi;
        this.tc = tc;
    }
    // Métodos de ActionListener
    
    /**
     * Método que se ejecuta cuando se realiza una acción en la interfaz.
     *
     * @param e Evento de acción
     */  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(tc.jbVolver)){
            volver();
        }
        if (e.getSource().equals(tc.jbFormulario)) {
            ConsultarUsuario cu = new ConsultarUsuario(tc, privilegios);
            tc.setVisible(false);
        }
        if (e.getSource().equals(tc.jbQr)) {
            ConsultaQR cq = new ConsultaQR(tc);
            tc.setVisible(false);
        }
    }
    /**
     * Muestra un cuadro de diálogo de confirmación al intentar cerrar la ventana.
     * Si el usuario elige "Sí", se cierra la aplicación.
     */    
    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(tc,
                "¿Desea salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    /**
     * Oculta la ventana actual y muestra la ventana principal.
     */    
    private void volver() {
        tc.setVisible(false);
        tc.dispose();
        tc.ma.setVisible(true);
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