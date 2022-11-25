/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DomainModel.ChiTietSanPham;
import Jdbc.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChiTietSanPhamDAO extends ShopDAO<ChiTietSanPham, Integer>{

    @Override
    public void insert(ChiTietSanPham e) {
        String sql = "INSERT INTO dbo.ChiTietSanPham(idSp,idKichThuoc,idMau,idChatLieu,gia,soLuong,trangThai)values(?,?,?,?,?,?,?)";
        jdbcHelper.update(sql,  e.getIdSanPham(), e.getIdKichThuoc(), e.getIdMau(), e.getIdChatLieu(), e.getGia(), e.getSoLuong(),e.isTrangThai());
    }

    @Override
    public void update(ChiTietSanPham e) {
        String sql = "UPDATE dbo.ChiTietSanPham SET idKichThuoc = ?, idMau = ?, idChatLieu = ?, gia = ? WHERE idCTSP = ?";
        jdbcHelper.update(sql, e.getIdKichThuoc(), e.getIdMau(), e.getIdChatLieu(), e.getGia(), e.getIdCTSP());
    }
    public void updateSl(ChiTietSanPham e) {
        String sql = "UPDATE dbo.ChiTietSanPham SET soLuong = ? WHERE idCTSP = ?";
        jdbcHelper.update(sql, e.getSoLuong(), e.getIdCTSP());
    }

    @Override
    public void delete(Integer k) {
        String sql = "delete from ChiTietSanPham where idCTSP = ?";
        jdbcHelper.update(sql, k);
    }

    @Override
    public List<ChiTietSanPham> selectAll() {
        String sql = "select D.*,P.tenSp,S.giaTriKichThuoc,C.tenMau,M.tenChatLieu,tenLoaiSp,gia from ChiTietSanPham D\n"
                + " INNER JOIN KichThuoc S on D.idKichThuoc = S.idKichThuoc INNER JOIN ChatLieu M on M.idChatLieu = D.idChatLieu\n"
                + "                 INNER JOIN Mau C on C.idMau = D.idMau\n"
                + "                 INNER JOIN SanPham P on P.idSp = D.idSp\n"
                + "                 INNER JOIN LoaiSp L  on L.idLoaiSp = P.idLoaiSp ORDER BY idCTSP Desc";
        return selectBySql(sql);
    }

    @Override
    public ChiTietSanPham selectById(Integer k) {
        String sql = "select D.*,P.tenSp,S.giaTriKichThuoc,C.tenMau,M.tenChatLieu,tenLoaiSp,gia from ChiTietSanPham D\n"
                + " INNER JOIN KichThuoc S on D.idKichThuoc = S.idKichThuoc INNER JOIN ChatLieu M on M.idChatLieu = D.idChatLieu\n"
                + "                 INNER JOIN Mau C on C.idMau = D.idMau\n"
                + "                 INNER JOIN SanPham P on P.idSp = D.idSp\n"
                + "                 INNER JOIN LoaiSp L  on L.idLoaiSp = P.idLoaiSp\n"
                + "                where D.idCTSP = ?";
        List<ChiTietSanPham> list = selectBySql(sql, k);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<ChiTietSanPham> selectBySql(String sql, Object... args) {
        List<ChiTietSanPham> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                ChiTietSanPham p = new ChiTietSanPham();
                p.setIdCTSP(rs.getInt("idCTSP"));
                p.setIdSanPham(rs.getInt("idSp"));
                p.setIdKichThuoc(rs.getInt("idKichThuoc"));
                p.setIdMau(rs.getInt("idMau"));
                p.setIdChatLieu(rs.getInt("idChatLieu"));
                p.setGia(rs.getFloat("gia"));
                p.setSoLuong(rs.getInt("soLuong"));
                p.setTrangThai(rs.getBoolean("trangThai"));
                p.setKichThuoc(rs.getString("giaTriKichThuoc"));
                p.setMau(rs.getString("tenMau"));
                p.setChatLieu(rs.getString("tenChatLieu"));
                p.setTenSp(rs.getString("tenSp"));
                p.setLoaiSp(rs.getString("tenLoaiSp"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<ChiTietSanPham> selectByKey(String k) {
        String sql = "select D.*,P.tenSp,S.giaTriKichThuoc,C.tenMau,M.tenChatLieu,tenLoaiSp,gia from ChiTietSanPham D\n"
                + " INNER JOIN KichThuoc S on D.idKichThuoc = S.idKichThuoc INNER JOIN ChatLieu M on M.idChatLieu = D.idChatLieu\n"
                + "                 INNER JOIN Mau C on C.idMau = D.idMau\n"
                + "                 INNER JOIN SanPham P on P.idSp = D.idSp\n"
                + "                 INNER JOIN LoaiSp L  on L.idLoaiSp = P.idLoaiSp\n"
                + "                where P.tenSp like ?";
        return selectBySql(sql, "%" + k + "%");
    }

    
}
