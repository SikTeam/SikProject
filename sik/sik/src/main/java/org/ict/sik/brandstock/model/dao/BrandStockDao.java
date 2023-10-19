package org.ict.sik.brandstock.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.brandstock.model.vo.BrandStock;
import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("BrandStockDao")
public class BrandStockDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int selectListBrandNameCount(String keyword, String searchOption) {
		return sqlSessionTemplate.selectOne("brandStockMapper.selectListBrandNameCount", keyword);
	}

	public ArrayList<BrandStock> selectListBrandName(Search search) {
		List<BrandStock> list = sqlSessionTemplate.selectList("brandStockMapper.selectListBrandName", search);
		return (ArrayList<BrandStock>)list; 
	}

	public ArrayList<BrandStock> selectList(Paging paging) {
		List<BrandStock> list = sqlSessionTemplate.selectList("brandStockMapper.selectList", paging);
		return (ArrayList<BrandStock>)list;
	}

	

}
