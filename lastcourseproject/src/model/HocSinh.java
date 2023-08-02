package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class HocSinh implements Serializable {
	private int maHocSinh;
	private String hoTen;
	private Tinh queQuan;
	private Date ngaySinh;
	private String lop;
	private boolean gioiTinh;

	private double toan;
	private double ly;
	private double hoa;
	private double sinh;
	private double tin;
	private double congNghe;
	private double nguVan;
	private double diaLy;
	private double lichSu;
	private double congDan;
	private double diemTB;
	
	public HocSinh() {
	}

	public HocSinh(int maHocSinh, String hoTen, Tinh queQuan, Date ngaySinh, String lop, boolean gioiTinh,
			double toan, double ly, double hoa, double sinh, double tin, double congNghe, double nguVan, double diaLy,
			double lichSu, double congDan, double diemTB) {
		this.maHocSinh = maHocSinh;
		this.hoTen = hoTen;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		this.lop = lop;
		this.gioiTinh = gioiTinh;
		this.toan = toan;
		this.ly = ly;
		this.hoa = hoa;
		this.sinh = sinh;
		this.tin = tin;
		this.congNghe = congNghe;
		this.nguVan = nguVan;
		this.diaLy = diaLy;
		this.lichSu = lichSu;
		this.congDan = congDan;
		this.diemTB = diemTB;
	}
	
	

	public HocSinh(int maHocSinh, String hoTen, Tinh queQuan, Date ngaySinh, boolean gioiTinh,
			double toan, double ly, double hoa, double sinh, double tin, double congNghe, double nguVan, double diaLy,
			double lichSu, double congDan) {
		this.maHocSinh = maHocSinh;
		this.hoTen = hoTen;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		//this.lop = lop;
		this.gioiTinh = gioiTinh;
		this.toan = toan;
		this.ly = ly;
		this.hoa = hoa;
		this.sinh = sinh;
		this.tin = tin;
		this.congNghe = congNghe;
		this.nguVan = nguVan;
		this.diaLy = diaLy;
		this.lichSu = lichSu;
		this.congDan = congDan;
		//this.diemTB = diemTB;
	}
	

	public HocSinh(int maHocSinh, String hoTen, Tinh queQuan, Date ngaySinh, String lop, boolean gioiTinh,
			double toan, double ly, double hoa) {
		this.maHocSinh = maHocSinh;
		this.hoTen = hoTen;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		this.lop = lop;
		this.gioiTinh = gioiTinh;
		this.toan = toan;
		this.ly = ly;
		this.hoa = hoa;
	}
	

	public HocSinh(int maHocSinh, String hoTen, Tinh queQuan, Date ngaySinh, boolean gioiTinh,
			double toan, double ly, double hoa) {
		this.maHocSinh = maHocSinh;
		this.hoTen = hoTen;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		//this.lop = lop;
		this.gioiTinh = gioiTinh;
		this.toan = toan;
		this.ly = ly;
		this.hoa = hoa;
	}

	public int getMaHocSinh() {
		return maHocSinh;
	}

	public void setMaHocSinh(int maHocSinh) {
		this.maHocSinh = maHocSinh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Tinh getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(Tinh queQuan) {
		this.queQuan = queQuan;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public double getToan() {
		return toan;
	}

	public void setToan(double toan) {
		this.toan = toan;
	}

	public double getLy() {
		return ly;
	}

	public void setLy(double ly) {
		this.ly = ly;
	}

	public double getHoa() {
		return hoa;
	}

	public void setHoa(double hoa) {
		this.hoa = hoa;
	}

	public double getSinh() {
		return sinh;
	}

	public void setSinh(double sinh) {
		this.sinh = sinh;
	}

	public double getTin() {
		return tin;
	}

	public void setTin(double tin) {
		this.tin = tin;
	}

	public double getCongNghe() {
		return congNghe;
	}

	public void setCongNghe(double congNghe) {
		this.congNghe = congNghe;
	}

	public double getNguVan() {
		return nguVan;
	}

	public void setNguVan(double nguVan) {
		this.nguVan = nguVan;
	}

	public double getDiaLy() {
		return diaLy;
	}

	public void setDiaLy(double diaLy) {
		this.diaLy = diaLy;
	}

	public double getLichSu() {
		return lichSu;
	}

	public void setLichSu(double lichSu) {
		this.lichSu = lichSu;
	}

	public double getCongDan() {
		return congDan;
	}

	public void setCongDan(double congDan) {
		this.congDan = congDan;
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}

	@Override
	public String toString() {
		return "HocSinh [maHocSinh=" + maHocSinh + ", hoTen=" + hoTen + ", queQuan=" + queQuan + ", ngaySinh="
				+ ngaySinh + ", lop=" + lop + ", gioiTinh=" + gioiTinh + ", toan=" + toan + ", ly=" + ly + ", hoa="
				+ hoa + ", sinh=" + sinh + ", tin=" + tin + ", congNghe=" + congNghe + ", nguVan=" + nguVan + ", diaLy="
				+ diaLy + ", lichSu=" + lichSu + ", congDan=" + congDan + ", diemTB=" + diemTB + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(congDan, congNghe, diaLy, diemTB, gioiTinh, hoTen, hoa, lichSu, lop, ly, maHocSinh,
				ngaySinh, nguVan, queQuan, sinh, tin, toan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HocSinh other = (HocSinh) obj;
		return Double.doubleToLongBits(congDan) == Double.doubleToLongBits(other.congDan)
				&& Double.doubleToLongBits(congNghe) == Double.doubleToLongBits(other.congNghe)
				&& Double.doubleToLongBits(diaLy) == Double.doubleToLongBits(other.diaLy)
				&& Double.doubleToLongBits(diemTB) == Double.doubleToLongBits(other.diemTB)
				&& gioiTinh == other.gioiTinh && Objects.equals(hoTen, other.hoTen)
				&& Double.doubleToLongBits(hoa) == Double.doubleToLongBits(other.hoa)
				&& Double.doubleToLongBits(lichSu) == Double.doubleToLongBits(other.lichSu)
				&& Objects.equals(lop, other.lop) && Double.doubleToLongBits(ly) == Double.doubleToLongBits(other.ly)
				&& Objects.equals(maHocSinh, other.maHocSinh) && Objects.equals(ngaySinh, other.ngaySinh)
				&& Double.doubleToLongBits(nguVan) == Double.doubleToLongBits(other.nguVan)
				&& Objects.equals(queQuan, other.queQuan)
				&& Double.doubleToLongBits(sinh) == Double.doubleToLongBits(other.sinh)
				&& Double.doubleToLongBits(tin) == Double.doubleToLongBits(other.tin)
				&& Double.doubleToLongBits(toan) == Double.doubleToLongBits(other.toan);
	}
	
	
	
}
