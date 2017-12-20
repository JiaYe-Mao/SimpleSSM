package controller;

import domain.ItemsCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ItemsService;

import java.util.List;

@Controller
public class ItemsController {

    @Autowired
    ItemsService itemsService;

    @RequestMapping(name = "/queryitems")
    public ModelAndView queryItems() throws Exception{
        //调用servie来查询商品列表
        List<ItemsCustom> itemsList=itemsService.findItemsList(null);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        //指定逻辑视图名itemsList
        modelAndView.setViewName("itemsList");

        return modelAndView;
    }
}
