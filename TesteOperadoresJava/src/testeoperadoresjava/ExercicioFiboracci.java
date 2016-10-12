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
public class ExercicioFiboracci {
    
    public static void sequenciaFiboracci(){
        long a = 0;        
        long b =1;
        //long c = 0;
        for(int n = 0; n < 100; n++){
            System.out.print("[" + n + "],[" );
            
//            if(n!=0){
//                c = a + b;
//                a = b;
//                b = c;
//            }
            if(n!=0){
            a = a+b;
            b = a-b;
            }
            //primeiraPosicao = primeiraPosicao + segundaPosicao;
            //segundaPosicao = primeiraPosicao - segundaPosicao;
            
             System.out.println(a + "]");
        }
        
    }
}
