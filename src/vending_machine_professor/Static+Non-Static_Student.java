package oop_exam;

public class Student {

	// 멤버변수
	int java;
	int python;
	int cpp;
	int csharp;
	
	/**
	 * 점수들의 총 합
	 * @return
	 */
	public int getSumAllScores() {
		return java + python + cpp + csharp;
	}
	
	public double getAverage() {
		int average = (int) (getSumAllScores() / 4.0 * 100); //9877
		return average / 100.0; // 98.77
	}
	
	/**
	 * 학점 구하기
	 * @return (평균점수 - 55) / 10
	 */
	public static double getCourseCredit(double average) {
		int courseCredit = (int) ((average - 55) / 10 * 100); // 450
		return courseCredit / 100.0;
	}
	
	public static String getABCDE(double courseCredit) {
		if (courseCredit >= 4.1) {
			return "A+";
		}
		else if (courseCredit >= 3.6) {
			return "A";
		}
		else if (courseCredit >= 3.1) {
			return "B+";
		}
		else if (courseCredit >= 2.6) {
			return "B";
		}
		else if (courseCredit >= 1.6) {
			return "C";
		}
		else if (courseCredit >= 0.6) {
			return "D";
		}
//		else {
//			return "F";
//		}
		return "F";
	}
	
	public static void main(String[] args) {
		Student student = new Student();
		student.java = 100;
		student.python = 97;
		student.cpp = 81;
		student.csharp = 99;
		
		int sum = student.getSumAllScores();
		double average = student.getAverage();
		double courseCredit = Student.getCourseCredit(average);
		String abcde = Student.getABCDE(courseCredit);
		
		System.out.println("합계: " + sum);
		System.out.println("평균: " + average);
		System.out.println("학점: " + courseCredit);
		System.out.println("등급: " + abcde);
	}
	
}















