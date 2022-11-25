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
public class Size {
    private int idKichThuoc;
    private String giaTriKichThuoc;

    public Size() {
    }

    public Size(int idKichThuoc, String giaTriKichThuoc) {
        this.idKichThuoc = idKichThuoc;
        this.giaTriKichThuoc = giaTriKichThuoc;
    }

    public int getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(int idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public String getGiaTriKichThuoc() {
        return giaTriKichThuoc;
    }

    public void setGiaTriKichThuoc(String giaTriKichThuoc) {
        this.giaTriKichThuoc = giaTriKichThuoc;
    }
    
    
}
