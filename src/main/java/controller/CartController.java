/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProductDao;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
    private static final Logger logger = Logger.getLogger(CategoryController.class);
    @Autowired
    ProductDao productDao;
    
    @RequestMapping(value = "/cart/detail")
    public ModelAndView CartDetail(){
        logger.info("Chi tiết giỏ hàng");
        return new ModelAndView("viewCart/detailCart");         
    }
    
    @RequestMapping(value = "/cart/add")
    public String ThemSanPhamVaoGioHang(HttpServletRequest request,HttpSession session, @RequestParam("id") long id){
        logger.info("Xu li them san pham vao gio hang ");
        HashMap<Long, Cart> map = (HashMap<Long, Cart>) session.getAttribute("myCart");        
        if (map == null) {
            map = new HashMap<Long, Cart>();            
        }      
        Product product = productDao.TimKiemSanPhamTheoId((int)id);
        if (product != null) {
            if (map.containsKey(id)) {
                Cart item = map.get(id);
                item.setProduct(product);
                item.setQty(item.getQty()+ 1);  
                item.setPrice(item.getQty()*product.getPrice_discount());
                map.put(id, item);
            } else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setPrice(product.getPrice_discount());
                map.put(id, item);
            }
        }
        session.setAttribute("myCart", map);
        session.setAttribute("totalPrice", totalPrice(map));
        session.setAttribute("totalQuantity", totalQuantity(map));
        return "redirect:"+request.getHeader("Referer");          
    }
    
    @RequestMapping(value = "/cart/delete")
    public String XoaSanPhamTrongGioHang(HttpServletRequest request,HttpSession session, @RequestParam("id") long id){
        logger.info("Xu li xoa san pham trong gio hang ");
        HashMap<Long, Cart> map = (HashMap<Long, Cart>) session.getAttribute("myCart");               
        map.remove(id);
        session.setAttribute("myCart", map);
        session.setAttribute("totalPrice", totalPrice(map));
        session.setAttribute("totalQuantity", totalQuantity(map));
        return "redirect:"+request.getHeader("Referer");          
    }
    
    public static double totalPrice(HashMap<Long, Cart> hashMap) {     
        double totalPrice = 0;
        Set<Long> keySet = hashMap.keySet();//lay cac key 
        for(Long i : keySet){
            Cart cart = hashMap.get(i);
            totalPrice += cart.getPrice();
        }              
        return totalPrice;
    }
    
    public static int totalQuantity(HashMap<Long, Cart> hashMap) {     
        int qty = 0;
        Set<Long> keySet = hashMap.keySet();//lay cac key 
        for(Long i : keySet){
            qty+=1;
        }              
        return qty;
    }
}
