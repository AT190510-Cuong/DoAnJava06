package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.QLHSController;

import java.awt.EventQueue;

import model.HocSinh;
import model.QLHSModel;
import model.Tinh;

public class QLHSView extends JFrame {

	public JPanel contentPane;
	public QLHSModel model;
	public JTextField textField_MaThiSinh_TimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public ButtonGroup btn_gioiTinh;
	public JComboBox comboBox_queQuan;
	public JRadioButton radioButton_nam;
	public JRadioButton radioButton_nu;
	public JComboBox comboBox_queQuan_timKiem;
	private JTextField textField_Mon4;
	private JTextField textField_Mon5;
	private JTextField textField_Mon6;
	private JTextField textField_Mon8;
	private JTextField textField_Mon9;
	private JTextField textField_Mon10;
	private JTextField textField_Mon3;
	private JTextField textField_Mon7;
	private JTextField textField_8;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLHSView frame = new QLHSView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLHSView() {
		this.model = new QLHSModel();
		this.setTitle("PHẦM MỀM QUẢN LÍ HỌC SINH");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1315, 701);

		QLHSController action = new QLHSController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_QueQuan = new JLabel("Quê Quán");
		label_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_QueQuan.setBounds(10, 22, 86, 23);
		contentPane.add(label_QueQuan);

		JLabel label_maThiSinh = new JLabel("Mã thí sinh");
		label_maThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_maThiSinh.setBounds(283, 22, 104, 23);
		contentPane.add(label_maThiSinh);

		textField_MaThiSinh_TimKiem = new JTextField();
		textField_MaThiSinh_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_MaThiSinh_TimKiem.setColumns(10);
		textField_MaThiSinh_TimKiem.setBounds(397, 10, 138, 47);
		contentPane.add(textField_MaThiSinh_TimKiem);

		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(action);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTim.setBounds(868, 21, 89, 27);
		contentPane.add(btnTim);

		comboBox_queQuan_timKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_queQuan_timKiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan_timKiem.setBounds(110, 11, 138, 37);
		contentPane.add(comboBox_queQuan_timKiem);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 68, 1209, 8);
		contentPane.add(separator_1);

		JLabel label_QueQuan_2 = new JLabel("Danh sách thí sinh");
		label_QueQuan_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_QueQuan_2.setBounds(10, 87, 174, 23);
		contentPane.add(label_QueQuan_2);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 th\u00ED sinh", "Họ tên", "Quê quán", "Ngày sinh", "Giới tính", "Toán", "Lý",
						"Hóa", "Sinh", "Tin", "Công nghệ", "Ngữ văn", "Địa lý", "Lịch sử", "Công dân" }));

		table.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 115, 1263, 199);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 325, 1263, 2);
		contentPane.add(separator_1_1);

		JLabel label_QueQuan_1 = new JLabel("Thông tin thí sinh");
		label_QueQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_QueQuan_1.setBounds(10, 337, 157, 23);
		contentPane.add(label_QueQuan_1);

		JLabel label_ID = new JLabel("Mã thí sinh");
		label_ID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_ID.setBounds(10, 383, 93, 23);
		contentPane.add(label_ID);

		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_ID.setColumns(10);
		textField_ID.setBounds(110, 379, 212, 29);
		contentPane.add(textField_ID);

		JLabel label_HovaTen = new JLabel("Họ và tên");
		label_HovaTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_HovaTen.setBounds(10, 432, 83, 23);
		contentPane.add(label_HovaTen);

		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(110, 427, 212, 29);
		contentPane.add(textField_HoVaTen);

		JLabel label_HovaTen_1 = new JLabel("Quê quán");
		label_HovaTen_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_HovaTen_1.setBounds(10, 474, 83, 23);
		contentPane.add(label_HovaTen_1);

		comboBox_queQuan = new JComboBox();
		comboBox_queQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan.setBounds(110, 475, 212, 27);
		contentPane.add(comboBox_queQuan);

		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNgySinh.setBounds(10, 529, 83, 23);
		contentPane.add(lblNgySinh);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(110, 523, 212, 29);
		contentPane.add(textField_NgaySinh);

		JLabel label_ID_1 = new JLabel("Giới tính ");
		label_ID_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_ID_1.setBounds(371, 383, 93, 23);
		contentPane.add(label_ID_1);

		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_nu.setBounds(552, 384, 63, 23);
		contentPane.add(radioButton_nu);

		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_nam.setBounds(470, 384, 63, 23);
		contentPane.add(radioButton_nam);

		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_nam);
		btn_gioiTinh.add(radioButton_nu);

		textField_Mon1 = new JTextField();
		textField_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(464, 473, 166, 29);
		contentPane.add(textField_Mon1);

		textField_Mon2 = new JTextField();
		textField_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(464, 526, 166, 29);
		contentPane.add(textField_Mon2);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem.setBounds(249, 593, 89, 27);
		contentPane.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.setBounds(404, 593, 89, 27);
		contentPane.add(btnXoa);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCapNhat.setBounds(558, 593, 129, 27);
		contentPane.add(btnCapNhat);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLuu.setBounds(758, 593, 89, 27);
		contentPane.add(btnLuu);

		JButton btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyBo.setBounds(918, 593, 129, 27);
		contentPane.add(btnHuyBo);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 566, 1263, 6);
		contentPane.add(separator_1_1_1);

		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyTim.setBounds(985, 21, 129, 27);
		contentPane.add(btnHuyTim);

		JLabel lblSinh = new JLabel("Sinh");
		lblSinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSinh.setBounds(682, 432, 83, 23);
		contentPane.add(lblSinh);

		JLabel lblTin = new JLabel("Tin");
		lblTin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTin.setBounds(682, 474, 83, 23);
		contentPane.add(lblTin);

		JLabel lblCngNgh = new JLabel("Công nghệ");
		lblCngNgh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCngNgh.setBounds(682, 529, 99, 23);
		contentPane.add(lblCngNgh);

		textField_Mon4 = new JTextField();
		textField_Mon4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon4.setColumns(10);
		textField_Mon4.setBounds(791, 429, 166, 29);
		contentPane.add(textField_Mon4);

		textField_Mon5 = new JTextField();
		textField_Mon5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon5.setColumns(10);
		textField_Mon5.setBounds(791, 471, 166, 29);
		contentPane.add(textField_Mon5);

		textField_Mon6 = new JTextField();
		textField_Mon6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon6.setColumns(10);
		textField_Mon6.setBounds(791, 526, 166, 29);
		contentPane.add(textField_Mon6);

		textField_Mon8 = new JTextField();
		textField_Mon8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon8.setColumns(10);
		textField_Mon8.setBounds(1107, 426, 166, 29);
		contentPane.add(textField_Mon8);

		textField_Mon9 = new JTextField();
		textField_Mon9.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon9.setColumns(10);
		textField_Mon9.setBounds(1107, 474, 166, 29);
		contentPane.add(textField_Mon9);

		textField_Mon10 = new JTextField();
		textField_Mon10.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon10.setColumns(10);
		textField_Mon10.setBounds(1107, 523, 166, 29);
		contentPane.add(textField_Mon10);

		JLabel lblTon_1_1 = new JLabel("Địa lý ");
		lblTon_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTon_1_1.setBounds(1014, 432, 83, 23);
		contentPane.add(lblTon_1_1);

		JLabel lblTon_1_2 = new JLabel("Lịch sử ");
		lblTon_1_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTon_1_2.setBounds(1014, 482, 83, 23);
		contentPane.add(lblTon_1_2);

		JLabel lblTon_1_3 = new JLabel("Công dân");
		lblTon_1_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTon_1_3.setBounds(1014, 529, 83, 23);
		contentPane.add(lblTon_1_3);

		JLabel lblHa_1 = new JLabel("Hóa");
		lblHa_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblHa_1.setBounds(682, 383, 83, 23);
		contentPane.add(lblHa_1);

		JLabel lblL_1 = new JLabel("Lý");
		lblL_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblL_1.setBounds(371, 529, 83, 23);
		contentPane.add(lblL_1);

		JLabel lblTon_4 = new JLabel("Toán");
		lblTon_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTon_4.setBounds(371, 474, 83, 23);
		contentPane.add(lblTon_4);

		textField_Mon3 = new JTextField();
		textField_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(791, 380, 166, 29);
		contentPane.add(textField_Mon3);

		textField_Mon7 = new JTextField();
		textField_Mon7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon7.setColumns(10);
		textField_Mon7.setBounds(1107, 377, 166, 29);
		contentPane.add(textField_Mon7);

		JLabel lblTon_4_1 = new JLabel("Lớp");
		lblTon_4_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTon_4_1.setBounds(371, 432, 83, 23);
		contentPane.add(lblTon_4_1);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_8.setColumns(10);
		textField_8.setBounds(464, 427, 166, 29);
		contentPane.add(textField_8);

		JLabel lblNgVn = new JLabel("Ngữ văn");
		lblNgVn.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNgVn.setBounds(1014, 383, 83, 23);
		contentPane.add(lblNgVn);

		JButton btnSpXp = new JButton("Sắp Xếp");
		btnSpXp.addActionListener(action);

		btnSpXp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSpXp.setBounds(1135, 21, 138, 27);
		contentPane.add(btnSpXp);

		JLabel label_maThiSinh_1 = new JLabel("Lớp");
		label_maThiSinh_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_maThiSinh_1.setBounds(582, 22, 41, 23);
		contentPane.add(label_maThiSinh_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField.setColumns(10);
		textField.setBounds(643, 10, 138, 47);
		contentPane.add(textField);

		this.setVisible(true);
	}

	public void xoaForm() {

		textField_ID.setText("");
		textField_HoVaTen.setText("");
		textField_MaThiSinh_TimKiem.setText("");
		textField_NgaySinh.setText("");
		textField_Mon1.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		comboBox_queQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();

	}

	public void themThiSinhVaoTable(HocSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { ts.getMaHocSinh() + "", ts.getHoTen(), ts.getQueQuan().getTenTinh(),
				(ts.getNgaySinh().getMonth() + 1) + "/" + (ts.getNgaySinh().getDate()) + "/"
						+ (ts.getNgaySinh().getYear() + 1900),
				(ts.isGioiTinh() ? "Nam" : "Nữ"), ts.getToan() + "", ts.getLy() + "", ts.getHoa() + "",
				ts.getSinh() + "", ts.getTin() + "", ts.getCongNghe() + "", ts.getNguVan() + "", ts.getDiaLy() + "",
				ts.getLichSu() + "", ts.getCongDan() + "" });

	}

	public void themHoacCapNhatThiSinh(HocSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			// String mts = ts.getMaThiSinh()+"";

			this.themThiSinhVaoTable(ts);
		} else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {

				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaHocSinh() + "")) {
					model_table.setValueAt(ts.getMaHocSinh() + "", i, 0);
					model_table.setValueAt(ts.getHoTen() + "", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt((ts.getNgaySinh().getMonth() + 1) + "/" + (ts.getNgaySinh().getDate()) + "/"
							+ (ts.getNgaySinh().getYear() + 1900) + "", i, 3);
					model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Nữ") + "", i, 4);
					model_table.setValueAt(ts.getToan() + "", i, 5);
					model_table.setValueAt(ts.getLy() + "", i, 6);
					model_table.setValueAt(ts.getHoa() + "", i, 7);
					model_table.setValueAt(ts.getSinh() + "", i, 8);
					model_table.setValueAt(ts.getTin() + "", i, 9);
					model_table.setValueAt(ts.getCongNghe() + "", i, 10);
					model_table.setValueAt(ts.getNguVan() + "", i, 11);
					model_table.setValueAt(ts.getDiaLy() + "", i, 12);
					model_table.setValueAt(ts.getLichSu() + "", i, 13);
					model_table.setValueAt(ts.getCongDan() + "", i, 14);
				}

			}
		}

	}

	public HocSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		String s_ngaySinh = model_table.getValueAt(i_row, 3) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		Boolean gioiTinh = textGioiTinh.equals("Nam");

		double diemMon1 = Double.valueOf(model_table.getValueAt(i_row, 5) + "");
		double diemMon2 = Double.valueOf(model_table.getValueAt(i_row, 6) + "");
		double diemMon3 = Double.valueOf(model_table.getValueAt(i_row, 7) + "");
		double diemMon4 = Double.valueOf(model_table.getValueAt(i_row, 8) + "");
		double diemMon5 = Double.valueOf(model_table.getValueAt(i_row, 9) + "");
		double diemMon6 = Double.valueOf(model_table.getValueAt(i_row, 10) + "");
		double diemMon7 = Double.valueOf(model_table.getValueAt(i_row, 11) + "");
		double diemMon8 = Double.valueOf(model_table.getValueAt(i_row, 12) + "");
		double diemMon9 = Double.valueOf(model_table.getValueAt(i_row, 13) + "");
		double diemMon10 = Double.valueOf(model_table.getValueAt(i_row, 14) + "");

		HocSinh ts = new HocSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3,
				diemMon4, diemMon5, diemMon6, diemMon7, diemMon8, diemMon9, diemMon10);
		return ts;
	}

	public void hienThiThongTinThiSinhDaChon() {
		HocSinh ts = getThiSinhDangChon();

		this.textField_ID.setText(ts.getMaHocSinh() + "");
		this.textField_HoVaTen.setText(ts.getHoTen() + "");
		this.comboBox_queQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = (ts.getNgaySinh().getMonth() + 1) + "/" + (ts.getNgaySinh().getDate()) + "/"
				+ (ts.getNgaySinh().getYear() + 1900) + "";
		this.textField_NgaySinh.setText(s_ngaySinh + "");
		if (ts.isGioiTinh()) {
			radioButton_nam.setSelected(true);
		} else {
			radioButton_nu.setSelected(true);
		}
		// this.btn_gioiTinh.setSelected(null, rootPaneCheckingEnabled)
		this.textField_Mon1.setText(ts.getToan() + "");
		this.textField_Mon2.setText(ts.getLy() + "");
		this.textField_Mon3.setText(ts.getHoa() + "");
		this.textField_Mon4.setText(ts.getSinh() + "");
		this.textField_Mon5.setText(ts.getTin() + "");
		this.textField_Mon6.setText(ts.getCongNghe() + "");
		this.textField_Mon7.setText(ts.getNguVan() + "");
		this.textField_Mon8.setText(ts.getDiaLy() + "");
		this.textField_Mon9.setText(ts.getLichSu() + "");
		this.textField_Mon10.setText(ts.getCongDan() + "");

	}

	public void thucHienXoa() {

		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dòng đã chọn ?");
		if (luaChon == JOptionPane.YES_OPTION) {
			HocSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}

	}

	public void thucHienThemThiSinh() {
		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_queQuan.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());
		Boolean gioiTinh = true;
		if (this.radioButton_nam.isSelected()) {
			gioiTinh = true;
		} else if (this.radioButton_nu.isSelected()) {
			gioiTinh = false;
		}

		double diemMon1 = Double.valueOf(this.textField_Mon1.getText());
		double diemMon2 = Double.valueOf(this.textField_Mon2.getText());
		double diemMon3 = Double.valueOf(this.textField_Mon3.getText());
		double diemMon4 = Double.valueOf(this.textField_Mon4.getText());
		double diemMon5 = Double.valueOf(this.textField_Mon5.getText());
		double diemMon6 = Double.valueOf(this.textField_Mon6.getText());
		double diemMon7 = Double.valueOf(this.textField_Mon7.getText());
		double diemMon8 = Double.valueOf(this.textField_Mon8.getText());
		double diemMon9 = Double.valueOf(this.textField_Mon9.getText());
		double diemMon10 = Double.valueOf(this.textField_Mon10.getText());

		HocSinh ts = new HocSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3,
				diemMon4, diemMon5, diemMon6, diemMon7, diemMon8, diemMon9, diemMon10);

		// HocSinh ts = new HocSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh,
		// diemMon1, diemMon2, diemMon3);

		// private int maThiSinh;
		// private String tenThiSinh;
		// private Tinh queQuan;
		// private Date ngaySinh;
		// private boolean gioiTinh;
		// private float diemMon1, diemMon2, diemMon3;
		this.themHoacCapNhatThiSinh(ts);
	}

	public void thucHienTim() {

		this.thucHienHuyTim();

		int queQuan = this.comboBox_queQuan_timKiem.getSelectedIndex() - 1;
		String maThiSinhTimKiem = this.textField_MaThiSinh_TimKiem.getText();

		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {

				String tenTinh = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if (maThiSinhTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {

				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}

		}
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				if (idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}

		}

	}

	public void thucHienHuyTim() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if (soLuongDong == 0) {
				break;
			} else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

			}
		}
		// TODO Auto-generated method stub
		for (HocSinh ts : this.model.getDsThiSinh()) {

			this.themThiSinhVaoTable(ts);

		}

	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lí thí sinh 4.0");
	}

	public void thoatKhoiChuongTrinh() {
		// TODO Auto-generated method stub
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát ra khỏi chương trình ?", "Exit",
				JOptionPane.YES_NO_OPTION);

		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (HocSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);

			}
			oos.flush();
			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void openFile(File file) {
		ArrayList<HocSinh> ds = new ArrayList<HocSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file.getAbsoluteFile());
			ObjectInputStream ois = new ObjectInputStream(fis);

			HocSinh ts = null;
			while ((ts = (HocSinh) ois.readObject()) != null) {
				ds.add(ts);
			}

			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);

	}

	public void thucHienSaveFile() {
		if (this.model.getTenFile().length() > 0) {
			saveFile(this.model.getTenFile());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}

	}

	public void thucHienOpenFile() {
		// TODO Auto-generated method stub
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienHuyTim();
		}

	}
}
