/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ThaiBao
 */
public class ProductDao {
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    public Product TimKiemSanPhamTheoId(int id) {
        String sql = "select * from product where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Product>(Product.class));
    }
    
    public List<Product> LayDanhSachSanPham() {
        return template.query("select p.*, c.name from product p join category c on p.category_id = c.id", new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int row) throws SQLException {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getFloat(3));
                p.setPrice_discount(rs.getFloat(4));
                p.setCategory_id(rs.getInt(5));             
                p.setShop_id(rs.getInt(6));
                p.setCategory_name(rs.getString(7));
                return p;
            }
        });
    }
    
     public void Them(Product p, int user_id) {
        String sql = String.format("insert into product (name,price,price_discount,category_id,shop_id) values('%s','%s','%s','%d','%d')", p.getName(), p.getPrice(), p.getPrice_discount(), p.getCategory_id(), user_id);
        template.update(sql);
    }
     
    public int Xoa(int id) {
        String sql = "delete from product where id = " + id;
        return template.update(sql);
    }
    
    public int CapNhat(Product p) {
        String sql = String.format("update product set name='%s',price='%s', price_discount='%s', category_id='%d' where id=%d",p.getName(), p.getPrice(), p.getPrice_discount(), p.getCategory_id(), p.getId());
        return template.update(sql);
    }
}
