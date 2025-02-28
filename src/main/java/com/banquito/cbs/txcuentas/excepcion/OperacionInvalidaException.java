package com.banquito.cbs.txcuentas.excepcion;

/**
 * Excepción lanzada cuando una operación de transacción es inválida.
 */
public class OperacionInvalidaException extends RuntimeException {
    public OperacionInvalidaException(String message) {
        super(message);
    }
}
