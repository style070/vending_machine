package hello_java_world;


public class IfProblem3 {

	public static void main(String[] args) {
		
		int money = 1_000_000;
		
		int father = 40;
		int mother = 36;
		int daughter = 11;
		
		int adultOneWayFlightFare = 300_000;
		int kidOneWayFlightFare = 120_000;
		
		int adult = 0;
		int kid = 0;
		
		int flightFare = 0;
		
		if (father >= 19) {
			adult++;
		}
		else {
			kid++;
		}
		
		if (mother >= 19) {
			adult++;
		}
		else {
			kid++;
		}
		
		if (daughter >= 19) {
			adult++;
		}
		else {
			kid++;
		}
		
		System.out.println(adult);
		System.out.println(kid);
		
		flightFare = adult * adultOneWayFlightFare;
		flightFare += kid * kidOneWayFlightFare;
		
		System.out.println(flightFare);
		
		if (flightFare <= money) {
			System.out.println("여행가자!");
		}
		else {
			System.out.println("다음에 가자 ㅠㅠ");
		}
		
		
	}
	
}
