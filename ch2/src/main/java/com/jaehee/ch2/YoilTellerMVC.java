package com.jaehee.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// ������� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTellerMVC {
	
//	public static void main(String[] args) {
	@RequestMapping("/getYoilMVC")							// http://localhost/ch2/getYoilMVC
	public void main(@RequestParam (required = true) int year,
									 @RequestParam (required = true) int month,
									 @RequestParam (required = true) int day, Model mv)throws IOException {
		
		//ModelAndView mv = new ModelAndView();
		// 1. 유효성 검사
		//if(!isValid(year, month, day)) return "yoilError";
	 	
		// 2.  처리
		char yoil =	getYoil(year, month, day);
		
		// 3.  Model에 작업 결과 저장
		mv.addAttribute("year", year);
		mv.addAttribute("month", month);
		mv.addAttribute("day", day);
		mv.addAttribute("yoil", yoil);
		
		// 4.  작업 결과를 보여줄 View의 이름을 반환
//		mv.setViewName("yoil");
		
		//return mv;
		//return "yoil";	// WEB-INF/views/yoil.jsp
	}

private boolean isValid(int year, int month, int day) {
		return true;
	}

private char getYoil(int year, int month, int day) {
	Calendar cal = Calendar.getInstance();
	cal.set(year, month-1, day);
	
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1.�Ͽ��� 2:������.. ���ڴϲ� ���ڷ� �ٲ���
	return " �Ͽ�ȭ�������".charAt(dayOfWeek);
}
}
