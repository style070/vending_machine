package bookcafe;

public class BookMain {
	public static void main(String[] args) {
		// BookCafe 타입 인스턴스 생성
		BookCafe books = new BookCafe();
		
		books.bookList();
		books.rentBook("슬램덩크1화");
		books.bookList();
		books.rentBook("슬램덩크1화");
		books.rentBook("슬램덩크2화");
		books.bookList();
		books.returnBook("슬램덩크1화");
		books.bookList();
	}
}
