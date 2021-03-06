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
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=4, message="User name must be at least 4 characters")
	private String username;
	
	@Email(message="Email address must be filled!")
	private String email;
	
	@Size(min=5, message="Password must be at least 5 characters")
	private String password;
	
	@Transient
	private String passwordConfirm;
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Competition> competitions;
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Music> musics;
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Party> parties;
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Swimmer> swimmers;
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Comment> comments;
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Album> albums;
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Composer> composers;
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<TagCategory> tagCategories;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="competitions_users",
		joinColumns=@JoinColumn(name="user_id"),
		inverseJoinColumns=@JoinColumn(name="competition_id")
	)
	private List<Competition> participatedCompetitions;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public User() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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
	
	public List<Competition> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}

	public List<Music> getMusics() {
		return musics;
	}

	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}

	public List<Swimmer> getSwimmers() {
		return swimmers;
	}

	public void setSwimmers(List<Swimmer> swimmers) {
		this.swimmers = swimmers;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<Composer> getComposers() {
		return composers;
	}

	public void setComposers(List<Composer> composers) {
		this.composers = composers;
	}
	
	public List<TagCategory> getTagCategories() {
		return tagCategories;
	}

	public void setTags(List<TagCategory> tags) {
		this.tagCategories = tags;
	}

	public List<Competition> getParticipatedCompetitions() {
		return participatedCompetitions;
	}

	public void setParticipatedCompetitions(List<Competition> participatedCompetitions) {
		this.participatedCompetitions = participatedCompetitions;
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
