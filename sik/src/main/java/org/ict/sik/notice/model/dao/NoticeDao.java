package org.ict.sik.notice.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.common.Paging;
import org.ict.sik.notice.model.vo.Notice;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("noticeDao")
public class NoticeDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int selectListCount() {
		return sqlSessionTemplate.selectOne("noticeMapper.selectListCount");
	}

	public ArrayList<Notice> selectList(Paging paging) {
		List<Notice> list = sqlSessionTemplate.selectList("",paging);
		return (ArrayList<Notice>)list;
	}
}
