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
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="swimmers")
public class Swimmer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, message="First name must be at least 3 characters!")
	private String name;

	private Integer birthYear;
	
	@Column(nullable = true, length = 64)
	private String photos;
	
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User host;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="competitions_swimmers",
		joinColumns=@JoinColumn(name="swimmer_id"),
		inverseJoinColumns=@JoinColumn(name="competition_id")
			)
	private List<Competition> competitions;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nation_id")
	private Nation nation;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="musics_swimmers",
		joinColumns=@JoinColumn(name="swimmer_id"),
		inverseJoinColumns=@JoinColumn(name="music_id")
			)
	private List<Music> musics;
	
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(name="groups_swimmer",
//		joinColumns=@JoinColumn(name="swimmer_id"),
//		inverseJoinColumns=@JoinColumn(name="group_id")
//			)
//	private List<Group> groups;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="parties_swimmers",
		joinColumns=@JoinColumn(name="swimmer_id"),
		inverseJoinColumns=@JoinColumn(name="party_id")
			)
	private List<Party> parties;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="coaches_parties",
		joinColumns=@JoinColumn(name="swimmer_id"),
		inverseJoinColumns=@JoinColumn(name="party_id")
			)
	private List<Party> cParties;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="swimmers_tagCategories",
		joinColumns=@JoinColumn(name="swimmer_id"),
		inverseJoinColumns=@JoinColumn(name="tagCategory_id")
		)
	private List<TagCategory> tagCategories;
	
	@OneToMany(mappedBy="swimmer", fetch=FetchType.LAZY)
	private List<Comment> comments;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Swimmer() {
	}
	
	
	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
	
	public User getHost() {
		return host;
	}


	public void setHost(User host) {
		this.host = host;
	}


	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}


	public Integer getBirthYear() {
		return birthYear;
	}


	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Competition> getCompetitions() {
		return competitions;
	}


	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}


	public Nation getNation() {
		return nation;
	}


	public void setNation(Nation nation) {
		this.nation = nation;
	}


	public List<Music> getMusics() {
		return musics;
	}


	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}
	
	
//	public List<Group> getGroups() {
//		return groups;
//	}
//
//
//	public void setGroups(List<Group> groups) {
//		this.groups = groups;
//	}

	public List<Party> getParties() {
		return parties;
	}
	
	
	public List<TagCategory> getTagCategories() {
		return tagCategories;
	}


	public void setTagCategories(List<TagCategory> tagCategories) {
		this.tagCategories = tagCategories;
	}


	public void setParties(List<Party> parties) {
		this.parties = parties;
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
	
	@Transient
	public String getPicPath() {
		if(photos==null || id==null) {
			return "/img/avatar.png";
			//return null;
		}else {
			return "/swimmerphotos/"+id+"/"+photos;
		}
	}
	
	public List<Party> getcParties() {
		return cParties;
	}


	public void setcParties(List<Party> cParties) {
		this.cParties = cParties;
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
