package org.ict.sik.management.controller;

import javax.servlet.http.HttpServletRequest;

import org.ict.sik.management.model.service.ManagementService;
import org.ict.sik.management.model.vo.Management;
import org.ict.sik.request.model.vo.FranchiseeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManagementController {
 
	private Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@Autowired
	ManagementService managementService;
	
	
	//뷰페이지 이동 처리용 -------------------------------------
	
	//요청사항 작성 페이지 이동
	@RequestMapping(value="requestwriteform.do")
	public String moveRequestWritePage() {
		return "franchisee/fr_request/requestManageWriteForm";
	}
	
	//요청 처리용---------------------------------------------
	
	
	//요청사항 작성 
	@RequestMapping(value="requestinsert.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String insertRequestMethod (Management management, 
			Model model, HttpServletRequest hsrequest) {
		
		logger.info("requestinsert.do : " + management);
		
		if(managementService.insertOriginRequestManage(management) > 0) {
			return "redirect:rlist.do";
		} else {
			model.addAttribute("message", " 새 요청사항 등록에 실패했습니다.");
			return "common/error";
		}
				
	}
	
}
