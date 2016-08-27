/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeoperadoresjava;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author joaocorreia
 */
public class ExercicioFatorial {
    
    public static void fatorialSimplificado(){
                String resultado = " O Fatorial de [#]! é [##] ";

        for(long n=1; n < 100; n++){
           long auxiliar = n;
             BigDecimal fatorial = new BigDecimal(BigInteger.ONE);
                while(auxiliar > 1){
                //n*(n-1)... == 1
                fatorial = fatorial.multiply(new BigDecimal(auxiliar).subtract(new BigDecimal(1)));
                auxiliar--;
             }
            System.out.println(resultado.replace("[#]", (String.valueOf(n-1))).replace("[##]", String.valueOf(fatorial)));        
        }
    }
    
    public static void fatorialComplicado(){
                int fatorial = 1;
        for (int n = 1; n < 10; n++) {
            int auxN = n-1;
            System.out.print(" O fatorial de " + auxN);
            if((n-1)==1 ||(n-1)==0){
                System.out.println("! é = 1"); 
            }else{
                int r = 1;
                int x = n-1;
                while(auxN > fatorial){
                    r = r*(x--);
                    auxN--;
                }
                System.out.println("! é = " + r);
            }
        }
    }
    
}
