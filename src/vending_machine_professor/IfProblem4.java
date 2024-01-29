package hello_java_world;


public class IfProblem4 {

	public static void main(String[] args) {
		
		int money = 1_000_000;
		
		int father = 40;
		int mother = 36;
		int daughter = 11;
		
		int adultOneWayFlightFare = 300_000;
		int kidOneWayFlightFare = 120_000;
		
		int flightFare = 0;
		
		// 삼항 연산자.
		// father의 값이 19보다 크거나 같다면 adultOneWayFlightFare 를 할당하고
		// 그렇지 않다면 kidOneWayFlightFare 를 할당한다.
		// 삼항연산자 문법: 조건 ? 조건이 true일 때의 값 : 조건이 false일 때의 값
		flightFare += father >= 19 ? adultOneWayFlightFare : kidOneWayFlightFare;
		flightFare += mother >= 19 ? adultOneWayFlightFare : kidOneWayFlightFare;
		flightFare += daughter >= 19 ? adultOneWayFlightFare : kidOneWayFlightFare;
		
		if (flightFare <= money) {
			System.out.println("여행가자!");
		}
		else {
			System.out.println("다음에 가자ㅠㅠ");
		}
		
	}
	
}
