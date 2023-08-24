/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package viewStudent;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import model.Grade;
import model.GradeDAO;
import model.SinhVien;
import model.SinhVienDAO;
import viewTeacher.SinhVienDialog;

/**
 *
 * @author HP
 */
public class WatchDialog extends javax.swing.JDialog {

    SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
    SinhVienDAO dao = new SinhVienDAO();
    String strHinhAnh = null;
    List<String> dsLop = new ArrayList<>();
    Set<String> idCuaThiSinhCanXoa = null;
    SinhVienDAO svDAO = new SinhVienDAO();
    GradeDAO dDAO = new GradeDAO();

    /**
     * Creates new form WatchDialog
     */
    public WatchDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        SinhVien sv = dao.getSinhVienByID("pd02");
        setModel(sv);
        Grade g = dDAO.getOneGradeByMaSV(sv.getMaSV());
        setModelGrade(g);

    }

    public SinhVien getModel() throws ParseException {
        SinhVien sv = new SinhVien();
        sv.setMaSV(txtMaSV.getText());
        sv.setTenSV(txtTenSV.getText());
        boolean gt = false;
        if (rdNam.isSelected()) {
            gt = true;
        }
        sv.setGioiTinh(gt);
        sv.setDiaChi(txtDiaChi.getText());
        sv.setNgaySinh(date_format.parse(txtNgaySinh.getText()));

//        SinhVien sv1 = dao.getSinhVienByID(sv.getMaSV());
//        strHinhAnh = sv1.getHinhAnh();
        if (strHinhAnh == null) {
            sv.setHinhAnh("NO AVATA");

        } else {
            sv.setHinhAnh(strHinhAnh);
        }

        sv.setLop(ComboBoxLop.getSelectedItem().toString());

        return sv;
    }

    public void setModel(SinhVien sv) {
        txtMaSV.setText(sv.getMaSV());
        txtTenSV.setText(sv.getTenSV());
        txtNgaySinh.setText(date_format.format(sv.getNgaySinh()));
        txtDiaChi.setText(sv.getDiaChi());
        boolean gt = sv.isGioiTinh();
        if (sv.isGioiTinh()) {
            rdNam.isSelected();
        } else {
            rdNu.isSelected();
        }
        if (sv.getHinhAnh().equalsIgnoreCase("no avata")) {
            lblHinhAnh.setText("NO AVATA");
            lblHinhAnh.setIcon(null);
        } else {
            lblHinhAnh.setText("");
            int width = lblHinhAnh.getWidth();
            int height = lblHinhAnh.getHeight();
            ImageIcon imgIcon = new ImageIcon(getClass().getResource("/anhthe/" + sv.getHinhAnh()));
            Image img = imgIcon.getImage().getScaledInstance(width, height, width);
            img.getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), 0);
            lblHinhAnh.setIcon(imgIcon);
        }
        ComboBoxLop.setSelectedItem(sv.getLop());

    }

    public void setModelGrade(Grade g) {
        txtTOAN.setText(String.valueOf(g.getAnhVan()));
        txtLY.setText(String.valueOf(g.getTinHoc()));
        txtHOA.setText(String.valueOf(g.getGdtc()));
        txtSINH.setText(String.valueOf(g.getSinh()));
        txtTIN.setText(String.valueOf(g.getTin()));
        txtCONGNGHE.setText(String.valueOf(g.getCongNghe()));
        txtNGUVAN.setText(String.valueOf(g.getNguVan()));
        txtDIALY.setText(String.valueOf(g.getDiaLy()));
        txtLICHSU.setText(String.valueOf(g.getLichSu()));
        txtCONGDAN.setText(String.valueOf(g.getCongDan()));
        txtMaSV.setText(g.getSv().getMaSV());
        txtTenSV.setText(g.getSv().getTenSV());
        lblTBC.setText(String.valueOf(g.getTBC()));
        String tb = String.format("%.2f", g.getTBC());
        lblTBC.setText(tb);
    }

    public Grade getModelGrade() {
        Grade g = new Grade();
        g.setId(0);
        SinhVien sv = new SinhVien(txtMaSV.getText(), txtTenSV.getText());
        g.setSv(sv);
        g.setAnhVan(Double.parseDouble(txtTOAN.getText()));
        g.setTinHoc(Double.parseDouble(txtLY.getText()));
        g.setGdtc(Double.parseDouble(txtHOA.getText()));
        g.setSinh(Double.parseDouble(txtSINH.getText()));
        g.setTin(Double.parseDouble(txtTIN.getText()));
        g.setCongNghe(Double.parseDouble(txtCONGNGHE.getText()));
        g.setNguVan(Double.parseDouble(txtNGUVAN.getText()));
        g.setDiaLy(Double.parseDouble(txtDIALY.getText()));
        g.setLichSu(Double.parseDouble(txtLICHSU.getText()));
        g.setCongDan(Double.parseDouble(txtCONGDAN.getText()));
        return g;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHinhAnh = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenSV = new javax.swing.JTextField();
        ComboBoxLop = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        txtTOAN = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTIN = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSINH = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCONGNGHE = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCONGDAN = new javax.swing.JTextField();
        txtLY = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtLICHSU = new javax.swing.JTextField();
        txtHOA = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDIALY = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtNGUVAN = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        lblTBC = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblHinhAnh.setText("HÌNH ẢNH");
        lblHinhAnh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("MÃ SINH VIÊN:");

        txtMaSV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaSV.setEnabled(false);
        txtMaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSVActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("HỌ VÀ TÊN");

        txtTenSV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenSV.setEnabled(false);
        txtTenSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSVActionPerformed(evt);
            }
        });

        ComboBoxLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12A1", "12A2", "12A3", "12A4", "12A5", "12B1", "12B2", "12B3", "12B4", "12B5", "12D1", "12D2", "12D3", "12D4", "12D5" }));
        ComboBoxLop.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("LỚP:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("GIỚI TÍNH:");

        txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgaySinh.setEnabled(false);
        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("NGÀY SINH:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("QUÊ QUÁN:");

        rdNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdNam.setSelected(true);
        rdNam.setText("NAM");
        rdNam.setEnabled(false);
        rdNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNamActionPerformed(evt);
            }
        });

        rdNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdNu.setText("NỮ");
        rdNu.setEnabled(false);

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        txtDiaChi.setEnabled(false);
        jScrollPane1.setViewportView(txtDiaChi);

        txtTOAN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTOAN.setEnabled(false);
        txtTOAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTOANActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("TOÁN:");

        txtTIN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTIN.setEnabled(false);
        txtTIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTINActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("TIN:");

        txtSINH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSINH.setEnabled(false);
        txtSINH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSINHActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("SINH:");

        txtCONGNGHE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCONGNGHE.setEnabled(false);
        txtCONGNGHE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCONGNGHEActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("CÔNG NGHỆ:");

        txtCONGDAN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCONGDAN.setEnabled(false);
        txtCONGDAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCONGDANActionPerformed(evt);
            }
        });

        txtLY.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLY.setEnabled(false);
        txtLY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLYActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("LỊCH SỬ:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("LÝ:");

        txtLICHSU.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLICHSU.setEnabled(false);
        txtLICHSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLICHSUActionPerformed(evt);
            }
        });

        txtHOA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHOA.setEnabled(false);
        txtHOA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHOAActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("CÔNG DÂN:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("HÓA:");

        txtDIALY.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDIALY.setEnabled(false);
        txtDIALY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDIALYActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("ĐỊA LÝ:");

        txtNGUVAN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNGUVAN.setEnabled(false);
        txtNGUVAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNGUVANActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("NGỮ VĂN:");

        lblTBC.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTBC.setForeground(new java.awt.Color(255, 51, 51));
        lblTBC.setText("0.0");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("ĐIỂM TB:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaSV)
                            .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdNam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdNu)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(ComboBoxLop, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(225, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel15))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtLY, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTOAN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtHOA, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCONGNGHE, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTIN, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtSINH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLICHSU)
                    .addComponent(txtCONGDAN)
                    .addComponent(txtDIALY, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTBC)
                    .addComponent(txtNGUVAN, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rdNam)
                            .addComponent(rdNu)
                            .addComponent(jLabel7)
                            .addComponent(ComboBoxLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTOAN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLY, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtHOA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtDIALY, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNGUVAN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtLICHSU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(txtCONGDAN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel18)
                                            .addComponent(lblTBC)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtSINH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtTIN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCONGNGHE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        // TODO add your handling code here:

        try {

            JFileChooser jfc = new JFileChooser("D:\\NetBeans-17\\quanlysinhvien\\src\\anhthe");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            strHinhAnh = file.getName();
            lblHinhAnh.setText("");
            int width = lblHinhAnh.getWidth();
            int height = lblHinhAnh.getHeight();
            lblHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));

        } catch (IOException ex) {

        }
    }//GEN-LAST:event_lblHinhAnhMouseClicked

    private void txtMaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSVActionPerformed

    private void txtTenSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSVActionPerformed

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void rdNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNamActionPerformed

    private void txtTOANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTOANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTOANActionPerformed

    private void txtTINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTINActionPerformed

    private void txtSINHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSINHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSINHActionPerformed

    private void txtCONGNGHEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCONGNGHEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCONGNGHEActionPerformed

    private void txtCONGDANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCONGDANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCONGDANActionPerformed

    private void txtLYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLYActionPerformed

    private void txtLICHSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLICHSUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLICHSUActionPerformed

    private void txtHOAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHOAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHOAActionPerformed

    private void txtDIALYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDIALYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDIALYActionPerformed

    private void txtNGUVANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNGUVANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNGUVANActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WatchDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WatchDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WatchDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WatchDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    WatchDialog dialog = new WatchDialog(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxLop;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblTBC;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTextField txtCONGDAN;
    private javax.swing.JTextField txtCONGNGHE;
    private javax.swing.JTextField txtDIALY;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtHOA;
    private javax.swing.JTextField txtLICHSU;
    private javax.swing.JTextField txtLY;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtNGUVAN;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSINH;
    private javax.swing.JTextField txtTIN;
    private javax.swing.JTextField txtTOAN;
    private javax.swing.JTextField txtTenSV;
    // End of variables declaration//GEN-END:variables
}
