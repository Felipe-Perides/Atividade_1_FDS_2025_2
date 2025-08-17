package com.codificador;

public class Factory {
    public static Codificador createCodificador(int nivel){
        switch (nivel) {
            case 1 -> {
                return new CodificadorSimples();
            }
            case 2 -> {
                return new CodificadorASCII();
            }
            case 3 -> {
                return new CodificadorMorse();
            }
            default -> throw new AssertionError();
        }
    }
}
