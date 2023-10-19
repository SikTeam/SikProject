package org.ict.sik.request.service;

import java.util.ArrayList;

import org.ict.sik.request.model.dao.RequestDao;
import org.ict.sik.request.model.vo.FranchiseeRequest;
import org.ict.sik.request.model.vo.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("requestService")
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestDao requestDao;

	@Override
	public int insertOriginRequest(Request request) {
		// TODO Auto-generated method stub
		return requestDao.insertOriginRequest(request);
	}

	@Override
	public int selectListCount() {
		// TODO Auto-generated method stub
		return requestDao.selectListCount();
	}

	@Override
	public ArrayList<FranchiseeRequest> selectList() {
		return requestDao.selectList();
	}



}
