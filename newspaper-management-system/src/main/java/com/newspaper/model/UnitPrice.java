package com.newspaper.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class UnitPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long unitPriceId;

	@Column(name = "monday_price")
	private double monday;

	@Column(name = "tuesday_price")
	private double tuesday;

	@Column(name = "wednesday_price")
	private double wednesday;

	@Column(name = "thrusday_price")
	private double thrusday;

	@Column(name = "friday_price")
	private double friday;

	@Column(name = "saturday_price")
	private double saturday;

	@Column(name = "sunday_price")
	private double sunday;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh.mm.ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh.mm.ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	private String createdBy;

	private String updatedBy;

	@OneToOne(mappedBy = "unitPrice", cascade = CascadeType.ALL)
	private Newspaper newspaper;

	public long getUnitPriceId() {
		return unitPriceId;
	}

	public void setUnitPriceId(long unitPriceId) {
		this.unitPriceId = unitPriceId;
	}

	public double getMonday() {
		return monday;
	}

	public void setMonday(double monday) {
		this.monday = monday;
	}

	public double getTuesday() {
		return tuesday;
	}

	public void setTuesday(double tuesday) {
		this.tuesday = tuesday;
	}

	public double getWednesday() {
		return wednesday;
	}

	public void setWednesday(double wednesday) {
		this.wednesday = wednesday;
	}

	public double getThrusday() {
		return thrusday;
	}

	public void setThrusday(double thrusday) {
		this.thrusday = thrusday;
	}

	public double getFriday() {
		return friday;
	}

	public void setFriday(double friday) {
		this.friday = friday;
	}

	public double getSaturday() {
		return saturday;
	}

	public void setSaturday(double saturday) {
		this.saturday = saturday;
	}

	public double getSunday() {
		return sunday;
	}

	public void setSunday(double sunday) {
		this.sunday = sunday;
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

	public Newspaper getNewspaper() {
		return newspaper;
	}

	public void setNewspaper(Newspaper newspaper) {
		this.newspaper = newspaper;
	}

	@Override
	public String toString() {
		return "UnitPrice [unitPriceId=" + unitPriceId + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday="
				+ wednesday + ", thrusday=" + thrusday + ", friday=" + friday + ", saturday=" + saturday + ", sunday="
				+ sunday + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", newspaper=" + newspaper + "]";
	}

}
