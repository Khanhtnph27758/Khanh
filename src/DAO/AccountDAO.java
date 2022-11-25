/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DomainModel.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Jdbc.DBContext;
import Jdbc.jdbcHelper;

/**
 *
 * @author Admin
 */
public class AccountDAO extends ShopDAO<Account, String> {

    private String INSERT_SQL_USER = "insert into TaiKhoan (TK,MK,Email,ROLEACC) values(?,?,?,?)";
    private String UPDATE_SQL = "update account set MK = ?  where TK = ?";
    private String DELETE_SQL = "";
    private String SELECT_ALL_SQL = "SELECT * FROM TaiKhoan";
    private String SELECT_ALL_OFF = "SELECT * FROM dbo.[User] where status = 0";

    private String SELECT_BY_ID = "";
    private String SELECT_BY_KEY = "SELECT * FROM dbo.[USER] WHERE name LIKE ? ";

    @Override
    public void insert(Account e) {
        jdbcHelper.update(INSERT_SQL_USER, e.getUser(), e.getPass(), e.getEmail(), e.getRole());
    }

    @Override
    public void update(Account e) {
        jdbcHelper.update(UPDATE_SQL, e.getPass(),e.getEmail());
         //To change body of generated methods, choose Tools | Templates.
    }
    public void update(String pass, String user) {
        jdbcHelper.update(UPDATE_SQL, pass, user);
         //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void delete(String k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Account selectById(String k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Account> selectBySql(String sql, Object... args) {
        List<Account> listA = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Account acc = new Account();
                acc.setUser(rs.getString("TK"));
                acc.setPass(rs.getString("MK"));
                acc.setEmail(rs.getString("Email"));
                acc.setRole(Integer.parseInt(rs.getString("ROLEACC")));
                listA.add(acc);
            }
            rs.getStatement().getConnection().close();
            return listA;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*public boolean insert(Account acc) throws Exception{
        
        String sql ="insert into ACCOUNT (TK,MK,Email,ROLEACC) values(?,?,?,?)";
        try(
               Connection conn = DBContext.getConnection();
               PreparedStatement pstm = conn.prepareStatement(sql);
                ){
                pstm.setString(1, acc.getUser());
                pstm.setString(2, acc.getPass());
                pstm.setString(3, acc.getEmail());
                pstm.setString(4, String.valueOf(acc.getRole()));
                
                return pstm.executeUpdate() > 0;
        }
    }
    public ArrayList<String> listTk() throws Exception{
        ArrayList<String> x = new ArrayList<String>();
        String sql = "select TK from ACCOUNT";
        try(
               Connection conn = DBContext.getConnection();
               PreparedStatement pstm = conn.prepareStatement(sql);
                ){
               ResultSet rs = pstm.executeQuery();
               
               while(rs.next()){
                   x.add(rs.getString("TK"));
                   
               }        
        }
        return x;
    }
    
    public List<Account> accLogin() throws Exception{
        List<Account> listAcc = new ArrayList<>();
        String sql = "select * from ACCOUNT";
        try(
               
               Connection conn = DBContext.getConnection();
               PreparedStatement pstm = conn.prepareStatement(sql);
                ){
               ResultSet rs = pstm.executeQuery();
               
               while(rs.next()){
                   Account acc = new Account(); 
                   acc.setUser(rs.getString("TK"));
                   acc.setPass(rs.getString("MK"));
                   acc.setEmail(rs.getString("Email"));
                   acc.setRole(Integer.parseInt(rs.getString("ROLEACC")));
                   listAcc.add(acc);
                   
               }        
        }
        return listAcc;
    }
    
    public boolean update(String user, String pass ) throws Exception{
        String sql = "update account set MK = ?" + " where TK = ? ";
        try(
               
               Connection conn = DBContext.getConnection();
               PreparedStatement pstm = conn.prepareStatement(sql);
                ){
               
               
               pstm.setString(1, user);
               pstm.setString(2, pass);
               
               
               return pstm.executeUpdate() > 0;
               
        }
        
    } */
}
