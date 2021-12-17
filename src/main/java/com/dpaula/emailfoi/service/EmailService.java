package com.dpaula.emailfoi.service;

import com.dpaula.emailfoi.dto.EmailDTO;
import com.dpaula.emailfoi.error.WSEmailException;
import com.dpaula.emailfoi.model.DadosEmailCompra;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailService {

    private final JavaMailSender emailSender;

    public static final String COM_COPIA = "fernando.dpaula@gmail.com";
    private static final String REMETENTE = "no-reply@compraevendas.com";

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

    public void enviarCompra(final DadosEmailCompra dadosEmailCompra) {

        try {
            final MimeMessage message = emailSender.createMimeMessage();
            final MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(REMETENTE);
            helper.setTo(dadosEmailCompra.getEmail().getDestinatarios()
                    .toArray(String[]::new));
            helper.setSubject(dadosEmailCompra.getEmail().getTitulo());
            helper.setText(dadosEmailCompra.getEmail().getCorpo(), true);

            log.info("Enviando e-mail {}", dadosEmailCompra);
            emailSender.send(message);

        } catch (final MessagingException e) {
            log.error("{} Erro ao enviar e-mail {}", dadosEmailCompra, e);
            throw new WSEmailException("Problemas ao enviar e-mail");
        }

    }
}
