package com.banquito.cbs.txcuentas.repositorio;

import com.banquito.cbs.txcuentas.modelo.Txcuentas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxCuentaRepository extends JpaRepository<Txcuentas, Integer> {
    
}
