package com.banquito.cbs.txcuentas.servicio;

import org.springframework.stereotype.Component;
import com.banquito.cbs.txcuentas.modelo.Txcuentas;
import com.banquito.cbs.txcuentas.dto.TransaccionDto;

@Component
public class TxCuentaMapper {
    
    public TransaccionDto toDto(Txcuentas transaccion) {
        TransaccionDto dto = new TransaccionDto();
        dto.setId(transaccion.getId());
        dto.setIdCuenta(transaccion.getIdCuenta());
        dto.setTipo(transaccion.getTipo());
        dto.setCodigoUnico(transaccion.getCodigoUnico());
        dto.setCanal(transaccion.getCanal());
        dto.setFechaHora(transaccion.getFechaHora());
        dto.setMonto(transaccion.getMonto());
        dto.setReferencia(transaccion.getReferencia());
        dto.setAplicaImpuesto(transaccion.getAplicaImpuesto());
        dto.setEstado(transaccion.getEstado());
        dto.setFechaAutorizacion(transaccion.getFechaAutorizacion());
        dto.setCodigoTransaccionPadre(transaccion.getCodigoTransaccionPadre());
        return dto;
    }

    public Txcuentas toEntity(TransaccionDto dto) {
        Txcuentas transaccion = new Txcuentas();
        transaccion.setId(dto.getId());
        transaccion.setIdCuenta(dto.getIdCuenta());
        transaccion.setTipo(dto.getTipo());
        transaccion.setCodigoUnico(dto.getCodigoUnico());
        transaccion.setCanal(dto.getCanal());
        transaccion.setFechaHora(dto.getFechaHora());
        transaccion.setMonto(dto.getMonto());
        transaccion.setReferencia(dto.getReferencia());
        transaccion.setAplicaImpuesto(dto.getAplicaImpuesto());
        transaccion.setEstado(dto.getEstado());
        transaccion.setFechaAutorizacion(dto.getFechaAutorizacion());
        transaccion.setCodigoTransaccionPadre(dto.getCodigoTransaccionPadre());
        return transaccion;
    }
}
