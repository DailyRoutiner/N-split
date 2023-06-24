package com.nsplit.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class MeetingDTO implements Serializable {
	private int meetingType;
	private int meetNo ;
	private String meetName ;
	private String place ;
	private String meetDate ;
	private int totalfee ;
	private int manageNo ;
	private int memNo;

	public MeetingDTO(int meetingType, String meetName, String place,
			String meetDate, int manageNo) {
		super();
		this.meetingType = meetingType;
		this.meetName = meetName;
		this.place = place;
		this.meetDate = meetDate;
		this.manageNo = manageNo;
	}
}

