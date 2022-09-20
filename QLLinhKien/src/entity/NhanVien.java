package entity;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private Boolean gioiTinh;
	private String sDT;
	private String chucVu;
	private double luong;
	private String diaChi;
	private String email;
	
	public NhanVien() {
		super();
	}
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	public NhanVien(String maNV, String tenNV, Boolean gioiTinh, String sDT, String chucVu, double luong,
			String diaChi, String email) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.sDT = sDT;
		this.chucVu = chucVu;
		this.luong = luong;
		this.diaChi = diaChi;
		this.email = email;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public Boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSDT() {
		return sDT;
	}
	public void setSDT(String sDT) {
		this.sDT = sDT;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiachi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		String s ="";
		if(gioiTinh == true)
			s += "nam";
		else
			s += "nu";
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + s +", SDT=" + sDT + ", Chucvu=" + chucVu + ", luong=" + luong + ", diaChi="
				+ diaChi + ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}
	
	
	
}
