package com.baina.spring.soap.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baina.spring.soap.api.entity.ApVoter;
import com.baina.spring.soap.api.entity.TelanganaVoter;
import com.baina.spring.soap.api.entity.VoterDb;
import com.baina.spring.soap.api.service.VoterRegService;
import com.baina.spring.soap.api.voterreg.VoterDetails;

@SpringBootApplication
@RestController
public class EmpSoap2Application {

	@Autowired
	VoterRegService service;

	public static void main(String[] args) {
		SpringApplication.run(EmpSoap2Application.class, args);
	}

	@GetMapping("/voterlist")
	public List<VoterDb> getAllVoters() {
		return service.getVoterList();
	}

	@GetMapping("/voter/{id}")
	public ResponseEntity<VoterDb> getVoterById(@PathVariable int id) {
		return new ResponseEntity<VoterDb>(service.getVoterById(id), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public String updateVoter(@PathVariable int id) {
		service.getUpdatedVoter(id);
		return "updated successfully";
	}

	@PostMapping("/tg/save")
	public VoterDetails saveTGVoter(@RequestBody TelanganaVoter tgvoter) {
		System.out.println(tgvoter+"********");
		return service.storeTgVoter(tgvoter);

	}

	@PostMapping("/ap/save")
	public VoterDetails saveAPVoter(@RequestBody ApVoter apvoter) {
		System.out.println(apvoter+"********");
		return service.storeApVoter(apvoter);
		
	}

}
