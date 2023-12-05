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

public class EnviarCorreo {

    String correoDestinatario;
    public EnviarCorreo(String correoDestinatario){
        this.correoDestinatario = correoDestinatario;
        enviarParametros(correoDestinatario);
    }
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
     
     public void enviarParametros(String correoDestinatario){ // enviar correo a varios destinatarios con archivos adjuntos
         String parametros[] =  { "JOHN ALEJANDRO VALLARINO CRUZ",      // remitente
                                "john.vallarino@correounivalle.edu.co", // correoRemitente
                                "qgjy rwjf mxxy chee",               // contrasena de aplicaciones de Gmail
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
