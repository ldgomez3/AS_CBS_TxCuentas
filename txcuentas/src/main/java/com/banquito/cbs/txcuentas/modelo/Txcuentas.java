package com.banquito.cbs.txcuentas.modelo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Txcuentas {
    private Integer id;
    private Integer idCliente;
    private String tipo;
    private String numero;
    private BigDecimal saldoTotal;
    private BigDecimal saldoDisponible;
    private BigDecimal saldoAcreditar;
    private String estado;
    private OffsetDateTime fechaCreacion;
}
