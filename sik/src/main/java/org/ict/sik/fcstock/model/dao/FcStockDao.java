package org.ict.sik.fcstock.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.fc.model.vo.Fc;
import org.ict.sik.fcstock.model.vo.FcStock;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("FcStockDao")
public class FcStockDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int selectListFcNameCount(String keyword) {
		return sqlSessionTemplate.selectOne("fcStockMapper.selectListFcCount", keyword);
	}

	public ArrayList<FcStock> selectListFcName(Search search) {
		List<FcStock> list = sqlSessionTemplate.selectList("fcStockMapper.selectListName",search);
		return (ArrayList<FcStock>)list;
	}

	public ArrayList<FcStock> selectList(Paging paging) {
		List<FcStock> list = sqlSessionTemplate.selectList("fcStockMapper.selectList", paging);
		return (ArrayList<FcStock>)list;
	}

	
}
