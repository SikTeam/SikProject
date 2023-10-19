package org.ict.sik.notice.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Search;
import org.ict.sik.notice.model.vo.BrandNotice;

import org.ict.sik.notice.model.vo.Notice;


public interface NoticeService {

	int selectListCount();
	int selectListCount(Search search);
	ArrayList<BrandNotice> selectList(Search search);
	BrandNotice selectDetail(String noId);
	int updateAddReadCount(String noId);

	int insertNotice(Notice notice);

}