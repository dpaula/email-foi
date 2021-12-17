package com.dpaula.emailfoi.service;

import com.dpaula.emailfoi.enuns.EnTipoEvento;
import com.dpaula.emailfoi.model.DadosEmailCompra;
import com.dpaula.emailfoi.model.EmailInput;
import com.dpaula.emailfoi.payload.PedidoPayload;
import org.springframework.core.io.ResourceLoader;

import java.util.List;

public class RegraEmailCompraConfirmada extends RegraEmailBase {

    private static final String TITULO = "COMPRA & VENDAS - Pedido Confirmado";
    private static final String TEMPLATES_EMAIL_PEDIDO_CONFIRMADO_HTML = "classpath:templates-email/compra_confirmada.html";
    private final ResourceLoader resourceLoader;

    public RegraEmailCompraConfirmada(final ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public DadosEmailCompra montar(final PedidoPayload pedido) {

        final var email = EmailInput.builder()
            .destinatarios(List.of(pedido.getEmail()))
            .tipo(EnTipoEvento.COMPRA_CONFIRMADA)
            .corpo(getCorpo(pedido))
            .titulo(getTitulo(pedido))
            .copias(List.of(EmailService.COM_COPIA))
            .build();

        return montarDadosEmail(email, pedido);
    }

    @Override public String getTitulo(final PedidoPayload pedido) {
        return TITULO;
    }

    @Override
    public String getCorpo(final PedidoPayload pedido) {

        var corpoString = buscarHtmlTemplateString(resourceLoader.getResource(TEMPLATES_EMAIL_PEDIDO_CONFIRMADO_HTML));
        corpoString = corpoString.replace(EMPRESA, pedido.getNomeCliente());

        return corpoString;
    }
}