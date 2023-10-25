/*
Proposito: Nos permite controlar la acciones de la vista menu principal
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  26/09/2023
version: 1.0
*/
package Controlador;

import Vista.AcercaDe;
import Vista.CrearUsuario;
import Vista.ListadoUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.MenuPrincipal;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

public class ControlMenuPrincipal implements ActionListener, WindowListener{

    MenuPrincipal mp; //crea un obj de la clase que controla
    
    
    public ControlMenuPrincipal(MenuPrincipal obj){
        mp = obj; // Guarda el objeto que recibe de MenuPrincipal en la variable antes creado        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mp.jbVentanaCrearUsuario)) {
            CrearUsuario cu = new CrearUsuario(mp);
            mp.setVisible(false);
        }
        if (e.getSource().equals(mp.jbAcerca)) {
            AcercaDe ad = new AcercaDe(mp);
            mp.setVisible(false);
        }
        if (e.getSource().equals(mp.jbVentanaListado)) {
            //System.out.println("Clic en jbGrafica");
            ListadoUsuarios lp = new ListadoUsuarios(mp);
            mp.setVisible(false);
        }
       /* if (e.getSource().equals(mp.jbAcerca)) {
            System.out.println("Clic en jbAcerca");
        }
*/
    }
    public void evento_salir(){
       int respuesta = JOptionPane.showConfirmDialog(mp,
               "¿Desea salir de la aplicación?",
               "Confirmación", 
               JOptionPane.YES_NO_OPTION);
       if(respuesta == JOptionPane.YES_OPTION) System.exit(0);
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
