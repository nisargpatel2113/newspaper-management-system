/**
 * 
 */
package com.newspaper.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author tarkhand
 *
 */

@Entity
public class Newspaper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "newspaper_id")
	private long newspaperId;

	@Column(name = "newspaper_name")
	@NotBlank(message = "Newspaper name is mandatory.")
	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh.mm.ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh.mm.ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "is_active")
	private boolean isActive;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "newspaper_type_id")
	private NewspaperType newspaperType;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "unit_price_id")
	private UnitPrice unitPrice;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subscriptionId")
	private Subscription subscription;

	public long getNewspaperId() {
		return newspaperId;
	}

	public void setNewspaperId(long newspaperId) {
		this.newspaperId = newspaperId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public NewspaperType getNewspaperType() {
		return newspaperType;
	}

	public void setNewspaperType(NewspaperType newspaperType) {
		this.newspaperType = newspaperType;
	}

	public UnitPrice getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(UnitPrice unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	@Override
	public String toString() {
		return "Newspaper [newspaperId=" + newspaperId + ", name=" + name + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", isActive=" + isActive + ", newspaperType=" + newspaperType + ", unitPrice=" + unitPrice
				+ ", subscription=" + subscription + "]";
	}

}
