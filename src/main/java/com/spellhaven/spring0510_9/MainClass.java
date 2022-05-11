package com.spellhaven.spring0510_9;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		// 사용자에게서 빨간 프로필 줄까 파란 프로필 줄까 입력받는 부분
		System.out.println("개발하려는 서버를 입력해 주세요(dev / run): ");
		Scanner scann = new Scanner(System.in);
		String str = scann.next();
		
		String config = null;
		
		if(str.equals("dev")) {
			config = "dev";
		} else {
			config = "run";
		}
		
		scann.close();
		
		
		// 사용자 요구에 맞는 Bean 가져오는 부분
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("Server IP:" + info.getIpNum());
		System.out.println("Server Port:" + info.getPortNum());
		
		ctx.close();
	}
}













