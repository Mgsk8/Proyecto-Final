/*
Proposito: Gestiona las interacciones del usuario en la vista Actualizar Usuario.
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
import Vista.ActualizarUsuario;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ControlActualizarUsuario implements ActionListener, WindowListener {

    ActualizarUsuario au;

    public ControlActualizarUsuario(ActualizarUsuario obj) {
        au = obj;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(au.jbVolver)) {
            volver();
        }
        if (e.getSource().equals(au.jbLimpiar)) {
            limpiar();
            volverNoEditables();
        }
        if (e.getSource().equals(au.jbConsultar)) {

            String ced = au.jtCedula.getText();
            limpiar();
            volverNoEditables();
            llenarCampos(ced);

        }
        if (e.getSource().equals(au.jbActualizar)) {
            String ced = au.jtCedula.getText();
            actualizarDatos(ced);
        }
    }

    private void limpiar() {
        au.jtCedula.setText("");
        au.jtNom.setText("");
        au.jtApe.setText("");
        au.jcTipoUsuario.setSelectedItem("Cliente");
        au.jcGrupoSanguineo.setSelectedItem("A+");
        au.jcDia.setSelectedItem("1");
        au.jcMes.setSelectedItem("1");
        au.jcYear.setSelectedItem(au.yearActual);
        au.jtEmail.setText("");
        au.jpPassword.setText("");
        au.jtCedula.requestFocus();
    }

    private void volverEditables() {
        au.jtCedula.setEditable(false);
        au.jtNom.setEditable(true);
        au.jtApe.setEditable(true);
        au.jtEmail.setEditable(true);
        au.jpPassword.setEditable(true);
        au.jpPassword.setEchoChar((char) 0);
        au.jcTipoUsuario.setEnabled(true);
        au.jcGrupoSanguineo.setEnabled(true);
        au.jcDia.setEnabled(true);
        au.jcMes.setEnabled(true);
        au.jcYear.setEnabled(true);
        au.jrActivo.setEnabled(true);
        au.jrInactivo.setEnabled(true);
    }

    private void volverNoEditables() {
        au.jtCedula.setEditable(true);
        au.jtNom.setEditable(false);
        au.jtApe.setEditable(false);
        au.jtEmail.setEditable(false);
        au.jpPassword.setEditable(false);
        au.jcTipoUsuario.setEnabled(false);
        au.jcGrupoSanguineo.setEnabled(false);
        au.jcDia.setEnabled(false);
        au.jcMes.setEnabled(false);
        au.jcYear.setEnabled(false);
        au.jrActivo.setEnabled(false);
        au.jrInactivo.setEnabled(false);
    }

    private void llenarCampos(String ced) {
        FileReader fr = null;
        boolean error = false;

        try {
            fr = new FileReader("Usuarios.csv");
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(au, e + "\n\n Error al abrir el archivo");
        }
        if (!error) {
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            boolean existe = false;
            String tokens[];
            try {
                while ((linea = br.readLine()) != null) {
                    tokens = linea.split(";");
                    if (tokens[0].equals(ced)) {
                        existe = true;
                        volverEditables();
                        au.jtCedula.setText(tokens[0]);
                        au.jtNom.setText(tokens[1]);
                        au.jtApe.setText(tokens[2]);
                        au.jcTipoUsuario.setSelectedItem(tokens[3]);
                        au.jcGrupoSanguineo.setSelectedItem(tokens[4]);
                        au.jcDia.setSelectedItem(tokens[5]);
                        au.jcMes.setSelectedItem(tokens[6]);
                        au.jcYear.setSelectedItem(tokens[7]);
                        au.jtEmail.setText(tokens[8]);
                        au.jpPassword.setText(tokens[9]);
                        if ("Activo".equals(tokens[10]))
                            au.jrActivo.setSelected(true);
                        else
                            au.jrInactivo.setSelected(true);
                    }
                }
                if (!existe) {
                    JOptionPane.showMessageDialog(au, "Usuario con cedula " + ced + " no existe");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(au, e + "\n\nError al leer el archivo", "Error", 0);
            }

        }

    }

    private void actualizarDatos(String id) {
        if (au.jtNom.getText().isEmpty() || au.jtCedula.getText().isEmpty() || au.jtApe.getText().isEmpty()
                || au.jtEmail.getText().isEmpty() || au.jpPassword.getPassword().equals("")) {
            JOptionPane.showMessageDialog(au, "Complete todos los datos",
                    "Error", 2);
        } else {
            FileReader fr = null;
            boolean error = false;
            boolean existe = false;
            try {
                fr = new FileReader("Usuarios.csv");
            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(au, e + "\n\n Error al abrir el archivo");
            }
            if (!error) {
                BufferedReader br = new BufferedReader(fr);
                String linea = "";
                ArrayList<String> lineas = new ArrayList<>();
                String tokens[];
                try {
                    while ((linea = br.readLine()) != null) {
                        tokens = linea.split(";");
                        if (tokens[0].equals(id)) {
                            existe = true;
                            String nom = au.jtNom.getText();
                            String ape = au.jtApe.getText();
                            String email = au.jtEmail.getText();
                            char caracteres[] = au.jpPassword.getPassword(); // obtener los caracteres escritos como un
                                                                             // arreglo de tipo char[]
                            String password = String.valueOf(caracteres);
                            String dia = (String) au.jcDia.getSelectedItem();
                            String mes = (String) au.jcMes.getSelectedItem();
                            String year = (String) au.jcYear.getSelectedItem();
                            String grupoS = (String) au.jcGrupoSanguineo.getSelectedItem();
                            String tipoU = (String) au.jcTipoUsuario.getSelectedItem();
                            String estado = "Activo";
                            if (au.jrActivo.isSelected())
                                estado = "Activo";
                            if (au.jrInactivo.isSelected())
                                estado = "Inactivo";
                            tokens[1] = nom;
                            tokens[2] = ape;
                            tokens[3] = tipoU;
                            tokens[4] = grupoS;
                            tokens[5] = dia;
                            tokens[6] = mes;
                            tokens[7] = year;
                            tokens[8] = email;
                            tokens[9] = password;
                            tokens[10] = estado;

                            String editor = String.join(";", tokens);
                            lineas.add(editor);
                        } else {
                            lineas.add(linea);
                        }
                    }
                    if (!existe) {
                        JOptionPane.showMessageDialog(au, "INGRESE PRIMERO LOS DATOS!!" + "\n Precione Consultar",
                                "¿QUE ESTAS HACIENDO?", 2);
                    } else {
                        int resp = JOptionPane.showConfirmDialog(au,
                                "desea actualizar los datos?",
                                "Confirmación",
                                JOptionPane.YES_NO_OPTION);
                        if (resp == JOptionPane.YES_OPTION) {
                            BufferedWriter escritor = new BufferedWriter(new FileWriter("Usuarios.csv"));
                            for (String l : lineas) {
                                escritor.write(l);
                                escritor.newLine();
                            }
                            escritor.close();
                            int resp2 = JOptionPane.showConfirmDialog(au,
                                    "datos guardados, \n desea actualizar otro usuario?",
                                    "Confirmación",
                                    JOptionPane.YES_NO_OPTION);
                            if (resp2 == JOptionPane.YES_OPTION) {
                                limpiar();
                                volverNoEditables();
                            } else {
                                volver();
                            }
                        } else {
                            int resp3 = JOptionPane.showConfirmDialog(au,
                                    "desea actualizar otro usuario?",
                                    "Confirmación",
                                    JOptionPane.YES_NO_OPTION);
                            if (resp3 == JOptionPane.YES_OPTION) {
                                limpiar();
                                volverNoEditables();
                            } else {
                                volver();
                            }
                        }

                        if (!existe) {
                            JOptionPane.showMessageDialog(au, "Usuario con cedula " + id + " no existe");
                        }
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(au, e + "\n\nError al leer el archivo", "Error", 0);
                }

            }
        }
    }

    private void volver() {
        au.setVisible(false);
        au.dispose();
        au.mp.setVisible(true);
    }

    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(au,
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
