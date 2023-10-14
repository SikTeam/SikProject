package org.ict.sik.fc.model.service;

import org.ict.sik.fc.model.dao.FcDao;
import org.ict.sik.fc.model.vo.Fc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fcService")
public class FcServiceImpl implements FcService{

	@Autowired
	private FcDao fcDao;
	
	
	@Override
	public int selectFcCheck(Fc fc) {
		return fcDao.selectFcCheck(fc);
	}

}
