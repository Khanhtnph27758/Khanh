/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author pqd15
 */
public class HoaDon {
    private String idhd,idkh,idnv,ngaytao,tthd,ttttoan;

    public HoaDon() {
    }

    public HoaDon(String idhd, String idkh, String idnv, String ngaytao, String tthd, String ttttoan) {
        this.idhd = idhd;
        this.idkh = idkh;
        this.idnv = idnv;
        this.ngaytao = ngaytao;
        this.tthd = tthd;
        this.ttttoan = ttttoan;
    }

    public String getIdhd() {
        return idhd;
    }

    public void setIdhd(String idhd) {
        this.idhd = idhd;
    }

    public String getIdkh() {
        return idkh;
    }

    public void setIdkh(String idkh) {
        this.idkh = idkh;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getTthd() {
        return tthd;
    }

    public void setTthd(String tthd) {
        this.tthd = tthd;
    }

    public String getTtttoan() {
        return ttttoan;
    }

    public void setTtttoan(String ttttoan) {
        this.ttttoan = ttttoan;
    }
    
}
