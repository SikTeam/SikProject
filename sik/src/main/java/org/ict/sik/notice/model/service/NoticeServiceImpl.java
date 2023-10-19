package org.ict.sik.notice.model.service;

import java.util.ArrayList;

import org.ict.sik.common.Search;
import org.ict.sik.notice.model.dao.NoticeDao;
import org.ict.sik.notice.model.vo.BrandNotice;

import org.ict.sik.notice.model.vo.Notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public int selectListCount() {
		return noticeDao.selectListCount();
	}

	@Override
	public ArrayList<BrandNotice> selectList(Search search) {
		return noticeDao.selectList(search);
	}

	@Override
	public int selectListCount(Search search) {
		return noticeDao.selectListCount(search);
	}

	@Override
	public BrandNotice selectDetail(String noId) {
		return noticeDao.selectDetail(noId);
	}

	@Override
	public int updateAddReadCount(String noId) {
		return noticeDao.updateAddReadCount(noId);
	}

	@Override
	public int insertNotice(Notice notice) {
		return noticeDao.insertNotice(notice);
	}

}
