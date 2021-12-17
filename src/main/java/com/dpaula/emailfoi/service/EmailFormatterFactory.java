package com.dpaula.emailfoi.service;

import com.dpaula.emailfoi.enuns.EnTipoEvento;
import com.dpaula.emailfoi.error.WSEmailException;
import com.dpaula.emailfoi.model.DadosEmailCompra;
import com.dpaula.emailfoi.payload.PedidoPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailFormatterFactory {

    private final ResourceLoader resource;

    public DadosEmailCompra create(final PedidoPayload pedido, final EnTipoEvento evento) {

        switch (evento) {
            case COMPRA_EFETUADA:
                final RegraEmailCompraEfetuada regraEmailCompraEfetuada = new RegraEmailCompraEfetuada(resource
                );
                return regraEmailCompraEfetuada.montar(pedido);
            case COMPRA_CONFIRMADA:
                final RegraEmailCompraConfirmada regraEmailCompraConfirmada = new RegraEmailCompraConfirmada(resource);
                return regraEmailCompraConfirmada.montar(pedido);
            default:
                throw new WSEmailException("Evento de e-mail inválido!");
        }
    }
}
