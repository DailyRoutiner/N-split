package com.nsplit.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Builder
@Getter
@Setter
public class PayDTO implements Serializable{
	String memName;
	String memPw;
	String email;
	String account;
	String phoneNumber;
	String carPw;
	String memPic;
	int payCheck;
	int price;
	int memno;
	int totalfee;
	int meetno;
	int meetingType;
	String deviceId;

	public PayDTO(int memno, int meetno) {
		super();
		this.memno = memno;
		this.meetno = meetno;
	}
	public PayDTO(int price2, int totalfee2, int meetno2) {
		this.meetno = meetno2;
		this.price = price2;
		this.totalfee = totalfee2;
	}
}
