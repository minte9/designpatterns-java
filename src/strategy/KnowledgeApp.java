package strategy;

public class KnowledgeApp {
    
    public static void main(String[] args) {
        
        Human master = new Master("Socrate");
        Human pupil = new Pupil("Alcibiades");

        System.out.println( 
            master.getName() + ": " + master.speak() 
        );

        System.out.println( 
            pupil.getName() + ": " + pupil.speak() 
        );
    }
}
