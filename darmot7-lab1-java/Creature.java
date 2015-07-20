
public abstract class Creature extends Thing{
private String eaten = null;

	
	public Creature(String aname) {
		super(aname);
	}

	void eat (Thing aThing) {
		
	//	Creatures may be asked to eat various Things. 
	//	By default, creatures eat whatever they are told AND 
	//	print a message stating '{this object} has just eaten a {a Thing}.' 
	//	substituting the concrete details for the part enclosed inside of {}. 
	//	(the single quotes are not part of the message.) 
	//	A creature only remembers the last thing it ate.
		eaten = aThing.getClass().getSimpleName();
		System.out.println(this.getClass().getSimpleName() + " has just eaten a "+ eaten+".");
		
	}
	
	abstract void move(); //Tell the Creature to move. Each creature will print a message stating the way it most commonly moves.
	
	void whatDidYouEat() {
		//	Make the Creature tell what is in its stomach. 
		//	If there is nothing in its stomach, whatDidYouEat() prints '{name} {class} has had nothing to eat!' 
		//	If it has something in its stomach, whatDidYouEat() prints '{creature name} {class name} has eaten a {content of stomach}!' 
		//	NOTE: The pattern {word} in the text above indicates what attribute value belongs in the output text.
		
		if (eaten == null) {
			System.out.println(super.getName() + " "+ super.getClass().getSimpleName() + " has had nothing to eat!" );
		}
		
		else System.out.println(super.getName() + " "+ super.getClass().getSimpleName() + " has eaten a " + eaten +"!" );
	}
	
	
}
