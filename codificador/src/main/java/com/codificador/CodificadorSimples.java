package com.codificador;

import java.time.LocalDate;

public class CodificadorSimples implements Codificador {
    @Override
    public String getNome() {
        return "Codificador Simples";
    }

    @Override
    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 03, 13);
    }

    @Override
    public int getNivelSeguranca(){
        return 1;
    }

    @Override
    public String codifica(String str) {
        StringBuilder encoded = new StringBuilder();

        for (char c : str.toCharArray()) {
            encoded.append((char) (c + 1));
        }

        return encoded.toString();
    }

    @Override
    public String decodifica(String str) {
        StringBuilder encoded = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            encoded.append((char) (c - 1));
        }
        
        return encoded.toString();
    }
}