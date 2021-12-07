package com.dpaula.emailfoi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_WRITE;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class EmailDTO implements Serializable {

    private static final long serialVersionUID = -7485049415634089995L;
    @Schema(accessMode = READ_WRITE, example = "fernando.dpaula@gmail.com", description = "E-mail do remetente")
    @NotEmpty
    @Size(max = 200)
    @Email(message = "Deve ser endereço de email válido!")
    private String remetente;

    @Schema(accessMode = READ_WRITE, example = "fernando.lima@mouts.info", description = "E-mail do destinatário")
    @NotEmpty
    @Size(max = 200)
    @Email(message = "Deve ser endereço de email válido!")
    private String destinatario;

    @Schema(accessMode = READ_WRITE, example = "Pagamento Enviado", description = "Título do E-mail")
    @NotEmpty
    @Size(max = 100)
    private String titulo;

    @Schema(accessMode = READ_WRITE, description = "Corpo do E-mail")
    @NotEmpty
    @Size(max = 1000)
    private String corpo;
}
