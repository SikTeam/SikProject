package org.ict.sik.report.controller;

import java.util.ArrayList;

import org.ict.sik.report.model.service.ReportService;
import org.ict.sik.report.model.vo.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController {
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	@Autowired
	private ReportService reportService;
	
	//뷰페이지
	//결재페이지 리스트
	@RequestMapping("relist.do")
	public String reportList() {
		return "report/reportList";
	}
	
	//요청 처리용
}
