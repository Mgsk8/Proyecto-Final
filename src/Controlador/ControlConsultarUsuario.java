/*
Proposito: Gestiona las interacciones del usuario en la vista Consultar Usuario.
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
import javax.swing.JOptionPane;
import Vista.ConsultarUsuario;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class ControlConsultarUsuario implements ActionListener, WindowListener {

    ConsultarUsuario cu;

    public ControlConsultarUsuario(ConsultarUsuario obj) {
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
        if (e.getSource().equals(cu.jbConsultar)) {
            String ced = cu.jtCedula.getText();
            buscarUsario(ced);
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
        cu.jtCedula.requestFocus();
    }

    private void volver() {
        cu.setVisible(false);
        cu.dispose();
        cu.mp.setVisible(true);
    }

    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(cu,
                "¿Desea salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    public void buscarUsario(String ced) {
        FileReader fr = null;
        boolean error = false;
        try {
            fr = new FileReader("Usuarios.csv");
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(cu, e + "\n\n Error al abrir el archivo");
        }
        if (!error) {
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String tokens[];
            boolean existe = false;
            try {
                while ((linea = br.readLine()) != null) {
                    tokens = linea.split(";");
                    if (tokens[0].equals(ced)) {
                        existe = true;
                        cu.jtCedula.setText(tokens[0]);
                        cu.jtNom.setText(tokens[1]);
                        cu.jtApe.setText(tokens[2]);
                        cu.jcTipoUsuario.setSelectedItem(tokens[3]);
                        cu.jcGrupoSanguineo.setSelectedItem(tokens[4]);
                        cu.jcDia.setSelectedItem(tokens[5]);
                        cu.jcMes.setSelectedItem(tokens[6]);
                        cu.jcYear.setSelectedItem(tokens[7]);
                        cu.jtEmail.setText(tokens[8]);
                        if ("Activo".equals(tokens[10]))
                            cu.jrActivo.setSelected(true);
                        else
                            cu.jrInactivo.setSelected(true);
                        break;
                    }
                }
                if (!existe) {
                    JOptionPane.showMessageDialog(cu, "Usuario con cedula " + ced + " no existe");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(cu, e + "\n\nError al leer el archivo", "Error", 0);
            }

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
