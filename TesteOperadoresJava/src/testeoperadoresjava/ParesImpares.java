/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeoperadoresjava;

/**
 *
 * @author joaocorreia
 */
public class ParesImpares {
    
    
    public static void paresImpares(int x){
          
        int divisor = 2;
         System.out.print("Valor ");
        while(x!=1){
        
            if((x%divisor)==0){
                x = x/2;
            }else{
                x = x*3+1;
            }
            
          
            System.out.print(": "+ x);
        }
    }
}
