/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CategoryDao;
import dao.ProductDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import model.Category;
import model.Product;
import model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {
    private static final Logger logger = Logger.getLogger(ProductController.class);
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    ProductDao productDao;
    
    
    @RequestMapping(value = "/product/list")
    public ModelAndView ListProduct(){
        logger.info("Hien thi danh sach san pham");
        List<Product> listProduct = productDao.LayDanhSachSanPham();       
        return new ModelAndView("viewProduct/listProduct", "listProduct",listProduct);       
    }
    
    @RequestMapping(value = "/product/detail")
    public ModelAndView ProductDetail(@RequestParam("id") int id){
        logger.info("Hien thi chi tiet san pham");
        Product p = productDao.TimKiemSanPhamTheoId(id);
        return new ModelAndView("viewProduct/detailProduct","product",p);       
    }
    
    @RequestMapping(value = "/product/add")
    public ModelAndView Them_ui(){
        logger.info("Hien thi trang them san pham");
        List<Category> listCategory = categoryDao.LayDanhSachLoaiSanPham();          
        return new ModelAndView("viewProduct/addProduct","listCategory",listCategory);       
    }
    
    @RequestMapping(value = "/product/addsave")
    public String ThemSanPham(Product p, HttpSession session){
        logger.info("Thuc hien them san pham");
        User user = (User)session.getAttribute("LoginInfo");
        int user_id;
        if(user == null){
            return "redirect:/account/login.html";
        } else {
             user_id = user.getId();
        }
        productDao.Them(p, user_id);
        return "redirect:/homepage.html";     
    }
    
    @RequestMapping(value = "/product/edit")
    public ModelAndView CapNhat_ui(@RequestParam("id") int id){
        logger.info("Hien thi trang cap nhat san pham");
        Product p = productDao.TimKiemSanPhamTheoId(id);
        Category c = categoryDao.TimKiemLoaiSanPhamTheoID(p.getCategory_id());
        List<Category> listCategory = categoryDao.LayDanhSachLoaiSanPham();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("product", p);
        model.put("category", c);
        model.put("listCategory", listCategory);
        return new ModelAndView("viewProduct/editProduct", "data",model);       
    }
    
    @RequestMapping(value = "/product/editsave")
    public String CapNhatSanPham(Product p){
        logger.info("Thuc hien cap nhat san pham");
        productDao.CapNhat(p);
        return "redirect:/homepage.html";     
    }
    
    @RequestMapping(value = "/product/delete")
    public String XoaSanPham(@RequestParam("id") int id){
        logger.info("Thuc hien xoa san pham");
        productDao.Xoa(id);
        return "redirect:/homepage.html";     
    }
    
    
}
