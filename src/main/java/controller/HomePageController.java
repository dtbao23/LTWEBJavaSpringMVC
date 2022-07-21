/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProductDao;
import java.util.List;
import model.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
    private static final Logger logger = Logger.getLogger(HomePageController.class);     
    @Autowired
    ProductDao productDao;
    @RequestMapping(value = "/homepage")
    public ModelAndView HomePage(){
        logger.info("Hien thi giao dien trang chu");
        List<Product> listProduct = productDao.LayDanhSachSanPham();  
        return new ModelAndView("viewHome/homePage", "listProduct", listProduct);
        
    }
}
