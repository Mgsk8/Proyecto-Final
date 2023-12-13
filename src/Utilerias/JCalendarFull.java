/**
 * Clase JCalendarFull que extiende JDialog y proporciona un selector de fecha con funcionalidades adicionales.
 * 
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 * @since 11/12/2023
 * @version 1.4
 */

package Utilerias;


import com.toedter.calendar.JCalendar;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Clase JCalendarFull que extiende JDialog y proporciona un selector de fecha con funcionalidades adicionales.
 */

public class JCalendarFull extends JDialog {

    private JCalendar jcFecha;
    private JButton jbAceptar, jbLimpiar, jbAhora;
    private JComboBox<String> jcHora, jcMinutos;
    private int dia, mes, year, diaSemana, hora, minutos;
    String nombreDia, nombreMes, horaCadena, minutosCadena, fechaCompleta, horaCompleta;
    boolean selecciono;
    
    
    /**
     * Constructor para crear un JCalendar con la fecha actual del sistema.
     *
     * @param jf JFrame padre para el JDialog.
     */
    public JCalendarFull(JFrame jf) {
        super(jf, "Selector de Fecha", true); 
        set(); // asignar atributos con valores por defecto
        crearGUI(); 
    }
    
    /**
     * Constructor para crear un JCalendar con una fecha establecida.
     * La fecha que se desea establecer debe estar en formato "dia;mes;anio;hora;minutos".
     * Por ejemplo, para establecer la fecha de 7 de marzo de 1979 a las 3:30 pm, 
     * la cadena debe ser: "07;03;1979;15;30".
     *
     * @param jf    JFrame padre para el JDialog.
     * @param fecha Cadena con la fecha a establecer.
     */
    public JCalendarFull(JFrame jf, String fecha) {
        super(jf, "Selector de Fecha", true);          
        set(); // asignar atributos con valores por defecto
        crearGUI();       
        
        selecciono = true;
        String tokens[] = fecha.split(";");
        Calendar calendario = new GregorianCalendar(
                Integer.parseInt(tokens[2]),        //convertir el año en entero
                Integer.parseInt(tokens[1]) - 1,    //convertir el mes en entero
                Integer.parseInt(tokens[0]));       //convertir el dia en entero
                
        jcFecha.setDate(calendario.getTime());  //asignar la fecha al jcFecha
        
        jcHora.setSelectedItem(tokens[3]);      //asignar la hora al combobox
        jcMinutos.setSelectedItem(tokens[4]);   //asignar los minutos al combobox
        
        dia = calendario.get(Calendar.DATE);
        mes = calendario.get(Calendar.MONTH) + 1;
        year = calendario.get(Calendar.YEAR);
        diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
        hora = Integer.parseInt((String) jcHora.getSelectedItem());
        minutos = Integer.parseInt((String) jcMinutos.getSelectedItem());
        horaCadena = (String) jcHora.getSelectedItem();
        minutosCadena = (String) jcMinutos.getSelectedItem();
        
        setNombreDia();
        setNombreMes();
    }
    
    /**
     * Inicializa los atributos de la clase.
     */
    public void set(){
        dia = mes = year = diaSemana = hora = minutos = 0;
        nombreDia = nombreMes = horaCadena = minutosCadena = fechaCompleta = horaCompleta = "";
        selecciono = false;
    }
    
    /**
     * Crea la interfaz gráfica del JDialog.
     */
    public void crearGUI(){
        // crear el JDialog
        setSize(315, 330);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        // asignar icono en la barra de titulo del JDialog
        Image icon = new ImageIcon(getClass().getResource("imagenes/calendar-icon.png")).getImage();
        setIconImage(icon);
        
        // crear los componentes para ser adicionados el JDialog
        jcFecha = new JCalendar();// crear el JCalendar con la fecha actual del sistema
        jcFecha.setBounds(30, 10, 240, 200);// Ubicar y agregar al panel             
        add(jcFecha);
        
        jcHora = new JComboBox<String>();
        for(int i = 0; i < 24; i++){
            if(i < 10) jcHora.addItem("0" + i);
            else jcHora.addItem("" + i);
        }
        jcHora.setBounds(97, 215, 48, 25);
        add(jcHora);
        
        JLabel jl = new JLabel(":");
        jl.setBounds(152, 215, 20, 25);
        add(jl);
        
        jcMinutos = new JComboBox<String>();
        for(int i = 0; i < 60; i++){
            if(i < 10) jcMinutos.addItem("0" + i);
            else jcMinutos.addItem("" + i);
        }
        jcMinutos.setBounds(162, 215, 48, 25);
        add(jcMinutos);
        
        jbAceptar = new JButton("Aceptar");
        jbAceptar.setBounds(20, 248, 85, 25);// Ubicar y agregar al panel
        jbAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbAceptar();
            }
        });
        add(jbAceptar);
        
        jbAhora = new JButton("Ahora");
        jbAhora.setBounds(110, 248, 80, 25);// Ubicar y agregar al panel
        jbAhora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbAhora();
            }
        });
        add(jbAhora);
        
        jbLimpiar = new JButton("Limpiar");
        jbLimpiar.setBounds(195, 248, 85, 25);// Ubicar y agregar al panel
        jbLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evento_jbLimpiar();
            }
        });
        add(jbLimpiar);
    }

    /**
     * Maneja el evento de aceptar la fecha seleccionada.
     */
    private void evento_jbAceptar() {        
        selecciono = true;
        Calendar calendario = jcFecha.getCalendar();
        dia = calendario.get(Calendar.DATE);
        mes = calendario.get(Calendar.MONTH) + 1;
        year = calendario.get(Calendar.YEAR);
        diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
        hora = Integer.parseInt((String) jcHora.getSelectedItem());
        minutos = Integer.parseInt((String) jcMinutos.getSelectedItem());
        horaCadena = (String) jcHora.getSelectedItem();
        minutosCadena = (String) jcMinutos.getSelectedItem();
        
        setNombreDia();
        setNombreMes();
        
        setVisible(false);
    }

    /**
     * Maneja el evento de establecer la fecha actual.
     */
    private void evento_jbAhora() {        
        jcFecha.setDate(new Date());// asignar la fecha actual del sistema al JCalendar
        
        // obtener la fecha actual del sistema
        Calendar actual = Calendar.getInstance();
        int hora = actual.get(Calendar.HOUR_OF_DAY); // obtener la hora del dia
        int min =   actual.get(Calendar.MINUTE); // obtener los minutos del dia
        
        // asignar la hora al combobox
        if(hora < 10) jcHora.setSelectedItem("0" + hora);
        else jcHora.setSelectedItem(hora + "");
        
        // asignar los minutos al combobox
        if(min < 10) jcMinutos.setSelectedItem("0" + min);
        else jcMinutos.setSelectedItem(min + "");        
    }
    
    /**
     * Maneja el evento de limpiar la selección.
     */
    private void evento_jbLimpiar() {
        set(); // asignar atributos con valores por defecto
        evento_jbAhora();
        setVisible(false);
    }
     /**
     * Establece el nombre del día de la semana.
     */
    public void setNombreDia(){
    	switch(diaSemana){
	    case 1: nombreDia = "Domingo";	break;
	    case 2: nombreDia = "Lunes"; 	break;
	    case 3: nombreDia = "Martes"; 	break;
	    case 4: nombreDia = "Miércoles"; 	break;
	    case 5: nombreDia = "Jueves"; 	break;
	    case 6: nombreDia = "Viernes"; 	break;
	    case 7: nombreDia = "Sábado"; 	break;
    	}	
    }
    /**
     * Establece el nombre del mes.
     */
    public void setNombreMes(){
    	switch(mes){
	    case 1:  nombreMes = "Enero"; 	break;
	    case 2:  nombreMes = "Febrero"; 	break;
	    case 3:  nombreMes = "Marzo"; 	break;
	    case 4:  nombreMes = "Abril"; 	break;
	    case 5:  nombreMes = "Mayo"; 	break;
	    case 6:  nombreMes = "Junio"; 	break;
	    case 7:  nombreMes = "Julio"; 	break;
	    case 8:  nombreMes = "Agosto"; 	break;
	    case 9:  nombreMes = "Septiembre"; 	break;
	    case 10: nombreMes = "Octubre"; 	break;
	    case 11: nombreMes = "Noviembre"; 	break;
	    case 12: nombreMes = "Diciembre"; 	break;
    	}	
    }	
            
    /**
     * Establece la fecha en diferentes formatos.
     *
     * @param tipo Tipo de formato de fecha.
     */
    public void setFecha(int tipo){
        fechaCompleta = "";
        switch (tipo) {
            case 1: // fecha en formato DD/MM/YYYY (2 digitos para el dia y el mes. 4 digitos para el anio)
                if(dia < 10) fechaCompleta+="0" + dia + "/";
                else fechaCompleta+= dia + "/";
                
                if(mes < 10) fechaCompleta+="0" + mes + "/";
                else fechaCompleta+= mes + "/";
                
                fechaCompleta+= year;
                break;
            case 2: // fecha en formato YYYY/MM/DD (4 digitos para el anio. 2 digitos para el mes y el dia)
                fechaCompleta+= year + "/";
                
                if(mes < 10) fechaCompleta+="0" + mes + "/";
                else fechaCompleta+= mes + "/";
                
                if(dia < 10) fechaCompleta+="0" + dia;
                else fechaCompleta+= dia;
                break; 
            case 3: // fecha en formato MM/DD/YYYY (2 digitos para el mes y el dia. 4 digitos para el anio)
                if(mes < 10) fechaCompleta+="0" + mes + "/";
                else fechaCompleta+= mes + "/";
                
                if(dia < 10) fechaCompleta+="0" + dia + "/";
                else fechaCompleta+= dia + "/";
                
                fechaCompleta+= year;
                break; 
            default:
                fechaCompleta = "FORMATO INVALIDO";
        }        
    }
    
     /**
     * Obtiene el día seleccionado.
     *
     * @return Día seleccionado.
     */
    public int getDia(){ return dia; }
     /**
     * Obtiene el mes seleccionado.
     *
     * @return Mes seleccionado.
     */
    public int getMes(){ return mes; }
    /**
     * Obtiene el año seleccionado.
     *
     * @return Año seleccionado.
     */
    public int getYear(){ return year; }
    /**
     * Obtiene la hora seleccionada.
     *
     * @return Hora seleccionada.
     */
    public int getHora(){ return hora; }
     /**
     * Obtiene los minutos seleccionados.
     *
     * @return Minutos seleccionados.
     */
    public int getMinutos(){ return minutos; }
    /**
     * Obtiene el día de la semana seleccionado.
     *
     * @return Día de la semana seleccionado.
     */
    public int getDiaSemana(){ return diaSemana; }
    /**
     * Obtiene el nombre del día de la semana seleccionado.
     *
     * @return Nombre del día de la semana seleccionado.
     */    
    public String getNombreDia(){ return nombreDia; }
    /**
     * Obtiene el nombre del mes seleccionado.
     *
     * @return Nombre del mes seleccionado.
     */
    public String getNombreMes(){ return nombreMes; }
    /**
     * Obtiene la cadena de la hora seleccionada.
     *
     * @return Cadena de la hora seleccionada.
     */
    public String getHoraCadena(){ return horaCadena; }
     /**
     * Obtiene la cadena de los minutos seleccionados.
     *
     * @return Cadena de los minutos seleccionados.
     */
    public String getMinutosCadena(){ return minutosCadena; } 
    /**
     * Obtiene la hora completa en formato HH:MM.
     *
     * @return Hora completa en formato HH:MM.
     */
    public String getHoraCompleta(){ return horaCadena + ":" + minutosCadena; }
    /**
     * Obtiene la fecha completa en el formato especificado.
     *
     * @param tipo Tipo de formato de fecha.
     * @return Fecha completa en el formato especificado.
     */
    public String getFechaCompleta(int tipo){
        if(selecciono) setFecha(tipo);
        else fechaCompleta = "";
        return fechaCompleta;
    }
}
