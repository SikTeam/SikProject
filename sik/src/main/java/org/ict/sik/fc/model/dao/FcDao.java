package org.ict.sik.fc.model.dao;

import org.ict.sik.fc.model.vo.Fc;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("fcDao")
public class FcDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int selectFcCheck(Fc fc) {
		return sqlSessionTemplate.selectOne("fc-mapper.selectFcCheck",fc);
	}

}
