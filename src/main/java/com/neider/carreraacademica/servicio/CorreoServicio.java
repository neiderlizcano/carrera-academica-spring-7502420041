package com.neider.carreraacademica.servicio;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CorreoServicio {

    private final JavaMailSender javaMailSender;

    public CorreoServicio(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviarCorreoRecuperacion(String destinatario, String nuevaClave) {
        SimpleMailMessage mensaje = new SimpleMailMessage();

        mensaje.setFrom("sistema-academico@local.test");
        mensaje.setTo(destinatario);
        mensaje.setSubject("Recuperación de contraseña - Sistema Académico MVC");

        mensaje.setText(
                "Hola,\n\n" +
                        "Se ha generado una nueva contraseña temporal para ingresar al sistema.\n\n" +
                        "Nueva contraseña temporal: " + nuevaClave + "\n\n" +
                        "Ingresa al sistema usando esta contraseña.\n\n" +
                        "Sistema Académico MVC"
        );

        javaMailSender.send(mensaje);
    }
}