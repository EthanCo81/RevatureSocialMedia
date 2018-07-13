package com.revaturesocialmedia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="forumpost")
public class ForumPost{
	@Id
	@Column(name="forum_id")
	@SequenceGenerator(name="forum_id_seq", sequenceName = "for_id_seq", initialValue = 1000001, allocationSize = 899999)
	@GeneratedValue(generator="forum_id_seq", strategy=GenerationType.AUTO)
	private int forumid;
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
	
	@Column(name = "question_asked")
	private String questionAsked;
	

	
	public ForumPost() {
		super();
	}
	
	

	public ForumPost(int id, String nameOfPoster, String datePosted, String questionTitle, String relevantLanguages,
			String relevantTechnologies, String description, String likes) {
		super();
		this.forumid = id;
		this.nameOfPoster = nameOfPoster;
		this.datePosted = datePosted;
		this.questionTitle = questionTitle;
		this.relevantLanguages = relevantLanguages;
		this.relevantTechnologies = relevantTechnologies;
		this.questionAsked = description;

	}



	public int getForumid() {
		return forumid;
	}



	public void setForumid(int forumid) {
		this.forumid = forumid;
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



	public String getQuestionAsked() {
		return questionAsked;
	}



	public void setQuestionAsked(String questionAsked) {
		this.questionAsked = questionAsked;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ForumPost [id=");
		builder.append(forumid);
		builder.append(", nameOfPoster=");
		builder.append(nameOfPoster);
		builder.append(", datePosted=");
		builder.append(datePosted);
		builder.append(", questionTitle=");
		builder.append(questionTitle);
		builder.append(", relevantLanguages=");
		builder.append(relevantLanguages);
		builder.append(", relevantTechnologies=");
		builder.append(relevantTechnologies);
		builder.append(", description=");
		builder.append(questionAsked);

		return builder.toString();
	}
	
	
	
}

