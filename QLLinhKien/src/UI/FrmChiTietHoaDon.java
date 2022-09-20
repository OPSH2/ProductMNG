package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FrmChiTietHoaDon extends JFrame {

	private DefaultTableModel modelHoaDonct;
	private JTable tblHoaDonct;
	private JLabel lblTenCuaHang;
	private JLabel lblBanLinhKien;
	private JPanel p;
	private JPanel pNorth;
	private JPanel pSouth;
	private Box b;
	private Box bTenCuaHang;
	private Box bTenNV;
	private Box bNgayLap;
	private Box bNgayNhan;
	private Box bNoiNhan;
	private Box bMaHd;
	private Box bTenKH;
	private Box bSouth;
	private Box b1;
	private Box b2;

	private Box bVienTren;
	private Box bVienDuoi;
	private JTextField txtBanLinhKien;
	private JTextField txtTenNV;
	private JLabel lblTenNV;
	private JLabel lblNgayLap;
	private JTextField txtNgayLap;
	private JLabel lblNgayNhan;
	private JTextField txtNgayNhan;
	private JLabel lblNoiNhan;
	private JTextField txtNoiNhan;
	private JLabel lblMaHD;
	private JTextField txtMaHD;
	private JLabel lblTenKH;
	private JTextField txtTenKH;
	private JLabel lblThanhTien;
	private JTextField txtThanhTien;
	private JLabel lblGiamGia;
	private JTextField txtGiamGia;
	private Box bLinhKien;
	private JTextField pVienTren;
	private JTextField pVienDuoi;
	private JButton btnin;
	private Box b3;

	public FrmChiTietHoaDon() {
		// TODO Auto-generated constructor stub
		setTitle("FrmHoaDonChiTiet");
		setSize(800, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		p=new JPanel();
		pNorth=new JPanel();
		pSouth=new JPanel();
		pVienTren=new JTextField(60);
		pVienDuoi=new JTextField(60);
		
		pVienTren.setText("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		pVienTren.setForeground(Color.BLACK);
		pVienTren.setBorder(null);
		pVienTren.setBackground(null);
		
		
		pVienDuoi.setText("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		pVienDuoi.setForeground(Color.BLACK);
		pVienDuoi.setBorder(null);
		pVienDuoi.setBackground(null);
		
		b=Box.createVerticalBox();
		bTenCuaHang=Box.createHorizontalBox();
		bLinhKien=Box.createHorizontalBox();
		bTenNV=Box.createHorizontalBox();
		bNgayLap=Box.createHorizontalBox();
		bNgayNhan=Box.createHorizontalBox();
		bNoiNhan=Box.createHorizontalBox();
		bMaHd=Box.createHorizontalBox();
		bTenKH=Box.createHorizontalBox();
		
		bSouth=Box.createVerticalBox();
		b1=Box.createHorizontalBox();
		b2=Box.createHorizontalBox();
		b3=Box.createHorizontalBox();
		
		bVienTren=Box.createHorizontalBox();
		bVienDuoi=Box.createHorizontalBox();
		
		lblTenCuaHang=new JLabel("Tên Cửa Hàng");
		lblTenCuaHang.setFont(new Font("Arial", Font.BOLD, 30));
		lblTenCuaHang.setForeground(Color.black);
		
		txtBanLinhKien=new JTextField(40);
		//txtBanLinhKien.setForeground(Color.BLACK);
		txtBanLinhKien.setBorder(null);
		txtBanLinhKien.setBackground(null);
		txtBanLinhKien.setText("Hóa Đơn Bán Linh Kiện");
		txtBanLinhKien.setFont(new Font("Arial", Font.BOLD, 20));
		txtBanLinhKien.setForeground(Color.black);
		
		
		
		lblTenNV=new JLabel("Nhân Viên Lập Hóa Đơn:          ");
		txtTenNV=new JTextField(40);
		txtTenNV.setForeground(Color.BLACK);
		txtTenNV.setBorder(null);
		txtTenNV.setBackground(null);
		txtTenNV.setText("Trần Hoàng Long");
		
		
		
		
		lblNgayLap=new JLabel("Ngày Lập Hóa Đơn");
		txtNgayLap=new JTextField(40);
		txtNgayLap.setForeground(Color.BLACK);
		txtNgayLap.setBorder(null);
		txtNgayLap.setBackground(null);
		txtNgayLap.setText("4-27-2022");
		
		
		
		
		
		lblNgayNhan=new JLabel("Ngày Nhận Hóa Đơn");
		txtNgayNhan=new JTextField(40);
		txtNgayNhan.setForeground(Color.BLACK);
		txtNgayNhan.setBorder(null);
		txtNgayNhan.setBackground(null);
		txtNgayNhan.setText("4-28-2022");
		
		
		
		lblNoiNhan=new JLabel("Nơi Nhân Hàng");
		txtNoiNhan=new JTextField(40);
		txtNoiNhan.setForeground(Color.BLACK);
		txtNoiNhan.setBorder(null);
		txtNoiNhan.setBackground(null);
		txtNoiNhan.setText("2-Lê Lợi-Gò Vấp");
		
		
			
		lblMaHD=new JLabel("Mã Hóa Đơn");
		txtMaHD=new JTextField(40);
		txtMaHD.setForeground(Color.BLACK);
		txtMaHD.setBorder(null);
		txtMaHD.setBackground(null);
		txtMaHD.setText("HD147258");
		
		
		
		
		lblTenKH=new JLabel("Tên Khách Hàng");
		txtTenKH=new JTextField(40);
		txtTenKH.setForeground(Color.BLACK);
		txtTenKH.setBorder(null);
		txtTenKH.setBackground(null);
		txtTenKH.setText("Trần Văn Minh");
		
		
		
		lblThanhTien=new JLabel("Thành Tiền:");
		txtThanhTien=new JTextField(40);
		txtThanhTien.setForeground(Color.BLACK);
		txtThanhTien.setBorder(null);
		txtThanhTien.setBackground(null);
		txtThanhTien.setText("200000");
		
		
		
		lblGiamGia=new JLabel("Giảm Giá:");
		txtGiamGia=new JTextField(40);
		txtGiamGia.setForeground(Color.BLACK);
		txtGiamGia.setBorder(null);
		txtGiamGia.setBackground(null);
		txtGiamGia.setText("15%");
		
		
		
		String[] colHeader = { "Mã Linh Kiện", "Tên Linh Kiện", "Số Lượng", "Đơn Giá", "Giảm Giá", "Thành Tiền"};
		modelHoaDonct = new DefaultTableModel(colHeader, 0);
		tblHoaDonct=new JTable(modelHoaDonct);
		JScrollPane tblscroll=new JScrollPane(tblHoaDonct);
		tblHoaDonct.setPreferredScrollableViewportSize(new Dimension(700,200));
		
		
		add(p);
		p.add(pNorth,BorderLayout.NORTH);
		pNorth.add(b);
		b.add(bTenCuaHang);
		bTenCuaHang.add(lblTenCuaHang);
		
		b.add(bLinhKien);		
		bLinhKien.add(txtBanLinhKien);
		
		b.add(bTenNV);
		bTenNV.add(lblTenNV);
		bTenNV.add(txtTenNV);
		
		b.add(bNgayLap);
		bNgayLap.add(lblNgayLap);
		bNgayLap.add(txtNgayLap);
		
		b.add(bNgayNhan);
		bNgayNhan.add(lblNgayNhan);
		bNgayNhan.add(txtNgayNhan);
		
		b.add(bNoiNhan);
		bNoiNhan.add(lblNoiNhan);
		bNoiNhan.add(txtNoiNhan);
		
		b.add(bMaHd);
		bMaHd.add(lblMaHD);
		bMaHd.add(txtMaHD);
		
		b.add(bTenKH);
		bTenKH.add(lblTenKH);
		bTenKH.add(txtTenKH);
		
		b.add(bVienTren);
		bVienTren.add(pVienTren);
		
		
		p.add(tblscroll,BorderLayout.CENTER);
		
		p.add(pSouth,BorderLayout.SOUTH);
		pSouth.add(bSouth);
		
		bSouth.add(bVienDuoi);
		bVienDuoi.add(pVienDuoi);
		
		bSouth.add(b1);
		b1.add(lblGiamGia);
		b1.add(txtGiamGia);
		
		bSouth.add(b2);
		b2.add(lblThanhTien);
		b2.add(txtThanhTien);
		
		
		btnin=new JButton("In Hóa Đơn");
		bSouth.add(b3);
		b3.add(btnin);
		
		//txtBanLinhKien.setPreferredSize(lblMaHD.getPreferredSize());
		lblNgayLap.setPreferredSize(lblTenNV.getPreferredSize());
		lblNgayNhan.setPreferredSize(lblTenNV.getPreferredSize());
		lblNoiNhan.setPreferredSize(lblTenNV.getPreferredSize());
		lblTenKH.setPreferredSize(lblTenNV.getPreferredSize());
		lblThanhTien.setPreferredSize(lblTenNV.getPreferredSize());
		lblGiamGia.setPreferredSize(lblTenNV.getPreferredSize());
		lblMaHD.setPreferredSize(lblTenNV.getPreferredSize());
		
		
		
		//bTenCuaHang.setBorder(new EmptyBorder(new Insets(10, 0, 10, 10)));
		bTenNV.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		bTenKH.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		bNgayLap.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		bNgayNhan.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		bNoiNhan.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		bMaHd.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b1.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b2.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b3.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new FrmChiTietHoaDon().setVisible(true);
	}

}
