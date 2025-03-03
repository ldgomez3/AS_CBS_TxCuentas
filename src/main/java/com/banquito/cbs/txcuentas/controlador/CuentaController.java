package com.banquito.cbs.txcuentas.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.banquito.cbs.txcuentas.dto.TransaccionDto;
import com.banquito.cbs.txcuentas.servicio.CuentaService;
import com.banquito.cbs.txcuentas.excepcion.OperacionInvalidaException;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/txcuentas")
@Tag(name = "Transacciones", description = "API para gestionar transacciones bancarias")
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class CuentaController {
    private final CuentaService cuentaService;

    @GetMapping
    @Operation(summary = "Listar todas las transacciones")
    @ApiResponse(responseCode = "200", description = "Lista de transacciones obtenida exitosamente")
    public List<TransaccionDto> listarTodasLasTransacciones() {
        log.info("Obteniendo todas las transacciones");
        return cuentaService.buscarTodasLasTransacciones();
    }

    @GetMapping("/cuenta/{idCuenta}")
    @Operation(summary = "Obtener transacciones por cuenta", description = "Obtiene todas las transacciones asociadas a una cuenta específica")
    public List<TransaccionDto> obtenerTransacciones(
            @Parameter(description = "ID de la cuenta", required = true, example = "1001") @PathVariable(name = "idCuenta", required = true) Integer idCuenta) {
        return cuentaService.buscarTransaccionesPorCuenta(idCuenta);
    }

    @PostMapping("/cuenta/transaccion")
    @Operation(summary = "Crear nueva transacción", description = "Registra una nueva transacción para la cuenta especificada")
    public TransaccionDto procesarTransaccion(
            @Parameter(description = "Datos de la transacción", required = true) @RequestBody TransaccionDto transaccionDto)
            throws OperacionInvalidaException {
        return cuentaService.procesarTransaccion(transaccionDto);
    }

    @GetMapping("/transaccion/{id}")
    @Operation(summary = "Obtener transacción por ID", description = "Obtiene una transacción específica utilizando su ID")
    @ApiResponse(responseCode = "200", description = "Transacción obtenida exitosamente")
    @ApiResponse(responseCode = "404", description = "Transacción no encontrada")
    public TransaccionDto obtenerTransaccionPorId(
            @Parameter(description = "ID de la transacción", required = true, example = "1") @PathVariable Integer id) {
        return cuentaService.buscarTransaccionPorId(id);
    }
}
