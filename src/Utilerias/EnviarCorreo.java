/**
 * Clase EnviarCorreo que proporciona funcionalidades para enviar correos electrónicos con archivos adjuntos.
 * 
 * @version 1.4
 * @since 11/12/2023
 * @author  Jhon Alex Rodríguez Benítez - 2264363
 * @author  Miguel Angel Escobar Marín - 2264305
 * @author  John Alejandro Vallarino Cruz - 2264332
 */

package Utilerias;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Clase EnviarCorreo que proporciona funcionalidades para enviar correos electrónicos con archivos adjuntos.
 */

public class EnviarCorreo {

    String correoDestinatario;
    
    /**
     * Constructor para crear un objeto EnviarCorreo.
     * 
     * @param correoDestinatario Correo electrónico del destinatario.
     */
    
    public EnviarCorreo(String correoDestinatario){
        this.correoDestinatario = correoDestinatario;
        enviarParametros(correoDestinatario);
    }
    
    /**
     * Método para enviar correos electrónicos con archivos adjuntos.
     *
     * @param parametros          Arreglo con información del remitente y configuración del mensaje.
     * @param correosDestinatarios Arreglo con direcciones de correo electrónico de los destinatarios.
     * @param archivos            Arreglo con rutas de archivos adjuntos.
     */
    
     public void enviar(String parametros[], String correosDestinatarios[], String archivos[]){
        try{
            // --------------------------------------------------------------------------------
            //1) Configurar propiedades de la conexion             
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", parametros[1]); // correoRemitente
            props.setProperty("mail.smtp.auth", "true");

            // Preparar la sesion
            Session session = Session.getDefaultInstance(props);

            // Construir el mensaje
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress( parametros[1],      // correoRemitente
                                            parametros[0]));    // remitente
            
            InternetAddress toList[] = new InternetAddress[correosDestinatarios.length];
            for (int i = 0; i < correosDestinatarios.length; i++) { // recorrer el arreglo correosDestinatarios
                toList[i] = new InternetAddress(correosDestinatarios[i]);
            }
            mm.addRecipients(Message.RecipientType.TO, toList); // adicionar la lista de correosDestinatarios
            
            mm.setSubject(parametros[3]); // asunto
            
            // --------------------------------------------------------------------------------
            // 2) Crear el contenido del mensaje a enviar
            MimeBodyPart mime_mensage = new MimeBodyPart();
            mime_mensage.setContent(parametros[4],  // texto del mensage
                                    "text/html");   // tipo de codificacion del mensage
            
            //Crear un objeto de la Clase Multipart y adicionar las partes es este
            Multipart mp = new MimeMultipart();            
            mp.addBodyPart(mime_mensage); // adicionar el texto  
                        
            for (String nf : archivos) {
                MimeBodyPart attach = new MimeBodyPart();
                attach.attachFile(nf);
                mp.addBodyPart(attach); // adicionar el archivo 
            }
            
            mm.setContent(mp);// adicionar la informacion del objeto Multipart al mensaje
                        
            // --------------------------------------------------------------------------------
            // 3) Enviar el mensaje
            Transport t = session.getTransport("smtp");
            t.connect(  parametros[1],      // correoRemitente
                        parametros[2]);     // contrasena de aplicaciones de Gmail
            t.sendMessage(mm, mm.getAllRecipients());
            t.close();
            
        }catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }     
    }
     /**
     * Método para enviar correos electrónicos con parámetros predefinidos.
     */
     public void enviarParametros(String correoDestinatario){ // enviar correo a varios destinatarios con archivos adjuntos
         String parametros[] =  { "Systems Gym Brokos",      // remitente
                                "systemsgymbrokos@gmail.com", // correoRemitente
                                "yohc skyb vvgc incb",               // contrasena de aplicaciones de Gmail
                                "Comprobante de inscripción a brokogym_systems",      // asunto
                                "Hola."
                 + "<br>Este correo contiene su comprobante de pago <b><u>Java</u></b><br><br>"
                 + "Chao. Gracias" // mensaje
                                }; 
         
         String correosDestinatarios[] = {correoDestinatario};
         
         String archivos[] = {  "recibo_de_membresia.pdf"};
         
         enviar(parametros, correosDestinatarios, archivos);
     }
     
}
