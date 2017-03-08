package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Bem vindo ao jogo da Forca!");

        String array[] = {"Computador", "Pure", "Batatas", "Copo"};
        int numAleatorio = r.nextInt(4);


        int quantidadeLetras = array[numAleatorio].length();
        System.out.println("A sua palavra tem " + quantidadeLetras + " letras.");

        int pontos = 0;

        System.out.println("Você tem 10 tentativas: ");
        for (int i = 0; i < 10; i++) {
            System.out.println("Tente: ");
            String s = leia.nextLine();
            if(s.length() > 1){
                System.out.println("Você so pode digitar 1 letra, você perdeu uma chance!");
                System.out.println("Pontos = " + pontos);
                continue;
            }

            char letras[] = array[numAleatorio].toCharArray();

            loop : for (int j = 0; j < letras.length; j++) {

                if (s.equalsIgnoreCase(String.valueOf(letras[j]))) {
                    pontos++;
                    System.out.println("Você acertou uma letra = " + s);
                    System.out.println("Sua pontuação = " + pontos);
                    break loop;
                }

                if(j == letras.length) {
                    if (!(s.equalsIgnoreCase(String.valueOf(letras[j])))) {
                        pontos--;
                        System.out.println("Você errou uma letra = " + s);
                        System.out.println("Sua pontuação = " + pontos);
                    }
                }
            }

            if(!(s.equalsIgnoreCase(String.valueOf(letras)))){
                pontos--;
                System.out.println("Você errou uma letra = " + s);
                System.out.println("Sua pontuação = " + pontos);
            }

            if(pontos == array[numAleatorio].length()){
                System.out.println("Você acertou todas as letras!");
                System.out.println("A palavra é " + array[numAleatorio]);
                break;
            }
        }

        System.out.println("Jogo finalizado!");
    }
}
