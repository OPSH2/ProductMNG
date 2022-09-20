package entity;

import java.util.Date;

public class HoaDon {
	private String maHD;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private Date ngayDatHang;
	private Date ngayGiaoHang;
	private String noiNhanGiaoHang;
	private double giaBan;

	public HoaDon() {
		super();
	}

	public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}

	public HoaDon(String maHD, NhanVien nhanVien, KhachHang khachHang, Date ngayDatHang, Date ngayGiaoHang,
			String noiNhanGiaoHang, double giaBan) {
		super();
		this.maHD = maHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.ngayDatHang = ngayDatHang;
		this.ngayGiaoHang = ngayGiaoHang;
		this.noiNhanGiaoHang = noiNhanGiaoHang;
		this.giaBan = giaBan;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public Date getNgayGiaoHang() {
		return ngayGiaoHang;
	}

	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}

	public String getNoiNhanGiaoHang() {
		return noiNhanGiaoHang;
	}

	public void setNoiNhanGiaoHang(String noiNhanGiaoHang) {
		this.noiNhanGiaoHang = noiNhanGiaoHang;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	@Override
	public String toString() {
		return "HoaDon[maHD=" + maHD + ", nhanVien=" + nhanVien + ", khacHang=" + khachHang + ", ngayDatHang="
				+ ngayDatHang + ", ngayGiaoHang=" + ngayDatHang + ", noinhanGiaoHang=" + noiNhanGiaoHang + ", giaBan="
				+ giaBan + "]";
	}
}
