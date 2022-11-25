/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DAO.NhanVienDAO;
import DomainModel.NhanVien;
import Validate.Validation;
import Validate.Validation1;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khanh
 */
public class ViewNhanVien extends javax.swing.JPanel {

    DefaultTableModel dtm = new DefaultTableModel();
    NhanVienDAO nvdao = new NhanVienDAO();

    /**
     * Creates new form ViewNhanVien
     */
    public ViewNhanVien() {
        initComponents();
        dtm = (DefaultTableModel) tblBang.getModel();
        loadData();
        txtIdnv.setEditable(false);
    }

    private void loadData() {
        dtm.setRowCount(0);
        List<NhanVien> listnv = nvdao.selectAll();
        for (NhanVien nv : listnv) {
            dtm.addRow(new Object[]{nv.getIdnv(), nv.getTennv(), nv.getNgaysinh(), nv.getGioitinh() == 1 ? "Nam" : "Nu", nv.getSdt(), nv.getEmail(),
                nv.getDiachi(), nv.getLuong(), "NhanVien", nv.getTt(),});
        }

    }
    public boolean add(){
        if(Validatee()){
            return  true;
        }
        NhanVien nv = new NhanVien();
        nv.setTennv(txtTenNV.getText());
        nv.setNgaysinh(txtNgaysinh.getText());
        nv.setGioitinh(Integer.parseInt(txtGioitinh.getText()));
        nv.setDiachi(txtDiachi.getText());
        nv.setSdt(txtSDT.getText());
        nv.setEmail(txtEmail.getText());
        nv.setDiachi(txtDiachi.getText());
        nv.setLuong(Float.parseFloat(txtluong.getText()));
        nv.setVaitro(Integer.parseInt(txtVaitro.getText()));
        nv.setTt(Integer.parseInt(txtTrangthai.getText()));
        
        nvdao.insert(nv);
        loadData();
        return  false;
    }
    public boolean xoa(){
        NhanVien nv = new NhanVien();
        int i;
         int index = tblBang.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "chon dong ban muon xoa");
            
            return true;
        }
        if(Question("Ban co mon xoa k?")){
            return true;
            
        }
        i = Integer.parseInt(txtIdnv.getText());
        nvdao.delete(i);
        loadData();
        return false;
    }
    public boolean edit(){
        if(Validatee()){
            return  true;
        }
         int index = tblBang.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "chon dong ban muon Sua");
            return true;
        }
        NhanVien nv = new NhanVien();
        nv.setTennv(txtTenNV.getText());
        nv.setNgaysinh(txtNgaysinh.getText());
        nv.setGioitinh(Integer.parseInt(txtGioitinh.getText()));
        nv.setDiachi(txtDiachi.getText());
        nv.setSdt(txtSDT.getText());
        nv.setEmail(txtEmail.getText());
        nv.setDiachi(txtDiachi.getText());
        nv.setLuong(Float.parseFloat(txtluong.getText()));
        nv.setVaitro(Integer.parseInt(txtVaitro.getText()));
        nv.setTt(Integer.parseInt(txtTrangthai.getText()));
        nv.setIdnv(index+1);
        nvdao.update(nv);
        System.out.println(nv.getIdnv());
        loadData();
        return false;
    }
    public boolean Validatee(){
        
        if(Validation1.iEmpty(txtTenNV, "Ten k duoc de trong")){
            return true;
        }
        if(Validation1.iEmpty(txtNgaysinh, "Ngay sinh k duoc de trong")){
            return true;
        }
        if(Validation1.iEmpty(txtGioitinh, "Gioi tinh k duoc de trong")){
            return true;
        }
        if(Validation1.iEmpty(txtSDT, "Sdt k duoc de trong")){
            return true;
        }
        if(Validation1.iEmpty(txtEmail, "Email k duoc de trong")){
            return true;
        }
        if(Validation1.iEmpty(txtDiachi, "Dia Chi k duoc de trong")){
            return true;
        }
        if(Validation1.iEmpty(txtluong, "luong k duoc de trong")){
            return true;
        }
        if(Validation1.iEmpty(txtVaitro, "Vai tro k duoc de trong")){
            return true;
        }
        if(Validation1.iEmpty(txtTrangthai, "trang thai k duoc de trong")){
            return true;
        }
        if(Validation1.isNotFloat(txtluong, "Luong phai dien so")){
            return true;            
        }
        if(Question("Ban co muon them k?")){
          return true;  
        }
       return false;
    
    }
    private boolean Question(String mess) {
        int choice = JOptionPane.showConfirmDialog(this, mess, "Question", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
            return true;
        }
        return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSanPham = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnThem1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        txtIdnv = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtNgaysinh = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        txtTrangthai = new javax.swing.JTextField();
        txtGioitinh = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        btnLoadForm = new javax.swing.JButton();
        txtLuong = new javax.swing.JLabel();
        txtluong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtVaitro = new javax.swing.JTextField();

        pnlSanPham.setBackground(new java.awt.Color(204, 255, 255));

        jLabel9.setText("NhanVien");

        jLabel16.setText("TenNV");

        jLabel17.setText("Ngay Sinh");

        jLabel18.setText("Email");

        jLabel19.setText("SDT");

        jLabel20.setText("IDNV");

        jLabel21.setText("Trang thai");

        jLabel22.setText("Dia Chi");

        jLabel23.setText("Gioi Tinh");

        btnThem1.setText("Them");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnXoa1.setText("Xoa");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        btnSua1.setText("Sua");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Ten", "Ngay sinh", "Gioi tinh", "Sdt", "Email", "Dia chi", "Luong", "Vai tro", "Trang thai"
            }
        ));
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblBang);

        btnTimkiem.setText("Tim kiem");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        btnLoadForm.setText("LoadForm");
        btnLoadForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadFormActionPerformed(evt);
            }
        });

        txtLuong.setText("Luong");

        jLabel1.setText("Vai tro");

        txtVaitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVaitroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSanPhamLayout.createSequentialGroup()
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdnv, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                .addComponent(btnThem1)
                                .addGap(68, 68, 68)
                                .addComponent(btnSua1))
                            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                        .addComponent(btnXoa1)
                                        .addGap(68, 68, 68)
                                        .addComponent(btnTimkiem)))))
                        .addGap(33, 33, 33)
                        .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLoadForm)
                            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtluong, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(txtVaitro))))
                        .addGap(88, 88, 88))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pnlSanPhamLayout.setVerticalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDiachi))
                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtIdnv)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrangthai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaysinh)
                    .addComponent(txtGioitinh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtluong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT)
                    .addComponent(jLabel1)
                    .addComponent(txtVaitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem1)
                    .addComponent(btnXoa1)
                    .addComponent(btnSua1)
                    .addComponent(btnTimkiem)
                    .addComponent(btnLoadForm))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        // TODO add your handling code here:
Validatee();
    
//        NhanVien nv = new NhanVien();
//        String idNV = txtIdnv.getText();
//        String tenNV = txtTenNV.getText();
//        String ngaySinh = txtNgaysinh.getText();
//        String gioiTinh = txtGioitinh.getText();
//        String email = txtEmail.getText();
//        String diaChi = txtDiachi.getText();
//        String sdt = txtSDT.getText();
//        String Trangthai = txtTrangthai.getText();
//        String luong = txtluong.getText();
//
//        nv.setIdnv(idNV);
//        nv.setTennv(tenNV);
//        nv.setNgaysinh(ngaySinh);
//        nv.setGioitinh(gioiTinh);
//        nv.setEmail(email);
//        nv.setDiachi(diaChi);
//        nv.setSdt(WIDTH);
//        nv.setTt(WIDTH);
//        nv.setLuong(TOP_ALIGNMENT);
//
//        int confirm = JOptionPane.showConfirmDialog(this, "ban co cac muon them?","confirm",JOptionPane.YES_NO_OPTION);
//        if(confirm == JOptionPane.YES_OPTION){
//            nvs.them(nv);
//            JOptionPane.showMessageDialog(this, "them tc");
//            LoadDAta(nvs.getList());
//
//        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        // TODO add your handling code here:
      xoa();
        
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        // TODO add your handling code here:
        int i = tblBang.getSelectedRow();
        txtIdnv.setText(tblBang.getValueAt(i, 0).toString());
        txtTenNV.setText(tblBang.getValueAt(i, 1).toString());
        txtNgaysinh.setText(tblBang.getValueAt(i, 2).toString());
        txtGioitinh.setText(tblBang.getValueAt(i, 3).toString());
        txtEmail.setText(tblBang.getValueAt(i, 5).toString());
        txtDiachi.setText(tblBang.getValueAt(i, 6).toString());
        txtSDT.setText(tblBang.getValueAt(i, 4).toString());
        txtTrangthai.setText(tblBang.getValueAt(i, 9).toString());
        txtVaitro.setText(tblBang.getValueAt(i, 8).toString());
        txtluong.setText(tblBang.getValueAt(i, 7).toString());

    }//GEN-LAST:event_tblBangMouseClicked

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnLoadFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadFormActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnLoadFormActionPerformed

    private void txtVaitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVaitroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVaitroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadForm;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGioitinh;
    private javax.swing.JTextField txtIdnv;
    private javax.swing.JLabel txtLuong;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTrangthai;
    private javax.swing.JTextField txtVaitro;
    private javax.swing.JTextField txtluong;
    // End of variables declaration//GEN-END:variables
}
