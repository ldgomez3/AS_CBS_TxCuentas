package com.banquito.cbs.txcuentas.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class TransaccionDto {
    private Integer id;
    private Integer idCuenta;
    private String tipo;
    private String codigoUnico;
    private String canal;
    private OffsetDateTime fechaHora;
    private BigDecimal monto;
    private String referencia;
    private Boolean aplicaImpuesto;
    private String estado;
    private OffsetDateTime fechaAutorizacion;
    private String codigoTransaccionPadre;
} 