package com.baina.spring.soap.api.VoterRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baina.spring.soap.api.entity.VoterDb;


@Repository
public interface VoterRepository extends JpaRepository<VoterDb,Integer> {
	@Transactional
	@Modifying
	@Query("update VoterDb u set u.name = ?2 where u.vid = ?1")
	public void updateUserById(int id,String name);

}
