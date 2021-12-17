package com.dpaula.emailfoi.payload;

import com.dpaula.emailfoi.enuns.EnTipoPagamento;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PedidoPayload implements Serializable {

    private static final long serialVersionUID = -6334533951966412063L;
    private String id;
    private String nomeCliente;
    private String email;
    private LocalDateTime dataPagamento;
    private EnTipoPagamento tipo;

    private ItemPayload item;
}
