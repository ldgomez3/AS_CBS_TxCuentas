package com.banquito.cbs.txcuentas.servicio;

import org.springframework.stereotype.Service;

import com.banquito.cbs.txcuentas.repositorio.TxCuentaRepository;

@Service
public class CuentaService {
    private final TxCuentaRepository txCuentaRepository;
    private final TxCuentaMapper txCuentaMapper;

    public CuentaService(TxCuentaRepository txCuentaRepository, TxCuentaMapper txCuentaMapper) {
        this.txCuentaRepository = txCuentaRepository;
        this.txCuentaMapper = txCuentaMapper;
    }

}
