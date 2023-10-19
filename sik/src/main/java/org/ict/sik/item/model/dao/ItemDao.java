package org.ict.sik.item.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.TableView.TableRow;

import org.ict.sik.common.Paging;
import org.ict.sik.item.model.vo.Item;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ItemDao")
public class ItemDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int selectListCount(){
		return sqlSessionTemplate.selectOne("itemMapper.selectListCount");
	}

	public ArrayList<Item> selectList(Paging paging) {
		List<Item> list = sqlSessionTemplate.selectList("itemMapper.selectList", paging);
		return (ArrayList<Item>)list;
	}

	public Object addItem(TableRow row) {
		return sqlSessionTemplate.insert("itemMapper.addItem", row);
	}

	public List<Item> getAllItems(Paging paging) {
		List<Item> list = sqlSessionTemplate.selectList("itemMapper.getAllItems", paging);
		return (ArrayList<Item>)list;
	}

}
