package com.dpaula.emailfoi.enuns;

import lombok.Getter;

@Getter
public enum EnTipoEvento {

    COMPRA_EFETUADA(1, "COMPRA EFETUADA"),
    COMPRA_CONFIRMADA(2, "COMPRA CONFIRMADA");

    private final Integer id;
    private final String descricao;
    //    private final EnStatusFaturamento statusFaturamento;

    EnTipoEvento(final Integer id, final String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    //    public static EnTipoEvento getFromStatusFaturamento(final EnStatusFaturamento status) {
    //
    //        switch (status) {
    //            case COMPRA_EFETUADA:
    //                return COMPRA_EFETUADA;
    //            case COMPRA_EFETUADA:
    //                return COMPRA_EFETUADA;
    //            default:
    //                throw new WSEmailException("Status de Faturamento inválido para Tipo de Evento!");
    //        }
    //    }
}
