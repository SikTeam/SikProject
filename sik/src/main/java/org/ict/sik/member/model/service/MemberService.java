package org.ict.sik.member.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.member.model.vo.Member;
import org.ict.sik.member.model.vo.MemberDeptPosition;
import org.ict.sik.roll.model.vo.Roll;

public interface MemberService {
	public Member selectLogin(Member member);

	public int selectMemberCheck(Member member);

	public ArrayList<Roll> selectRollList(String memberId);
	
	public int selectlistCount();
	
	public ArrayList<MemberDeptPosition> selectList(Paging paging);
}
