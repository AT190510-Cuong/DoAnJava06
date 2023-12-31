/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multichatclientinterface;
import multichatclientcore.ResultCode;
import multichatclientcore.ClientManager;
import multichatclientcore.ActionType;
import multichatclientcore.Result;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MinhLuong
 */
public class ListRoom extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form ListRoom
     */
    ClientManager mClientManager;
    String mNickName;
    Login mLogin;
    public ListRoom(Login login, ClientManager clientManager) {
        initComponents();
        mLogin = login;
        mClientManager = clientManager;
        mClientManager.addObserver(this);
    }
    
    public void FillListRoom(Result result)
    {
        DefaultTableModel dtm = (DefaultTableModel)tblListPhong.getModel();
        if(result.mContent.length()>0)
        {
            //ds phòng có dạng maphong<col>tenphong<col>songuoi<col><row>
            //                 maphong<col>tenphong<col>songuoi<col><row>
            String[] rows = result.mContent.split("<row>");
            for (int i = 0; i < rows.length; i++) //hàng đầu là trống
            {
                String[] cols = rows[i].split("<col>");

                dtm.addRow(cols);
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListPhong = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnJoinRoom = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        txtTenPhong = new javax.swing.JTextField();
        btnTaoPhong = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("List Room");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblListPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Tên phòng", "Số người trong phòng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListPhong);

        btnRefresh.setText("Tải danh sách phòng");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnJoinRoom.setText("Vào phòng");
        btnJoinRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinRoomActionPerformed(evt);
            }
        });

        btnLogout.setText("Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        txtTenPhong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenPhongKeyTyped(evt);
            }
        });

        btnTaoPhong.setText("Tạo phòng");
        btnTaoPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPhongActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Danh sách phòng chat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnJoinRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenPhong)
                    .addComponent(btnTaoPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(274, 274, 274))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnJoinRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTaoPhong)
                        .addGap(116, 116, 116)
                        .addComponent(btnLogout))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPhongActionPerformed
        // TODO add your handling code here:
       String tenPhong = txtTenPhong.getText().trim();
       if(tenPhong.length()==0)
        {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên phòng", "Chưa nhập tên phòng", JOptionPane.WARNING_MESSAGE);
            txtTenPhong.requestFocus();
            return;
        }
        mClientManager.CreateRoom(tenPhong);
    }//GEN-LAST:event_btnTaoPhongActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        btnRefresh.setEnabled(false);
        DefaultTableModel dtm = (DefaultTableModel)tblListPhong.getModel();
        dtm.setRowCount(0);
        mClientManager.GetListRoom();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnJoinRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinRoomActionPerformed
        // TODO add your handling code here:
        int indexRow = tblListPhong.getSelectedRow();
        if(indexRow<0)
        {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn phòng nào", "Chưa chọn phòng", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String maPhong = tblListPhong.getValueAt(indexRow, 0).toString();
        mClientManager.JoinRoom(maPhong);
    }//GEN-LAST:event_btnJoinRoomActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        mClientManager.GetListRoom();
        this.setTitle("Xin chào " + mClientManager.mNickname);
    }//GEN-LAST:event_formWindowOpened

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        mClientManager.Logout();
        mClientManager.Dispose();
        mLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        mClientManager.Logout();
        mClientManager.Dispose();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void txtTenPhongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenPhongKeyTyped
        // TODO add your handling code here:
        String after = txtTenPhong.getText() + evt.getKeyChar();
        after = after.toLowerCase();
        if(after.contains("<row>") || after.contains("<col>"))  //vì danh sách phòng gửi về dùng <row> và <col> để tách dữ liệu nên không để người dùng đặt <row> <col> làm tên phòng
            evt.consume();
    }//GEN-LAST:event_txtTenPhongKeyTyped

    @Override
    public void update(Observable o, Object arg) {
        btnRefresh.setEnabled(true);
        Result result = (Result)arg;
        if(result.mResultCode.equals(ResultCode.ERROR))
        {
            JOptionPane.showMessageDialog(null, result.mContent, "Thất bại", JOptionPane.ERROR_MESSAGE);
            return;
        }
        switch (result.mActionType)
        {
            case ActionType.GET_LIST_ROOM:
            {
                FillListRoom(result);
                break;
            }
            case ActionType.CREATE_ROOM:
            {
                mClientManager.deleteObservers();
                RoomChat roomChat = new RoomChat(this, mClientManager, result.mContent, txtTenPhong.getText().trim(), 1);
                roomChat.setVisible(true);
                this.setVisible(false);
                break;
            }
            case ActionType.JOIN_ROOM:
            {
                int indexRow = tblListPhong.getSelectedRow();
                if(indexRow<0)
                {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn phòng nào", "Chưa chọn phòng", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String maPhong = tblListPhong.getValueAt(indexRow, 0).toString();
                String tenPhong = tblListPhong.getValueAt(indexRow, 1).toString();
                int soNguoi = Integer.parseInt(tblListPhong.getValueAt(indexRow, 2).toString());
                mClientManager.deleteObserver(this);
                RoomChat roomChat = new RoomChat(this, mClientManager, maPhong, tenPhong, soNguoi+1);
                roomChat.setVisible(true);
                this.setVisible(false);
                break;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJoinRoom;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTaoPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListPhong;
    private javax.swing.JTextField txtTenPhong;
    // End of variables declaration//GEN-END:variables
}
