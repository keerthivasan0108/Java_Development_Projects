import java.util.*;
public class Guess_Number{
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        random();

    }

    public static void random(){
        Random random = new Random();
        int rando = random.nextInt(100)+1;
        System.out.println(rando);
        int chances = choice();
        guess(chances,rando);
        
    }

    public static int choice(){
        System.out.println("Welcome to the Number Guessing Game!\n" + //
                "I'm thinking of a number between 1 and 100.");
        System.out.println("Please select the difficulty level:\n" + //
                "1. Easy (10 chances)\n" + //
                "2. Medium (5 chances)\n" + //
                "3. Hard (3 chances)\n");

        System.out.println("Enter your choice : ");
        int n = sc.nextInt();
        int chances =0;
        String s = "";
        if(n==1){
            s="Easy";
            chances = 10;
        }else if(n==2){s="Medium";chances = 5;}
        else{s="Hard";chances = 3;}
        System.out.println("Great! You have selected the "+s+" difficulty level.\n" + //
                "Let's start the game!");
        return chances;        
    } 

    public static void guess(int n,int rando){
        for(int i=1;i<=n;i++){
            System.out.println("Enter Your Guess : ");
            int g = sc.nextInt();
            if(g==rando){
                System.out.println("Congratulations! You guessed the correct number in "+i+" attempts");
                break;
            }
            else{
                System.out.println("Incorrect");
                if(g<rando){
                    System.out.println("The Number is Grater than "+g);
                }
                else{
                    System.out.println("The Number is less than "+g);
                }
                
                if(i==n){
                    System.out.println("if u want to play again click y ");
                    String c = sc.next();
                    if(c.equals("y")){
                        random();
                    }
                    else{
                        System.out.println("GoodBye!");
                    }
                }
                
            }
        }
    }
}
