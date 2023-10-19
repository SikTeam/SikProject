package org.ict.sik.member.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
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

	@Override
	public ArrayList<MemberDeptPosition> selectFullList() {
		return memberDao.selectFullList();
	}

	@Override
	public ArrayList<MemberDeptPosition> addApprover(MemberDeptPosition dp) {
		return memberDao.addApprover(dp);
	}
	
	@Override
	public int selectSearchIdCount(String keyword) {
		return memberDao.selectSearchIdCount(keyword);
	}
	
	@Override
	public int selectSearchNameCount(String keyword) {
		return memberDao.selectSearchNameCount(keyword);
	}
	
	@Override
	public int selectSearchDeptCount(String keyword) {
		return memberDao.selectSearchDeptCount(keyword);
	}
	
	@Override
	public int selectSearchPositionCount(String keyword) {
		return memberDao.selectSearchPositionCount(keyword);
	}
	
	@Override
	public int selectSearchDateCount(Search date) {
		return memberDao.selectSearchDateCount(date);
	}
	
	@Override
	public ArrayList<MemberDeptPosition> selectSearchId(Search search) {
		return memberDao.selectSearchId(search);
	}
	
	@Override
	public ArrayList<MemberDeptPosition> selectSearchName(Search search) {
		return memberDao.selectSearchName(search);
	}

	@Override
	public ArrayList<MemberDeptPosition> selectSearchDept(Search search) {
		return memberDao.selectSearchDept(search);
	}
	
	@Override
	public ArrayList<MemberDeptPosition> selectSearchPosition(Search search) {
		return memberDao.selectSearchPosition(search);
	}

	@Override
	public ArrayList<MemberDeptPosition> selectSearchDate(Search search) {
		return memberDao.selectSearchDate(search);
	}

	@Override
	public ArrayList<MemberDeptPosition> selectApprovalList(String reportId) {
		return memberDao.selectApprovalList(reportId);
	}
	
	@Override
	public int insertMember(Member member) {

		return memberDao.insertMember(member);
	}
}
