
package Controlador;

import Vista.ConsultaQR;
import Vista.ConsultarUsuario;
import Vista.TipoConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

public class ControlTipoConsulta implements ActionListener, WindowListener{
    
    TipoConsulta tc;
    
    public ControlTipoConsulta(TipoConsulta tc){
        this.tc = tc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(tc.jbVolver)){
            volver();
        }
        if (e.getSource().equals(tc.jbFormulario)) {
            ConsultarUsuario cu = new ConsultarUsuario(tc);
            tc.setVisible(false);
        }
        if (e.getSource().equals(tc.jbQr)) {
            ConsultaQR cq = new ConsultaQR(tc);
            tc.setVisible(false);
        }
    }
    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(tc,
                "¿Desea salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
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
