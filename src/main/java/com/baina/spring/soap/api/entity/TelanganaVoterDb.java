package com.baina.spring.soap.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="telangana")
public class TelanganaVoterDb {
	@Id
    private int vid;
	
	private String name;
	
	private int age;
	
	private String state;
	
	private String zipcode;

}
