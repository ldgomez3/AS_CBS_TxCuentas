package com.banquito.cbs.txcuentas.modelo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "TRANSACCIONES")
@Data
@ToString
public class Txcuentas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ID_CUENTA", nullable = false)
    private Integer idCuenta;

    @Column(name = "TIPO", length = 3, nullable = false)
    private String tipo;

    @Column(name = "CODIGO_UNICO", length = 64)
    private String codigoUnico;

    @Column(name = "CANAL", length = 3)
    private String canal;

    @Column(name = "FECHA_HORA")
    private OffsetDateTime fechaHora;

    @Column(name = "MONTO", precision = 20, scale = 2)
    private BigDecimal monto;

    @Column(name = "REFERENCIA", length = 50)
    private String referencia;

    @Column(name = "APLICA_IMPUESTO")
    private Boolean aplicaImpuesto;

    @Column(name = "ESTADO", length = 3)
    private String estado;

    @Column(name = "FECHA_AUTORIZACION")
    private OffsetDateTime fechaAutorizacion;

    @Column(name = "CODIGO_TRANSACCION_PADRE", length = 64)
    private String codigoTransaccionPadre;
}
