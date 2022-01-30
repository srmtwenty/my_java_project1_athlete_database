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
@Table(name="competitions")
public class Competition {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=6, message="Must be at least 6 characters!")
	private String name;
	
	private String description;

	private String location;
	
	private int year;
	
	private String eventType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User host;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="competitions_users",
		joinColumns=@JoinColumn(name="competition_id"),
		inverseJoinColumns=@JoinColumn(name="user_id")
	)
	private List<User> attendees;
	
	//@ManyToMany(fetch=FetchType.LAZY)
	//@JoinTable(name="competitions_swimmers",
	//		joinColumns=@JoinColumn(name="competition_id"),
	//		inverseJoinColumns=@JoinColumn(name="swimmer_id")
	//			)
	//private List<Swimmer> participatedSwimmers;
	
	//@ManyToMany(fetch=FetchType.LAZY)
	//@JoinTable(name="comps_nations",
	//joinColumns=@JoinColumn(name="competition_id"),
	//inverseJoinColumns=@JoinColumn(name="nation_id")
	//	)
	//private List<Nation> participatedNations;
	
	
	//@ManyToMany(fetch=FetchType.LAZY)
	//@JoinTable(name="comps_routines",
	//	joinColumns=@JoinColumn(name="competition_id"),
	//	inverseJoinColumns=@JoinColumn(name="routine_id")
	//		)
	//private List<Routine> routines;
	
	//@OneToMany(mappedBy="competition", fetch=FetchType.LAZY)
	//private Routine routine;
	@OneToMany(mappedBy="competition", fetch=FetchType.LAZY)
	private List<Party> parties;
	
	@OneToMany(mappedBy="competition", fetch=FetchType.LAZY)
	private List<Comment> comments;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Competition() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	//public List<Swimmer> getParticipatedSwimmers() {
	//	return participatedSwimmers;
	//}
	//public void setParticipatedSwimmers(List<Swimmer> participatedSwimmers) {
	//	this.participatedSwimmers = participatedSwimmers;
	//}

	//public List<Nation> getParticipatedNations() {
	//	return participatedNations;
	//}

	//public void setParticipatedNations(List<Nation> participatedNations) {
	//	this.participatedNations = participatedNations;
	//}
	
	//public List<Routine> getRoutines() {
	//	return routines;
	//}

	//public void setRoutines(List<Routine> routines) {
	//	this.routines = routines;
	//}
	
	//public void addRoutine(Routine routine) {
	//	this.routines.add(routine);
	//}
	//public void removeRoutine(Routine routine) {
	//	this.routines.remove(routine);
	//}
		
		
	//public Routine getRoutine() {
	//	return routine;
	//}
	//public void setRoutine(Routine routine) {
	//	this.routine = routine;
	//}
	
	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}
	
	public void addParty(Party party) {
		this.parties.add(party);
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public List<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
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
