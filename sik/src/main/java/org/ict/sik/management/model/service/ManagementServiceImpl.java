package org.ict.sik.management.model.service;

import org.ict.sik.management.model.dao.ManagementDao;
import org.ict.sik.management.model.vo.Management;
import org.ict.sik.request.model.vo.FranchiseeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("managementService")
public class ManagementServiceImpl  implements ManagementService {

	@Autowired
	private ManagementDao managementDao;
	
	@Override
	public int insertOriginRequestManage(Management management) {
		// TODO Auto-generated method stub
		return managementDao.insertOriginRequestManage(management);
	}

	@Override
	public int selectManagementCount() {
		// TODO Auto-generated method stub
		return managementDao.selectManagementCount();
	}


	@Override
	public int selectCount() {
		return managementDao.selectCount();
	}

	@Override
	public FranchiseeRequest selectManagementDetail(FranchiseeRequest fcr) {
		return managementDao.selectManagementDetail(fcr);
	}

}
