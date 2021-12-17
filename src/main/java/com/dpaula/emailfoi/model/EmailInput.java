package com.dpaula.emailfoi.model;

import com.dpaula.emailfoi.enuns.EnTipoEvento;
import lombok.*;

import java.util.List;

/**
 * @author Fernando de Lima
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class EmailInput {

    private List<String> destinatarios;
    private EnTipoEvento tipo;
    private String titulo;
    private String corpo;
    private List<String> copias;
}
