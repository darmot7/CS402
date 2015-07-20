
public class Ant extends Creature{
	
	
	
	public Ant(String aname) {
		super(aname);
		
	}

	void move() {
		System.out.println(super.getName() + " " + getClass().getSimpleName() + " is crawling around.");
		
	}

}
