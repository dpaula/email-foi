package com.dpaula.emailfoi.endpoint.impl;

import com.dpaula.emailfoi.dto.EmailDTO;
import com.dpaula.emailfoi.endpoint.IEmailController;
import com.dpaula.emailfoi.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailController implements IEmailController {

    private final EmailService service;


    @Override
    public ResponseEntity<EmailDTO> post(final EmailDTO emailInput) {
        final var email = service.enviar(emailInput);

        return ResponseEntity.ok(email);
    }
}
