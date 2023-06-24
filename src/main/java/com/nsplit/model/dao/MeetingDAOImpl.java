package com.nsplit.model.dao;


/*

@Repository("meetingDAO")
public class MeetingDAOImpl implements MeetingDAO {

	@Override
	public int insertPay(PayDTO payDTO) {
		SqlSession session = null;
		boolean flag = false;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			System.out.println("price : "+ payDTO.getPrice() + "totalfee : " +payDTO.getTotalfee() + "meetno" + payDTO.getMeetno());
			//모임에서 각 멤버에게 회비를 할당해 주어야 한다.( 필요한 값 : meetno)
			result = session.update("payment.priceUpdate", payDTO);
			result = session.update("payment.totalfeeUpdate", payDTO);
			flag = result > 0 ? true : false;
		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}

	@Override
	public int insertMeeting(MeetingDTO meetingDTO) {
		SqlSession session = DBUtil.getSqlSession();
		System.out.println(meetingDTO);
		int result = 0;
		boolean flag = false;
		try {
			result = session.insert("MEETING.insertMeeting", meetingDTO);
			flag = result >0 ? true : false;
		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}

	@Override
	public List<MeetingDTO> meetingList(int memno) {
		SqlSession session = DBUtil.getSqlSession();
		List<MeetingDTO> spendList = null;
		try {
			spendList = session.selectList("MEETING.meetingList", memno);
		} finally {
			session.close();
		}
		return spendList;
	}
}
*/
