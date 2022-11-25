/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswingdev.form;

import DAO.ChatLieuDAO;
import DAO.ChiTietSanPhamDAO;
import DAO.ColorDAO;
import DAO.LoaiSPDAO;
import DAO.ProductsDAO;
import DAO.SizeDAO;
import DomainModel.ChatLieu;
import DomainModel.ChiTietSanPham;
import DomainModel.Color;
import DomainModel.LoaiSP;
import DomainModel.Products;
import DomainModel.Size;
import Validate.Validation;
import Validate.Validation1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QLSPForm extends javax.swing.JPanel {

    DefaultTableModel defaultTableModel = new DefaultTableModel();

    List<ChiTietSanPham> listPro = new ArrayList<>();
    ChiTietSanPhamDAO proDAO = new ChiTietSanPhamDAO();
    ColorDAO mauDAO = new ColorDAO();
    SizeDAO sizeDAO = new SizeDAO();
    ChatLieuDAO clieuDao = new ChatLieuDAO();
    LoaiSPDAO loaiSpDAO = new LoaiSPDAO();
    ProductsDAO spDAO = new ProductsDAO();

    /**
     * Creates new form SanPham
     */
    public QLSPForm() {
        initComponents();
        panelCRUD.setVisible(false);
        defaultTableModel = (DefaultTableModel) tblSanPham.getModel();
        txtShowsl.setEditable(false);
        txtShowChatLieu.setEditable(false);
        txtShowGia.setEditable(false);
        txtShowLoai.setEditable(false);
        txtShowMau.setEditable(false);
        txtShowSize.setEditable(false);
        txtShowTen.setEditable(false);
        txtshowId.setEditable(false);

        fillComboboxProduct();

        // fillToTable();
    }

    public void fillToTable() {

        defaultTableModel.setRowCount(0);
        List<ChiTietSanPham> listPro = proDAO.selectAll();
        for (ChiTietSanPham x : listPro) {
            defaultTableModel.addRow(new Object[]{x.getIdCTSP(), x.getLoaiSp(), x.getTenSp(), x.getMau(), x.getKichThuoc(), x.getChatLieu(), x.getSoLuong(), x.getGia()});
        }

    }

    public void fillComboboxProduct() {

        DefaultComboBoxModel cbMau = (DefaultComboBoxModel) cbbColor.getModel();
        DefaultComboBoxModel cbMau2 = (DefaultComboBoxModel) cbbMau2.getModel();
        DefaultComboBoxModel cbLoai = (DefaultComboBoxModel) cbbLoaiSp.getModel();
        DefaultComboBoxModel cbLoai2 = (DefaultComboBoxModel) cbbLoaiSp2.getModel();
        DefaultComboBoxModel cbChat = (DefaultComboBoxModel) cbbChatLieu.getModel();
        DefaultComboBoxModel cbChat2 = (DefaultComboBoxModel) cbbChatLieu2.getModel();
        DefaultComboBoxModel cbSize = (DefaultComboBoxModel) cbbSize.getModel();
        DefaultComboBoxModel cbTenSp = (DefaultComboBoxModel) cbbTenSp.getModel();

        cbbMau2.removeAllItems();
        cbbColor.removeAllItems();
        cbbChatLieu.removeAllItems();
        cbbChatLieu2.removeAllItems();
        cbbLoaiSp.removeAllItems();
        cbbLoaiSp2.removeAllItems();
        cbbSize.removeAllItems();
        cbbTenSp.removeAllItems();

        cbMau2.addElement("All");
        cbChat2.addElement("All");
        cbLoai2.addElement("All");
        List<Color> listColor = new ArrayList<>();
        listColor = mauDAO.selectAll();
        for (Color p : listColor) {
            String x = p.getTenMau();
            cbMau.addElement(x);
            cbMau2.addElement(x);
        }
        List<ChatLieu> listCL = new ArrayList<>();
        listCL = clieuDao.selectAll();
        for (ChatLieu p : listCL) {
            String x = p.getTenChatLieu();
            cbChat.addElement(x);
            cbChat2.addElement(x);
        }
        List<Size> listSize = new ArrayList<>();
        listSize = sizeDAO.selectAll();
        for (Size p : listSize) {
            String x = p.getGiaTriKichThuoc();
            cbSize.addElement(x);
        }
        List<LoaiSP> listLoaiSp = new ArrayList<>();
        listLoaiSp = loaiSpDAO.selectAll();
        for (LoaiSP p : listLoaiSp) {
            String x = p.getTenLoaiSP();
            cbLoai.addElement(x);
            cbLoai2.addElement(x);
        }
        List<Products> listSp = new ArrayList<>();
        listSp = spDAO.selectAll();
        for (Products sp : listSp) {
            String x = sp.getNameProduct();
            cbTenSp.addElement(x);
        }
    }

    private boolean validateCreate() {

        if (Validation1.iEmpty(txtGia, "Giá sp không được để trống")) {
            return true;
        }
        if (Validation1.iEmpty(txtSoLuong, "Số lượng sp không được để trống")) {
            return true;
        }
        if (Validation1.isNotDouble(txtGia, "Giá sp phải là số dương")) {
            return true;
        }
        if (Validation1.isNotInt(txtSoLuong, "Số lượng phải nguyên dương")) {
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

    private boolean clickCreate() {
        
        if (validateCreate()) {
            return true;
        }
        if (Question("Bạn có muốn thêm sp")) {
            return true;
        }
        
        
        JOptionPane.showMessageDialog(this, "Thêm sp thành công");
        
        return false;
    }
    private boolean add(){
        if(clickCreate()){
            return true;
        }
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setIdSanPham(cbbTenSp.getSelectedIndex() + 1);
        ctsp.setIdKichThuoc(cbbSize.getSelectedIndex() + 1);
        ctsp.setIdMau(cbbColor.getSelectedIndex() + 1);
        ctsp.setIdChatLieu(cbbChatLieu.getSelectedIndex() + 1);
        ctsp.setGia(Float.parseFloat(txtGia.getText()));
        ctsp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));

        LoaiSP loaisp = new LoaiSP();
        List<LoaiSP> list1 = loaiSpDAO.selectAll();
        int id = cbbLoaiSp.getSelectedIndex() + 1;
        for (LoaiSP x : list1) {
            if (!cbbLoaiSp.getSelectedItem().toString().equalsIgnoreCase(x.getTenLoaiSP())) {
                x.setTenLoaiSP(cbbLoaiSp.getSelectedItem().toString());
                loaiSpDAO.insert(x);
                id = list1.size() + 1;
                break;
            }
        }
        // The conflict occurred in database "handDuAn1", table "dbo.LoaiSp", column 'idLoaiSp'.
        Products sp = new Products();
        List<Products> list2 = spDAO.selectAll();
        for (Products x : list2) {
            if (!cbbTenSp.getSelectedItem().toString().equalsIgnoreCase(x.getNameProduct())) {
                x.setIdList(id);
                x.setNameProduct(cbbTenSp.getSelectedItem().toString());
                spDAO.insert(x);
                break;
            }
        }

        Color cl = new Color();
        List<Color> listCl = mauDAO.selectAll();
        for (Color x : listCl) {
            if (!cbbColor.getSelectedItem().toString().equalsIgnoreCase(x.getTenMau())) {
                x.setTenMau(cbbColor.getSelectedItem().toString());
                mauDAO.insert(x);
                break;
            }
        }
        Size sz = new Size();
        List<Size> listSz = sizeDAO.selectAll();
        for (Size x : listSz) {
            if (!cbbColor.getSelectedItem().toString().equalsIgnoreCase(x.getGiaTriKichThuoc())) {
                x.setGiaTriKichThuoc(cbbColor.getSelectedItem().toString());
                sizeDAO.insert(x);
                break;
            }
        }
        ChatLieu clieu = new ChatLieu();
        List<ChatLieu> listChat = clieuDao.selectAll();
        for (ChatLieu x : listChat) {
            if (!cbbChatLieu.getSelectedItem().toString().equalsIgnoreCase(x.getTenChatLieu())) {
                x.setTenChatLieu(cbbChatLieu.getSelectedItem().toString());
                clieuDao.insert(x);
                break;
            }
        }

        proDAO.insert(ctsp);
        panelCRUD.setVisible(false);
        boLoc();
        tblSanPham.setVisible(true);
        fillComboboxProduct();
        return false;
    }
    private boolean clickEdit() {
        
        if (Question("Bạn có muốn sửa")) {
            return true;
        }

        return false;
    }
    private boolean edit(){
        int index = -1;
        try {
            index = Integer.parseInt(txtshowId.getText());
        } catch (NumberFormatException e) {
        }
        if(clickEdit()){
            return true;
        }
        Color cl = new Color();
        List<Color> listCl = mauDAO.selectAll();
        for (Color x : listCl) {
            if (!cbbColor.getSelectedItem().toString().equalsIgnoreCase(x.getTenMau())) {
                x.setTenMau(cbbColor.getSelectedItem().toString());
                mauDAO.insert(x);
                break;
            }
        }
        Size sz = new Size();
        List<Size> listSz = sizeDAO.selectAll();
        for (Size x : listSz) {
            if (!cbbColor.getSelectedItem().toString().equalsIgnoreCase(x.getGiaTriKichThuoc())) {
                x.setGiaTriKichThuoc(cbbColor.getSelectedItem().toString());
                sizeDAO.insert(x);
                break;
            }
        }
        ChatLieu clieu = new ChatLieu();
        List<ChatLieu> listChat = clieuDao.selectAll();
        for (ChatLieu x : listChat) {
            if (!cbbChatLieu.getSelectedItem().toString().equalsIgnoreCase(x.getTenChatLieu())) {
                x.setTenChatLieu(cbbChatLieu.getSelectedItem().toString());
                clieuDao.insert(x);
                break;
            }
        }
        
        ChiTietSanPham ctsp = new ChiTietSanPham();
        
        
        ctsp.setIdKichThuoc(cbbSize.getSelectedIndex() + 1);
        ctsp.setIdMau(cbbColor.getSelectedIndex() + 1);
        ctsp.setIdChatLieu(cbbChatLieu.getSelectedIndex() + 1);
        ctsp.setGia(Float.parseFloat(txtGia.getText()));
        ctsp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        ctsp.setIdCTSP(index);

        proDAO.update(ctsp);
        JOptionPane.showMessageDialog(this, "Sửa sp thành công");
        panelCRUD.setVisible(false);
        boLoc();
        tblSanPham.setVisible(true);
        txtShowGia.setText(txtGia.getText());
        txtShowMau.setText(cbbColor.getSelectedItem().toString());
        txtShowSize.setText(cbbSize.getSelectedItem().toString());
        txtShowChatLieu.setText(cbbChatLieu.getSelectedItem().toString());
        txtSearch.setText("");
        fillComboboxProduct();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelTable = new javax.swing.JPanel();
        panelCRUD = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        btnAddSpToDb = new javax.swing.JButton();
        cbbLoaiSp = new javax.swing.JComboBox<>();
        cbbSize = new javax.swing.JComboBox<>();
        cbbColor = new javax.swing.JComboBox<>();
        txtGia = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        cbbChatLieu = new javax.swing.JComboBox<>();
        btnAddLoai = new javax.swing.JLabel();
        btnAddSize = new javax.swing.JLabel();
        btnAddMau = new javax.swing.JLabel();
        btnAddChatLieu = new javax.swing.JLabel();
        txtSetTittle = new javax.swing.JLabel();
        cbbTenSp = new javax.swing.JComboBox<>();
        btnAddTenSp = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cbbLoaiSp2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbbMau2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbbChatLieu2 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        rdoduoi = new javax.swing.JRadioButton();
        rdotren = new javax.swing.JRadioButton();
        txtMucDinhTon = new javax.swing.JTextField();
        rdoAll = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtshowId = new javax.swing.JTextField();
        txtShowGia = new javax.swing.JTextField();
        txtShowTen = new javax.swing.JTextField();
        txtShowLoai = new javax.swing.JTextField();
        txtShowSize = new javax.swing.JTextField();
        txtShowsl = new javax.swing.JTextField();
        txtShowMau = new javax.swing.JTextField();
        txtShowChatLieu = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Mặt Hàng");

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearch.setBorder(null);
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Sửa");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Xóa");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        panelTable.setBackground(new java.awt.Color(223, 207, 190));
        panelTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelCRUD.setBackground(new java.awt.Color(127, 205, 205));
        panelCRUD.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.red, null));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Số Lương");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Chất Liệu");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Giá");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Màu sắc");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Tên Sp");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Loại");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Kích Thước");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/Left.png"))); // NOI18N
        jButton4.setText("Thoát");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnAddSpToDb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddSpToDb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/add.png"))); // NOI18N
        btnAddSpToDb.setText("Thêm");
        btnAddSpToDb.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAddSpToDb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSpToDbActionPerformed(evt);
            }
        });

        cbbLoaiSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtGia.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        cbbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAddLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/add.png"))); // NOI18N
        btnAddLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddLoaiMouseClicked(evt);
            }
        });

        btnAddSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/add.png"))); // NOI18N
        btnAddSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddSizeMouseClicked(evt);
            }
        });

        btnAddMau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/add.png"))); // NOI18N
        btnAddMau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMauMouseClicked(evt);
            }
        });

        btnAddChatLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/add.png"))); // NOI18N
        btnAddChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddChatLieuMouseClicked(evt);
            }
        });

        txtSetTittle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtSetTittle.setText("Thêm Mới Sản Phẩm");

        cbbTenSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAddTenSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/add.png"))); // NOI18N
        btnAddTenSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddTenSpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCRUDLayout = new javax.swing.GroupLayout(panelCRUD);
        panelCRUD.setLayout(panelCRUDLayout);
        panelCRUDLayout.setHorizontalGroup(
            panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCRUDLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCRUDLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(txtSetTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCRUDLayout.createSequentialGroup()
                        .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGap(31, 31, 31)
                        .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelCRUDLayout.createSequentialGroup()
                                .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnAddChatLieu))
                            .addGroup(panelCRUDLayout.createSequentialGroup()
                                .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbbLoaiSp, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbSize, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbColor, 0, 251, Short.MAX_VALUE)
                                    .addComponent(cbbTenSp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(34, 34, 34)
                                .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddSize)
                                    .addComponent(btnAddMau)
                                    .addComponent(btnAddTenSp)
                                    .addComponent(btnAddLoai)))
                            .addComponent(txtGia)
                            .addComponent(txtSoLuong)))
                    .addComponent(jLabel3))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCRUDLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAddSpToDb, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );
        panelCRUDLayout.setVerticalGroup(
            panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCRUDLayout.createSequentialGroup()
                .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCRUDLayout.createSequentialGroup()
                        .addComponent(txtSetTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnAddLoai))
                    .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbbLoaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCRUDLayout.createSequentialGroup()
                        .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbbTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbbColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCRUDLayout.createSequentialGroup()
                        .addComponent(btnAddTenSp)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddSize)
                        .addGap(23, 23, 23)
                        .addComponent(btnAddMau)
                        .addGap(30, 30, 30)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddChatLieu))
                        .addGap(24, 24, 24)))
                .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSpToDb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Sp", "Loại Sp", "Tên Sp", "Màu", "Kích Thước", "Chất Liệu", "Số Lượng", "Giá Bán"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setMinWidth(55);
            tblSanPham.getColumnModel().getColumn(0).setMaxWidth(55);
            tblSanPham.getColumnModel().getColumn(1).setMinWidth(85);
            tblSanPham.getColumnModel().getColumn(1).setMaxWidth(85);
            tblSanPham.getColumnModel().getColumn(3).setMinWidth(100);
            tblSanPham.getColumnModel().getColumn(3).setMaxWidth(100);
            tblSanPham.getColumnModel().getColumn(4).setMinWidth(85);
            tblSanPham.getColumnModel().getColumn(4).setMaxWidth(85);
            tblSanPham.getColumnModel().getColumn(5).setMinWidth(110);
            tblSanPham.getColumnModel().getColumn(5).setMaxWidth(110);
            tblSanPham.getColumnModel().getColumn(6).setMinWidth(100);
            tblSanPham.getColumnModel().getColumn(6).setMaxWidth(100);
            tblSanPham.getColumnModel().getColumn(7).setMinWidth(200);
            tblSanPham.getColumnModel().getColumn(7).setMaxWidth(200);
        }

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTableLayout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addComponent(panelCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
            .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTableLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(panelCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTableLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)))
        );

        lblSearch.setText(" ");

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Tìm");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        cbbLoaiSp2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLoaiSp2.setBorder(null);
        cbbLoaiSp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiSp2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Loại Sp");

        cbbMau2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMau2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMau2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Màu");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Chất Liệu");

        cbbChatLieu2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbChatLieu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChatLieu2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbLoaiSp2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbMau2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbbChatLieu2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbLoaiSp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbMau2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbChatLieu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Giá Bán");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Từ thấp đến cao");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Từ cao đến thấp");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(rdoduoi);
        rdoduoi.setText("Dưới mức định tồn");
        rdoduoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoduoiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdotren);
        rdotren.setText("Vượt mức định tồn");
        rdotren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdotrenActionPerformed(evt);
            }
        });

        txtMucDinhTon.setText("10");
        txtMucDinhTon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMucDinhTonKeyTyped(evt);
            }
        });

        buttonGroup1.add(rdoAll);
        rdoAll.setSelected(true);
        rdoAll.setText("Tất cả");
        rdoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAllActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Tồn kho");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Mức định tồn");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(rdoAll)
                    .addComponent(rdotren)
                    .addComponent(rdoduoi)
                    .addComponent(txtMucDinhTon, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMucDinhTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoduoi)
                .addGap(18, 18, 18)
                .addComponent(rdotren)
                .addContainerGap())
        );

        jSeparator2.setForeground(new java.awt.Color(240, 240, 240));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
            .addComponent(jSeparator2)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(247, 202, 201));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, null));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Id Sp");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Loại Sp");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Tên Sp");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Giá");

        txtshowId.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txtShowGia.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txtShowTen.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txtShowLoai.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txtShowSize.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txtShowsl.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txtShowMau.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txtShowChatLieu.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Chất Liệu");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Kích Thước");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Số lượng");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Màu");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtshowId, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(txtShowLoai)
                    .addComponent(txtShowTen)
                    .addComponent(txtShowGia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtShowMau)
                    .addComponent(txtShowsl)
                    .addComponent(txtShowSize)
                    .addComponent(txtShowChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtShowMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtShowsl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtShowSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtShowChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtshowId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtShowLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtShowTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtShowGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(lblSearch)
                        .addGap(43, 43, 43)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSearch)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        tblSanPham.setVisible(false);
        panelCRUD.setVisible(true);
        cbbTenSp.setEnabled(true);
        cbbLoaiSp.setEnabled(true);
        txtSoLuong.setEditable(true);
        txtSetTittle.setText("Thêm Mới Sản Phẩm");
        btnAddSpToDb.setText("Thêm");
        txtGia.setText("");
        txtSoLuong.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        panelCRUD.setVisible(false);
        tblSanPham.setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnAddSpToDbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSpToDbActionPerformed
        String i = btnAddSpToDb.getText();
        if(i.equalsIgnoreCase("Thêm")){
            add();
        }else{
            edit();
        }
        
    }//GEN-LAST:event_btnAddSpToDbActionPerformed

    private void btnAddLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddLoaiMouseClicked
        String i = JOptionPane.showInputDialog("Thêm loại sp");
        try {
            while (i.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống");
                i = JOptionPane.showInputDialog("Thêm loại sp");
            }
        } catch (Exception e) {
        }
        DefaultComboBoxModel cbLoai = (DefaultComboBoxModel) cbbLoaiSp.getModel();
        DefaultComboBoxModel cbLoai2 = (DefaultComboBoxModel) cbbLoaiSp2.getModel();
        cbbLoaiSp.removeAllItems();
        cbbLoaiSp2.removeAllItems();
        List<LoaiSP> listLoaiSp = new ArrayList<>();
        listLoaiSp = loaiSpDAO.selectAll();
        for (LoaiSP p : listLoaiSp) {
            String x = p.getTenLoaiSP();
            cbLoai.addElement(x);
            cbLoai2.addElement(x);
        }
        try {
            if (!i.isEmpty()) {
                cbLoai.addElement(i);
                cbLoai2.addElement(i);
                cbbLoaiSp.setSelectedItem(i);
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnAddLoaiMouseClicked

    private void btnAddMauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMauMouseClicked
        String i = JOptionPane.showInputDialog("Thêm mã màu");
        try {
            while (i.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống");
                i = JOptionPane.showInputDialog("Thêm mã màu sp");
            }
        } catch (Exception e) {
        }
        DefaultComboBoxModel cbMau = (DefaultComboBoxModel) cbbColor.getModel();
        DefaultComboBoxModel cbMau2 = (DefaultComboBoxModel) cbbMau2.getModel();
        cbbMau2.removeAllItems();
        cbbColor.removeAllItems();

        List<Color> listColor = new ArrayList<>();
        listColor = mauDAO.selectAll();

        for (Color p : listColor) {
            String x = p.getTenMau();
            cbMau.addElement(x);
            cbMau2.addElement(x);
        }
        try {
            if (!i.isEmpty()) {
                cbMau.addElement(i);
                cbbColor.setSelectedItem(i);
            }
        } catch (Exception e) {
        }

        cbMau2.addElement(i);    }//GEN-LAST:event_btnAddMauMouseClicked

    private void btnAddSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddSizeMouseClicked
        String i = JOptionPane.showInputDialog("Thêm kích thước sp");
        try {
            while (i.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống");
                i = JOptionPane.showInputDialog("Thêm kích thước sp");
            }
        } catch (Exception e) {
        }
        DefaultComboBoxModel cb = (DefaultComboBoxModel) cbbSize.getModel();

        cbbSize.removeAllItems();

        List<Size> listLoaiSp = new ArrayList<>();
        listLoaiSp = sizeDAO.selectAll();
        for (Size p : listLoaiSp) {
            String x = p.getGiaTriKichThuoc();
            cb.addElement(x);

        }
        try {
            if (!i.isEmpty()) {
                cb.addElement(i);
                cbbSize.setSelectedItem(i);
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnAddSizeMouseClicked

    private void btnAddChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddChatLieuMouseClicked
        String i = JOptionPane.showInputDialog("Thêm chất liệu sp");
        try {
            while (i.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống");
                i = JOptionPane.showInputDialog("Thêm chất liệu sp");
            }
        } catch (Exception e) {
        }
        DefaultComboBoxModel cbLoai = (DefaultComboBoxModel) cbbChatLieu.getModel();
        DefaultComboBoxModel cbLoai2 = (DefaultComboBoxModel) cbbChatLieu2.getModel();
        cbbChatLieu.removeAllItems();
        cbbChatLieu2.removeAllItems();
        List<ChatLieu> listLoaiSp = new ArrayList<>();
        listLoaiSp = clieuDao.selectAll();
        for (ChatLieu p : listLoaiSp) {
            String x = p.getTenChatLieu();
            cbLoai.addElement(x);
            cbLoai2.addElement(x);
        }
        try {
            if (!i.isEmpty()) {
                cbLoai.addElement(i);
                cbLoai2.addElement(i);
                cbbChatLieu.setSelectedItem(i);
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnAddChatLieuMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtSetTittle.setText("Sửa Sản Phẩm");
        btnAddSpToDb.setText("Sửa");
        cbbTenSp.setEnabled(false);
        cbbLoaiSp.setEnabled(false);
        txtSoLuong.setEditable(false);
        int index = -1;
        try {
            index = Integer.parseInt(txtshowId.getText());
        } catch (NumberFormatException e) {
        }

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chọn sp muốn sửa");

        } else {
            panelCRUD.setVisible(true);
            tblSanPham.setVisible(false);

            cbbLoaiSp.setSelectedItem(txtShowLoai.getText());
            cbbTenSp.setSelectedItem(txtShowTen.getText());
            cbbSize.setSelectedItem(txtShowSize.getText());
            cbbColor.setSelectedItem(txtShowMau.getText());
            cbbChatLieu.setSelectedItem(txtShowChatLieu.getText());
            txtGia.setText(txtShowGia.getText());
            txtSoLuong.setText(txtShowsl.getText());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void rdoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAllActionPerformed
        fillToTable();
        cbbChatLieu2.setSelectedIndex(0);
        cbbMau2.setSelectedIndex(0);
        cbbLoaiSp2.setSelectedIndex(0);
    }//GEN-LAST:event_rdoAllActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        listPro = boLoc();
        Collections.sort(listPro, (a, b) -> (int) (a.getGia() - b.getGia()));
        defaultTableModel.setRowCount(0);

        for (ChiTietSanPham x : listPro) {
            defaultTableModel.addRow(new Object[]{x.getIdCTSP(), x.getLoaiSp(), x.getTenSp(), x.getMau(), x.getKichThuoc(), x.getChatLieu(), x.getSoLuong(), x.getGia()});
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        listPro = boLoc();
        Collections.sort(listPro, (a, b) -> (int) (b.getGia() - a.getGia()));
        defaultTableModel.setRowCount(0);

        for (ChiTietSanPham x : listPro) {
            defaultTableModel.addRow(new Object[]{x.getIdCTSP(), x.getLoaiSp(), x.getTenSp(), x.getMau(), x.getKichThuoc(), x.getChatLieu(), x.getSoLuong(), x.getGia()});
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void rdoduoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoduoiActionPerformed
        duoiMuc();
    }//GEN-LAST:event_rdoduoiActionPerformed

    private void rdotrenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdotrenActionPerformed
        trenMuc();
    }//GEN-LAST:event_rdotrenActionPerformed

    private void txtMucDinhTonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMucDinhTonKeyTyped
        if (rdoduoi.isSelected()) {
            duoiMuc();
        }
        if (rdotren.isSelected()) {
            trenMuc();
        }
    }//GEN-LAST:event_txtMucDinhTonKeyTyped

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped

    }//GEN-LAST:event_txtSearchKeyTyped

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed

    }//GEN-LAST:event_txtSearchKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        rdoAll.setSelected(true);
        try {
            searchTable();
        } catch (Exception e) {
            searchKeyFillTable();

        }
        try {
            show2(searchTable());
        } catch (Exception e) {
            show1(0);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void cbbLoaiSp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiSp2ActionPerformed
        boLoc();
    }//GEN-LAST:event_cbbLoaiSp2ActionPerformed

    private void cbbMau2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMau2ActionPerformed
        boLoc();
    }//GEN-LAST:event_cbbMau2ActionPerformed

    private void cbbChatLieu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChatLieu2ActionPerformed
        boLoc();
    }//GEN-LAST:event_cbbChatLieu2ActionPerformed

    private void btnAddTenSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddTenSpMouseClicked
        String i = JOptionPane.showInputDialog("Thêm tên  sp");
        try {
            while (i.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không được để trống");
                i = JOptionPane.showInputDialog("Thêm tên sp");
            }
        } catch (Exception e) {
        }

        DefaultComboBoxModel cbLoai = (DefaultComboBoxModel) cbbTenSp.getModel();

        cbbTenSp.removeAllItems();

        List<Products> listLoaiSp = new ArrayList<>();
        listLoaiSp = spDAO.selectAll();
        for (Products p : listLoaiSp) {
            String x = p.getNameProduct();
            cbLoai.addElement(x);

        }
        try {
            if (!i.isEmpty()) {
                cbLoai.addElement(i);

                cbbTenSp.setSelectedItem(i);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAddTenSpMouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int index = tblSanPham.getSelectedRow();
        show3(index);


    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        xoa();
    }//GEN-LAST:event_jButton3ActionPerformed
    private void show(int i) {
        listPro = boLoc1();
        txtshowId.setText(String.valueOf(listPro.get(i).getIdCTSP()));
        txtShowTen.setText(listPro.get(i).getTenSp());
        txtShowLoai.setText(listPro.get(i).getLoaiSp());
        txtShowGia.setText(String.valueOf(listPro.get(i).getGia()));
        txtShowSize.setText(listPro.get(i).getKichThuoc());
        txtShowMau.setText(listPro.get(i).getMau());
        txtShowsl.setText(String.valueOf(listPro.get(i).getSoLuong()));
        txtShowChatLieu.setText(listPro.get(i).getChatLieu());
    }

    private void show1(int i) {
        List<ChiTietSanPham> listPro1 = searchKeyFillTable();
        txtshowId.setText(String.valueOf(listPro1.get(i).getIdCTSP()));
        txtShowTen.setText(listPro1.get(i).getTenSp());
        txtShowLoai.setText(listPro1.get(i).getLoaiSp());
        txtShowGia.setText(String.valueOf(listPro1.get(i).getGia()));
        txtShowSize.setText(listPro1.get(i).getKichThuoc());
        txtShowMau.setText(listPro1.get(i).getMau());
        txtShowsl.setText(String.valueOf(listPro1.get(i).getSoLuong()));
        txtShowChatLieu.setText(listPro1.get(i).getChatLieu());
    }

    private void show2(ChiTietSanPham x) {

        txtshowId.setText(String.valueOf(x.getIdCTSP()));
        txtShowTen.setText(x.getTenSp());
        txtShowLoai.setText(x.getLoaiSp());
        txtShowGia.setText(String.valueOf(x.getGia()));
        txtShowSize.setText(x.getKichThuoc());
        txtShowMau.setText(x.getMau());
        txtShowsl.setText(String.valueOf(x.getSoLuong()));
        txtShowChatLieu.setText(x.getChatLieu());
    }
    private void show3(int i) {
        List<ChiTietSanPham> listPros = new ArrayList<>();
        ChiTietSanPham x = new ChiTietSanPham();
        try {
            x = searchTable();
        } catch (Exception e) {
            listPros = searchKeyFillTable();
        }
        if(listPros.isEmpty()){
            listPros = boLoc1();
        }
        txtshowId.setText(String.valueOf(listPros.get(i).getIdCTSP()));
        txtShowTen.setText(listPros.get(i).getTenSp());
        txtShowLoai.setText(listPros.get(i).getLoaiSp());
        txtShowGia.setText(String.valueOf(listPros.get(i).getGia()));
        txtShowSize.setText(listPros.get(i).getKichThuoc());
        txtShowMau.setText(listPros.get(i).getMau());
        txtShowsl.setText(String.valueOf(listPros.get(i).getSoLuong()));
        txtShowChatLieu.setText(listPros.get(i).getChatLieu());
    }
    private int muc() {
        int i = 10;
        try {
            i = Integer.parseInt(txtMucDinhTon.getText());
        } catch (Exception e) {
        }
        return i;
    }
    private boolean xoa(){
        int index = -1;
        try {
            index = Integer.parseInt(txtshowId.getText());
        } catch (NumberFormatException e) {
        }
        if(index == -1){
            JOptionPane.showMessageDialog(this, "Chọn sp muốn xóa", "error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (Question("Bạn có muốn xóa")) {
            return true;
        }
        JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công");
        proDAO.delete(index);
        boLoc();
        txtshowId.setText("");
        txtShowsl.setText("");
        txtShowTen.setText("");
        txtShowSize.setText("");
        txtShowChatLieu.setText("");
        txtShowGia.setText("");
        txtShowLoai.setText("");
        txtShowMau.setText("");
        
        return false;
    }
    private void duoiMuc() {
        listPro = proDAO.selectAll();
        List<ChiTietSanPham> newList = new ArrayList<>();
        for (ChiTietSanPham x : listPro) {
            if (x.getSoLuong() <= muc()) {
                newList.add(x);
            }
        }
        defaultTableModel.setRowCount(0);

        for (ChiTietSanPham x : newList) {
            defaultTableModel.addRow(new Object[]{x.getIdCTSP(), x.getLoaiSp(), x.getTenSp(), x.getMau(), x.getKichThuoc(), x.getChatLieu(), x.getSoLuong(), x.getGia()});
        }
    }

    private void trenMuc() {
        listPro = proDAO.selectAll();
        List<ChiTietSanPham> newList = new ArrayList<>();
        for (ChiTietSanPham x : listPro) {
            if (x.getSoLuong() > muc()) {
                newList.add(x);
            }
        }
        defaultTableModel.setRowCount(0);

        for (ChiTietSanPham x : newList) {
            defaultTableModel.addRow(new Object[]{x.getIdCTSP(), x.getLoaiSp(), x.getTenSp(), x.getMau(), x.getKichThuoc(), x.getChatLieu(), x.getSoLuong(), x.getGia()});
        }
    }

    public ChiTietSanPham searchTable() {
        // tìm kiếm theo mã sản phẩm
        defaultTableModel = (DefaultTableModel) tblSanPham.getModel();
        defaultTableModel.setRowCount(0);
        int keyWord = Integer.parseInt(txtSearch.getText());

        ChiTietSanPham x = proDAO.selectById(keyWord);

        defaultTableModel.addRow(new Object[]{x.getIdCTSP(), x.getLoaiSp(), x.getTenSp(), x.getMau(), x.getKichThuoc(), x.getChatLieu(), x.getSoLuong(), x.getGia()});

        lblSearch.setText("");
        return x;
    }

    public List<ChiTietSanPham> searchKeyFillTable() {
        // tìm kiếm theo tên sản phẩm
        String key = txtSearch.getText();
        defaultTableModel = (DefaultTableModel) tblSanPham.getModel();
        defaultTableModel.setRowCount(0);
        List<ChiTietSanPham> list = proDAO.selectByKey(key);
        List<ChiTietSanPham> lists = boLoc();
        List<ChiTietSanPham> listss = new ArrayList<>();
        defaultTableModel.setRowCount(0);
        for (ChiTietSanPham x : list) {
            for (ChiTietSanPham i : lists) {
                if (i.getIdCTSP() == x.getIdCTSP()) {
                    defaultTableModel.addRow(new Object[]{x.getIdCTSP(), x.getLoaiSp(), x.getTenSp(), x.getMau(),
                        x.getKichThuoc(), x.getChatLieu(), x.getSoLuong(), x.getGia()});
                    listss.add(i);
                }
            }
        }
        defaultTableModel.fireTableDataChanged();
        return listss;
    }

    private List<ChiTietSanPham> boLoc1() {
        listPro = proDAO.selectAll();
        List<ChiTietSanPham> newList = new ArrayList<>();

        String loai = "All";
        String mau = "All";
        String chatLieu = "All";

        try {
            loai = cbbLoaiSp2.getSelectedItem().toString();
            mau = cbbMau2.getSelectedItem().toString();
            chatLieu = cbbChatLieu2.getSelectedItem().toString();
        } catch (Exception e) {
        }

        for (ChiTietSanPham x : listPro) {
            if (loai.equalsIgnoreCase("All") && mau.equalsIgnoreCase("All") && chatLieu.equalsIgnoreCase("All")) {
                newList = listPro;
            }

            if (loai.equalsIgnoreCase("All")) {
                if (mau.equalsIgnoreCase("All")) {
                    if (chatLieu.equalsIgnoreCase(x.getChatLieu())) {
                        newList.add(x);
                    }
                } else {
                    if (chatLieu.equalsIgnoreCase("All")) {
                        if (mau.equalsIgnoreCase(x.getMau())) {
                            newList.add(x);
                        }
                    } else {
                        if (mau.equalsIgnoreCase(x.getMau()) && chatLieu.equalsIgnoreCase(x.getChatLieu())) {
                            newList.add(x);
                        }
                    }
                }
            }
            if (loai.equalsIgnoreCase(x.getLoaiSp())) {
                if (mau.equalsIgnoreCase("All") && chatLieu.equalsIgnoreCase("All")) {
                    newList.add(x);
                } else if (mau.equalsIgnoreCase("All") && chatLieu.equalsIgnoreCase(x.getChatLieu())) {
                    if (chatLieu.equalsIgnoreCase(x.getChatLieu())) {
                        newList.add(x);
                    }
                } else if (mau.equalsIgnoreCase(x.getMau()) && chatLieu.equalsIgnoreCase("All")) {
                    if (mau.equalsIgnoreCase(x.getMau())) {
                        newList.add(x);
                    }
                } else {
                    if (mau.equalsIgnoreCase(x.getMau()) && chatLieu.equalsIgnoreCase(x.getChatLieu())) {
                        newList.add(x);
                    }
                }
            }
        }

        return newList;
    }

    private List<ChiTietSanPham> boLoc() {
        List<ChiTietSanPham> newList = boLoc1();
        defaultTableModel.setRowCount(0);
        for (ChiTietSanPham i : newList) {
            defaultTableModel.addRow(new Object[]{i.getIdCTSP(), i.getLoaiSp(), i.getTenSp(), i.getMau(),
                i.getKichThuoc(), i.getChatLieu(), i.getSoLuong(), i.getGia()});
        }
        return newList;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAddChatLieu;
    private javax.swing.JLabel btnAddLoai;
    private javax.swing.JLabel btnAddMau;
    private javax.swing.JLabel btnAddSize;
    private javax.swing.JButton btnAddSpToDb;
    private javax.swing.JLabel btnAddTenSp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbChatLieu2;
    private javax.swing.JComboBox<String> cbbColor;
    private javax.swing.JComboBox<String> cbbLoaiSp;
    private javax.swing.JComboBox<String> cbbLoaiSp2;
    private javax.swing.JComboBox<String> cbbMau2;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbbTenSp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JPanel panelCRUD;
    private javax.swing.JPanel panelTable;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoduoi;
    private javax.swing.JRadioButton rdotren;
    private javaswingdev.swing.RoundPanel roundPanel1;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMucDinhTon;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel txtSetTittle;
    private javax.swing.JTextField txtShowChatLieu;
    private javax.swing.JTextField txtShowGia;
    private javax.swing.JTextField txtShowLoai;
    private javax.swing.JTextField txtShowMau;
    private javax.swing.JTextField txtShowSize;
    private javax.swing.JTextField txtShowTen;
    private javax.swing.JTextField txtShowsl;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtshowId;
    // End of variables declaration//GEN-END:variables
}
