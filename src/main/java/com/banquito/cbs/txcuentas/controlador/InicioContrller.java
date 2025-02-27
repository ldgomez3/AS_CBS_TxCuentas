package com.banquito.cbs.txcuentas.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class InicioContrller {
    @GetMapping
    public ResponseEntity<String> inicio() {
        return ResponseEntity.ok("Micorservicio de TXCuentas");
    }
}
