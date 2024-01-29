package com.ktdsuniversity.terranunit;

// 상속도하고 구현도 하는 코드도 가능
public class Scv implements Attackable , Mineable {

	// 인터페이스와는 아무 관련 없는 기능
	// 메소드를 구현해 놓아도 scv 인스턴스로는 mining을 사용할 수 없음
//	public void mining() {
//		System.out.println("자원을 캡니다.");
//	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("SCV 이동");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("SCV 정지");
	}

	@Override
	public void hold() {
		// TODO Auto-generated method stub
		System.out.println("SCV 정지");
	}

	@Override
	public void patrol() {
		// TODO Auto-generated method stub
		System.out.println("SCV 정찰");
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("SCV 공격");
	
		
	}

	@Override
	public void mining() {
		// TODO Auto-generated method stub
		
	}

}
