package org.ict.sik.fc.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.fc.model.vo.Fc;

public interface FcService {
	public int selectFcCheck(Fc fc);

	public ArrayList<Fc> selectList(Paging paging);
	
	public Fc selectLogin(Fc fc);

	public int selectListCount();

	public int selectListFcCount(String keyword);

	public ArrayList<Fc> selectFcListName(Search search);
	
}
