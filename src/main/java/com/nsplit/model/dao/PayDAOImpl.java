package com.nsplit.model.dao;

/*


@Repository("payDao")
public class PayDAOImpl implements PayDAO {

	@Override
	public List<PayDTO> paySelect() {
		SqlSession session = null;
		List<PayDTO> list = null;
		
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("payment.paySelect");
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	
	@Override
	public List<WebPushDTO> ResAfterSelect(int ckNo) {
		SqlSession session = null;
		List<WebPushDTO> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("webselect.ResAfterSelect",ckNo);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}
	
	@Override
	public int payUpdate(PayDTO vo) {
		SqlSession session = null;
		boolean flag = false;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.update("payment.payUpdate", vo);
			flag = result > 0 ? true : false;
		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}
	
	@Override
	public int payMeetUpdate(PayDTO vo) {
		SqlSession session = null;
		boolean flag = false;
		int result = 0;
		try {
			session = DBUtil.getSqlSession();
			result = session.update("payment.payMeetUpdate", vo);
			flag = result > 0 ? true : false;
	
		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}

	@Override
	public List<PayDTO> friendSelect(int meetno) {
		SqlSession session = null;
		List<PayDTO> list = null;
		try {
			session = DBUtil.getSqlSession();
			list = session.selectList("payment.friendSelect", meetno);
		} finally {
			DBUtil.closeSqlSession(session);
		}
		return list;
	}

	@Override
	public int insertPayment(PayDTO pd) {
		SqlSession session = DBUtil.getSqlSession();
		boolean flag = false;
		int result = 0;
		try {
			result = session.insert("payment.insertPayment",pd);	
			*/
/*flag = result > 0 ? true : false;*//*

		} finally {
			DBUtil.closeSqlSession(flag, session);
		}
		return result;
	}
	
}*/
