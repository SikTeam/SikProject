package org.ict.sik.request.service;

import java.util.ArrayList;

import org.ict.sik.request.model.vo.FranchiseeRequest;
import org.ict.sik.request.model.vo.Request;

public interface RequestService {

	int insertOriginRequest(Request request);

	int selectListCount();

	ArrayList<FranchiseeRequest> selectList();
	
//	ArrayList<Request> selectList(Paging paging);

}
