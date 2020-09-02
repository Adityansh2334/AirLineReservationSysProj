package com.air.app.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "airline_passenger")
public class AirLinePassengerDto implements Serializable {
	@Id
	@SequenceGenerator(name = "my.entity.seq", sequenceName = "PASSENGER_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my.entity.seq")
	@Column(name = "ID")
	private Long id;
	@Column(name = "Pasngr_NAME")
	private String passengerName;
	@Column(name = "Pasngr_AGE")
	private Integer passengerAge;
	@Column(name = "Pasngr_PLANE")
	private String forAirPlane;
	@Column(name = "Pasngr_TICKETNO")
	private String generatedTicketNo;
	@Column(name = "Pasngr_SEATNO")
	private String assignedSeatNo;
	@Column(name = "Pasngr_FROMROUTE")
	private String fromRoute;
	@Column(name = "Pasngr_TOROUTE")
	private String toRoute;
	@Column(name = "Pasngr_BOOKTIME")
	private Timestamp bookTime;
	@Column(name = "Pasngr_SEATPREF")
	private String seatPreference;
	@Column(name = "Pasngr_TICKETPRICE")
	private Double ticketPrice;
	@Column(name = "Pasngr_ISPAID")
	private Boolean paid;
	@Column(name = "Pasngr_TRIP")
	private String tripType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public Integer getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getForAirPlane() {
		return forAirPlane;
	}
	public void setForAirPlane(String forAirPlane) {
		this.forAirPlane = forAirPlane;
	}
	public String getGeneratedTicketNo() {
		return generatedTicketNo;
	}
	public void setGeneratedTicketNo(String generatedTicketNo) {
		this.generatedTicketNo = generatedTicketNo;
	}
	public String getAssignedSeatNo() {
		return assignedSeatNo;
	}
	public void setAssignedSeatNo(String assignedSeatNo) {
		this.assignedSeatNo = assignedSeatNo;
	}
	public String getFromRoute() {
		return fromRoute;
	}
	public void setFromRoute(String fromRoute) {
		this.fromRoute = fromRoute;
	}
	public String getToRoute() {
		return toRoute;
	}
	public void setToRoute(String toRoute) {
		this.toRoute = toRoute;
	}
	public Timestamp getBookTime() {
		return bookTime;
	}
	public void setBookTime(Timestamp bookTime) {
		this.bookTime = bookTime;
	}
	public String getSeatPreference() {
		return seatPreference;
	}
	public void setSeatPreference(String seatPreference) {
		this.seatPreference = seatPreference;
	}
	public Double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public Boolean getPaid() {
		return paid;
	}
	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	@Override
	public String toString() {
		return "AirLinePassengerDto [id=" + id + ", passengerName=" + passengerName + ", passengerAge=" + passengerAge
				+ ", forAirPlane=" + forAirPlane + ", generatedTicketNo=" + generatedTicketNo + ", assignedSeatNo="
				+ assignedSeatNo + ", fromRoute=" + fromRoute + ", toRoute=" + toRoute + ", bookTime=" + bookTime
				+ ", seatPreference=" + seatPreference + ", ticketPrice=" + ticketPrice + ", paid=" + paid
				+ ", tripType=" + tripType + "]";
	}
	
}
