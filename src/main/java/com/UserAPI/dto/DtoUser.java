package com.UserAPI.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.UserAPI.Model.User;
import com.UserAPI.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class DtoUser {

	private Long id;
	private String title;
	private String firstName;
	private String lastName;
	private String password;
	private String nationality;
	private Integer gender;
	private String email;

	@JsonIgnore
	private List<DtoPost> posts = new ArrayList<>();

	@JsonIgnore
	private List<DtoCommentary> commentaries = new ArrayList<>();

	public DtoUser(User user) {

		setGender(user.getGender());
		this.id = user.getId();
		this.title = user.getTitle();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.password = user.get_SHA_512_SecurePassword(password, "1");
		this.nationality = user.getNationality();
		this.email = user.getEmail();

	}

	public DtoUser() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Gender getGender() {
		return Gender.valueOf(gender);
	}

	public void setGender(Gender gender) {
		this.gender = gender.getCode();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<DtoPost> getPosts() {
		return posts;
	}

	public List<DtoCommentary> getCommentaries() {
		return commentaries;
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
		DtoUser other = (DtoUser) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "DtoUser [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", nationality=" + nationality + ", gender=" + gender + ", email=" + email
				+ ", posts=" + posts + ", commentaries=" + commentaries + "]";
	}

}
