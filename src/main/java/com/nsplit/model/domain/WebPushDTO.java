package com.nsplit.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class WebPushDTO implements Serializable{
	String memname;
	String content;
	int notificationno;
	int meetno;
	int memno;
	int ckNo;
	String alramtime;
}
