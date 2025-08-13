package com.codificador;

import java.time.LocalDate;

public class CodificadorASCII implements Codificador{
    @Override
    public String getNome(){
        return "Codificador ASCII";
    }
    @Override
    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 03, 13);
    }
    @Override
    public int getNivelSeguranca(){
        return 2;
    }
    @Override
    public String codifica(String str) {
        StringBuilder encoded = new StringBuilder();

        for (char c : str.toCharArray()) {
           int codigo = (int) c;
           encoded.append((int) (codigo));
           encoded.append((char) (' '));
        }

        return encoded.toString();
    }

    @Override
    public String decodifica(String str) {
        StringBuilder encoded = new StringBuilder();
        StringBuilder codigo = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (c != ' ') {
                codigo.append(c);
            } else {
                if (codigo.length() > 0) {
                    int decode = Integer.parseInt(codigo.toString());
                    char letra = (char) decode;
                    encoded.append(letra);
                    codigo.setLength(0);
                }
            }
        }
        if (codigo.length() > 0) {
            int decode = Integer.parseInt(codigo.toString());
            char letra = (char) decode;
            encoded.append(letra);
        }

        return encoded.toString();
    }
}
