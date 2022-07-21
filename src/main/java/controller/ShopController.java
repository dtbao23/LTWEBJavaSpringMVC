/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AccountDao;
import dao.ShopDao;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Shop;
import model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ThaiBao
 */
@Controller
public class ShopController {

    private static final Logger logger = Logger.getLogger(ShopController.class);
    @Autowired
    ShopDao shopDao;
    @Autowired
    AccountDao accountDao;

    @RequestMapping(value = "/shop/signup")
    public ModelAndView Sign_ui(HttpSession session) {
        try {
            logger.info("Hien thi dang ki ban hang");
            User user = (User) session.getAttribute("LoginInfo");
            int user_id;
            user_id = user.getId();
            Shop shop = shopDao.TimKiemShopTheoIdUser(user_id);
        } catch (Exception e) {
            return new ModelAndView("viewShop/signupShop");
        }
        return new ModelAndView("redirect:/shop/infomation.html");
    }

    @RequestMapping(value = "/shop/infomation")
    public ModelAndView Infomation_ui(HttpSession session) {
        logger.info("Hien thi trang thong tin shop");
        User user = (User) session.getAttribute("LoginInfo");
        int user_id;
        user_id = user.getId();
        Shop shop = shopDao.TimKiemShopTheoIdUser(user_id);
        return new ModelAndView("viewShop/infomationShop", "shop", shop);
    }

    @RequestMapping(value = "/shop/signup/add")
    public String AddShop(Shop shop, HttpSession session) {
        logger.info("Them shop");
        User user = (User) session.getAttribute("LoginInfo");
        int user_id;
        if (user == null) {
            return "redirect:/account/login.html";
        } else {
            user_id = user.getId();
        }
        shopDao.Them(shop, user_id);
        return "redirect:/shop/infomation.html";
    }

    @RequestMapping(value = "/shop/list")
    public ModelAndView ListShop() {
        logger.info("Danh sach shop");
        List<Shop> listShop = shopDao.LayDanhSachCuaHang();
        return new ModelAndView("viewShop/listShop", "listShop", listShop);
    }

    @RequestMapping(value = "/shop/delete")
    public String DeleteShop(@RequestParam("id") int id) {
        logger.info("Thuc hien xoa cua hang");
        shopDao.Xoa(id);
        return "redirect:/homepage.html";
    }

    //cap nhat lai quyen user va kich hoat shop
    @RequestMapping(value = "/shop/editrules")
    public String EditRulesShop(@RequestParam("id") int id, @RequestParam("userid") int user_id) {
        logger.info("Thuc hien cap nhat lại quyen cua user");
        // kích hoat shop 
        shopDao.EnabledShop(id);
        //phan quyen lai cho user la shop
        accountDao.UpdateRulesUser(user_id);
        return "redirect:/homepage.html";
    }
}
