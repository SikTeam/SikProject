package org.ict.sik.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.common.Paging;
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
	
	
}
