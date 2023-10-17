package org.ict.sik.fcstock.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.fc.model.vo.Fc;
import org.ict.sik.fcstock.model.vo.FcStock;

public interface FcStockService {
	public int selectListFcNameCount(String keyword);
	
	public ArrayList<FcStock> selectListFcName(Search search);

	public ArrayList<FcStock> selectList(Paging paging);
}
