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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="routines")
public class Routine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=5, message="Routine must be at least 5 characters long!")
	private String routineName;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="comps_routines",
		joinColumns=@JoinColumn(name="routine_id"),
		inverseJoinColumns=@JoinColumn(name="competition_id")
			)
	private List<Competition> competitions;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="competition_id")
	//private Competition competition;
	
//	@OneToMany(mappedBy="routine", fetch=FetchType.LAZY)
//	private List<Group> groups;
	
	@OneToMany(mappedBy="routine", fetch=FetchType.LAZY)
	private List<Party> parties;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Routine() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoutineName() {
		return routineName;
	}

	public void setRoutineName(String routineName) {
		this.routineName = routineName;
	}

	public List<Competition> getCompetitions() {
		return competitions;
	}
	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}
	public void addCompetition(Competition competition) {
		this.competitions.add(competition);
	}
	
	//public Competition getCompetition() {
	//	return competition;
	//}
	//public void setCompetition(Competition competition) {
	//	this.competition = competition;
	//}
	
//	public List<Group> getGroups() {
//		return groups;
//	}
//
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
