/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DomainModel.ChatLieu;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import Jdbc.jdbcHelper;

/**
 *
 * @author Admin
 */
public class ChatLieuDAO extends ShopDAO<ChatLieu, Integer>{

    @Override
    public void insert(ChatLieu e) {
        String sql = "insert into ChatLieu values(?)";
        jdbcHelper.update(sql, e.getTenChatLieu());
    }

    @Override
    public void update(ChatLieu e) {
        String sql = "update ChatLieu set tenChatLieu = ? where idChatLieu = ?";
        jdbcHelper.update(sql, e.getTenChatLieu(), e.getIdChatLieu());
    }

    @Override
    public void delete(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ChatLieu> selectAll() {
        String sql = "select * from ChatLieu";
        return selectBySql(sql);
    }

    @Override
    public ChatLieu selectById(Integer k) {
        String sql = "SELECT * FROM dbo.ChatLieu where idChatLieu = ?";
        List<ChatLieu> list = selectBySql(sql, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public ChatLieu selectByName(Integer k) {
        String sql = "SELECT * FROM dbo.ChatLieu where tenChatLieu = ?";
        List<ChatLieu> list = selectBySql(sql, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<ChatLieu> selectBySql(String sql, Object... args) {
        List<ChatLieu> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                ChatLieu m = new ChatLieu();
                m.setIdChatLieu(rs.getInt("idChatLieu"));
                m.setTenChatLieu(rs.getString("tenChatLieu"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
