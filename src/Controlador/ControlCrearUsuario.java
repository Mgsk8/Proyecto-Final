/*
Proposito: Gestiona las interacciones del usuario en la vista Crear Usuario.
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
import Modelo.Usuario;
import Vista.CrearUsuario;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ControlCrearUsuario implements ActionListener, WindowListener {

    CrearUsuario cu;

    public ControlCrearUsuario(CrearUsuario obj) {
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
            if (cu.jtNom.getText().isEmpty() || cu.jtCedula.getText().isEmpty() || cu.jtApe.getText().isEmpty()
                    || cu.jtEmail.getText().isEmpty() || cu.jpPassword.equals("")) {
                JOptionPane.showMessageDialog(cu, "Complete todos los datos",
                        "Error", 2);
            } else {
                FileWriter fw = null;
                Boolean error = false;
                try {
                    fw = new FileWriter("Usuarios.csv", true);
                } catch (Exception a) {
                    error = true;
                    JOptionPane.showMessageDialog(cu, a + "\n\n Error al tratar de crear el archivo", "error", 0);
                }
                if (!error) {
                    String ced = cu.jtCedula.getText();
                    if (consultar_x_ced(ced)) {
                        JOptionPane.showMessageDialog(cu, "Usuario con cedula " + ced + " ya existe");
                    } else {
                        String nom = cu.jtNom.getText();
                        String ape = cu.jtApe.getText();
                        String email = cu.jtEmail.getText();
                        char caracteres[] = cu.jpPassword.getPassword(); // obtener los caracteres escritos como un
                                                                         // arreglo de tipo char[]
                        String password = String.valueOf(caracteres);
                        String dia = (String) cu.jcDia.getSelectedItem();
                        String mes = (String) cu.jcMes.getSelectedItem();
                        String year = (String) cu.jcYear.getSelectedItem();
                        String grupoS = (String) cu.jcGrupoSanguineo.getSelectedItem();
                        String tipoU = (String) cu.jcTipoUsuario.getSelectedItem();
                        String estado = "Activo";
                        Usuario usuario = new Usuario(ced, nom, ape, tipoU, grupoS, dia, mes, year, email, password,
                                estado);
                        try {
                            fw.write(usuario + "\r\n");
                            int resp = JOptionPane.showConfirmDialog(cu,
                                    "Se guardaron los datos de la persona.\nDesea ingresar otro usuario?",
                                    "Confirmación", JOptionPane.YES_NO_OPTION);
                            if (resp == JOptionPane.YES_OPTION) {
                                limpiar();
                            } else {
                                volver();
                            }
                        } catch (Exception a) {
                            JOptionPane.showMessageDialog(cu, a + "\n\n Error al tratar de guardar el archivo", "error",
                                    0);
                        }
                        try {
                            fw.close();
                        } catch (IOException a) {
                            System.out.println("Error al tratar de cerrar el archivo");
                        }
                    }

                }
            }

        }

    }

    public boolean consultar_x_ced(String ced) {
        FileReader fr = null;// permite leer el archivo
        boolean error = false;
        boolean existe = false;
        try {
            fr = new FileReader("Usuarios.csv");
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null,
                    e + "\n\nError al abrir el archivo");
        }
        if (!error) {
            BufferedReader br = new BufferedReader(fr);// clase que se utiliza para leer texto
            String linea = "";
            String[] tokens;

            try {
                while ((linea = br.readLine()) != null) { // readLine() es un método utilizado para leer una línea de
                                                          // texto
                    tokens = linea.split(";");// divir los caracteres
                    if (tokens[0].equals(ced)) {
                        existe = true;
                        break; // romper el while, para que no siga buscando en el archivo
                    }
                } // fin while
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e + "\n\nError al leer el archivo");
            }
            try {
                fr.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e + "\n\nError al cerrar el archivo");
            }
        }
        return existe;
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
        cu.jpPassword.setText("");
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
