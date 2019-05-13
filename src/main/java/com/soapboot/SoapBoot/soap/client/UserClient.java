package com.soapboot.SoapBoot.soap.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.soap.peiky.client.UserLoginRequest;
import com.soap.peiky.client.UserLoginResponse;

public class UserClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(UserClient.class);

	public UserLoginResponse login(String username, String password) {
		UserLoginRequest request = new UserLoginRequest();
		request.setUsername(username);
		request.setPassword(password);

		log.info("Requesting location for login in peiky service");

		UserLoginResponse response = (UserLoginResponse) getWebServiceTemplate().marshalSendAndReceive(//
				"http://18.222.184.108:8080/ws", //
				request, //
				null//
		);

		return response;

	}
}
