package com.codificador;

import java.util.Scanner;

public class App {
    private static Scanner scan;
    public static void main(String[] args) throws Exception {
        scan = new Scanner(System.in);
        
        System.out.println("\nQual é o nível de segurança que você precisa de 1 a 3?");
        int nivel = scan.nextInt();

        Codificador cod = Factory.createCodificador(nivel);

        System.out.println("\nCodificador: "+cod.getNome());
        System.out.println("\nVersao: "+cod.getDataCriacao());
        System.out.println("\nNivel de segurança: "+cod.getNivelSeguranca());

        System.out.println("\nQual é o texto a ser codificado?");
        scan.nextLine();
        String texto = scan.nextLine();
        String codificado = cod.codifica(texto);
        String decodificado = cod.decodifica(codificado);

        System.out.println("\nTexto original: "+texto);
        System.out.println("\nTexto codificado: "+codificado);
        System.out.println("\nTexto decodificado: "+decodificado);

        scan.close();
    }
}