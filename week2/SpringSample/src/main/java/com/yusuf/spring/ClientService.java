package com.yusuf.spring;

public class ClientService {
	private static ClientService clientService = new ClientService();

	private ClientService() {
	}

	public static ClientService createInstance() {
		return clientService;
	}
}