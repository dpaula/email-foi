package com.dpaula.emailfoi.message;

import com.dpaula.emailfoi.enuns.EnTipoEvento;
import com.dpaula.emailfoi.model.DadosEmailCompra;
import com.dpaula.emailfoi.payload.PedidoPayload;
import com.dpaula.emailfoi.service.EmailFormatterFactory;
import com.dpaula.emailfoi.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author Fernando de Lima on 09/12/21
 */
@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageConsumer {

    private final EmailService service;
    private final EmailFormatterFactory emailFactory;

    @Bean
    public Consumer<PedidoPayload> consume() {
        return message -> {
            log.info("New message received: '{}'", message);

            final DadosEmailCompra dadosEmailCompra = emailFactory.create(message,
                    EnTipoEvento.COMPRA_EFETUADA);

            service.enviarCompra(dadosEmailCompra);
        };
    }
}
