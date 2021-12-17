package com.dpaula.emailfoi.service;

import com.dpaula.emailfoi.model.DadosEmailCompra;
import com.dpaula.emailfoi.payload.PedidoPayload;

public interface RegraEmail {

    DadosEmailCompra montar(PedidoPayload pedido);

    String getTitulo(PedidoPayload pedido);

    String getCorpo(PedidoPayload pedido);
}
