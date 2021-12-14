package com.javaex.minipro02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		List<Person> pList = new ArrayList<Person>();
		PhoneManager pm = new PhoneManager();
		boolean start = true;
		BufferedWriter bw;
		Writer fw;
		pm.inputList(pList);
		
		System.out.println("*********************************");
		System.out.println("*       전화번호 관리 프로그램       *");
		System.out.println("*********************************");
		
		//제일 바깥쪽 틀
		while(start) {
			System.out.println("");
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("---------------------------------");
			System.out.print(">메뉴번호: ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
			case 1:

				pm.showList(pList);
				break;
				
			case 2:
				
				fw = new FileWriter("C:\\javaStudy\\file\\PhoneDB_minipro.txt");
				bw = new BufferedWriter(fw);
				
				pm.addList(pList,sc);
				pm.writeTxt(pList, bw);

				break;
				
			case 3:
				
				fw = new FileWriter("C:\\javaStudy\\file\\PhoneDB_minipro.txt");
				bw = new BufferedWriter(fw);
				
				pm.writeTxt(pList, bw);
				break;
				
			case 4:
				
				pm.searchList(pList, sc);
				break;
				
			case 5:
				System.out.println("");
				System.out.println("*********************************");
				System.out.println("*            감사합니다            *");
				System.out.println("*********************************");
				start = false;
				break;
				
			default:
				System.out.println("[다시 입력해 주세요.]");
				break;
				
			}
			
		}
		sc.close();
	}

	

}
