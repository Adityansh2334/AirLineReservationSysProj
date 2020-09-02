package com.air.app.dto;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="authorization_customers")
public class AuthorizationDto implements Serializable{
		@Id
		@Column(name="ID")
		private Integer id;
		@Column(name="AirLine_PAYID")
		private String payId;
		@Column(name="AirLine_USERNAME")
		private String userName;
		@Column(name="User_NAME")
		private String name;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getPayId() {
			return payId;
		}
		public void setPayId(String payId) {
			this.payId = payId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "AuthorizationDto [id=" + id + ", payId=" + payId + ", userName=" + userName + ", name=" + name
					+ "]";
		}
}
