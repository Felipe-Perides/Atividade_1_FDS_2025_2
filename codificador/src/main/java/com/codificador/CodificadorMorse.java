package com.codificador;

import java.time.LocalDate;

public class CodificadorMorse implements Codificador {

    private static final class Node {

        public Node father;
        public Node left;
        public Node right;
        private char element;

        public Node(char element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    private final Node root;

    public CodificadorMorse() {
        root = new Node(' ');
        this.insert('a', ".-");
        this.insert('b', "-...");
        this.insert('c', "-.-.");
        this.insert('d', "-..");
        this.insert('e', ".");
        this.insert('f', "..-.");
        this.insert('g', "--.");
        this.insert('h', "....");
        this.insert('i', "..");
        this.insert('j', ".---");
        this.insert('k', "-.-");
        this.insert('l', ".-..");
        this.insert('m', "--");
        this.insert('n', "-.");
        this.insert('o', "---");
        this.insert('p', ".--.");
        this.insert('q', "--.-");
        this.insert('r', ".-.");
        this.insert('s', "...");
        this.insert('t', "-");
        this.insert('u', "..-");
        this.insert('v', "...-");
        this.insert('w', ".--");
        this.insert('x', "-..-");
        this.insert('y', "-.--");
        this.insert('z', "--..");
    }

    @Override
    public String getNome() {
        return "Codificador Morse";
    }

    @Override
    public LocalDate getDataCriacao() {
        return LocalDate.of(2025, 8, 16);
    }

    @Override
    public int getNivelSeguranca() {
        return 3;
    }

    @Override
    public String codifica(String texto) {
        String coded = "";
        for (char c : texto.toCharArray()) {
            if (searchNodeRef(root, c) == null) {
                continue;
            }
            coded += codifica(c) + " ";
        }
        return coded;
    }

    @Override
    public String decodifica(String coded) {
        String decoded = "";
        String[] frase = coded.split("  ");
        for (String s : frase) {
            for (String str : s.split(" ")) {
                decoded += decodifica(root, str);
            }
            decoded += " ";
        }
        return decoded;
    }

    private void insert(char caratcter, String caminho) {
        Node atual = root;
        for (int i = 0; i < caminho.length(); i++) {
            if (caminho.charAt(i) == '.') {
                if (atual.left == null) {
                    atual.left = new Node(' ');
                    atual.left.father = atual;
                }
                atual = atual.left;
            } else {
                if (atual.right == null) {
                    atual.right = new Node(' ');
                    atual.right.father = atual;
                }
                atual = atual.right;
            }
        }
        atual.element = caratcter;
    }

    private String codifica(char caracter) {
        String coded = "";
        Node aux = searchNodeRef(root, caracter);
        while (aux.father != null) {
            if (aux.father.left == aux) {
                coded += ".";
            } else {
                coded += "-";
            }
            aux = aux.father;
        }
        String result = new StringBuilder(coded).reverse().toString();
        return result;
    }

    private Node searchNodeRef(Node n, char c) {
        if (n == null) {
            return null;
        }
        if (n.element == c) {
            return n;
        } else {
            Node left = searchNodeRef(n.left, c);
            if (left != null) {
                return left;
            } else {
                return searchNodeRef(n.right, c);
            }
        }
    }

    private char decodifica(Node n, String code) {
        char c = n.element;
        if (code.length() > 0) {
            if (code.charAt(0) == '.') {
                code = code.substring(1);
                c = decodifica(n.left, code);
            } else if (code.charAt(0) == '-') {
                code = code.substring(1);
                c = decodifica(n.right, code);
            }
        }
        return c;
    }
}
