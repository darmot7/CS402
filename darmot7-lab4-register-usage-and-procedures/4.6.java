import java.util.Scanner;

//I checked with professor and he said it was ok to use Java

public class Ack {

	public static long ack(long x, long y) {
		if (x == 0) return y+1;
		if (y == 0) return ack(x-1,1);
		
		return ack(x-1, ack(x, y -1));
		
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a value for x: ");
		long x = in.nextLong();
		System.out.print("Enter a vlue for y: ");
		long y = in.nextLong();
		
		System.out.println(ack(x,y));
		

	}

}
