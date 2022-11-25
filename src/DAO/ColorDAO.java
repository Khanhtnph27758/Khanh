/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DomainModel.Color;
import Jdbc.jdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Đặng Đình Vũ
 */
public class ColorDAO extends ShopDAO<Color, Integer>{

    @Override
    public void insert(Color e) {
        String sql = "INSERT dbo.Mau( tenMau) values(?)";
        jdbcHelper.update(sql, e.getTenMau());
    }

    @Override
    public void update(Color e) {
        String sql = "update dbo.Mau set tenMau = ? where idMau = ?";
        jdbcHelper.update(sql, e.getTenMau(), e.getIdMau());
    }

    @Override
    public void delete(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Color> selectAll() {
        String sql = "SELECT * FROM dbo.Mau";
        return selectBySql(sql);
    }

    @Override
    public Color selectById(Integer k) {
        String sql = "SELECT * FROM dbo.Mau where idMau = ?";
        List<Color> list = selectBySql(sql, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<Color> selectBySql(String sql, Object... args) {
        List<Color> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Color c = new Color();
                c.setIdMau(rs.getInt("idMau"));
                c.setTenMau(rs.getString("tenMau"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Color selectByName(String name) {
        String sql = "select * from Mau where tenMau = ?";
        List<Color> list = selectBySql(sql, name);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
}
