package com.nsplit.model.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;

import java.io.Serializable;


@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MemberDTO implements Serializable{
	private int memno;
	private String memname;
	private String mempw;
	private String cardpw;
	private String email;
	private String account;
	private int phonenumber;
	private String deviceid;
	private String mempic;

	public MemberDTO(String email, String mempw) {
		this.email = email;
		this.mempw = mempw;
	}

	public MemberDTO(String memname, String mempw, String email, int phonenumber) {
		this.memname = memname;
		this.mempw = mempw;
		this.email = email;
		this.phonenumber = phonenumber;
	}
}
