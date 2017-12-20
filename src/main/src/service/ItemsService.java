package service;

import domain.ItemsCustom;
import domain.ItemsQueryVo;

import java.util.List;

public interface ItemsService {
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
