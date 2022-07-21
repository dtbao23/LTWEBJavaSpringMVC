/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CategoryDao;
import java.util.List;
import model.Category;
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
public class CategoryController {
    private static final Logger logger = Logger.getLogger(CategoryController.class);
    @Autowired
    CategoryDao categoryDao;
    @RequestMapping(value = "/category/list")
    public ModelAndView ListCategory(){
        logger.info("Hien thi danh sach loai san pham");
        List<Category> listCategory = categoryDao.LayDanhSachLoaiSanPham();     
        return new ModelAndView("viewCategory/listCategory", "listCategory",listCategory);       
    }
    
    @RequestMapping(value = "/category/add")
    public ModelAndView Them_ui(){
        logger.info("Hien thi trang them loai san pham");                
        return new ModelAndView("viewCategory/addCategory");       
    }
    
    @RequestMapping(value = "/category/addsave")
    public String ThemSanPham(Category c){
        logger.info("Thuc hien them loai san pham");
        categoryDao.Them(c);
        return "redirect:/homepage.html";     
    }
    
    @RequestMapping(value = "/category/edit")
    public ModelAndView CapNhat_ui(@RequestParam("id") int id){
        logger.info("Hien thi trang cap nhat san pham");       
        Category category = categoryDao.TimKiemLoaiSanPhamTheoID(id);            
        return new ModelAndView("viewCategory/editCategory", "category", category);       
    }
    
    @RequestMapping(value = "/category/editsave")
    public String CapNhatSanPham(Category c){
        logger.info("Thuc hien cap nhat loai san pham");
        categoryDao.CapNhat(c);
        return "redirect:/homepage.html";     
    }
    
    @RequestMapping(value = "/category/delete")
    public String XoaSanPham(@RequestParam("id") int id){
        logger.info("Thuc hien xoa loai san pham");
        categoryDao.Xoa(id);
        return "redirect:/homepage.html";     
    }
}
