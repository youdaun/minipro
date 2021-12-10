package com.javaex.minipro;

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
		Reader fr = new FileReader("C:\\javaStudy\\file\\PhoneDB_minipro.txt");
		BufferedReader br = new BufferedReader(fr);
		List<Person> pList = new ArrayList<Person>();
		
		boolean start = true;
		
		//메모장 읽어와서 리스트에 저장
		while(true) {
			String line = br.readLine();
			
			if(line == null) {
				break;
			}
			
			String[] pArray = line.split(",");
			String name = pArray[0];
			String hp = pArray[1];
			String company = pArray[2];
			
			Person p = new Person(name, hp, company);
			pList.add(p);
		}
		
		System.out.println("*********************************");
		System.out.println("*       전화번호 관리 프로그램       *");
		System.out.println("*********************************");
		
		
		//제일 바깥쪽 리스트
		while(start) {
			System.out.println("");
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("---------------------------------");
			System.out.print(">메뉴번호: ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
			case 1:
				//리스트
				System.out.println("<1.리스트>");
				showList(pList);
				break;
				
			case 2:
				//데이터 입력받음
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				String name = sc.nextLine();
				
				System.out.print(">휴대전화: ");
				String hp = sc.nextLine();
				
				System.out.print(">회사전화: ");
				String company = sc.nextLine();
				
				//리스트에 저장
				Person p = new Person(name, hp, company);
				pList.add(p);
				
				//메모장에 쓰기
				Writer fw = new FileWriter("C:\\javaStudy\\file\\PhoneDB_minipro.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				writeTxt(pList, bw);
				System.out.println("[등록되었습니다.]");
				
				break;
				
			case 3:
				//리스트에서 삭제
				System.out.println("<3.삭제>");
				System.out.print(">번호 : ");
				int remove_num = sc.nextInt();
				
				pList.remove(remove_num - 1);
				
				//메모장에 쓰기
				Writer fw2 = new FileWriter("C:\\javaStudy\\file\\PhoneDB_minipro.txt");
				BufferedWriter bw2 = new BufferedWriter(fw2);
				
				writeTxt(pList, bw2);
				System.out.println("[삭제되었습니다.]");
				break;
				
			case 4:
				System.out.println("<4.검색>");
				System.out.print(">이름 : ");
				String search = sc.nextLine();
				
				for(int i=0; i<pList.size(); i++) {
					boolean search_name = pList.get(i).getName().contains(search);
					if(search_name == true) {
						System.out.println((i+1) + ".  " + pList.get(i).getName() + "  " + pList.get(i).getHp() + "  " + pList.get(i).getCompany() );
					}
				}
				
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
		
	}
	
	public static void showList(List<Person> pList) {
		for(int i=0; i<pList.size(); i++) {
			System.out.println((i+1) + ".  " + pList.get(i).getName() + "  " + pList.get(i).getHp() + "  " + pList.get(i).getCompany() );
		}
	}
	
	public static void writeTxt (List<Person> pList, BufferedWriter bw) throws IOException {
		for(int i=0; i<pList.size(); i++) {
			bw.write(pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany());
			bw.newLine();
		}
		
		bw.close();
		
	}

}
