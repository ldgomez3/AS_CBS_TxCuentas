package com.banquito.cbs.txcuentas.servicio;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.cbs.txcuentas.dto.TransaccionDto;
import com.banquito.cbs.txcuentas.excepcion.EntidadNoEncontradaException;
import com.banquito.cbs.txcuentas.excepcion.OperacionInvalidaException;
import com.banquito.cbs.txcuentas.modelo.Txcuentas;
import com.banquito.cbs.txcuentas.repositorio.TxCuentaRepository;
import com.banquito.cbs.txcuentas.controlador.mapper.TxCuentaMapper;

@Service
public class CuentaService {
    private final TxCuentaRepository txCuentaRepository;
    private final TxCuentaMapper txCuentaMapper;

    public CuentaService(TxCuentaRepository txCuentaRepository, TxCuentaMapper txCuentaMapper) {
        this.txCuentaRepository = txCuentaRepository;
        this.txCuentaMapper = txCuentaMapper;
    }

    @Transactional(readOnly = true)
    public List<TransaccionDto> buscarTransaccionesPorCuenta(Integer idCuenta) {
        return txCuentaRepository.findByIdCuenta(idCuenta)
                .stream()
                .map(txCuentaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public TransaccionDto crearTransaccion(TransaccionDto transaccionDto) throws OperacionInvalidaException {
        if (transaccionDto.getMonto() == null || transaccionDto.getMonto().signum() <= 0) {
            throw new OperacionInvalidaException("El monto debe ser mayor que cero");
        }

        Txcuentas transaccion = txCuentaMapper.toEntity(transaccionDto);
        transaccion.setFechaHora(OffsetDateTime.now());
        transaccion.setEstado("ACT");

        // consutar el id integer para el siguiente registro
        transaccion.setId(txCuentaRepository.getSiguienteId());
        
        //var txNueva =  txCuentaRepository.guardarTxCuenta(transaccion);

        txCuentaRepository.insertarTransaccion(
            transaccion.getId(),
            transaccion.getIdCuenta(),
            transaccion.getTipo(),
            transaccion.getCodigoUnico(),
            transaccion.getCanal(),
            transaccion.getFechaHora(),
            transaccion.getMonto(),
            transaccion.getReferencia(),
            transaccion.getAplicaImpuesto(),
            transaccion.getEstado(),
            transaccion.getFechaAutorizacion(),
            transaccion.getCodigoTransaccionPadre()
        );


        txCuentaRepository.flush();
        return txCuentaMapper.toDto(transaccion);
    }

    @Transactional
    public TransaccionDto actualizarEstadoTransaccion(Integer id, String nuevoEstado) throws OperacionInvalidaException {
        Txcuentas transaccion = txCuentaRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Transacción no encontrada con ID: " + id));

        if (!List.of("ACT", "INA", "ANU").contains(nuevoEstado)) {
            throw new OperacionInvalidaException("Estado no válido. Estados permitidos: ACT, INA, ANU");
        }

        transaccion.setEstado(nuevoEstado);
        transaccion.setFechaAutorizacion(OffsetDateTime.now());

        return txCuentaMapper.toDto(txCuentaRepository.save(transaccion));
    }

    @Transactional(readOnly = true)
    public TransaccionDto buscarTransaccionPorId(Integer id) {
        return txCuentaRepository.findById(id)
                .map(txCuentaMapper::toDto)
                .orElseThrow(() -> new EntidadNoEncontradaException("Transacción no encontrada con ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<TransaccionDto> buscarTransaccionesPorFecha(OffsetDateTime fechaInicio, OffsetDateTime fechaFin) {
        return txCuentaRepository.findByFechaHoraBetween(fechaInicio, fechaFin)
                .stream()
                .map(txCuentaMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Procesa una nueva transacción bancaria.
     *
     * @param idCuenta ID de la cuenta asociada
     * @param transaccionDto Datos de la transacción
     * @return TransaccionDto con los datos de la transacción procesada
     * @throws OperacionInvalidaException si el monto es inválido
     */
    @Transactional
    public TransaccionDto procesarTransaccion(TransaccionDto transaccionDto) 
            throws OperacionInvalidaException {
        if (transaccionDto.getMonto() == null || transaccionDto.getMonto().signum() <= 0) {
            throw new OperacionInvalidaException("El monto debe ser mayor que cero");
        }
        return crearTransaccion(transaccionDto);
    }

    @Transactional(readOnly = true)
    public List<TransaccionDto> buscarTodasLasTransacciones() {
        return txCuentaRepository.findAll()
                .stream()
                .map(txCuentaMapper::toDto)
                .collect(Collectors.toList());
    }
}
