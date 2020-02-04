package com.baina.spring.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import com.baina.spring.soap.api.service.VoterRegService;
import com.baina.spring.soap.api.voterreg.VoterDetails;
import com.baina.spring.soap.api.voterreg.VoterEnrollment;
@Endpoint
public class VoterRegisterEndpoint {

	private static final String NAMESPACE = "http://www.baina.com/spring/soap/api/voterreg";
	@Autowired
	private VoterRegService service;

	@PayloadRoot(namespace = NAMESPACE, localPart = "VoterEnrollment")
	@ResponsePayload
	public VoterDetails getLoanStatus(@RequestPayload VoterEnrollment voterReq) {
		return service.regVoter(voterReq);
	}

}
