package com.jaehee.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {
//	public static void main(String[] args) {
	@RequestMapping("/getYoil")							// 브라우저 출력하기 위해 사용
		public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1.입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		// 2.작업
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1.일요일 2:월요일.. 숫자니꼐 문자로 바꿔줌
		char yoil = " 일월화수목금토".charAt(dayOfWeek);
		
		//3. 출력
		response.setContentType("text/html");	// 출력하기전에 꼭 타입 해주기
		response.setCharacterEncoding("utf-8"); // 브라우저는 타입과 인코딩을 알려줘야한다	
		
		PrintWriter out = response.getWriter(); 	// response객체에서 브라우져로의 출력 스트림을 얻는다.
		out.println(yyyy + "년" + month + "월" + day + "일은" );
		out.println(yoil +"요일입니다.");
	}
}
