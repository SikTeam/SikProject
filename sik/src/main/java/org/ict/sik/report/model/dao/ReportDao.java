package org.ict.sik.report.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.common.Search;
import org.ict.sik.report.model.vo.Report;
import org.ict.sik.reportsign.model.vo.ReportSign;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("reportDao")
public class ReportDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public ArrayList<Report> selectList(Search search) {
		List<Report> list = sqlSessionTemplate.selectList("reportMapper.selectList", search);
		return (ArrayList<Report>)list;
	}
	
	public String getReportId() {
		return sqlSessionTemplate.selectOne("reportMapper.getReportId");
	}
	
	public int insertReport(Report report){
		return sqlSessionTemplate.insert("reportMapper.insertReport", report);
	}

	public int selectMyReportCount(String memberId) {
		return sqlSessionTemplate.selectOne("reportSignMapper.selectMyReportCount",memberId);
	}
	
	public int updateReport(Report report) {
		return sqlSessionTemplate.update("reportMapper.updateReport", report);
	}
}
