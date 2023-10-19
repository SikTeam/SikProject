package org.ict.sik.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.member.model.vo.Member;
import org.ict.sik.member.model.vo.MemberDeptPosition;
import org.ict.sik.roll.model.vo.Roll;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public Member selectLogin(Member member) {
		return sqlSessionTemplate.selectOne("memberMapper.selectLogin", member);
	}

	public int selectMemberCheck(Member member) {
		return sqlSessionTemplate.selectOne("memberMapper.selectMemberCheck", member);
	}

	public ArrayList<Roll> SelectRollList(String memberId) {
		List<Roll> list = sqlSessionTemplate.selectList("memberMapper.selectRollList",memberId);
		return (ArrayList<Roll>)list;
	}
	
	public int selectlistCount() {
		return sqlSessionTemplate.selectOne("memberMapper.selectListCount");
	}

	public ArrayList<MemberDeptPosition> selectList(Paging paging){
		List<MemberDeptPosition> list = sqlSessionTemplate.selectList("memberMapper.selectListP", paging);
		return (ArrayList<MemberDeptPosition>)list;
	}
	
	public ArrayList<MemberDeptPosition> selectFullList(){
		List<MemberDeptPosition> list = sqlSessionTemplate.selectList("memberMapper.selectFullList");
		return (ArrayList<MemberDeptPosition>)list;
	}
	
	public ArrayList<MemberDeptPosition> addApprover(MemberDeptPosition dp){
		List<MemberDeptPosition> list = sqlSessionTemplate.selectList("memberMapper.addApprover", dp);
		return (ArrayList<MemberDeptPosition>)list;
	}
	
	//검색 메소드
	public int selectSearchIdCount(String keyword) {
		return sqlSessionTemplate.selectOne("memberMapper.selectSearchIdCount", keyword);
	}
	
	public int selectSearchNameCount(String keyword) {
		return sqlSessionTemplate.selectOne("memberMapper.selectSearchNameCount", keyword);
	}
	
	public int selectSearchDeptCount(String keyword) {
		return sqlSessionTemplate.selectOne("memberMapper.selectSearchDeptCount", keyword);
	}
	
	public int selectSearchPositionCount(String keyword) {
		return sqlSessionTemplate.selectOne("memberMapper.selectSearchPositionCount", keyword);
	}
	
	public int selectSearchDateCount(Search date) {
		return sqlSessionTemplate.selectOne("memberMapper.selectSearchDateCount", date);
	}
	
	public ArrayList<MemberDeptPosition> selectSearchId(Search search) {
		List<MemberDeptPosition> list = sqlSessionTemplate.selectList("memberMapper.selectSearchId", search);
		return (ArrayList<MemberDeptPosition>)list;
	}
	
	public ArrayList<MemberDeptPosition> selectSearchName(Search search) {
		List<MemberDeptPosition> list = sqlSessionTemplate.selectList("memberMapper.selectSearchName", search);
		return (ArrayList<MemberDeptPosition>)list;
	}

	public ArrayList<MemberDeptPosition> selectSearchDept(Search search) {
		List<MemberDeptPosition> list = sqlSessionTemplate.selectList("memberMapper.selectSearchDept", search);
		return (ArrayList<MemberDeptPosition>)list;
	}
	
	public ArrayList<MemberDeptPosition> selectSearchPosition(Search search) {

		List<MemberDeptPosition> list = sqlSessionTemplate.selectList("memberMapper.selectSearchPosition", search);

		return (ArrayList<MemberDeptPosition>)list;
	}

	public ArrayList<MemberDeptPosition> selectSearchDate(Search search) {

		List<MemberDeptPosition> list = sqlSessionTemplate.selectList("memberMapper.selectSearchDate", search);

		return (ArrayList<MemberDeptPosition>)list;
	}
	
	public ArrayList<MemberDeptPosition> selectApprovalList(String reportId){
		List<MemberDeptPosition> list = sqlSessionTemplate.selectList("memberMapper.selectApprovalList",reportId);
		return (ArrayList<MemberDeptPosition>)list;
	}


}
