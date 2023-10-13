package org.ict.sik.member.model.service;

import org.ict.sik.member.model.dao.MemberDao;
import org.ict.sik.member.model.vo.Member;
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

}
