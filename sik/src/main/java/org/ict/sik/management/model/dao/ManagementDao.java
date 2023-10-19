package org.ict.sik.management.model.dao;

import org.ict.sik.management.model.vo.Management;
import org.ict.sik.request.model.vo.FranchiseeRequest;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("managementDao")
public class ManagementDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insertOriginRequestManage(Management management) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("managementMapper.insertOriginRequestManage", management);
	}

	public int selectManagementCount() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("managementMapper.selectManagementCount");
	}

	public int selectCount() {
		return sqlSessionTemplate.selectOne("managementMapper.selectCount");
	}

	public FranchiseeRequest selectManagementDetail(FranchiseeRequest fcr) {
		return sqlSessionTemplate.selectOne("requestMapper.selectManagementDetail",fcr);
	}

}
