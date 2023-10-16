package org.ict.sik.notice.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Search;
import org.ict.sik.notice.model.vo.BrandNotice;

public interface NoticeService {

	int selectListCount();
	int selectListCount(Search search);
	ArrayList<BrandNotice> selectList(Search search);

}