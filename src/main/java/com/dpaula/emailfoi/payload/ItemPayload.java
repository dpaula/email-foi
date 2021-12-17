package com.dpaula.emailfoi.payload;

import com.dpaula.emailfoi.enuns.EnTipoDepartamento;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemPayload implements Serializable {

    private static final long serialVersionUID = -595235278936745093L;
    private String id;
    private String descricao;
    private BigDecimal valor;
    private EnTipoDepartamento departamento;
}
