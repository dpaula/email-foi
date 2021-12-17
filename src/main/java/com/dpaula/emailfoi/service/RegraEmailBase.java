package com.dpaula.emailfoi.service;

import com.dpaula.emailfoi.error.WSEmailException;
import com.dpaula.emailfoi.model.DadosEmailCompra;
import com.dpaula.emailfoi.model.EmailInput;
import com.dpaula.emailfoi.payload.PedidoPayload;
import org.apache.commons.io.Charsets;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public abstract class RegraEmailBase implements RegraEmail {

    public static final String EMPRESA = "|cliente|";

    public static String buscarHtmlTemplateString(final Resource resource) {

        try (final Reader reader = new InputStreamReader(resource.getInputStream(), Charsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (final IOException e) {
            throw new WSEmailException(
                "Não foi possível buscar template de email: " + resource);
        }
    }

    public static DadosEmailCompra montarDadosEmail(@NotNull final EmailInput email,
        @NotNull final PedidoPayload pedido) {

        return DadosEmailCompra.builder()
            .email(email)
            .pedido(pedido)
            .build();
    }
}
