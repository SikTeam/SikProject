package org.ict.sik.reportsign.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.common.Search;
import org.ict.sik.member.model.vo.MemberDeptPosition;
import org.ict.sik.reportsign.model.vo.ReportSign;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ReportSignDao")
public class ReportSignDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int listCount(String keyword) {
		return sqlSessionTemplate.selectOne("reportSignMapper.listCount", keyword);
	}
	
	public ArrayList<ReportSign> selectList(Search search){
		List<ReportSign> list = sqlSessionTemplate.selectList("reportSignMapper.selectList", search);
		return (ArrayList<ReportSign>)list;
	}
	
	public int insertReport(ReportSign reSign) {

		return sqlSessionTemplate.insert("reportSignMapper.insertReport", reSign);
	}
	
	public ArrayList<ReportSign> selectApproval(ReportSign reSign){
		List<ReportSign> list = sqlSessionTemplate.selectList("reportSignMapper.selectApproval", reSign);
		return (ArrayList<ReportSign>)list;
	}
	
	public int countApproval(String reportId) {
		return sqlSessionTemplate.selectOne("reportSignMapper.countApproval", reportId);
	}

	
	public int sameMemberCheck(ReportSign reSign) {
		return sqlSessionTemplate.selectOne("reportSignMapper.sameMemberCheck", reSign);
	}

}
