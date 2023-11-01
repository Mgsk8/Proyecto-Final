/*
Proposito: Muestra en pantalla un gráfico circular o de torta rotatorio donde
se muestran los porcentajes de los usuario por su tipo de usuario.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  20/10/2023
version: 1.1
*/

package Vista;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import Controlador.ControlGraficoPersonal;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GraficoPersonal extends JFrame {

    JFreeChart chart;
    public Graficos g;
    public ControlGraficoPersonal cgp;

    public GraficoPersonal(Graficos obj) {
        super("GRAFICO PERSONAL GYMBROKO");
        g = obj;
        setSize(900, 700);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        cgp = new ControlGraficoPersonal(this);
        addWindowListener(cgp);

        int[] personal = listadoPersonal();
        crearGrafico(personal);

        ChartPanel panel = new ChartPanel(chart, false);
        panel.setBounds(30, 30, 760, 520);
        add(panel);

        setVisible(true);
    }

    public void crearGrafico(int[] personal) {
        
        for (int i = 0; i < personal.length; i++) {
            System.out.println("Posicion " + i + ": " + personal[i]);
        }
        int usuariosTotales = personal[0];
        double porcAdmin = 0;
        double porcSup = 0;
        double porcRec = 0;
        double porcEnt = 0;
        double porcCli = 0;

        if(personal[1] != 0){
            porcAdmin = (personal[1] * 100) / usuariosTotales;
        }
        if(personal[2] != 0){
            porcSup = (personal[2] * 100) / usuariosTotales;
        }
        if(personal[3] != 0){
            porcRec = (personal[3] * 100) / usuariosTotales;
        }
        if(personal[4] != 0){
            porcEnt = (personal[4] * 100) / usuariosTotales;
        }
        if(personal[5] != 0){
            porcCli = (personal[5] * 100) / usuariosTotales;
        }

        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Administradores: " + porcAdmin + "%", porcAdmin);
        data.setValue("Supervisores: " + porcSup + "%", porcSup);
        data.setValue("Recepcionistas: " + porcRec + "%", porcRec);
        data.setValue("Entrenadores: " + porcEnt + "%", porcEnt);
        data.setValue("Clientes: " + porcCli + "%", porcCli);

        chart = ChartFactory.createPieChart3D(
                "PERSONAL", // chart title
                data, // data
                true, // include legend
                true,
                true);

        chart.setBackgroundPaint(Color.ORANGE);// Color de fonde de la ventana
        chart.getTitle().setPaint(Color.blue); // Dar color al titulo

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelBackgroundPaint(Color.ORANGE);// Color de las etiquetas
        plot.setForegroundAlpha(0.60f);// Color de el fondo del grafico

        // esto es lo que lo hace rotar
        Rotator rotator = new Rotator(plot);
        rotator.start();
    }

    public int [] listadoPersonal() {
        FileReader fr = null;
        boolean error = false;
        int[] personal = new int[6];
        int contadorUsu = 0;
        int contadorAdmin = 0;
        int contadorSup = 0;
        int contadorRec = 0;
        int contadorEnt = 0;
        int contadorCli = 0;
        try {
            fr = new FileReader("Usuarios.csv");
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null,
                    e + "\n\nError al abrir el archivo");
        }
        if (!error) {
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String tokens[];
            try {
                while ((linea = br.readLine()) != null) {
                    tokens = linea.split(";");
                    contadorUsu = contadorUsu + 1;
                    System.out.println(tokens[3]);
                    if(tokens[3].equals("Administrador")){
                        contadorAdmin = contadorAdmin + 1;
                    }
                    if(tokens[3].equals("Supervisor")){
                        contadorSup = contadorSup + 1;
                    }
                    if(tokens[3].equals("Recepcionista")){
                        contadorRec = contadorRec + 1;
                    }
                    if(tokens[3].equals("Entrenador")){
                        contadorEnt = contadorEnt + 1;
                    }
                    if(tokens[3].equals("Cliente")){
                        contadorCli = contadorCli + 1;
                    }
                }
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
        personal[0] = contadorUsu;
        personal[1] = contadorAdmin;
        personal[2] = contadorSup;
        personal[3] = contadorRec;
        personal[4] = contadorEnt;
        personal[5] = contadorCli;
        return personal;

    }

    /*public static void main(final String[] args) {
        GraficoPersonal gp = new GraficoPersonal();
    }*/
}
