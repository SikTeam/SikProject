package org.ict.sik.notice.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.notice.model.vo.Notice;

public interface NoticeService {

	int selectListCount();

	ArrayList<Notice> selectList(Paging paging);

}
