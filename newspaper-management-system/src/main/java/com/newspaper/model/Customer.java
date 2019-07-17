package com.newspaper.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
	
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	
	@NotBlank(message = "First name is mandatory")
	private String firstName;
	
	private String middleName;
	
	@NotBlank(message = "Last name is mandatory")
	private String lastName;
	
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@Length(max = 10, min = 10)
	@NotBlank(message = "Mobile is mandatory")
	private String mobile;
	
	private String phone;
	
	private boolean isOwner;
	
	private boolean isActive;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh.mm.ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh.mm.ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	private String createdBy;
	
	private String updatedBy;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Users user;
	
	@ManyToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinTable(name = "customer_address", joinColumns = { @JoinColumn(name = "customerId") }, inverseJoinColumns = {
			@JoinColumn(name = "addressId") })
	private Set<Address> addresses;

	@ManyToMany(targetEntity = Subscription.class, cascade = CascadeType.ALL)
	@JoinTable(name = "customer_subscription", joinColumns = { @JoinColumn(name = "customerId") }, inverseJoinColumns = {
			@JoinColumn(name = "subscriptionId") })
	private Set<Subscription> subscriptions;
	
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isOwner() {
		return isOwner;
	}

	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
}
