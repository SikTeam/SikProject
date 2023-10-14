package org.ict.sik.brand.model.service;

import java.util.ArrayList;

import org.ict.sik.brand.model.dao.BrandDao;
import org.ict.sik.brand.model.vo.Brand;
import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("brandServie")
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandDao brandDao;

	@Override
	public int selectListCount() {
		return brandDao.selectListCount();
	}

	@Override
	public ArrayList<Brand> selectList(Paging paging) {
		return brandDao.selectList(paging);
	}

	@Override
	public int selectListNameCount(String keyword) {
		return brandDao.selectListNameCount(keyword);
	}

	@Override
	public ArrayList<Brand> selectListName(Search search) {
		return brandDao.selectListName(search);
	}
}
