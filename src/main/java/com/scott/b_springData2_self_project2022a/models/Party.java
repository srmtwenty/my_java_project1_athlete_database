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
@Table(name="parties")
public class Party {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=5, message="Group name must be at least 5 characters long!")
	private String partyName;
	
	private String description;
	
	private double score;
	
	private String ranking;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="routine_id")
	private Routine routine;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nation_id")
	private Nation nation;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="parties_swimmers",
		joinColumns=@JoinColumn(name="party_id"),
		inverseJoinColumns=@JoinColumn(name="swimmer_id")
			)
	private List<Swimmer> swimmers;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="musics_parties",
		joinColumns=@JoinColumn(name="party_id"),
		inverseJoinColumns=@JoinColumn(name="music_id")
			)
	private List<Music> musics;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="competition_id")
	private Competition competition;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User host;
	
	@OneToMany(mappedBy="party", fetch=FetchType.LAZY)
	private List<Comment> comments;
	
	private String coach;
	
	public Party() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
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

	public Routine getRoutine() {
		return routine;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	public List<Swimmer> getSwimmers() {
		return swimmers;
	}

	public void setSwimmers(List<Swimmer> swimmers) {
		this.swimmers = swimmers;
	}

	public List<Music> getMusics() {
		return musics;
	}

	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void removeSwimmer(Swimmer swimmer) {
		this.swimmers.remove(swimmer);
	}
	
	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}
	
	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
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
