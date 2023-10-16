package org.ict.sik.notice.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.notice.model.dao.NoticeDao;
import org.ict.sik.notice.model.vo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeserviceImpl implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public int selectListCount() {
		return noticeDao.selectListCount();
	}

	@Override
	public ArrayList<Notice> selectList(Paging paging) {
		return noticeDao.selectList(paging);
	}
}
