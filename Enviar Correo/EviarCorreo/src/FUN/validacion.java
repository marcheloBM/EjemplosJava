/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FUN;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

/**
 *
 * @author march
 */
public class validacion implements Runnable {

    String correo,contrasena,error,jlogin,mail, passs;
//    JTextField correo;
//    JPasswordField contrasena;
//    JLabel error;
//    Login jlogin;
//    String mail, passs;
    
    public validacion(String valor1, String valor2, String valor3, String valor4) {
        this.correo = valor1;
        this.contrasena = valor2;
        this.error = valor3;
        this.jlogin = valor4;
        mail = correo;
        passs = contrasena;

    }
    
    @Override
    public void run() {
        Properties props = new Properties();

        final String usuario = mail;
        final String pass = passs;

        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(usuario, pass);
                    }
                });
        session.setDebug(false);

        Transport transport = null;

        try {
            transport = session.getTransport("smtp");
        } catch (javax.mail.NoSuchProviderException ex) {
            Logger.getLogger(validacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            transport.connect();
//            error.setVisible(false);
//            jlogin.setVisible(false);
//            dashboard objeto = new dashboard(mail, passs);
//            objeto.setVisible(true);
        } catch (MessagingException ex) {
//            error.setVisible(true);
//            contrasena.setText("");
        }
    }
    
    public void start() {
        new Thread(this).start();
    }
}
