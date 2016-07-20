package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="category")
@Component
public class Category {
	@Id
	private String cid;
	private String cname;
	
	
	public String getCId() {
		return cid;
	}
	public void setCId(String cid) {
		this.cid = cid;
	}
	public String getCName() {
		return cname;
	}
	public void setCName(String cname) {
		this.cname = cname;
	}

}
