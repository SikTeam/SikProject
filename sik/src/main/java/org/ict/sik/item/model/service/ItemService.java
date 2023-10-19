package org.ict.sik.item.model.service;

import java.util.ArrayList;
import java.util.List;

import org.ict.sik.common.Paging;
import org.ict.sik.item.model.vo.Item;

public interface ItemService {

	int selectListCount();

	ArrayList<Item> selectList(Paging paging);

	List<Item> getAllItems(Paging paging);


}
