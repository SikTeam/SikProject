package org.ict.sik.fc.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.fc.model.dao.FcDao;
import org.ict.sik.fc.model.vo.Fc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fcService")
public class FcServiceImpl implements FcService{

	@Autowired
	private FcDao fcDao;
	
	public FcServiceImpl() {
		super();
	}
	
	@Override
	public int selectFcCheck(Fc fc) {
		return fcDao.selectFcCheck(fc);
	}

	@Override
	public Fc selectLogin(Fc fc) {
		return fcDao.selectLogin(fc);
	}

}
