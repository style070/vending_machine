package hello_java_world;


public class IfProblem2 {

	public static void main(String[] args) {
		
		int money = 1_000_000;
		
		int father = 4;
		int mother = 36;
		int daughter = 11;
		
		int adultOneWayFlightFare = 300_000;
		int kidOneWayFlightFare = 120_000;
		
		int flightFare = 0;
		
		if (father >= 19) {
			flightFare += adultOneWayFlightFare;
		}
		else {
			flightFare += kidOneWayFlightFare;
		}
		
		if (mother >= 19) {
			flightFare += adultOneWayFlightFare;
		}
		else {
			flightFare += kidOneWayFlightFare;
		}
		
		if (daughter >= 19) {
			flightFare += adultOneWayFlightFare;
		}
		else {
			flightFare += kidOneWayFlightFare;
		}
		
		if (flightFare <= money) {
			System.out.println("여행가자!");
		}
		else {
			System.out.println("다음에 가자 ㅠㅠ");
		}
		
		
	}
	
}
