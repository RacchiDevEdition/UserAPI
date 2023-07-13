package com.UserAPI.Model;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.UserAPI.enums.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String firstName;
	private String lastName;
	private String password;
	private String nationality;
	private Integer gender;
	private String email;

	

	@JsonManagedReference
	@OneToMany(mappedBy = "creator")
	private List<Post> posts = new ArrayList<>();


	@JsonBackReference
	@OneToMany(mappedBy = "commentor")
	private List<Commentary> commentaries = new ArrayList<>();

	

	public User(Long id, String title, String firstName, String lastName, String password, String nationality,
			String email, Gender gender) {

		setGender(gender);
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.nationality = nationality;
		this.email = email;		
		
		}

	public User() {

	}

	public User(User user) {
		setGender(user.getGender());
		this.id = user.getId();
		this.title = user.getTitle();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.password = user.get_SHA_512_SecurePassword(password, "1");
		this.nationality = user.getNationality();
		this.email = user.getEmail();		
		
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

	
	public List<Post> getPosts() {	
		return posts;
	}

	public List<Commentary> getCommentaries(){
		return commentaries;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	public String get_SHA_512_SecurePassword(String password, String salt){
		  String generatedPassword = null;
		    try {
		        MessageDigest md = MessageDigest.getInstance("SHA-512");
		        md.update(salt.getBytes(StandardCharsets.UTF_8));
		        byte[] bytes = md.digest(getPassword().getBytes(StandardCharsets.UTF_8));
		        StringBuilder sb = new StringBuilder();
		        for(int i=0; i< bytes.length ;i++){
		            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		        }
		        generatedPassword = sb.toString();
		    } catch (NoSuchAlgorithmException e) {
		        e.printStackTrace();
		    }
		    return generatedPassword;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", nationality=" + nationality + ", gender=" + gender + ", email=" + email
				+ ", posts=" + posts.toArray() + "]";
	}

}
