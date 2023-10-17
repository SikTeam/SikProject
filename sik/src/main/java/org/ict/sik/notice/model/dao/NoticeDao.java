package org.ict.sik.notice.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
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

	public ArrayList<BrandNotice> selectList(Search search) {
		List<BrandNotice> list = sqlSessionTemplate.selectList("noticeMapper.selectList",search);
		return (ArrayList<BrandNotice>)list;
	}

	public int selectListCount(Search search) {
		return sqlSessionTemplate.selectOne("noticeMapper.selectListCount",search);
	}

	public BrandNotice selectDetail(String noId) {
		return sqlSessionTemplate.selectOne("noticeMapper.selectDetail",noId);
	}

	public int updateAddReadCount(String noId) {
		return sqlSessionTemplate.update("noticeMapper.updateAddReadCount",noId);
	}
}
