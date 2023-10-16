package org.ict.sik.notice.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.common.Paging;
import org.ict.sik.notice.model.vo.BrandNotice;
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

	public ArrayList<BrandNotice> selectList(Paging paging) {
		List<BrandNotice> list = sqlSessionTemplate.selectList("noticeMapper.selectList",paging);
		return (ArrayList<BrandNotice>)list;
	}
}
