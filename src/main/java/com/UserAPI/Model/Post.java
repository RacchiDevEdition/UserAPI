package com.UserAPI.Model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;

import com.UserAPI.dto.DtoPost;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_post")
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "creator_id")
	private User creator;
	private String content;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant creationTime;

	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "post")
	private List<Commentary> comments = new ArrayList<>();
	
	
	public Post(Long id, User creator, String content, Instant creationTime) {
		this.id = id;
		this.creator = creator;
		this.content = content;
		this.creationTime = creationTime;

	}

	public Post() {

	}

	public Post(DtoPost post) {

		this.id = post.getId();
		this.creator = new User(post.getCreator());
		this.content = post.getContent();
		this.creationTime = post.getCreationTime();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Instant getCreationTime() {
		return creationTime;
	}

	public List<Commentary> getComments() {
		return comments;
	}

	public void setCreationTime(Instant creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", creator=" + creator.getFirstName() + ", content=" + content + ", creationTime="
				+ creationTime + "]";
	}

}
