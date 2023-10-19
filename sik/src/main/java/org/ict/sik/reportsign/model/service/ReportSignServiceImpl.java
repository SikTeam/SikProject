package org.ict.sik.reportsign.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.member.model.vo.MemberDeptPosition;
import org.ict.sik.reportsign.model.dao.ReportSignDao;
import org.ict.sik.reportsign.model.vo.ReportSign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("reportSignService")
public class ReportSignServiceImpl implements ReportSignService{
	
	@Autowired
	private ReportSignDao reportSignDao;
	
	@Override
	public int listCount(String keyword) {
		return reportSignDao.listCount(keyword);
	}
	
	@Override
	public ArrayList<ReportSign> selectList(Search search){
		return reportSignDao.selectList(search);
	}

	@Override
	public int insertReport(ReportSign reSign) {
		return reportSignDao.insertReport(reSign);
	}

	@Override
	public ArrayList<ReportSign> selectApproval(ReportSign reSign) {
		return reportSignDao.selectApproval(reSign);
	}

	@Override
	public int countApproval(String reportId) {
		return reportSignDao.countApproval(reportId);
	}

	@Override
	public int sameMemberCheck(ReportSign reSign) {
		return reportSignDao.sameMemberCheck(reSign);
	}
}
