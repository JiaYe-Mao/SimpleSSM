package service.impl;

import domain.ItemsCustom;
import domain.ItemsQueryVo;
import mapper.ItemsMapperCustom;
import org.springframework.beans.factory.annotation.Autowired;
import service.ItemsService;

import java.util.List;


public class ItemsServiceImpl implements ItemsService{

    @Autowired
    ItemsMapperCustom itemsMapperCustom;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }
}
