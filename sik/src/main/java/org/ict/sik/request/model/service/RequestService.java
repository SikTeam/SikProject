package org.ict.sik.request.model.service;

import java.util.ArrayList;

import org.ict.sik.request.model.vo.FranchiseeRequest;
import org.ict.sik.request.model.vo.Request;

public interface RequestService {

	int insertOriginRequest(Request request);

	int selectListCount();

	ArrayList<FranchiseeRequest> selectList(String fcId);
	
//	ArrayList<Request> selectList(Paging paging);

}
