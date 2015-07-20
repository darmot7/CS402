
public class Tiger extends Creature {



	public Tiger(String aname) {
		super(aname);
	}
	
	void move() {
		
		System.out.println(super.getName() + " " + getClass().getSimpleName() + " has just pounced");
		
	}

}
