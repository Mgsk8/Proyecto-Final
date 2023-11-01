/*
Proposito: Muestra en pantalla 2 listas desplegables donde el ususario
puede seleccionar 2 opciones entre estado del usuarios y el tipo de sangre
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

import Controlador.ControlFormListadoEstadoxSanguineo;
import Utilerias.JButtonMenu;
import Utilerias.JLabelTitulo;

public class FormListadoEstadoxSanguineo extends JFrame{
    
    public String Estado_Buscar = "", Grupo_Buscar = "";
    public Listados l;
    public ControlFormListadoEstadoxSanguineo cfles;
    public JButton jbVolver, jbConsultar;
    public JComboBox<String> jcGrupoSanguineo, jcEstado;

    public FormListadoEstadoxSanguineo(Listados obj){
        super("Formulario Estado x Sanguineo");
        l = obj;
        setSize(800, 620);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        cfles = new ControlFormListadoEstadoxSanguineo(this);
        addWindowListener(cfles);
        crearGUI();
        
        setVisible(true);
    }



    public void crearGUI(){
        ControlFormListadoEstadoxSanguineo cfles = new ControlFormListadoEstadoxSanguineo(this);
        
        JPanel jp = new JPanel();
        jp.setBounds(100, 80, 600, 400);
        jp.setBackground(Color.white);
        jp.setLayout(null);
        add(jp);
        
        JLabelTitulo jt = new JLabelTitulo(60, "Formulario Estado x Sanguineo", this, "");
        add(jt);

        JLabel jlGrupoSanguineo = new JLabel("Escoga un Grupo Sanguineo:");
        jlGrupoSanguineo.setBounds(90, 50, 250, 30);
        jp.add(jlGrupoSanguineo);

        jcGrupoSanguineo = new JComboBox<>();
        String grupoSanguineo[] = {"A+","O+","B+","AB+","A-","O-","B-","AB-"};
        for (int i = 0; i < grupoSanguineo.length; i++) {
            jcGrupoSanguineo.addItem(grupoSanguineo[i]); 
        }

        jcGrupoSanguineo.setBounds(120, 100,  70, 30);
        jp.add(jcGrupoSanguineo);

        JLabel jlEstado = new JLabel("Escoga un Estado:");
        jlEstado.setBounds(360, 50, 250, 30);
        jp.add(jlEstado);

        jcEstado = new JComboBox<>();
        String Estado[] = {"Activo","Inactivo"};
        for (int i = 0; i < Estado.length; i++) {
            jcEstado.addItem(Estado[i]); 
        }

        jcEstado.setBounds(370, 100,  70, 30);
        jp.add(jcEstado);

        jbVolver = new JButtonMenu(80, 330, 200, 50, 
                "Volver", "Ir a Listados", 
                "", 'V', this);
        jbVolver.addActionListener(cfles);
        jp.add(jbVolver);


        jbConsultar = new JButtonMenu(300, 330, 200, 50, 
                "Consultar", "Ir a Consultar", 
                "", 'G', this);
        jbConsultar.addActionListener(cfles);
        jp.add(jbConsultar);

    }

}
