public class Testes{

public static void main(String... args){

    int x = 15;
    int y = x;
    
    y++;
    x++;
    int z = y;
    
    System.out.println("Z: " + z);
    z--;
    
    System.out.println("X: " + x);
    System.out.println("Y: " + y);
    System.out.println("Z: " + z);
    System.out.println(x+y+z);
    


}

}