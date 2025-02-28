package com.banquito.cbs.txcuentas.repositorio;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banquito.cbs.txcuentas.modelo.Txcuentas;

import jakarta.transaction.Transactional;

/**
 * Repositorio para operaciones de base de datos con transacciones.
 */
@Repository
public interface TxCuentaRepository extends JpaRepository<Txcuentas, Integer> {
    
    /**
     * Busca todas las transacciones asociadas a una cuenta.
     *
     * @param idCuenta ID de la cuenta
     * @return Lista de transacciones
     */
    List<Txcuentas> findByIdCuenta(Integer idCuenta);
    List<Txcuentas> findByFechaHoraBetween(OffsetDateTime fechaInicio, OffsetDateTime fechaFin);

    // Método adicional (opcional) que llama a save() internamente:
    default Txcuentas guardarTxCuenta(Txcuentas tx) {
        return this.save(tx);
    }


    @Modifying
    @Transactional
    @Query(value = """
        INSERT INTO TRANSACCIONES (
            ID,
            ID_CUENTA,
            TIPO,
            CODIGO_UNICO,
            CANAL,
            FECHA_HORA,
            MONTO,
            REFERENCIA,
            APLICA_IMPUESTO,
            ESTADO,
            FECHA_AUTORIZACION,
            CODIGO_TRANSACCION_PADRE
        )
        VALUES (
            :id,
            :idCuenta,
            :tipo,
            :codigoUnico,
            :canal,
            :fechaHora,
            :monto,
            :referencia,
            :aplicaImpuesto,
            :estado,
            :fechaAutorizacion,
            :codigoTransaccionPadre
        )
        """, nativeQuery = true)
    void insertarTransaccion(
        @Param("id") Integer id,
        @Param("idCuenta") Integer idCuenta,
        @Param("tipo") String tipo,
        @Param("codigoUnico") String codigoUnico,
        @Param("canal") String canal,
        @Param("fechaHora") OffsetDateTime fechaHora,
        @Param("monto") BigDecimal monto,
        @Param("referencia") String referencia,
        @Param("aplicaImpuesto") Boolean aplicaImpuesto,
        @Param("estado") String estado,
        @Param("fechaAutorizacion") OffsetDateTime fechaAutorizacion,
        @Param("codigoTransaccionPadre") String codigoTransaccionPadre
    );
    
    // Ejemplo usando JPQL
    @Query("SELECT COALESCE(MAX(t.id), 0) + 1 FROM Txcuentas t")
    Integer getSiguienteId();
}
