package com.mycompany.qualquer;

/**
 *
 * @author carlos
 */
public class CPF {

    private final String numero;

    public CPF(String numero) {
        this.numero = numero;
    }

    public String valor() {
        return this.numero;
    }

    public String formatado() {
        return String.format(
            "%s.%s.%s-%s",
            this.numero.substring(0,3), // 111222
            this.numero.substring(3,6),
            this.numero.substring(6,9),
            this.numero.substring(9,11)
        );
    }

    public boolean naoValido() {
        return (11 != this.numero.length());
    }

    public CPF() {
        this.numero = "";
    }
}
