/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Product;
import model.Shop;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ThaiBao
 */
public class ShopDao {
    JdbcTemplate template;
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
     public void Them(Shop s, int user_id) {
        String sql = String.format("insert into shop (name,address,phone_number,business_license,enabled,user_id) values('%s','%s','%s','%d','%d','%d')", s.getName(), s.getAddress(), s.getPhone_number(), 1, 0, user_id);
        template.update(sql);
    }
     
    public int Xoa(int id) {
        String sql = "delete from shop where id = " + id;
        return template.update(sql);
    }
    
    public Shop TimKiemShopTheoIdUser(int id) {
        String sql = "select * from shop where user_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Shop>(Shop.class));
    }
    
    public List<Shop> LayDanhSachCuaHang() {
        return template.query("select * from shop", new RowMapper<Shop>() {
            public Shop mapRow(ResultSet rs, int row) throws SQLException {
                Shop s = new Shop();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setAddress(rs.getString(3));
                s.setPhone_number(rs.getString(4));
                s.setBusiness_license(rs.getInt(5));
                s.setEnabled(rs.getInt(6));
                s.setUser_id(rs.getInt(7));
                return s;
            }
        });
    }
    
    public int EnabledShop(int id) {
        String sql = String.format("update shop set enabled=1 where id=%d", id);
        return template.update(sql);
    }
}
