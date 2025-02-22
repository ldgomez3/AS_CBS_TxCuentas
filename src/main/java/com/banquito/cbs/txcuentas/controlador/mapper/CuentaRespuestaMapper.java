package com.banquito.cbs.txcuentas.controlador.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.banquito.cbs.txcuentas.dto.CuentaRespuestaDto;

import org.mapstruct.MappingConstants;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CuentaRespuestaMapper {
    CuentaRespuestaDto toDto(CuentaRespuestaDto cuentaRespuestaDto);
}
