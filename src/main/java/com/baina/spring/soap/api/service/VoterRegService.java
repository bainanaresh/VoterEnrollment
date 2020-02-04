package com.baina.spring.soap.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baina.spring.soap.api.VoterRepository.ApVoterRepository;
import com.baina.spring.soap.api.VoterRepository.TelanganaVoterRepository;
import com.baina.spring.soap.api.VoterRepository.VoterRepository;
import com.baina.spring.soap.api.entity.ApVoter;
import com.baina.spring.soap.api.entity.ApVoterDb;
import com.baina.spring.soap.api.entity.TelanganaVoter;
import com.baina.spring.soap.api.entity.TelanganaVoterDb;
import com.baina.spring.soap.api.entity.VoterDb;
import com.baina.spring.soap.api.voterreg.VoterDetails;
import com.baina.spring.soap.api.voterreg.VoterEnrollment;

@Service
public class VoterRegService {
	@Autowired
	private VoterRepository repository;
	
	@Autowired
	private TelanganaVoterRepository tgRepo;
	
	@Autowired
	private ApVoterRepository apRepo;
	
	public VoterDetails regVoter(VoterEnrollment voter) {
		
	VoterDb vdb=new VoterDb();
	vdb.setAge(voter.getAge());
	vdb.setName(voter.getName());
	vdb.setState(voter.getState());
	vdb.setZipcode(voter.getZipcode());
	VoterDb vote=repository.save(vdb);
	
	VoterDetails vdr=new VoterDetails();
	
	vdr.setId(vote.getVid());
	vdr.setAge(vote.getAge());
	vdr.setName(vote.getName());
	vdr.setState(vote.getState());
	vdr.setZipcode(vote.getZipcode());
	vdr.setResults("voter data stored successfully");
	
	return vdr;
	
	}
	
	
	public List<VoterDb> getVoterList(){
		return repository.findAll();
	}


	public void getUpdatedVoter(int id) {
		VoterDb vdb=repository.getOne(id);
		String name=vdb.getName()+"11";
	    repository.updateUserById(id, name);
		
	}


	public VoterDb getVoterById(int id) {
		
		return repository.getOne(id);
	}


	public VoterDetails storeTgVoter(TelanganaVoter tgvoter) {
		TelanganaVoterDb tdb=new TelanganaVoterDb();
		tdb.setVid(tgvoter.getVid());
		tdb.setName(tgvoter.getName());
		tdb.setAge(tgvoter.getAge());
		tdb.setZipcode(tgvoter.getZipcode());
		tdb.setState(tgvoter.getState());
		
		TelanganaVoterDb vote=tgRepo.save(tdb);
		
		VoterDetails vdr=new VoterDetails();
		
		vdr.setId(vote.getVid());
		vdr.setAge(vote.getAge());
		vdr.setName(vote.getName());
		vdr.setState(vote.getState());
		vdr.setZipcode(vote.getZipcode());
		vdr.setResults("voter data stored  in telangana db successfully");
		
		return vdr;
		
		
	}


	public VoterDetails storeApVoter(ApVoter apvoter) {

		ApVoterDb tdb=new ApVoterDb();
		tdb.setVid(apvoter.getVid());
		tdb.setName(apvoter.getName());
		tdb.setAge(apvoter.getAge());
		tdb.setZipcode(apvoter.getZipcode());
		tdb.setState(apvoter.getState());
		
		ApVoterDb vote=apRepo.save(tdb);
		
		VoterDetails vdr=new VoterDetails();
		
		vdr.setId(vote.getVid());
		vdr.setAge(vote.getAge());
		vdr.setName(vote.getName());
		vdr.setState(vote.getState());
		vdr.setZipcode(vote.getZipcode());
		vdr.setResults("voter data stored  in ap db successfully");
		
		return vdr;
		
		
	
		
	}

}
