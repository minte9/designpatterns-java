package strategy;

public class Pupil extends Human {

	public Pupil (String name) {
		
		super(name);

		speakType = new AskIncapable(); // He knows everything
	}
}