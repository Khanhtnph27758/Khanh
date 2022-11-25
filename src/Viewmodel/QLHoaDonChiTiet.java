/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viewmodel;

/**
 *
 * @author pqd15
 */
public class QLHoaDonChiTiet {
    private String idHoaDon,idCTSP,idSp,ten;
    private int idMau,idKichThuoc,trangThai,soLuong,idNhaCC;
    public QLHoaDonChiTiet() {
    }

    public QLHoaDonChiTiet(String idHoaDon, String idCTSP, String idSp, String ten, int idMau, int idKichThuoc, int trangThai, int soLuong, int idNhaCC) {
        this.idHoaDon = idHoaDon;
        this.idCTSP = idCTSP;
        this.idSp = idSp;
        this.ten = ten;
        this.idMau = idMau;
        this.idKichThuoc = idKichThuoc;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
        this.idNhaCC = idNhaCC;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
    }

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getIdMau() {
        return idMau;
    }

    public void setIdMau(int idMau) {
        this.idMau = idMau;
    }

    public int getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(int idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdNhaCC() {
        return idNhaCC;
    }

    public void setIdNhaCC(int idNhaCC) {
        this.idNhaCC = idNhaCC;
    }

    
    public String getncc(){
        String ncc = idNhaCC ==1?"Adidas":"Nike";
        return ncc; 
    }
}
