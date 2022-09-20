package entity;

public class LinhKien {
	private String maLK;
	private String tenLK;
	private int soLuong;
	private double donGia;
	private String nhaCungCap;
	private String loaiHang;
	
	public LinhKien() {
		super();
	}
	public LinhKien(String maLK) {
		super();
		this.maLK = maLK;
	}
	public LinhKien(String maLK, String tenLK, int soLuong, double donGia, String nhaCungCap, String loaiHang) {
		super();
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.nhaCungCap = nhaCungCap;
		this.loaiHang = loaiHang;
	}
	public String getMaLK() {
		return maLK;
	}
	public void setMaLK(String maLK) {
		this.maLK = maLK;
	}
	public String getTenLK() {
		return tenLK;
	}
	public void setTenLK(String tenLK) {
		this.tenLK = tenLK;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public String getLoaiHang() {
		return loaiHang;
	}
	public void setLoaiHang(String loaiHang) {
		this.loaiHang = loaiHang;
	}
	
	@Override
	public String toString() {
		return "LinhKien[maLk=" + maLK + ", tenLK="  + tenLK + ", soLuong=" + soLuong + ", donGia=" + donGia + ", nhaCungCap=" + nhaCungCap + ", loaiHang=" + loaiHang + "]";
	}
}
