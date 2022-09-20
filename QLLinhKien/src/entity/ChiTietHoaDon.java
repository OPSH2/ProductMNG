package entity;

public class ChiTietHoaDon {
	private HoaDon hoaDon;
	private LinhKien linhKien;
	private int soLuong;
	
	public ChiTietHoaDon() {
		super();
	}
	public ChiTietHoaDon(HoaDon hoaDon, LinhKien linhKien, int soLuong) {
		super();
		this.hoaDon = hoaDon;
		this.linhKien = linhKien;
		this.soLuong = soLuong;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public LinhKien getLinhKien() {
		return linhKien;
	}
	public void setLinhKien(LinhKien linhKien) {
		this.linhKien = linhKien;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon[HoaDon=" + hoaDon + ", linhKien=" + linhKien + ", soLuong=" + soLuong + "]";
	}
}
