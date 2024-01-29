package com.ktdsuniversity.terranunit;

public class Game {

	public static void move(Attackable unit) {
		unit.attack();
		unit.move();
		unit.stop();
		unit.hold();
		unit.patrol();
		// 말도 안되게 억지스러운 기능 ( 인터페이스가 정의하지 않은 기능 강제사용 / 사용하면 안되는 코드 )
		// 이렇게 쓸거면 인터페이스를 쓰는 의미가없음 잘못된 호출 방법임
//		if(unit instanceof Scv) {
//			Scv scv = (Scv) unit;
//			scv.mining();
//		}
		if (unit instanceof Mineable) {
			Mineable worker = (Mineable) unit;
			worker.mining();
		}
	}

	public static void main(String[] args) {

		Mineable drone = new Mineable() {
			@Override
			public void mining() {
				// TODO Auto-generated method stub
				System.out.println("드론이 미네랄을 채굴합니다.");
			}
		};

		drone.mining();
		// 슈퍼인터페이스 marine = new 클래스
		SpeicalCommand marine = new Marin();

		// SCV 인스턴스를 만들면 사용은 가능함
		// Scv scv = new Scv();

		// SpeicalCommand marine = new Marin();
		// Scv scv = new Scv();
		Attackable scv = new Scv();

		marine.attack();
		marine.move();
		marine.steampack();

		scv.attack();
		scv.move();
		scv.patrol();
		// scv.steampack();

		move(scv);
		move(marine);

	}
}
