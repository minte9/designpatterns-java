package strategy;

/**
 * Insteed of using an interface for Speak
 * we use an instance variable (speakType)
 * which is a subclass of interface Speak
 *
 * Human class doesn't konw what speakType does
 * It just knows that the behavior is available 
 * to its subclasses
 *
 * This is known as Composition.
 * It allows you to change the capabilities
 * of objects at run time!
 *
 */
public abstract class Human {

	private String name;

	public Speak speakType; // Look Here

	public Human(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String speak() {
		return speakType.speak(); // Look Here
	}
}