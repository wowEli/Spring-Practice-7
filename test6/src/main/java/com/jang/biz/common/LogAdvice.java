package com.jang.biz.common;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	public void printLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		// 현재 수행중인 포인터컷(핵심로직 ,CRUD)의 시그니처의 메서드명
		Object[] args = jp.getArgs();
		// 현재 수행중인 포인터컷(핵심로직 ,CRUD)이 사용하는 인자들의 정보
		
		
		System.out.println("로그: 수핸중인 핵심 메서드명 "+methodName);
		System.out.print("로그: 수핸중인 핵심 메서드의 인자: ");
		for(Object o:args) {
			System.out.print(o); // 동적바인딩으로 인해 VO의 toString이 나옴
		}
		System.out.println();
		
	}
	public void selectLog() {
		System.out.println("로그: select 함수 실행");
	}
}
