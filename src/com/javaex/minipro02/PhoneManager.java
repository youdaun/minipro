package com.javaex.minipro02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;


public class PhoneManager {
	
	public void inputList(List<Person> pList) throws IOException { //메모장 읽어와서 리스트에 저장
		
		Reader fr = new FileReader("C:\\javaStudy\\file\\PhoneDB_minipro.txt");
		BufferedReader br = new BufferedReader(fr);
		
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
		
		br.close();
	}

	public void showList(List<Person> pList) {
		System.out.println("<1.리스트>");
		for(int i=0; i<pList.size(); i++) {
			System.out.println((i+1) + ".  " + pList.get(i).getName() + "  " + pList.get(i).getHp() + "  " + pList.get(i).getCompany() );
		}
	}
	
	public void writeTxt (List<Person> pList, BufferedWriter bw) throws IOException {
		for(int i=0; i<pList.size(); i++) {
			bw.write(pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany());
			bw.newLine();
		}
		
		bw.close();
		
	}
	
	public void addList(List<Person> pList, Scanner sc) {
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
		
		System.out.println("[등록되었습니다.]");
	}
	
	public void removeList(List<Person> pList, Scanner sc) {
		System.out.println("<3.삭제>");
		System.out.print(">번호 : ");
		int remove_num = sc.nextInt();
		
		pList.remove(remove_num - 1);
		System.out.println("[삭제되었습니다.]");
	}
	
	public void searchList(List<Person> pList, Scanner sc) {
		System.out.println("<4.검색>");
		System.out.print(">이름 : ");
		String search = sc.nextLine();
		
		for(int i=0; i<pList.size(); i++) {
			boolean search_name = pList.get(i).getName().contains(search);
			if(search_name == true) {
				System.out.println((i+1) + ".  " + pList.get(i).getName() + "  " + pList.get(i).getHp() + "  " + pList.get(i).getCompany() );
			}
		}
	}
	



}
