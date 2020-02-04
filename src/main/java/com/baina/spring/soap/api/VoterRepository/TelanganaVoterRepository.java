package com.baina.spring.soap.api.VoterRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baina.spring.soap.api.entity.TelanganaVoterDb;
import com.baina.spring.soap.api.entity.VoterDb;

@Repository
public interface TelanganaVoterRepository extends JpaRepository<TelanganaVoterDb,Integer> {

}
