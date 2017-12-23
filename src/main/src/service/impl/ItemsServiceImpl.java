package service.impl;

import domain.ItemsCustom;
import domain.ItemsQueryVo;
import mapper.ItemsMapper;
import mapper.ItemsMapperCustom;
import org.springframework.beans.factory.annotation.Autowired;
import service.ItemsService;

import java.util.List;


public class ItemsServiceImpl implements ItemsService{

    @Autowired
    ItemsMapperCustom itemsMapperCustom;

    @Autowired
    ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    @Override
    public ItemsCustom findItemsById(Integer id) throws Exception {
        return itemsMapperCustom.findItemsById(id);
    }

    @Override
    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
        //itemsMapperCustom.updateItems(itemsCustom);

        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }

    @Override
    public void deleteItems(Integer[] ids) throws Exception {
        for (int i=0; i<ids.length; i++){
            itemsMapper.deleteByPrimaryKey(ids[i]);
        }
    }


}
