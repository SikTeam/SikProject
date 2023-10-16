package org.ict.sik.member.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.member.model.dao.MemberDao;
import org.ict.sik.member.model.vo.Member;
import org.ict.sik.member.model.vo.MemberDeptPosition;
import org.ict.sik.roll.model.vo.Roll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member selectLogin(Member member) {
		return memberDao.selectLogin(member);
	}

	@Override
	public int selectMemberCheck(Member member) {
		return memberDao.selectMemberCheck(member);
	}

	@Override
	public ArrayList<Roll> selectRollList(String memberId) {
		return memberDao.SelectRollList(memberId);
	}
	
	@Override
	public int selectlistCount() {
		return memberDao.selectlistCount();
	}

	@Override
	public ArrayList<MemberDeptPosition> selectList(Paging paging){
		return memberDao.selectList(paging);
	}
	
}
