package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FrmBanHang extends JFrame {

	private JTextField txtTim;
	private JButton btnTim;
	private DefaultTableModel modelSanPham;
	private JTable tblSanPham;
	private JTextField txtMaKhachHang;
	private JCheckBox chkNam;
	private JTextField txtSoLuong;
	private JButton btnThemVaoGioHang;
	private DefaultTableModel modelGioHang;
	private JTable tblGioHang;
	private JTextField txtTongTien;
	private JButton btnHuy;
	private JButton btnThanhToan;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtDiaChi;
	private JLabel lblMa;
	private JLabel lblTen;
	private JLabel lblSDT;
	private JLabel lblEmail;
	private JLabel lblDiaChi;
	private JLabel lblSoLuong;
	private JTextField txtTenKhachHang;
	private JLabel lblGioiTinh;
	private JComboBox<String> cmbGioiTinh;
	private JLabel lblTongTien;

	public JPanel createPanelBanHang() {
		// TODO Auto-generated constructor stub
		setTitle("FrmBanHang");
		setSize(1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel p = new JPanel();

		Box b = Box.createHorizontalBox();
		Box b1 = Box.createVerticalBox();
		Box b2 = Box.createVerticalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createVerticalBox();
		Box b5 = Box.createHorizontalBox();
		Box b6 = Box.createHorizontalBox();
		Box b7 = Box.createHorizontalBox();
		Box b8 = Box.createHorizontalBox();
		Box b9 = Box.createHorizontalBox();
		Box b10 = Box.createHorizontalBox();
		Box b11 = Box.createHorizontalBox();
		Box b12 = Box.createHorizontalBox();
		Box b13 = Box.createHorizontalBox();

		b3.add(txtTim = new JTextField(17));
		b3.add(btnTim = new JButton("Tìm"));
		String[] colHeader = { "Mã Linh Kiện", "Tên Linh Kiện", "Số Lượng", "Đơn Giá", "Giảm Giá" };
		modelSanPham = new DefaultTableModel(colHeader, 0);
		tblSanPham = new JTable(modelSanPham);
		JScrollPane tblscroll = new JScrollPane(tblSanPham);
		tblSanPham.setPreferredScrollableViewportSize(new Dimension(600, 550));
		b1.add(b3);
		b1.add(tblscroll);
		b4.add(new JLabel("Thông Tin Khách Hàng"));
		b5.add(lblMa = new JLabel("Mã Khách Hàng:"));
		b5.add(Box.createHorizontalStrut(10));
		b5.add(txtMaKhachHang = new JTextField());
		b6.add(lblTen = new JLabel("Tên Khách Hàng:"));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(txtTenKhachHang = new JTextField());
		String[] gioitinh = { "Nam", "Nữ" };
		cmbGioiTinh = new JComboBox<String>(gioitinh);
		b13.add(lblGioiTinh = new JLabel("Giới Tính:"));
		b13.add(Box.createHorizontalStrut(10));
		b13.add(cmbGioiTinh);
		b7.add(lblSDT = new JLabel("SDT:"));
		b7.add(Box.createHorizontalStrut(10));
		b7.add(txtSDT = new JTextField());
		b8.add(lblEmail = new JLabel("Email:"));
		b8.add(Box.createHorizontalStrut(10));
		b8.add(txtEmail = new JTextField());
		b9.add(lblDiaChi = new JLabel("Địa Chỉ:"));
		b9.add(Box.createHorizontalStrut(10));
		b9.add(txtDiaChi = new JTextField());
		b11.add(lblSoLuong = new JLabel("Số Lượng:"));
		b11.add(Box.createHorizontalStrut(10));
		b11.add(txtSoLuong = new JTextField());

		b4.add(b5);
		b4.add(b6);
		b4.add(b13);
		b4.add(b7);
		b4.add(b8);
		b4.add(b9);
		b4.add(b11);
		String[] colHeader1 = { "Mã Linh Kiện", "Tên Linh Kiện", "Số Lượng", "Đơn Giá", "Giảm Giá", "Thành Tiền" };
		modelGioHang = new DefaultTableModel(colHeader1, 0);
		tblGioHang = new JTable(modelGioHang);
		JScrollPane tblscroll1 = new JScrollPane(tblGioHang);
		tblGioHang.setPreferredScrollableViewportSize(new Dimension(600, 205));
		b10.add(lblTongTien = new JLabel("Tổng Tiền:"));
		b10.add(txtTongTien = new JTextField());
		b12.add(btnThanhToan = new JButton("Thanh toán"));
		b12.add(Box.createHorizontalStrut(10));
		b12.add(btnHuy = new JButton("Huỷ"));
		b2.add(b4);
		b11.add(Box.createHorizontalStrut(10));
		b11.add(btnThemVaoGioHang = new JButton("Thêm vào giỏ hàng"));
		b2.add(tblscroll1);
		b2.add(b10);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p2.add(b12);
		b2.add(p2);
		p1.add(b1);
		p1.add(b2);
		p.add(p1, BorderLayout.CENTER);

		lblMa.setPreferredSize(lblTen.getPreferredSize());
		lblSDT.setPreferredSize(lblTen.getPreferredSize());
		lblEmail.setPreferredSize(lblTen.getPreferredSize());
		lblDiaChi.setPreferredSize(lblTen.getPreferredSize());
		lblSoLuong.setPreferredSize(lblTen.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblTen.getPreferredSize());
		lblTongTien.setPreferredSize(lblTen.getPreferredSize());

		b3.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b5.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b6.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b7.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b8.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b9.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b10.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b11.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b12.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b13.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

		btnThanhToan.setBounds(36, 330, 79, 13);
		btnHuy.setBounds(131, 330, 79, 13);

		return p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI_NhanVien().setVisible(true);
	}

}
