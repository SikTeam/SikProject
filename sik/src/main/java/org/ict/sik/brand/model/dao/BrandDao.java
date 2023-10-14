package org.ict.sik.brand.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.brand.model.vo.Brand;
import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("brandDao")
public class BrandDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int selectListCount() {
		return sqlSessionTemplate.selectOne("brandMapper.selectBrandCount");
	}
	public int selectListNameCount(String keyword) {
		return sqlSessionTemplate.selectOne("brandMapper.selectListNameCount", keyword);
	}
	
	public ArrayList<Brand> selectList(Paging paging) {
		List<Brand> list = sqlSessionTemplate.selectList("brandMapper.selectList", paging);
		return (ArrayList<Brand>)list;
	}
	public ArrayList<Brand> selectListName(Search search) {
		List<Brand> list = sqlSessionTemplate.selectList("brandMapper.selectListName",search);
		return (ArrayList<Brand>)list;
	}
}
