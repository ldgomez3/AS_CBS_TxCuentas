package com.banquito.cbs.txcuentas.repositorio;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.cbs.txcuentas.modelo.Txcuentas;

@Repository
public interface TxCuentaRepository extends JpaRepository<Txcuentas, Integer> {
    List<Txcuentas> findByIdCuenta(Integer idCuenta);
    List<Txcuentas> findByFechaHoraBetween(OffsetDateTime fechaInicio, OffsetDateTime fechaFin);
}
