package com.banquito.cbs.txcuentas.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.cbs.txcuentas.repositorio.TxCuentaRepository;

@RestController
@RequestMapping("/v1/txcuentas")
public class CuentaController {
    private final TxCuentaRepository txCuentaRepository;

    public CuentaController(TxCuentaRepository txCuentaRepository) {
        this.txCuentaRepository = txCuentaRepository;
    }

}
