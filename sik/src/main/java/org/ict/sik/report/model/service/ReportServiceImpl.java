package org.ict.sik.report.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.report.model.dao.ReportDao;
import org.ict.sik.report.model.vo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("reportService")
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private ReportDao reportDao;
	
	@Override
	public ArrayList<Report> selectList(Search search){
		return reportDao.selectList(search);
	}
	
	@Override
	public String getReportId() {
		return reportDao.getReportId();
	}
	
	@Override
	public int insertReport(Report report) {
		return reportDao.insertReport(report);
	}

	@Override
	public int updateReport(Report report) {
		return reportDao.updateReport(report);
	}
}