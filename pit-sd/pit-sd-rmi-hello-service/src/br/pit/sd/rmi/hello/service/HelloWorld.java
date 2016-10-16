package br.pit.sd.rmi.hello.service;

import java.rmi.Remote;

public interface HelloWorld extends Remote{

	public String hello();
	
}
