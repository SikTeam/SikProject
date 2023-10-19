package org.ict.sik.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.ict.sik.member.model.vo.Member;
import org.ict.sik.report.model.service.ReportServiceImpl;
import org.ict.sik.roll.model.vo.Roll;


public class AuthorityCheck {
	
	
	public static Map<String,String> Authority(Member member, String boardName,ArrayList<Roll> rollList) {
		//ArrayList<Roll> rollList = memberService.selectRollList(member.getMemberId());
		Map<String, String> rollMap = new HashMap<String, String>();
		if(member.getAdminYn().equals("Y")) {
			Roll adminRoll = new Roll();
			adminRoll.setRoll("admin1111");
			rollList.add(adminRoll);
		}

		for(int i = 0; i < rollList.size(); i++) {
			String roll = new Roll(rollList.get(i)).getRoll();
			String board = roll.substring(0, roll.length()-4);
			if(boardName.equals(board)) {
				String rollNum = roll.substring(roll.length()-4,roll.length());
				// CRUD 권한 순서
				rollMap.put("Create", rollNum.substring(0, 1).equals("1") ? "Y" : "N");
				rollMap.put("Select", rollNum.substring(1, 2).equals("1") ? "Y" : "N");
				rollMap.put("Update", rollNum.substring(2, 3).equals("1") ? "Y" : "N");
				rollMap.put("Delete", rollNum.substring(3, 4).equals("1") ? "Y" : "N");

				return rollMap;
			}
		}
		return null;
	}
	

}