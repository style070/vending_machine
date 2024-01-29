package oop_exam;

import java.util.Scanner;

public class RealyGame {

	// 장황한 코드
	public static void case1() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("끝말잇기 게임을 시작합니다.");
		
		int relayCount = 1;
		// 시작 단어 할당.
		String startWord = "자전거";
		System.out.println(startWord);
		
		while(true) {
			System.out.println("다음 단어를 입력해주세요.");
			// 다음단어 입력
			String nextWord = keyboard.nextLine();
			// 다음단어의 공백 제거
			nextWord = nextWord.trim();
			
			// 다음단어의 길이가 3이상인가?
			if (nextWord.length() >= 3) {
				// 시작 단어의 마지막 글자를 추출.
				String lastLetter = startWord.substring(startWord.length() - 1);
				
				// 다음 단어가 시작 단어의 마지막 글자로 시작하는가?
				if (nextWord.startsWith(lastLetter)) {
					// 다음 단어를 시작단어에 할당.
					startWord = nextWord;
					// 이어간 횟수를 1 증가시킨다.
					relayCount++;
				}
				else {
					// 다음 단어가 시작 단어의 마지막 글자로 시작하지 않는다.
					// 게임 종료
					break;
				}
			}
			else {
				// 다음 단어의 길이가 3 미만이다.
				// 게임 종료
				break;
			}
			
		}
		
		System.out.println("끝말잇기 게임이 종료되었습니다.");
		System.out.println("이어간 단어의 수는 " + relayCount + "번 입니다.");
	}
	
	// 덜 장황한 코드
	public static void case2() {
Scanner keyboard = new Scanner(System.in);
		
		System.out.println("끝말잇기 게임을 시작합니다.");
		
		int relayCount = 1;
		// 시작 단어 할당.
		String startWord = "자전거";
		System.out.println(startWord);
		
		while(true) {
			System.out.println("다음 단어를 입력해주세요.");
			// 다음단어 입력
			String nextWord = keyboard.nextLine();
			// 다음단어의 공백 제거
			nextWord = nextWord.trim();
			
			// 다음단어의 길이가 3미만인가?
			if (nextWord.length() < 3) {
				// 게임 종료
				break;
			}
			
			// 시작 단어의 마지막 글자를 추출.
			String lastLetter = startWord.substring(startWord.length() - 1);
			
			// 다음 단어가 시작 단어의 마지막 글자로 시작하는가?
			if (nextWord.startsWith(lastLetter)) {
				// 다음 단어를 시작단어에 할당.
				startWord = nextWord;
				// 이어간 횟수를 1 증가시킨다.
				relayCount++;
			}
			else {
				// 다음 단어가 시작 단어의 마지막 글자로 시작하지 않는다.
				// 게임 종료
				break;
			}
			
		}
		
		System.out.println("끝말잇기 게임이 종료되었습니다.");
		System.out.println("이어간 단어의 수는 " + relayCount + "번 입니다.");
	}
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		// 문자열 비교
		String str1 = "한글"; // Reference Type (메모리 주소)
		String str2 = "한글"; // Reference Type (메모리 주소)
		
		// str1 == str2 <= 메모리 주소가 같은가?
			
		System.out.println(str1 == str2);
		
		String str3 = keyboard.nextLine();
		String str4 = keyboard.nextLine();
		
		System.out.println(str3 == str4); // 메모리 주소 비교
		System.out.println(str3.equals(str4)); // 값을 비교
		
		
	}
	
}


















