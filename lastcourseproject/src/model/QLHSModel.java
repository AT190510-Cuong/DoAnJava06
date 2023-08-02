package model;

import java.util.ArrayList;

public class QLHSModel {
	private ArrayList<HocSinh> dsHocSinh;
	private String luaChon;
	private String tenFile;

	public QLHSModel() {
		this.dsHocSinh = new ArrayList<HocSinh>();
		this.luaChon = "";
		this.tenFile = "";
	}

	public QLHSModel(ArrayList<HocSinh> dsThiSinh) {
		this.dsHocSinh = dsThiSinh;
	}

	public ArrayList<HocSinh> getDsThiSinh() {
		return dsHocSinh;
	}

	public void setDsThiSinh(ArrayList<HocSinh> dsThiSinh) {
		this.dsHocSinh = dsThiSinh;
	}

	public void insert(HocSinh thiSinh) {
		this.dsHocSinh.add(thiSinh);
	}

	public void delete(HocSinh thiSinh) {
		this.dsHocSinh.remove(thiSinh);
	}

	public void update(HocSinh thiSinh) {
		this.dsHocSinh.remove(thiSinh);
		this.dsHocSinh.add(thiSinh);
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	
	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public boolean kiemTraTonTai(HocSinh ts) {
		for (HocSinh thiSinh : dsHocSinh) {
			if (thiSinh.getMaHocSinh() == ts.getMaHocSinh()) {
				return true;
			}

		}

		return false;
	}

}
