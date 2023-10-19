package org.ict.sik.request.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.request.model.vo.FranchiseeRequest;
import org.ict.sik.request.model.vo.Request;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("requestDao")
public class RequestDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int insertOriginRequest(Request request) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("requestMapper.insertOriginRequest", request);
	}

	public int selectListCount() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("requestMapper.selectListCount");
	}


	public ArrayList<FranchiseeRequest> selectList(String fcId) {
		List<FranchiseeRequest> list = sqlSessionTemplate.selectList("requestMapper.selectList",fcId);
		return (ArrayList<FranchiseeRequest>)list;
	}

}
