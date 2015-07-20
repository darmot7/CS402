
public class Fly extends Creature {

	public Fly(String aname) {
		super(aname);
		
	}
	
	public void eat(Thing aThing) {
		String superclass = aThing.getClass().getGenericSuperclass().toString();
		
		if (superclass.contains("Creature")) {
			System.out.println(super.getName() + getClass().getSimpleName() + " won't eat a " + aThing.getClass().getSimpleName());
		}
		
		else {
			super.eat(aThing);
			
		}
	}

	void move() {
		fly();
		
	}

	public void fly() {
		System.out.println(super.getName() + " " + getClass().getSimpleName() + " is buzzing around in flight.");
		
	}

}
