package com.ktdsuniversity.terranunit;

public interface Unit {

	
	/**
	 *  이동
	 */
	public abstract void move();
	/**
	 *  정지
	 */
	public abstract void stop();
	/**
	 *  홀드
	 */
	public abstract void hold();
	/**
	 *  정찰
	 */
	public abstract void patrol();
	
	
}
