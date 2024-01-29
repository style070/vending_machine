package com.ktdsuniversity.memservice;

public class MemberMain {
	public static void main(String[] args) {
		MemberService normalClass = new NormalMemberSerivce();
		MemberService vipClass1 = new VipClassMemberService();
		VipMemberService vipClass2 = new VipClassMemberService();
		
		normalClass.deleteMe();
		vipClass1.join();
		vipClass2.receiveVip();
	}
}
