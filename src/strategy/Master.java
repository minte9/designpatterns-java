package strategy;

public class Master extends Human {

	public Master (String name) {

		super(name);
		
		speakType = new AskCapable(); // He can raise questions
	}
}