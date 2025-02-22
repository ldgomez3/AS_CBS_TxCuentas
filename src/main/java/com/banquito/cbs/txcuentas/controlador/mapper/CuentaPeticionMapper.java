package com.banquito.cbs.txcuentas.controlador.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.banquito.cbs.txcuentas.dto.CuentaDto;
import com.banquito.cbs.txcuentas.modelo.Txcuentas;

import org.mapstruct.MappingConstants;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CuentaPeticionMapper {
    CuentaDto toDto(CuentaDto cuentaDto);

    Txcuentas toEntity(CuentaDto cuentaDto);
}
