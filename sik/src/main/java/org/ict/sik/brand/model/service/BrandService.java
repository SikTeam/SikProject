package org.ict.sik.brand.model.service;

import java.util.ArrayList;

import org.ict.sik.brand.model.vo.Brand;
import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;

public interface BrandService {

	public int selectListCount();
	public ArrayList<Brand> selectList(Paging paging);
	public int selectListNameCount(String keyword);
	public ArrayList<Brand> selectListName(Search search);
}
