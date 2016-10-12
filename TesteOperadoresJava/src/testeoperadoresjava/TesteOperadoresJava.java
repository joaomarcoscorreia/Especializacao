/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeoperadoresjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author joaocorreia
 */
public class TesteOperadoresJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        //System.out.println("-------------Exercicio Fatorial-----------------");
        
        //ExercicioFatorial.fatorialComplicado();
        //System.out.println("--------------------------------------");
        //ExercicioFatorial.fatorialSimplificado();
        
        //System.out.println("-------------Exercicio Fibonacci-----------------");
        //ExercicioFiboracci.sequenciaFiboracci();
        
        //System.out.println("--------------Exercicio Pares e Impares-------------");
        //ParesImpares.paresImpares(13);
        
      //Scanner s = new Scanner(System.in);
     InputStream is = System.in;
      InputStreamReader isr = new InputStreamReader(is);

     BufferedReader br = new BufferedReader(isr);

 

     System.out.println("Digite sua mensagem:");

     String linha = br.readLine(); // primeira linha

     while (linha != null) {

       System.out.println(linha);

       linha = br.readLine();

     }
    }   
}
