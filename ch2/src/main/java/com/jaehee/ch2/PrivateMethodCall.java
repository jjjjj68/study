package com.jaehee.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
//		Hello he = new Hello();
//		he.main(); // private�̶� �ܺ� ȣ�� �Ұ���
		
		// Reflection API�� ����ؼ� �Ӵ� - Ŭ���� ������ ��� �ٷ� �� �ִ� ������ �������
		// java.lang.reflect��Ű���� ����
		// Hello Ŭ������ Class ��ü(Ŭ������ ������ ��� �ִ� ��ü)�� ���´�.
		Class helloClass = Class.forName("com.jaehee.ch2.Hello");	//����ó���������
		Hello hello = (Hello)helloClass.newInstance();	// Class��ü�� ���� ������ ��ü ����
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private�� main()�� ȣ�Ⱑ���ϰ� �Ѵ�.
		
		main.invoke(hello);	// hello.main()
	}
}
