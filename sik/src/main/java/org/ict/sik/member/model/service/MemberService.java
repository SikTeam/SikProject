package org.ict.sik.member.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.member.model.vo.Member;
import org.ict.sik.member.model.vo.MemberDeptPosition;
import org.ict.sik.roll.model.vo.Roll;

public interface MemberService {
	public Member selectLogin(Member member);
	public int selectMemberCheck(Member member);
	public ArrayList<Roll> selectRollList(String memberId);
	public int selectlistCount();
	public ArrayList<MemberDeptPosition> selectList(Paging paging);
	public ArrayList<MemberDeptPosition> selectFullList();
	public ArrayList<MemberDeptPosition> addApprover(MemberDeptPosition dp);
	public int selectSearchIdCount(String keyword);
	public int selectSearchNameCount(String keyword);
	public int selectSearchDeptCount(String keyword);
	public int selectSearchPositionCount(String keyword);
	public int selectSearchDateCount(Search date);
	public ArrayList<MemberDeptPosition> selectSearchId(Search search);
	public ArrayList<MemberDeptPosition> selectSearchName(Search search);
	public ArrayList<MemberDeptPosition> selectSearchDept(Search search);
	public ArrayList<MemberDeptPosition> selectSearchPosition(Search search);
	public ArrayList<MemberDeptPosition> selectSearchDate(Search search);
	public ArrayList<MemberDeptPosition> selectApprovalList(String reportId);
	public int insertMember(Member member);
	
}
