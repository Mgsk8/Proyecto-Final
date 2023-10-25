/*
Proposito: Gestiona las interacciones del usuario en la vista CrearUsuario.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  26/09/2023
version: 1.0
*/

package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelo.Usuario;
import Vista.CrearUsuario;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControlCrearUsuario implements ActionListener, WindowListener{

    CrearUsuario cu;
    
    public ControlCrearUsuario(CrearUsuario obj){
        cu = obj;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cu.jbVolver)) {
            volver();
        }
        if (e.getSource().equals(cu.jbLimpiar)) {
            limpiar();
        }
        if (e.getSource().equals(cu.jbGuardar)) {
            String ced = cu.jtCedula.getText();
            String nom = cu.jtNom.getText();
            String ape = cu.jtApe.getText();
            String email = cu.jtEmail.getText();
            String password = cu.jtPassword.getText();
            String dia = (String) cu.jcDia.getSelectedItem();
            String mes = (String) cu.jcMes.getSelectedItem();
            String year = (String) cu.jcYear.getSelectedItem();
            String grupoS = (String) cu.jcGrupoSanguineo.getSelectedItem();
            String tipoU = (String) cu.jcTipoUsuario.getSelectedItem();
            String fecha = dia + "/" + mes + "/" + year;
            Usuario usuario = new Usuario(ced, nom, ape, tipoU, grupoS,fecha, email, password);
            cu.mp.usuarios.add(usuario);
            int resp = JOptionPane.showConfirmDialog(cu, 
                    "Se guardaron los datos de la persona.\nDesea ingresar otro usuario?", 
                    "Confirmación", 
                    JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                limpiar();
            }else{
                volver();
            }
        }
    }

    private void limpiar() {
        cu.jtCedula.setText("");
        cu.jtNom.setText("");
        cu.jtApe.setText("");
        cu.jcTipoUsuario.setSelectedItem("Cliente");
        cu.jcGrupoSanguineo.setSelectedItem("A+");
        cu.jcDia.setSelectedItem("1");
        cu.jcMes.setSelectedItem("1");
        cu.jcYear.setSelectedItem(cu.yearActual);
        cu.jtEmail.setText("");
        cu.jtPassword.setText("");
        cu.jtApe.requestFocus();
    }

    private void volver() {
        cu.setVisible(false);
        cu.dispose();
        cu.mp.setVisible(true);
    }
    
    public void evento_salir(){
       int respuesta = JOptionPane.showConfirmDialog(cu,
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
