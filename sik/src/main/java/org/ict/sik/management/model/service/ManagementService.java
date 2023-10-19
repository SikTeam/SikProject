package org.ict.sik.management.model.service;

import org.ict.sik.management.model.vo.Management;

import org.ict.sik.request.model.vo.FranchiseeRequest;


public interface ManagementService {

	int insertOriginRequestManage(Management management);

	int selectManagementCount();

	int selectCount();

	FranchiseeRequest selectManagementDetail(FranchiseeRequest fcr);

}
