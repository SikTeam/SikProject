package org.ict.sik.notice.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.notice.model.vo.BrandNotice;

public interface NoticeService {

	int selectListCount();

	ArrayList<BrandNotice> selectList(Paging paging);

}