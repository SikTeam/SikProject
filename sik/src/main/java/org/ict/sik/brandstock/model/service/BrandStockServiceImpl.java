package org.ict.sik.brandstock.model.service;

import java.util.ArrayList;

import org.ict.sik.brandstock.model.dao.BrandStockDao;
import org.ict.sik.brandstock.model.vo.BrandStock;
import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("brandstockService")
public class BrandStockServiceImpl implements BrandStockService{
	
	@Autowired
	private BrandStockDao brandstockDao;
	
	@Override
	public int selectListBrandNameCount(String keyword, String searchOption) {
		return brandstockDao.selectListBrandNameCount(keyword, searchOption);
	}
	
	@Override
	public ArrayList<BrandStock> selectListBrandName(Search search) {
		return brandstockDao.selectListBrandName(search);
	}

	@Override
	public ArrayList<BrandStock> selectList(Paging paging) {
		return brandstockDao.selectList(paging);
	}

}
