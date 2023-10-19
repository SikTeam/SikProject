package org.ict.sik.fcstock.model.service;

import java.util.ArrayList;

import org.ict.sik.brand.model.vo.Brand;
import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.fcstock.model.dao.FcStockDao;
import org.ict.sik.fcstock.model.vo.FcStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fcstockService")
public class FcStockServiceImpl implements FcStockService{
	
	@Autowired
	private FcStockDao fcstockDao;
	
	@Override
	public int selectListFcCount(String keyword, String searchOption) {
		return fcstockDao.selectListFcCount(keyword, searchOption);
	}
	
	
	@Override
	public ArrayList<FcStock> selectListFcName(Search search) {
		return fcstockDao.selectListFcName(search);
	}


	@Override
	public ArrayList<FcStock> selectList(Paging paging) {
		return fcstockDao.selectList(paging);
	}

}
