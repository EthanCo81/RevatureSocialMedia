package com.revaturesocialmedia.beans;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="answer")
public class Answer {
	@Id
	@Column(name="id_number")
	@SequenceGenerator(name="answer_id_seq", sequenceName = "ans_id_seq", initialValue = 1000001, allocationSize = 899999)
	@GeneratedValue(generator="answer_id_seq", strategy=GenerationType.AUTO)
	private int answerid;
	@Column(name="answer")
	private String answer;
	@Column(name="name")
	private String name;
	@Column(name="date_answered")
	private LocalDateTime dateAnswered;
	@Column(name="forum_post_id")
	private int forumPostId;
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(int answerid, String answer, String name, LocalDateTime dateAnswered, int forumPostId) {
		super();
		this.answerid = answerid;
		this.answer = answer;
		this.name = name;
		this.dateAnswered = dateAnswered;
		this.forumPostId = forumPostId;
	}
	public int getAnswerid() {
		return answerid;
	}
	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getDateAnswered() {
		return dateAnswered;
	}
	public void setDateAnswered(LocalDateTime dateAnswered) {
		this.dateAnswered = dateAnswered;
	}
	public int getForumPostId() {
		return forumPostId;
	}
	public void setForumPostId(int forumPostId) {
		this.forumPostId = forumPostId;
	}
	
	
}
