package com.banquito.cbs.txcuentas.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.cbs.txcuentas.dto.TransaccionDto;
import com.banquito.cbs.txcuentas.servicio.CuentaService;
import com.banquito.cbs.txcuentas.excepcion.OperacionInvalidaException;

import java.util.List;

@RestController
@RequestMapping("/v1/txcuentas")
public class CuentaController {
    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping
    public List<TransaccionDto> listarTodasLasTransacciones() {
        return cuentaService.buscarTodasLasTransacciones();
    }

    @GetMapping("/cuenta/{idCuenta}")
    public List<TransaccionDto> obtenerTransacciones(@PathVariable Integer idCuenta) {
        return cuentaService.buscarTransaccionesPorCuenta(idCuenta);
    }

    @PostMapping("/cuenta/{idCuenta}/transaccion")
    public TransaccionDto procesarTransaccion(
            @PathVariable Integer idCuenta,
            @RequestBody TransaccionDto transaccionDto) throws OperacionInvalidaException {
        return cuentaService.procesarTransaccion(idCuenta, transaccionDto);
    }
}
