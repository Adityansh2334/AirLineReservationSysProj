package com.air.app.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "airline_planes")
public class AirLineDto  implements Serializable{
		 @Id
		 @SequenceGenerator(name = "my.entity.seq", sequenceName = "plane_sequence")
		 @GeneratedValue(strategy = GenerationType.AUTO, generator = "my.entity.seq")
		 @Column(name = "ID")
		 private Long id;
		 @Column(name = "Air_NAME")
		 private String airName;
		 @Column(name = "Air_COMPANY")
		 private String airCompany;
		 @Column(name = "Air_ROUTE")
		 private String airRoute;
		 @Column(name = "Air_STRENGTH")
		 private Long totalSeatStrength;
		 @Column(name = "Air_FIRSTCLASS")
		 private Integer firstClassSeats;
		 @Column(name = "Air_ECONOMY")
		 private Integer economySeats;
		 @Column(name = "Air_FIRSTCLASSPRICE")
		 private Double firstClassPrice;
		 @Column(name = "Air_ECONOMYPRICE")
		 private Double economyPrice;
		 @Column(name = "Air_REGISTRATION")
		 private String airRegistrationNo;
		 @Column(name = "Air_STAFFS")
		 private Integer airStaffsCount;
		 @Column(name = "Air_TYPE")
		 private String airType;
		 public AirLineDto() {
			// TODO Auto-generated constructor stub
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getAirName() {
			return airName;
		}
		public void setAirName(String airName) {
			this.airName = airName;
		}
		public String getAirCompany() {
			return airCompany;
		}
		public void setAirCompany(String airCompany) {
			this.airCompany = airCompany;
		}
		public String getAirRoute() {
			return airRoute;
		}
		public void setAirRoute(String airRoute) {
			this.airRoute = airRoute;
		}
		public String getAirRegistrationNo() {
			return airRegistrationNo;
		}
		public void setAirRegistrationNo(String airRegistrationNo) {
			this.airRegistrationNo = airRegistrationNo;
		}
		public Integer getAirStaffsCount() {
			return airStaffsCount;
		}
		public void setAirStaffsCount(Integer airStaffsCount) {
			this.airStaffsCount = airStaffsCount;
		}
		public String getAirType() {
			return airType;
		}
		public void setAirType(String airType) {
			this.airType = airType;
		}
		public Long getTotalSeatStrength() {
			return totalSeatStrength;
		}
		public void setTotalSeatStrength(Long totalSeatStrength) {
			this.totalSeatStrength = totalSeatStrength;
		}
		public Integer getFirstClassSeats() {
			return firstClassSeats;
		}
		public void setFirstClassSeats(Integer firstClassSeats) {
			this.firstClassSeats = firstClassSeats;
		}
		public Integer getEconomySeats() {
			return economySeats;
		}
		public void setEconomySeats(Integer economySeats) {
			this.economySeats = economySeats;
		}
		public Double getFirstClassPrice() {
			return firstClassPrice;
		}
		public void setFirstClassPrice(Double firstClassPrice) {
			this.firstClassPrice = firstClassPrice;
		}
		public Double getEconomyPrice() {
			return economyPrice;
		}
		public void setEconomyPrice(Double economyPrice) {
			this.economyPrice = economyPrice;
		}
		@Override
		public String toString() {
			return "AirLineDto [id=" + id + ", airName=" + airName + ", airCompany=" + airCompany + ", airRoute="
					+ airRoute + ", totalSeatStrength=" + totalSeatStrength + ", firstClassSeats=" + firstClassSeats
					+ ", economySeats=" + economySeats + ", firstClassPrice=" + firstClassPrice + ", economyPrice="
					+ economyPrice + ", airRegistrationNo=" + airRegistrationNo + ", airStaffsCount=" + airStaffsCount
					+ ", airType=" + airType + "]";
		}
		
		
		 
}
