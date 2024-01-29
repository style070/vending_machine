package oop_exam;

public class ClassRoom {

	public static void main(String[] args) {
		Calculator 학생1 = new Calculator();
		학생1.korScore = 100;
		학생1.engScore = 70;
		학생1.mathScore = 80;
		학생1.progScore = 90;
		
		int sum1 = 학생1.getSumScore();
		int average1 = 학생1.getAverageScore();
		String grade1 = Calculator.getGrade(average1);
		
		System.out.println(sum1);
		System.out.println(average1);
		System.out.println(grade1);
		
		System.out.println(학생1); // oop_exam.Calculator@279f2327
		
		Calculator 학생2 = 학생1;
		
		System.out.println(학생2); // oop_exam.Calculator@279f2327
		
		학생2.korScore = 0;
		
		// Math.random() 으로 0, 1중 하나 구하기 
		double rand = Math.random();
		int randomValue = (int) (rand * 10);
		randomValue %= 2;
		System.out.println(randomValue);
		
	}
	
}




















