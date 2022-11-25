/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

/**
 *
 * @author Admin
 */
public class ChiTietSanPham {
    private int idCTSP;
    private int idSanPham;
    private int idKichThuoc;
    private int idMau;
    private int idChatLieu;
    private int idHoaDon;
    private int idKhachHang;

    private float gia;
    private int soLuong;
    private boolean trangThai;

    private String kichThuoc;
    private String mau;
    private String chatLieu;
    private String tenSp;
    private String tenKhachHang;
    private String loaiSp;
    private String ngayTaoHoaDon;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(int idCTSP, int idSanPham, int idKichThuoc, int idMau, int idChatLieu, int idHoaDon, int idKhachHang, float gia, int soLuong, boolean trangThai, String kichThuoc, String mau, String chatLieu, String tenSp, String tenKhachHang, String loaiSp, String ngayTaoHoaDon) {
        this.idCTSP = idCTSP;
        this.idSanPham = idSanPham;
        this.idKichThuoc = idKichThuoc;
        this.idMau = idMau;
        this.idChatLieu = idChatLieu;
        this.idHoaDon = idHoaDon;
        this.idKhachHang = idKhachHang;
        this.gia = gia;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.kichThuoc = kichThuoc;
        this.mau = mau;
        this.chatLieu = chatLieu;
        this.tenSp = tenSp;
        this.tenKhachHang = tenKhachHang;
        this.loaiSp = loaiSp;
        this.ngayTaoHoaDon = ngayTaoHoaDon;
    }

    public int getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(int idCTSP) {
        this.idCTSP = idCTSP;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(int idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public int getIdMau() {
        return idMau;
    }

    public void setIdMau(int idMau) {
        this.idMau = idMau;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }

    public String getNgayTaoHoaDon() {
        return ngayTaoHoaDon;
    }

    public void setNgayTaoHoaDon(String ngayTaoHoaDon) {
        this.ngayTaoHoaDon = ngayTaoHoaDon;
    }
    
    
}
