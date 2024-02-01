package vending_machine.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.css.CSSValueList;

import vending_machine.Product;

public class FileUtil {
	

	public static void writeFile(String parent, String filename , String description ,boolean append) {
		File file = new File(parent,filename);
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		List<String> originalFileDescription = new ArrayList();
		if(! append ) {
			//이어서 쓰지 않을것 이라면
			int index =2;
			while (file.exists()) {
				file = new File(file.getParent(),"java_output ("+(index++)+").txt");
			}
		}
		else {
			//이어서 쓸것이라면.. 영역.
			// 기존의 파일 내용을 읽어와서 List<String>으로 반환 받는다.
			// 반환 받을 내용을 originalFileDescription에 addAll 한다.
			//originalFileDescription.addAll(FileUti.get)
		}
	}
	public static List<String> getAllLines(File file){
		if(file.exists()&&file.isFile()) {
			FileReader reader = null;
			BufferedReader BufferedReader = null;
			try {
				reader = new FileReader(file)
			}
		}
	}
	


	public static List<Product> readCSVFile(String parent, String fileName) {

		File file = new File(parent, fileName);
		if (file.exists() && file.isFile()) {
			// C:\\JavaExam\JavaExam.txt이 존재하면
			// C:\\JavaExam\JavaExam.txt이 파일이라면

			FileReader reader = null;
			BufferedReader bufferedReader = null;

			try {
				// 파일을 바이트 단위로 읽어오는 FileReader를 선언
				reader = new FileReader(file, Charset.forName("UTF-8"));
				// 파일을 라인단위로 읽어오는 BufferedReader를 선언
				bufferedReader = new BufferedReader(reader);

				List<Product> csvList = new ArrayList<>();
				Product product = null;

				// 파일을 라인단위로 읽어와 할당하기 위한 String 변수 선언
				String line = null;
				String[] splittedCSVLine = null;
				// 파일이 끝날때까지 (EOF , End Of File) 반복하며 line 변수에 한 줄 씩 읽어오기
				while ((line = bufferedReader.readLine()) != null) {
					
					product = new Product();
					
					
					splittedCSVLine=line.trim().split(",");
					product.setName(splittedCSVLine[0].trim());
					product.setPrice(Integer.parseInt(splittedCSVLine[1].trim()));
					product.setQuantity(Integer.parseInt(splittedCSVLine[2].trim()));
					
					csvList.add(product);
					
					System.out.println(line);
				}
				
				return csvList;
			} catch (IOException ioe) {
				// 파일을 읽다가 예외 발생하면 예외 메시지만 출력
				System.out.println(ioe.getMessage());
			} finally {
				// 파일을 끝까지 읽었거나 예외가 발생했을경우
				// BufferedReader를 닫아준다.
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException ioe) {
					}
				}
				// 파일을 끝까지 읽었거나 예외가 발생했을 경우
				// FileReader를 닫아준다
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException ioe) {
					}
				}

			}

			return null;
		}
		return null;
	}
}