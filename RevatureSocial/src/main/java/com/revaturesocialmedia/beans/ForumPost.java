package com.revaturesocialmedia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Forum_Post")
public class ForumPost implements User{
	@Id
	@Column(name="id_number")
	@SequenceGenerator(name="id_seq", sequenceName = "user_id_seq", initialValue = 100001, allocationSize = 899999)
	@GeneratedValue(generator="id_seq", strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "name_of_poster")
	private String nameOfPoster;
	@Column(name = "date_posted")
	private String datePosted;
	@Column(name = "question_title")
	private String questionTitle;
	@Column(name = "relevant_languages")
	private String relevantLanguages;
	@Column(name = "relevant_technologies")
	private String relevantTechnologies;
	@Column(name = "description")
	private String description;
	@Column(name = "likes")
	private String likes;
	@Column(name = "comments")
	private String comments;
	
	public ForumPost() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfPoster() {
		return nameOfPoster;
	}

	public void setNameOfPoster(String nameOfPoster) {
		this.nameOfPoster = nameOfPoster;
	}

	public String getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getRelevantLanguages() {
		return relevantLanguages;
	}

	public void setRelevantLanguages(String relevantLanguages) {
		this.relevantLanguages = relevantLanguages;
	}

	public String getRelevantTechnologies() {
		return relevantTechnologies;
	}

	public void setRelevantTechnologies(String relevantTechnologies) {
		this.relevantTechnologies = relevantTechnologies;
	}
	
}
