package com.pack;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DummyApplication {



	public static void main(String[] args) {
		SpringApplication.run(DummyApplication.class, args);
	}
	/*@PostConstruct
	public void reverseOfString()
	{
		String str="Tesla";
		String result="";
		for(int i=0;i<str.length();i++)
		{
			result=result+str.charAt(str.length()-i-1);
  
		}
		System.out.println("Reverse of String:"+result);
	}
*/
	/*@PostConstruct
	public void pattern()
	{
		int a=0;
		for(int i=0;i<5;i++)
		{
			
			for(int j=0;j<i;j++)
			{
				System.out.print(a);
			}
			
		}
	}*/
	
	
	@PostConstruct
	public void stringToCharacterArray()
	{
		String str="Tesla";
		char[] ch=str.toCharArray();
		//System.out.println("String to Character Array:"+ch[1]);
	}
	
	
	@PostConstruct
	public void stringToCharacterArray1()
	{   String result="";
	char temp=' ';
		String str="Tesla";
		char[] ch=str.toCharArray();
		int n=ch.length;
		System.out.print("reverse of character   ");
		for(int i=0;i<n/2;i++)
		{
			temp=ch[i];
			ch[i]=ch[n-i-1];
			ch[n-i-1]=temp;
		 
			
			
		}
		for(int j=0;j<n;j++)
		{
			System.out.print(ch[j]);
		}
		
	}
	@PreDestroy
	public void close()
	{
		System.out.println("from destroy method");
	}
	
}
