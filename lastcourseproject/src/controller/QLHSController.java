package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QLHSView;

public class QLHSController implements ActionListener{
	public QLHSView view;

	public QLHSController(QLHSView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cm = e.getActionCommand();
		//JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào: " + cm);
		if (cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		} else if (cm.equals("Lưu")) {
			try {
				this.view.thucHienThemThiSinh();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (cm.equals("Cập nhật")) {
			this.view.hienThiThongTinThiSinhDaChon();

		} else if (cm.equals("Xóa")) {
			this.view.thucHienXoa();

		} else if (cm.equals("Hủy bỏ")) {
			this.view.xoaForm();
		} else if (cm.equals("Tìm")) {
			this.view.thucHienTim();
		} else if (cm.equals("Hủy tìm")) {
			this.view.thucHienHuyTim();
		}
		else if (cm.equals("About Me")) {
			this.view.hienThiAbout();
		}
		else if (cm.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		}
		else if (cm.equals("Save")) {
			this.view.thucHienSaveFile();
		}
		else if (cm.equals("Open")) {
			this.view.thucHienOpenFile();
		}

	}

}

