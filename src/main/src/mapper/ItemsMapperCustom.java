package mapper;

import domain.ItemsCustom;
import domain.ItemsQueryVo;

import java.util.List;


public interface ItemsMapperCustom {
	// 商品查询列表
	List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception;

	ItemsCustom findItemsById(Integer id) throws Exception;

	void updateItems(ItemsCustom itemsCustom) throws Exception;

}
