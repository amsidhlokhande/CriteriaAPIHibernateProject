package com.amsidh.hibernate.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity(name="userdetails")
@NamedQueries({
	@NamedQuery(name="userDetails.byNamedQuery.byUserId",query="from userdetails where userId = :userId"),
	@NamedQuery(name="userDetails.byNamedQuery.byUserName",query="from userdetails where userName = :userName")

})
@NamedNativeQueries({
	@NamedNativeQuery(name="userDetails.by@NamedNativeQuery.byUserId",query="SELECT * FROM USERDETAILS WHERE USER_ID = :user_id",resultClass=UserDetails.class),
	@NamedNativeQuery(name="userDetails.by@NamedNativeQuery.byUserName",query="SELECT * FROM USERDETAILS WHERE USER_NAME = :user_name",resultClass=UserDetails.class),

})


public class UserDetails {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(name = "USER_NAME")
	private String userName;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
