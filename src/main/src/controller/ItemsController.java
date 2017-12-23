package controller;

import domain.ItemsCustom;
import domain.ItemsQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ItemsService;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @RequestMapping(value = "/deleteItems", method = RequestMethod.POST)
    public String deleteItems(Model model, Integer[] delete_id) throws Exception {
        itemsService.deleteItems(delete_id);
        return "success";
    }

    //批量修改商品查询
    @RequestMapping("/editItemsList")
    public ModelAndView editItemsList() throws Exception {
        //调用servie来查询商品列表
        List<ItemsCustom> itemsList=itemsService.findItemsList(null);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        //指定逻辑视图名itemsList.jsp
        modelAndView.setViewName("editItemsList");

        return modelAndView;
    }

    //批量修改商品的提交

    @RequestMapping("/editItemsListSubmit")
    public String editItemsListSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
        return "success";
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

    @RequestMapping(value = "/editItemSubmit", consumes = "multipart/form-data")
    public String editItemSubmit(Model model,Integer id,
                                 @Validated @ModelAttribute(value = "itemsCustom") ItemsCustom itemsCustom,
                                 BindingResult bindingResult,
                                 //上传图片
                                 @RequestPart(value = "pictureFile", required = false) MultipartFile pictureFile
    ) throws Exception
    {


        //进行数据回显
        model.addAttribute("id",id);
//        model.addAttribute("item",itemsCustom);

        //进行图片的上传
        if (pictureFile!=null&&pictureFile.getOriginalFilename()!=null&&pictureFile.getOriginalFilename().length()>0)
        {
            //图片上传成功后，将图片的地址写到数据库
            String filePath="D://ProgramPic";//它的值要同你设置虚拟目录时涉及的目录路径一致，
            String originalFilename=pictureFile.getOriginalFilename();

            String newFileName= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));

            //新文件
            File file=new File(filePath+newFileName);

            //将内存中的文件写入磁盘
            pictureFile.transferTo(file);

            //图片上传成功
            itemsCustom.setPic(newFileName);
        }


        itemsService.updateItems(id,itemsCustom);
        //请求转发
//        return "forward:queryItems.action";


        return "editItem";
        //重定向
        //return "redirect:queryItems.action";
    }
}
