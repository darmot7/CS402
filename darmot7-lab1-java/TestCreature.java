
public class TestCreature {

static int THING_COUNT = 10;
static int CREATURE_COUNT = 6;

	public static void main(String[] args) {
		
		Thing[] testThing = new Thing[THING_COUNT];
		Creature[] testCreature = new Creature[CREATURE_COUNT];
		
		Thing thing1 = new Thing("Bob");
		Thing thing2 = new Thing("Will");
		Thing thing3 = new Thing("Sam");
		Thing thing4 = new Thing("Virgil");
		Thing thing5 = new Thing("Steve");
		Thing thing6 = new Thing("Pools");
		Thing thing7 = new Thing("Tambler");
		Thing thing8 = new Thing("Califor");
		Thing thing9 = new Thing("Tree");
		Thing thing10 = new Thing("Rock");
		
		Creature creature1 = new Tiger("Silly");
		Creature creature2 = new Fly("Mellon");
		Creature creature3 = new Ant("Tickles");
		Creature creature4 = new Bat("Brock");
		Creature creature5 = new Ant("Sally");
		Creature creature6 = new Tiger("Tinture");
		
		
		testThing[0] = thing1;
		testThing[1] = thing2;
		testThing[2] = thing3;
		testThing[3] = thing4;
		testThing[4] = thing5;
		testThing[5] = thing6;
		testThing[6] = thing7;
		testThing[7] = thing8;
		testThing[8] = thing9;
		testThing[9] = thing10;
		
		testCreature[0] = creature1;
		testCreature[1] = creature2;
		testCreature[2] = creature3;
		testCreature[3] = creature4;
		testCreature[4] = creature5;
		testCreature[5] = creature6;
		
		System.out.println("Things:");
		
		for (int i = 0; i < testThing.length; i++) {
			System.out.println(testThing[i].toString()); 
			
		}
		
		System.out.println("\nCreatures:");
		
		for (int i = 0; i < testCreature.length; i++) {
			System.out.println(testCreature[i].toString()); 
			
		}

		System.out.println("Testing the differnt instances of Thing and Creature");
		System.out.println("-----------------------------------------------------------");
		System.out.println("\nCreature 1 will try to eat creature1:");
		creature1.eat(creature2);
		System.out.println("\nCreature 1 will try to eat thing1:");
		creature1.eat(thing1);
		System.out.println("\nWhat did Creature1 eat?");
		creature1.whatDidYouEat();
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("\nCreature 3 will try to eat creature4:");
		creature3.eat(creature4);
		System.out.println("\nCreature 3 will try to eat thing2:");
		creature3.eat(thing2);
		System.out.println("\nWhat did Creature1 eat?");
		creature1.whatDidYouEat();
		
		System.out.println("\nCreature 3 will try to eat creature4:");
		creature3.eat(creature4);
		System.out.println("\nCreature 3 will try to eat thing2:");
		creature3.eat(thing2);
		System.out.println("\nWhat did Creature1 eat?");
		creature1.whatDidYouEat();
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("\nCreature4 is a Bat, they wont eat things, they just silently do nothing!:");
		creature4.eat(thing2);
		System.out.println("\nCreature4 what did you just eat?");
		creature4.whatDidYouEat();
		System.out.println("\nCreature4 is a Bat, they wont even consider nonthings or creatures, they just silently do nothing! (See the test for details):");
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("\nCreature2 is an fly, they  wont eat creatures:");
		creature2.eat(creature1);
		System.out.println("\nCreature2 what did you just eat?");
		creature2.whatDidYouEat();
		System.out.println("\nCreature2 is an fly, they will eat things:");
		creature2.eat(thing2);
		System.out.println("\nCreature2 what did you just eat?");
		creature2.whatDidYouEat();
		System.out.println("-----------------------------------------------------------");
		System.out.println("\n\nQUICKLY ANIMALS..FLLYYYY RUNN GET OUT OF HERE!!!!! (testing Creature.move())");
		
		
		
		for (int i = 0; i < testCreature.length; i++) {
			testCreature[i].move(); //using the move method! because it will work for all creatures!
			
		}
	}

}
