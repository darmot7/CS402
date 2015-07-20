
public class Thing extends java.lang.Object {
	static int CREATURE_COUNT = 6;
	private String name;
	
	public Thing(String aname) {
		name = aname;
	}
	
	protected String getName() {
		return name;
	}

	public String  toString() {
		String getclassname = getClass().getSimpleName();
		
		if (getclassname.equals("Thing")) {
				
			return name;
		}
		
		else return name + " " + this.getClass().getSimpleName();
	}
}
