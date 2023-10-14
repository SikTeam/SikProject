package org.ict.sik.reportsign.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Search;
import org.ict.sik.reportsign.model.vo.ReportSign;

public interface ReportSignService {
	
	public int listCount(String kerword);
	public ArrayList<ReportSign> selectList(Search search);
}
