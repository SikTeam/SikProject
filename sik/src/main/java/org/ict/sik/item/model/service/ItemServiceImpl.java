package org.ict.sik.item.model.service;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.item.model.dao.ItemDao;
import org.ict.sik.item.model.vo.Item;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int selectListCount() {
		return itemDao.selectListCount();
	}

	@Override
	public ArrayList<Item> selectList(Paging paging) {
		return itemDao.selectList(paging);
	
	}

	@Override
	public List<Item> getAllItems(Paging paging) {
		List<Item> list = sqlSessionTemplate.selectList("itemMapper.getAllItems", paging);
		return (ArrayList<Item>)list;
    
	}

	@Override
	public int selectListItemCount(String keyword, String searchOption) {
		return itemDao.selectListItemCount(keyword, searchOption);
	}

	@Override
	public ArrayList<Item> selectListItemName(Search search) {
		return itemDao.selectListItemName(search);
	}



}
