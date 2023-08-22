package com.example.day5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="hotel")
public class HotelModel {

	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int hotelid;
	    @Column(name="hotelname")
	    private String hotelname;
	    private String address;
		public int getHotelid() {
			return hotelid;
		}
		public void setHotelid(int hotelid) {
			this.hotelid = hotelid;
		}
		public String getHotelname() {
			return hotelname;
		}
		public void setHotelname(String hotelname) {
			this.hotelname = hotelname;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
	    
}

