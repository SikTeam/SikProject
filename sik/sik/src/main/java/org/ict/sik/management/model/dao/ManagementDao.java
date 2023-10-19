package org.ict.sik.management.model.dao;

import org.ict.sik.management.model.vo.Management;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("managementDao")
public class ManagementDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insertOriginRequestManage(Management management) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("manageMapper.insertOriginRequestManage", management);
	}

}
