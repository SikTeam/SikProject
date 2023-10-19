package org.ict.sik.brandstock.model.service;

import java.util.ArrayList;

import org.ict.sik.brandstock.model.vo.BrandStock;
import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;

public interface BrandStockService {

	public int selectListBrandNameCount(String keyword, String searchOption);

	public ArrayList<BrandStock> selectListBrandName(Search search);

	public ArrayList<BrandStock> selectList(Paging paging);


}
