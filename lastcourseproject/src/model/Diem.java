package model;

import java.io.Serializable;
import java.util.Objects;

public class Diem implements Serializable {
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

	public Diem(double toan, double ly, double hoa, double sinh, double tin, double congNghe, double nguVan,
			double diaLy, double lichSu, double congDan, double diemTB) {
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

	public double getToan() {
		return toan;
	}

	public void setToan(double toan) {
		if (toan >= 0 && toan <= 10) {
			this.toan = toan;
		}
	}

	public double getLy() {
		return ly;
	}

	public void setLy(double ly) {
		if (ly >= 0 && toan <= 10) {
			this.ly = ly;
		}
	}

	public double getHoa() {
		return hoa;
	}

	public void setHoa(double hoa) {
		if (hoa >= 0 && hoa <= 10) {
			this.hoa = hoa;
		}
	}

	public double getSinh() {
		return sinh;
	}

	public void setSinh(double sinh) {
		if (sinh >= 0 && sinh <= 10) {
			this.sinh = sinh;
		}
	}

	public double getTin() {
		return tin;
	}

	public void setTin(double tin) {
		if (tin >= 0 && tin <= 10) {
			this.tin = tin;
		}
	}

	public double getCongNghe() {
		return congNghe;
	}

	public void setCongNghe(double congNghe) {
		if (congNghe >= 0 && congNghe <= 10) {
			this.congNghe = congNghe;
		}
	}

	public double getNguVan() {
		return nguVan;
	}

	public void setNguVan(double nguVan) {
		if (nguVan >= 0 && nguVan <= 10) {
			this.nguVan = nguVan;
		}
	}

	public double getDiaLy() {
		return diaLy;
	}

	public void setDiaLy(double diaLy) {
		if (diaLy >= 0 && diaLy <= 10) {
			this.diaLy = diaLy;
		}
	}

	public double getLichSu() {
		return lichSu;
	}

	public void setLichSu(double lichSu) {
		if (lichSu >= 0 && lichSu <= 10) {
			this.lichSu = lichSu;
		}
	}

	public double getCongDan() {
		return congDan;
	}

	public void setCongDan(double congDan) {
		if (congDan >= 0 && congDan <= 10) {
			this.congDan = congDan;
		}
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		if (diemTB >= 0 && diemTB <= 10) {
			this.diemTB = diemTB;
		}
	}

	@Override
	public String toString() {
		return "Diem [toan=" + toan + ", ly=" + ly + ", hoa=" + hoa + ", sinh=" + sinh + ", tin=" + tin + ", congNghe="
				+ congNghe + ", nguVan=" + nguVan + ", diaLy=" + diaLy + ", lichSu=" + lichSu + ", congDan=" + congDan
				+ ", diemTB=" + diemTB + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(congDan, congNghe, diaLy, diemTB, hoa, lichSu, ly, nguVan, sinh, tin, toan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diem other = (Diem) obj;
		return Double.doubleToLongBits(congDan) == Double.doubleToLongBits(other.congDan)
				&& Double.doubleToLongBits(congNghe) == Double.doubleToLongBits(other.congNghe)
				&& Double.doubleToLongBits(diaLy) == Double.doubleToLongBits(other.diaLy)
				&& Double.doubleToLongBits(diemTB) == Double.doubleToLongBits(other.diemTB)
				&& Double.doubleToLongBits(hoa) == Double.doubleToLongBits(other.hoa)
				&& Double.doubleToLongBits(lichSu) == Double.doubleToLongBits(other.lichSu)
				&& Double.doubleToLongBits(ly) == Double.doubleToLongBits(other.ly)
				&& Double.doubleToLongBits(nguVan) == Double.doubleToLongBits(other.nguVan)
				&& Double.doubleToLongBits(sinh) == Double.doubleToLongBits(other.sinh)
				&& Double.doubleToLongBits(tin) == Double.doubleToLongBits(other.tin)
				&& Double.doubleToLongBits(toan) == Double.doubleToLongBits(other.toan);
	}

	public double tinhDiemTB() {
		double diem_TB = (this.getToan() + this.getLy() + this.getHoa() + this.getSinh() + this.getTin()
				+ this.getCongNghe() + this.getNguVan() + this.getDiaLy() + this.getLichSu() + this.getCongDan()) / 10;
		this.setDiemTB(diem_TB);
		return Math.round(diem_TB * 100) / 100;
	}

}
