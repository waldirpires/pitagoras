package br.pit.sd.rmi.hello.service;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public String hello() {
		System.out.println("Received from Client a call");
		return "Hello back!";
	}

}
