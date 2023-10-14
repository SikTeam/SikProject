package org.ict.sik.member.model.dao;

import org.ict.sik.member.model.vo.Member;
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
	
	
}
