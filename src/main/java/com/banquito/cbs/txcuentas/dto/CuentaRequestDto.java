package com.banquito.cbs.txcuentas.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class CuentaRequestDto {
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