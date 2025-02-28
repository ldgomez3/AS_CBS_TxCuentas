package com.banquito.cbs.txcuentas.modelo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entidad que representa una transacción bancaria.
 */
@Entity
@Table(name = "TRANSACCIONES")
@Data
@Schema(description = "Entidad que representa una transacción bancaria")
public class Txcuentas {
    
    /**
     * Identificador único de la transacción
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único de la transacción", example = "1")
    private Integer id;

    /**
     * ID de la cuenta asociada a la transacción
     */
    @Column(name = "ID_CUENTA", nullable = false)
    @Schema(description = "Identificador de la cuenta asociada a la transacción", example = "1001")
    private Integer idCuenta;

    /**
     * Tipo de transacción (DEB: Débito, CRE: Crédito)
     */
    @Column(name = "TIPO", length = 3, nullable = false)
    @Schema(description = "Tipo de transacción (DEB: Débito, CRE: Crédito)", example = "DEB")
    private String tipo;

    @Column(name = "CODIGO_UNICO", length = 64)
    @Schema(description = "Código único de la transacción", example = "TRX-2023-001")
    private String codigoUnico;

    @Column(name = "CANAL", length = 3)
    @Schema(description = "Canal por donde se realizó la transacción (WEB, ATM, MOV)", example = "WEB")
    private String canal;

    @Column(name = "FECHA_HORA")
    @Schema(description = "Fecha y hora de la transacción", example = "2023-12-25T10:30:00Z")
    private OffsetDateTime fechaHora;

    @Column(name = "MONTO", precision = 20, scale = 2)
    @Schema(description = "Monto de la transacción", example = "100.50")
    private BigDecimal monto;

    @Column(name = "REFERENCIA", length = 50)
    @Schema(description = "Referencia o descripción de la transacción", example = "Pago de servicios")
    private String referencia;

    @Column(name = "APLICA_IMPUESTO")
    @Schema(description = "Indica si la transacción aplica impuestos", example = "true")
    private Boolean aplicaImpuesto;

    @Column(name = "ESTADO", length = 3)
    @Schema(description = "Estado de la transacción (ACT: Activo, INA: Inactivo, ANU: Anulado)", example = "ACT")
    private String estado;

    @Column(name = "FECHA_AUTORIZACION")
    @Schema(description = "Fecha y hora de autorización de la transacción", example = "2023-12-25T10:30:01Z")
    private OffsetDateTime fechaAutorizacion;

    @Column(name = "CODIGO_TRANSACCION_PADRE", length = 64)
    @Schema(description = "Código de la transacción padre en caso de reversas", example = "TRX-2023-000")
    private String codigoTransaccionPadre;
}