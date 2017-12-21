package controller;

import domain.ItemsCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ItemsService;

import java.util.Date;
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

    @RequestMapping(value = "/editItems",method = RequestMethod.GET)
    public String editItems(Model model, @RequestParam Integer id) throws Exception
    {
        model.addAttribute("id",id);

        //调用service查询商品的信息
        ItemsCustom itemsCustom=itemsService.findItemsById(id);

        model.addAttribute("itemsCustom",itemsCustom);

        return "editItem";
    }

    @RequestMapping(value = "/editItemSubmit",method = RequestMethod.POST)
    public String updateItems(Model model, Integer id,
                              @ModelAttribute(value = "itemsCustom")ItemsCustom itemsCustom)
    {
        itemsCustom.setCreatetime(new Date());
        try {
            itemsService.updateItems(id, itemsCustom);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("" + id + itemsCustom );
        }
        return "redirect:queryItems.action";
    }
}
