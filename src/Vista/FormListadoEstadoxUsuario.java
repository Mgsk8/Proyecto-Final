/*
Proposito: Muestra en pantalla 2 listas desplegables donde el ususario
puede seleccionar 2 opciones entre estado del usuario y el tipo de usuario
con botones para consultar y volver al menú principal.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/
package Vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControlFormListadoEstadoxUsuario;
import Utilerias.JButtonMenu;
import Utilerias.JLabelTitulo;

public class FormListadoEstadoxUsuario extends JFrame {

    public String Estado_Buscar = "", Usuario_Buscar = "";
    public Listados l;
    public ControlFormListadoEstadoxUsuario cfleu;
    public JButton jbVolver, jbConsultar;
    public JComboBox<String> jcUsuario, jcEstado;

    public FormListadoEstadoxUsuario(Listados obj) {
        super("Formulario Estado x Usuario");
        l = obj;
        setSize(800, 620);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        cfleu = new ControlFormListadoEstadoxUsuario(this);
        addWindowListener(cfleu);
        crearGUI();

        setVisible(true);
    }

    public void crearGUI() {
        //ControlFormListadoEstadoxUsuario cfle = new ControlFormListadoEstadoxUsuario(this);
        JPanel jp = new JPanel();
        jp.setBounds(100, 80, 600, 400);
        jp.setBackground(Color.white);
        jp.setLayout(null);
        add(jp);

        JLabelTitulo jt = new JLabelTitulo(60, "Formulario Estado x Usuario", this, "");
        add(jt);

        JLabel jlEstado = new JLabel("Escoga un Estado:");
        jlEstado.setBounds(360, 50, 250, 30);
        jp.add(jlEstado);

        jcEstado = new JComboBox<>();
        String Estado[] = { "Activo", "Inactivo" };
        for (int i = 0; i < Estado.length; i++) {
            jcEstado.addItem(Estado[i]);
        }

        jcEstado.setBounds(370, 100, 70, 30);
        jp.add(jcEstado);

        JLabel jlUsuario = new JLabel("Escoga un tipo de usuario:");
        jlUsuario.setBounds(90, 50, 250, 30);
        jp.add(jlUsuario);

        jcUsuario = new JComboBox<>();
        String Usuario[] = { "Administrador", "Supervisor", "Entrenador", "Recepcionista", "Cliente" };
        for (int i = 0; i < Usuario.length; i++) {
            jcUsuario.addItem(Usuario[i]);
        }

        jcUsuario.setBounds(100, 100, 150, 30);
        jp.add(jcUsuario);

        jbVolver = new JButtonMenu(80, 330, 200, 50,
                "Volver", "Ir a Listados",
                "", 'V', this);
        jbVolver.addActionListener(cfleu);
        jp.add(jbVolver);

        jbConsultar = new JButtonMenu(300, 330, 200, 50,
                "Consultar", "Ir a Consultar",
                "", 'G', this);
        jbConsultar.addActionListener(cfleu);
        jp.add(jbConsultar);

    }

}
