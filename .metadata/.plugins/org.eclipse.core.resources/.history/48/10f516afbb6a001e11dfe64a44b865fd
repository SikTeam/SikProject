package org.ict.sik.report.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.common.Paging;
import org.ict.sik.report.model.vo.Report;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("reportDao")
public class ReportDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public ArrayList<Report> selectList(String keyword) {
		List<Report> list = sqlSessionTemplate.selectList("reportMapper.selectList", keyword);
		return (ArrayList<Report>)list;
	}
}
