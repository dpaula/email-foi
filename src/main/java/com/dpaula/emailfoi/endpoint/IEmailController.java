package com.dpaula.emailfoi.endpoint;

import com.dpaula.emailfoi.dto.EmailDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/emails")
@CrossOrigin(origins = "*")
@Tag(name = "Emails", description = "Serviços para gerenciar emails")
public interface IEmailController {

    @Operation(summary = "Enviar Emails", description = "Post para um e-mail")
    @PostMapping
    ResponseEntity<EmailDTO> postEmailSimples(@NotNull @Valid @RequestBody final EmailDTO emailInput);

    @Operation(summary = "Enviar Emails Anexo", description = "Post para um e-mail com anexo")
    @PostMapping
    ResponseEntity<EmailDTO> postEmailComAnexo(@NotNull @Valid @RequestBody final EmailDTO emailInput);
}
