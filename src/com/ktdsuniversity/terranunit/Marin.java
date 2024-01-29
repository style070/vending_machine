package com.ktdsuniversity.terranunit;

public class Marin implements SpeicalCommand {

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("공격!");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Move Move Move");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("정지!");
	}

	@Override
	public void hold() {
		// TODO Auto-generated method stub
		System.out.println("움직이지 않아요.");
	}

	@Override
	public void patrol() {
		// TODO Auto-generated method stub
		System.out.println("정찰하세요");
	}

	@Override
	public void steampack() {
		// TODO Auto-generated method stub
		System.out.println("더 빠르게 공격!");
	}
	
	public static void main(String[] args) {
		SpeicalCommand marine1 = new Marin();
		Unit marine2 = new Marin();
		Attackable marine3 = new Marin();
		
		
		
	}
}
