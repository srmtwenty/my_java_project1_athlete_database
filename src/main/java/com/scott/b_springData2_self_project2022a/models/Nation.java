package com.scott.b_springData2_self_project2022a.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="nations")
public class Nation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, message="Name has to be at least 2 characters!")
	private String name;
	
	@OneToMany(mappedBy="nation", fetch=FetchType.LAZY)
	private List<Swimmer> swimmers;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//@ManyToMany(fetch=FetchType.LAZY)
	//@JoinTable(name="comps_nations",
	//	joinColumns=@JoinColumn(name="nation_id"),
	//	inverseJoinColumns=@JoinColumn(name="competition_id")
	//		)
	//private List<Competition> participatedComps;
	
//	@OneToMany(mappedBy="nation", fetch=FetchType.LAZY)
//	private List<Group> groups;
	
	@OneToMany(mappedBy="nation", fetch=FetchType.LAZY)
	private List<Party> parties;
	
	public Nation() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Swimmer> getSwimmers() {
		return swimmers;
	}

	public void setSwimmers(List<Swimmer> swimmers) {
		this.swimmers = swimmers;
	}
	
	//public List<Competition> getParticipatedComps() {
	//	return participatedComps;
	//}

	//public void setParticipatedComps(List<Competition> participatedComps) {
	//	this.participatedComps = participatedComps;
	//}

//	public List<Group> getGroups() {
//		return groups;
//	}
//
//	public void setGroups(List<Group> groups) {
//		this.groups = groups;
//	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}

	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
}
