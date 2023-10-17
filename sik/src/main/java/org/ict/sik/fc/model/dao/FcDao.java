package org.ict.sik.fc.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.brand.model.vo.Brand;
import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.fc.model.vo.Fc;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("fcDao")
public class FcDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int selectFcCheck(Fc fc) {
		return sqlSessionTemplate.selectOne("fcMapper.selectFcCheck",fc);
	}

	public Fc selectLogin(Fc fc) {
		return sqlSessionTemplate.selectOne("fcMapper.selectLogin",fc);
	}
}

