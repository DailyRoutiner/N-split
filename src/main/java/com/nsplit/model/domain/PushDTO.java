package com.nsplit.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Builder
@Getter
@Setter
public class PushDTO implements Serializable{
	String content;
	int notificationno;
	int meetno;
	int memno;
	int ckNo;
	String alramtime;
}
