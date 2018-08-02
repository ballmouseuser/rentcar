package com.pgy.rentcar.common;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pgy.rentcar.dto.JSPMember_Dto;
import com.pgy.rentcar.dto.RentCar_Dto;


public class Parsing4Batch {
	private Class clazz;
	private String regex;

	public Parsing4Batch(Class clazz, String regex) {
		this.clazz = clazz;
		this.regex = regex;
	}

	public Object parsing(String target, String... settersName) throws Exception {
		String[] tokens = target.split(regex);
		Object obj = null;
		// -------------------------------------
		// 문제는 여기에서 만들어지는 배열순서를 예측할 수 없고
		// 토큰들의 순서가 같지 않다는데 있다. 이를 해결해야 한다.
		Method[] methods = clazz.getMethods();
		obj = clazz.newInstance();
		List<Method> setters = new ArrayList<>();
		for (int i = 0; i < methods.length; i++) {
			if (!methods[i].getName().startsWith("set"))
				continue;
			setters.add(methods[i]);
		}
		// 토큰의 성질에 맞는 세터를 불러 실행
		for (int i = 0; i < tokens.length; i++) {
			String setterName = settersName[i];
			String paraType = "";
			for (Method x : setters) {
				if (x.getName().equals(setterName)) {
					Class<?>[] p = x.getParameterTypes();
					paraType = (p[0].getSimpleName());
					Method y = null;
					switch (paraType) {
					case "int":
						y = clazz.getMethod(setterName, p[0]);
						y.invoke(obj, Integer.parseInt(tokens[i]));
						break;
					case "String":
						y = clazz.getMethod(setterName, p[0]);
						y.invoke(obj, tokens[i]);
						break;
					case "long":
						y = clazz.getMethod(setterName, p[0]);
						y.invoke(obj, Long.parseLong(tokens[i]));
						break;
					// .........필요하면 늘리세요
					}
				}
			}
		}
		return obj;
	}

	// 사용법
	public static void main(String[] args) throws Exception {
		Parsing4Batch parser = new Parsing4Batch(RentCar_Dto.class, "/");
		String[] setters1 = new String[] { 
				"setName", "setCategory", "setPrice", "setUsepeople", "setCompany", "setImg",
				"setInfo" };
		RentCar_Dto x = (RentCar_Dto) parser.parsing("SONATA/3/50000/4/현대/sonata.jpg/참좋은차다", setters1);
		System.out.println(x);
		// ---------------------------------------------------------
		Parsing4Batch parser2 = new Parsing4Batch(JSPMember_Dto.class, "/");
		String[] setters2 = new String[] { "setId", "setPass", "setEmail", "setTel", "setAge", "setJob", "setHobby" };
		JSPMember_Dto mem = (JSPMember_Dto) parser2.parsing("sjw/1234/jaain@naver.com/010-2307-3558/60대/교수/등산", setters2);
		System.out.println(mem);
	}
}