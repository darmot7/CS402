
public class Bat extends Creature  {

	
	public Bat(String aname) {
		super(aname);
		
	}

	void move() {
	 fly();
	}
	
	void fly() {
		System.out.println(super.getName() + " " + getClass().getSimpleName() + " is swooping through the dark.");
	}
	
	void eat(Thing aThing) {
		String classname = aThing.getClass().getSimpleName().toString();
		if (classname.contains("Thing")) {
			System.out.println(super.getName() + getClass().getSimpleName() + " won't eat a " + aThing.getClass().getSimpleName());
		}
		
		else if (aThing.getClass().getSimpleName().equals("Creatrue")) {
			super.eat(aThing);
			
		}
		
		else {System.out.println();} //Finally, if aThing is an instance neither of Creature nor Thing. the bat is silent and does not eat the instance.
		
	}

}
