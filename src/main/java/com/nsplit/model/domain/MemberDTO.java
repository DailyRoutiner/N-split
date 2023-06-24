package com.nsplit.model.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Builder
@Getter
@Setter
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
}
