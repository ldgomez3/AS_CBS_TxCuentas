package com.banquito.cbs.txcuentas.modelo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Txcuentas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;

    @Column(name = "tipo", length = 3, nullable = false)
    private String tipo;

    @Column(name = "numero", length = 20, nullable = false)
    private String numero;

    @Column(name = "saldo_total", precision = 20, scale = 2)
    private BigDecimal saldoTotal;

    @Column(name = "saldo_disponible", precision = 20, scale = 2)
    private BigDecimal saldoDisponible;

    @Column(name = "saldo_acreditar", precision = 20, scale = 2)
    private BigDecimal saldoAcreditar;

    @Column(name = "estado", length = 3)
    private String estado;

    @Column(name = "fecha_creacion", nullable = false)
    private OffsetDateTime fechaCreacion;
}
