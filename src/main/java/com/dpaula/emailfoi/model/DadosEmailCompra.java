package com.dpaula.emailfoi.model;

import com.dpaula.emailfoi.payload.PedidoPayload;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author Fernando de Lima
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class DadosEmailCompra {

    @NotNull
    private EmailInput email;
    @NotNull
    private PedidoPayload pedido;
}
