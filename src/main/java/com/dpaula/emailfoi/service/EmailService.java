package com.dpaula.emailfoi.service;

import com.dpaula.emailfoi.dto.EmailDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailService {

    private final JavaMailSender emailSender;

    public EmailDTO enviar(final EmailDTO emailInput) {

        log.info("Enviando e-mail para {}", emailInput.getDestinatario());
        final var simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(emailInput.getRemetente());
        simpleMailMessage.setTo(emailInput.getDestinatario());
        simpleMailMessage.setSubject(emailInput.getTitulo());
        simpleMailMessage.setText(emailInput.getCorpo());
        emailSender.send(simpleMailMessage);
        log.info("Email enviado com sucesso!!");

        return emailInput;
    }
}
