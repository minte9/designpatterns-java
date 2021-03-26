package strategy;

/**
 * run:
     [java] Socrate: I can raise questions.
     [java] Alcibiades: I can answer, I know everything!
     [java] Alcibiades: I can raise questions.
 */
public class KnowledgeApp {
    
    public static void main(String[] args) {
        
        Human master = new Master("Socrate");
        Human pupil = new Pupil("Alcibiades");

        // Socrate can raise questions

        System.out.println( 
            master.getName() + ": " + master.speak() 
        );

        // Alcibiades can't ask, he knows everything!

        System.out.println( 
            pupil.getName() + ": " + pupil.speak() 
        );

        // After a while Alchibiades gets wiser ...
        // He's now capable to raise questions too

        pupil.setAskCapability(new AskCapable());

        System.out.println( 
            pupil.getName() + ": " + pupil.speak() 
        );
    }
}
