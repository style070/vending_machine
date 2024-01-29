package bookcafe;

public class BookCafe {

	// 멤버변수 선언
	private int profits;

	// Books 데이터 클래스 타입 멤버변수 선언
	private Books slamDunk1;
	private Books slamDunk2;
	private Books novel;

	// Getter/Setter
	public int getProfits() {
		return profits;
	}

	public void setProfits(int profits) {
		this.profits = profits;
	}

	public Books getSlamDunk1() {
		return slamDunk1;
	}

	public void setSlamDunk1(Books slamDunk1) {
		this.slamDunk1 = slamDunk1;
	}

	public Books getSlamDunk2() {
		return slamDunk2;
	}

	public void setSlamDunk2(Books slamDunk2) {
		this.slamDunk2 = slamDunk2;
	}

	public Books getNovel() {
		return novel;
	}

	public void setNovel(Books novel) {
		this.novel = novel;
	}

	public BookCafe() {
		// 데이터 클래스 인스턴스 실체화
		this.slamDunk1 = new Books();
		this.slamDunk2 = new Books();
		this.novel = new Books();
		
		// TODO Auto-generated constructor stub
		// 생성자 호출시 초기 소지금 10000원으로 세팅
		this.profits = 10000;
		System.out.println("현재 만화카페 소지금 : " + profits);
		this.slamDunk1.setBooksName("슬램덩크1화");
		this.slamDunk1.setBooksPrice(1000);
		this.slamDunk1.setBooksStatus(true);

		this.slamDunk2.setBooksName("슬램덩크2화");
		this.slamDunk2.setBooksPrice(2000);
		this.slamDunk2.setBooksStatus(true);

		this.novel.setBooksName("소설");
		this.novel.setBooksPrice(3000);
		this.novel.setBooksStatus(true);

	}

	// 현재 가지고 있는 3권의 책 보유현황 및 정보 리턴
	public void bookList() {
		System.out.println("=============== 도서현황 ===============");
		System.out.println("책 제목 : " + this.slamDunk1.getBooksName() + " 책 대여료 : " + this.slamDunk1.getBooksPrice()
				+ " 책 보유현황" + this.slamDunk1.getBooksStatus());
		System.out.println("책 제목 : " + this.slamDunk2.getBooksName() + " 책 대여료 : " + this.slamDunk2.getBooksPrice()
				+ " 책 보유현황" + this.slamDunk2.getBooksStatus());
		System.out.println("책 제목 : " + this.novel.getBooksName() + " 책 대여료 : " + this.novel.getBooksPrice() + " 책 보유현황 :"
				+ this.novel.getBooksStatus());
		System.out.println("======================================");
	}

	public void rentBook(String booksName) {
		if (booksName == this.slamDunk1.getBooksName()) {
			if (this.slamDunk1.getBooksStatus() == false) {
				System.out.println(this.slamDunk1.getBooksName() + "책이 대여중입니다. 대여 할 수 없습니다.");
			} else {
				this.slamDunk1.setBooksStatus(false);
				this.profits += this.slamDunk1.getBooksPrice();
				System.out.println("현재 만화카페 소지금 : "+this.profits);
			}
		}
		else if (booksName == this.slamDunk2.getBooksName()) {
			if (this.slamDunk2.getBooksStatus() == false) {
				System.out.println(this.slamDunk2.getBooksName() + "책이 대여중입니다. 대여 할 수 없습니다.");
			} else {
				this.slamDunk2.setBooksStatus(false);
				this.profits += this.slamDunk2.getBooksPrice();
				System.out.println("현재 만화카페 소지금 : "+this.profits);
			}
		}
		else if (booksName == this.novel.getBooksName()) {
			if (this.novel.getBooksStatus() == false) {
				System.out.println(this.novel.getBooksName() + "책이 대여중입니다. 대여 할 수 없습니다.");
			} else {
				this.novel.setBooksStatus(false);
				this.profits += this.novel.getBooksPrice();
				System.out.println("현재 만화카페 소지금 : "+this.profits);
			}
		}
		else {
			System.out.println(booksName+"책이 만화카페에 존재하지 않습니다.");
		}
	}

	public void returnBook(String booksName) {
		if(booksName == this.slamDunk1.getBooksName()) {
			this.slamDunk1.setBooksStatus(
					true);
			System.out.println(this.slamDunk1.getBooksName()+"책이 반납이 완료 되었습니다.");
		}
		else if(booksName == this.slamDunk2.getBooksName()) {
			this.slamDunk2.setBooksStatus(true);
			System.out.println(this.slamDunk2.getBooksName()+"책이 반납이 완료 되었습니다.");
		}
		else if(booksName == this.novel.getBooksName()) {
			this.novel.setBooksStatus(true);
			System.out.println(this.novel.getBooksName()+"책이 반납이 완료 되었습니다.");
		}
		else {
			System.out.println(booksName+"책이 존재하지 않습니다.");
		}
	}

}
