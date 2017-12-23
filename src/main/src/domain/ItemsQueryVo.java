package domain;

import java.util.List;

/**
 * 
 * <p>Title: ItemsQueryVo</p>
 * <p>Description: 商品的包装类</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-20下午2:52:00
 * @version 1.0
 */
public class ItemsQueryVo {
	
	//商品信息
	private ItemsCustom itemsCustom;

	private List<ItemsCustom> itemsCustomList;

	public List<ItemsCustom> getItemsCustomList() {
		return itemsCustomList;
	}

	public void setItemsCustomList(List<ItemsCustom> itemsCustomList) {
		this.itemsCustomList = itemsCustomList;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	

}
