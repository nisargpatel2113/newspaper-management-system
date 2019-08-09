package com.newspaper.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subscriptionId;

	@NotBlank(message = "Subscription days is mandatory")
	private int subscriptionDays;

	private boolean isActive;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh.mm.ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh.mm.ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	private String createdBy;

	private String updatedBy;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;

	@OneToMany(mappedBy = "subscription")
	private Set<Newspaper> newspaper;
	
	@OneToOne(mappedBy = "subscription")
	private InvoiceItem invoiceItem;

	public long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public int getSubscriptionDays() {
		return subscriptionDays;
	}

	public void setSubscriptionDays(int subscriptionDays) {
		this.subscriptionDays = subscriptionDays;
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

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Newspaper> getNewspaper() {
		return newspaper;
	}

	public void setNewspaper(Set<Newspaper> newspaper) {
		this.newspaper = newspaper;
	}

	@Override
	public String toString() {
		return "Subscription [subscriptionId=" + subscriptionId + ", subscriptionDays=" + subscriptionDays
				+ ", isActive=" + isActive + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", customer=" + customer + ", newspaper="
				+ newspaper + "]";
	}

}