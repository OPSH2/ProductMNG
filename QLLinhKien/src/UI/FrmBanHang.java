package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.BanHang_DAO;
import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.LinhKien_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;

public class FrmBanHang extends JFrame implements ActionListener {

	private JTextField txtTim;
	private JButton btnTim;
	private static DefaultTableModel modelLinhKien;
	private static JTable tableLinhKien;
	private JTextField txtMaKhachHang;
	private JCheckBox chkNam;
	private JTextField txtSoLuong;
	private JButton btnCong;
	private DefaultTableModel modelGioHang;
	private JTable tableGioHang;
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
	private JDateChooser txtNgaySinh;
	private JLabel lblNgaySinh;
	private JLabel lblCMND;
	private JTextField txtCMND;
	private BanHang_DAO banhang_dao;
	private ChiTietHoaDon_DAO cthd_dao;
	private static JComboBox<String> cmbDanhSachSdt;
	private static JComboBox<String> cmbTim;
	private JButton btnTimKHCu;
	private static LinhKien_DAO linhkien_dao;
	private static KhachHang_DAO khachhang_dao;
	private static HoaDon_DAO hoadon_dao;
	private JLabel lblGioHang;
	private JPanel pTitle1;
	private JLabel lblTitle;
	private JLabel lblTitle1;
	private JButton btnTaoGioHang;
	private JButton btnTru;
	private Date thoiGianTraPhongDate;
	private Date ngayLapHoaDon;
	private static JComboBox<String> cmbChon;
	private static JComboBox<String> cmbGioHang;
	public static String maHDMoiDat = "";
	public static String maKHDatGioHang = "";

	public JPanel createPanelBanHang() {
		FlatLightLaf.setup();
		// TODO Auto-generated constructor stub
		setTitle("FrmBanHang");
		setSize(1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel p = new JPanel();

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		banhang_dao = new BanHang_DAO();
		linhkien_dao = new LinhKien_DAO();
		khachhang_dao = new KhachHang_DAO();
		hoadon_dao = new HoaDon_DAO();
		cthd_dao = new ChiTietHoaDon_DAO();

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
		Box b14 = Box.createHorizontalBox();
		Box b15 = Box.createHorizontalBox();
		Box b16 = Box.createHorizontalBox();
		Box b17 = Box.createHorizontalBox();

		String[] tim = { "M?? Linh Ki???n", "T??n Linh Ki???n", "Lo???i H??ng", "Nh?? Cung C???p", "????n Gi??", "S??? L?????ng T???n" };
		cmbChon = new JComboBox<String>(tim);
		b3.add(cmbChon);
		b3.add(Box.createHorizontalStrut(10));
		cmbTim = new JComboBox<String>();
		cmbTim.setEditable(true);
		AutoCompleteDecorator.decorate(cmbTim);
		cmbTim.setMaximumRowCount(10);
		cmbChon.setSize(20, cmbTim.getPreferredSize().height);
		b3.add(cmbTim);
		b3.add(Box.createHorizontalStrut(10));
		b3.add(btnTim = new JButton("T??M LINH KI???N", new ImageIcon("image/timlinhkien.png")));
		btnTim.setBackground(new Color(0, 148, 224));
		btnTim.setForeground(Color.WHITE);
		btnTim.setFocusPainted(false);

		b3.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "DANH S??CH LINH KI???N: "));

		String[] colHeader = { "M?? Linh Ki???n", "T??n Linh Ki???n", "Lo???i H??ng", "Nh?? Cung C???p", "????n Gi??",
				"S??? L?????ng T???n" };
		modelLinhKien = new DefaultTableModel(colHeader, 0);
		tableLinhKien = new JTable(modelLinhKien) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				Color color1 = new Color(219, 243, 255);
				Color color2 = Color.WHITE;
				if (!c.getBackground().equals(getSelectionBackground())) {
					Color coleur = (row % 2 == 0 ? color1 : color2);
					c.setBackground(coleur);
					coleur = null;
				}
				return c;
			}
		};
		tableLinhKien.setGridColor(getBackground());
		tableLinhKien.setRowHeight(tableLinhKien.getRowHeight() + 20);
		tableLinhKien.setSelectionBackground(new Color(255, 255, 128));
		JTableHeader tableHeader = tableLinhKien.getTableHeader();
		tableHeader.setBackground(new Color(0, 148, 224));
		tableHeader.setFont(new Font("Tahoma", Font.BOLD, 12));
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setPreferredSize(new Dimension(WIDTH, 30));
		JScrollPane tblscroll = new JScrollPane(tableLinhKien);
		tableLinhKien.setPreferredScrollableViewportSize(new Dimension(700, 730));
		b1.add(b3);
		b1.add(tblscroll);
		tblscroll.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "DANH S??CH LINH KI???N: "));

		b.add(lblTitle = new JLabel("TH??NG TIN KH??CH H??NG"));
		b5.add(lblMa = new JLabel("M?? Kh??ch H??ng:"));
		b5.add(Box.createHorizontalStrut(10));
		b5.add(txtMaKhachHang = new JTextField());
		b6.add(lblTen = new JLabel("T??n Kh??ch H??ng:"));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(txtTenKhachHang = new JTextField());
		b14.add(lblNgaySinh = new JLabel("Ng??y Sinh:"));
		b14.add(Box.createHorizontalStrut(10));
		b14.add(txtNgaySinh = new JDateChooser());
		txtNgaySinh.setDateFormatString("yyyy-MM-dd");
		txtNgaySinh.setDate(new Date(1999 - 1900, 1 - 1, 1));
		b15.add(lblCMND = new JLabel("CMND:"));
		b15.add(Box.createHorizontalStrut(10));
		b15.add(txtCMND = new JTextField());
		String[] gioitinh = { "Nam", "N???" };
		cmbGioiTinh = new JComboBox<String>(gioitinh);
		b13.add(lblGioiTinh = new JLabel("Gi???i T??nh:"));
		b13.add(Box.createHorizontalStrut(10));
		b13.add(cmbGioiTinh);
		b7.add(lblSDT = new JLabel("SDT:"));
		b7.add(Box.createHorizontalStrut(10));
		cmbDanhSachSdt = new JComboBox<String>();
		cmbDanhSachSdt.setEditable(true);
		AutoCompleteDecorator.decorate(cmbDanhSachSdt);
		cmbDanhSachSdt.setMaximumRowCount(10);
		b7.add(cmbDanhSachSdt);
		btnTimKHCu = new JButton("T??M SDT", new ImageIcon("image/timkiem.png"));
		btnTimKHCu.setBackground(new Color(0, 148, 224));
		btnTimKHCu.setForeground(Color.WHITE);
		btnTimKHCu.setFocusPainted(false);
		b7.add(Box.createHorizontalStrut(300));
		b7.add(btnTimKHCu);
		b8.add(lblEmail = new JLabel("Email:"));
		b8.add(Box.createHorizontalStrut(10));
		b8.add(txtEmail = new JTextField());
		b9.add(lblDiaChi = new JLabel("?????a Ch???:"));
		b9.add(Box.createHorizontalStrut(10));
		b9.add(txtDiaChi = new JTextField());

		b17.add(pTitle1 = new JPanel());
		pTitle1.add(lblTitle1 = new JLabel("GI??? H??NG"));
		b16.add(lblGioHang = new JLabel("Gi??? H??ng C???a:"));
		b16.add(Box.createHorizontalStrut(10));
		cmbGioHang = new JComboBox<String>();
		cmbGioHang.setEditable(true);
		AutoCompleteDecorator.decorate(cmbGioHang);
		cmbGioHang.setMaximumRowCount(10);
		b16.add(cmbGioHang);
		b11.add(lblSoLuong = new JLabel("S??? L?????ng:"));
		b11.add(Box.createHorizontalStrut(10));
		b11.add(txtSoLuong = new JTextField());
		b11.add(Box.createHorizontalStrut(200));

		b4.add(b);
		b4.add(b7);
		b4.add(b5);
		b4.add(b6);
		b4.add(b14);
		b4.add(b15);
		b4.add(b13);
		b4.add(b8);
		b4.add(b9);
		b4.add(b17);
		b4.add(b16);
		b4.add(b11);

		String[] colHeader1 = { "M?? Linh Ki???n", "T??n Linh Ki???n", "Lo???i H??ng", "Nh?? Cung C???p", "????n Gi??", "S??? L?????ng",
				"Th??nh Ti???n" };
		modelGioHang = new DefaultTableModel(colHeader1, 0);
		tableGioHang = new JTable(modelGioHang) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				Color color1 = new Color(219, 243, 255);
				Color color2 = Color.WHITE;
				if (!c.getBackground().equals(getSelectionBackground())) {
					Color coleur = (row % 2 == 0 ? color1 : color2);
					c.setBackground(coleur);
					coleur = null;
				}
				return c;
			}
		};
		tableGioHang.setGridColor(getBackground());
		tableGioHang.setRowHeight(tableGioHang.getRowHeight() + 30);
		tableGioHang.setSelectionBackground(new Color(255, 255, 128));
		JTableHeader tableHeader1 = tableGioHang.getTableHeader();
		tableHeader1.setBackground(new Color(0, 148, 224));
		tableHeader1.setFont(new Font("Tahoma", Font.BOLD, 11));
		tableHeader1.setForeground(Color.WHITE);
		tableHeader1.setPreferredSize(new Dimension(WIDTH, 30));
		tableLinhKien.setRowHeight(tableLinhKien.getRowHeight() + 20);

		tableLinhKien.getColumnModel().getColumn(1).setPreferredWidth(165);
		
		JScrollPane tblscroll1 = new JScrollPane(tableGioHang);
		tblscroll1.setBorder(javax.swing.BorderFactory.createTitledBorder("GI??? H??NG: "));
		tableGioHang.setPreferredScrollableViewportSize(new Dimension(700, 205));
		b10.add(lblTongTien = new JLabel("T???ng Ti???n:"));
		b10.add(txtTongTien = new JTextField());
		b12.add(btnThanhToan = new JButton("THANH TO??N", new ImageIcon("image/thanhtoan.png")));
		btnThanhToan.setBackground(new Color(0, 148, 224));
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFocusPainted(false);
		b12.add(Box.createHorizontalStrut(10));
		b12.add(btnHuy = new JButton("L??M M???I", new ImageIcon("image/lammoi.png")));
		btnHuy.setBackground(new Color(0, 148, 224));
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFocusPainted(false);
		b2.add(b4);
		b11.add(Box.createHorizontalStrut(10));
		b11.add(btnCong = new JButton("TH??M", new ImageIcon("image/them.png")));
		btnCong.setBackground(new Color(0, 148, 224));
		btnCong.setForeground(Color.WHITE);
		btnCong.setFocusPainted(false);
		b11.add(Box.createHorizontalStrut(5));
		b11.add(btnTru = new JButton("X??A", new ImageIcon("image/xoa.png")));
		btnTru.setBackground(new Color(0, 148, 224));
		btnTru.setForeground(Color.WHITE);
		btnTru.setFocusPainted(false);
		b9.add(Box.createHorizontalStrut(10));
		b9.add(btnTaoGioHang = new JButton("T???O GI??? H??NG", new ImageIcon("image/them.png")));
		btnTaoGioHang.setBackground(new Color(0, 148, 224));
		btnTaoGioHang.setForeground(Color.WHITE);
		btnTaoGioHang.setFocusPainted(false);
		b2.add(tblscroll1);
		b2.add(b10);
		JPanel p1 = new JPanel();
//		p1.setLayout(new BorderLayout());
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
		lblNgaySinh.setPreferredSize(lblTen.getPreferredSize());
		lblCMND.setPreferredSize(lblTen.getPreferredSize());
		lblGioHang.setPreferredSize(lblTen.getPreferredSize());
		cmbDanhSachSdt.setPreferredSize(lblTen.getPreferredSize());

		b.setBorder(new EmptyBorder(new Insets(10, 10, 0, 10)));
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
		b14.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b15.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b16.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		b17.setBorder(new EmptyBorder(new Insets(10, 10, 0, 10)));

		btnThanhToan.setBounds(36, 330, 79, 13);
		btnHuy.setBounds(131, 330, 79, 13);
		txtMaKhachHang.setEditable(false);

		docDuLieuDatabaseVaoTableLinhKien();
		docDuLieuVaoCmbSDT();
		docDuLieuVaoCmbGioHang();
		docMaLinhKienVaoCmbTim();

		cmbChon.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbDanhSachSdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimKHCu.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMaKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTenKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCMND.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCMND.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTaoGioHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGioHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitle1.setFont(new Font("Tahoma", Font.BOLD, 16));
		cmbGioHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSoLuong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTru.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTongTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 12));

		tableGioHang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableGioHang.setDefaultEditor(Object.class, null);
		tableGioHang.getTableHeader().setReorderingAllowed(false);
		tableLinhKien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableLinhKien.setDefaultEditor(Object.class, null);
		tableLinhKien.getTableHeader().setReorderingAllowed(false);

		btnTimKHCu.addActionListener(this);
		btnTaoGioHang.addActionListener(this);
		btnCong.addActionListener(this);
		btnTru.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnTim.addActionListener(this);
		btnHuy.addActionListener(this);
		cmbGioHang.addActionListener(this);
		cmbChon.addActionListener(this);
		btnTaoGioHang.setEnabled(false);
		txtTongTien.setEditable(false);

		txtTongTien.setBorder(null);
		txtTongTien.setBackground(null);
		txtTongTien.setText(null);
		
		
		return p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FrmDangNhap().setVisible(true);
	}

	public static void docDuLieuDatabaseVaoTableLinhKien() {
		List<LinhKien> listLK = new ArrayList<LinhKien>();
		listLK = linhkien_dao.getTatCaLinhKien();
		DecimalFormat df = new DecimalFormat("#,##0");
		for (LinhKien lk : listLK) {
			modelLinhKien.addRow(new Object[] { lk.getMaLK().trim(), lk.getTenLK().trim(), lk.getLoaiHang(),
					lk.getNhaCungCap().trim(), df.format(lk.getDonGia()), lk.getSoLuong() });
		}
	}

	public static void xoaHetDLLinhKien() {
		DefaultTableModel dm = (DefaultTableModel) tableLinhKien.getModel();
		dm.setRowCount(0);
	}

	public static void docDuLieuVaoCmbSDT() {
		cmbDanhSachSdt.removeAllItems();
		List<String> listSDT = khachhang_dao.getTatCaSDTKhachHang();
		cmbDanhSachSdt.addItem("");
		for (String s : listSDT) {
			cmbDanhSachSdt.addItem(s.trim());
		}
	}

	public static void docMaLinhKienVaoCmbTim() {
		cmbTim.removeAllItems();
		List<String> list = linhkien_dao.getTatCaMaLinhKien();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docTenLinhKienVaoCmbTim() {
		cmbTim.removeAllItems();
		List<String> list = linhkien_dao.getTatCaTenLinhKien();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docNhaCungCapLinhKienVaoCmbTim() {
		cmbTim.removeAllItems();
		List<String> list = linhkien_dao.getTatCaNhaCungCapLinhKien();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docLoaiHangLinhKienVaoCmbTim() {
		cmbTim.removeAllItems();
		List<String> list = linhkien_dao.getTatCaLoaiHangLinhKien();
		cmbTim.addItem("");
		for (String s : list) {
			cmbTim.addItem(s.trim());
		}
	}

	public static void docDonGiaLinhKienVaoCmbTim() {
		DecimalFormat df = new DecimalFormat("#,##0");
		cmbTim.removeAllItems();
		List<Double> list = linhkien_dao.getTatCaDonGiaLinhKien();
		cmbTim.addItem("");
		for (Double s : list) {
			cmbTim.addItem(df.format(s));
		}
	}

	public static void docSoLuongTonLinhKienVaoCmbTim() {
		DecimalFormat df = new DecimalFormat("#");
		cmbTim.removeAllItems();
		List<Integer> list = linhkien_dao.getTatCaSoLuongTonLinhKien();
		cmbTim.addItem("");
		for (Integer s : list) {
			cmbTim.addItem(df.format(s));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnTimKHCu)) {
			txtMaKhachHang.setText(maHDMoiDat);
			if (cmbDanhSachSdt.getItemCount() > 0 && cmbDanhSachSdt.getSelectedIndex() != -1) {
				String sdt = cmbDanhSachSdt.getSelectedItem().toString().trim();
				List<KhachHang> list = khachhang_dao.getTatCaKhachHang();

				List<KhachHang> listKHTrungSDT = new ArrayList<KhachHang>();

				for (KhachHang khachHang : list) {
					if (khachHang.getSDT().trim().equals(sdt.trim())) {
						listKHTrungSDT.add(khachHang);
					}
				}

				if (listKHTrungSDT.size() == 1) {
					KhachHang kh = listKHTrungSDT.get(0);
					JOptionPane.showMessageDialog(this, "????y l?? kh??ch h??ng c??. Welcome back!!!");
					txtTenKhachHang.setText(kh.getTenKH().trim());
					txtCMND.setText(kh.getCMND().trim());
					cmbGioiTinh.setSelectedItem(kh.isGioiTinh() == true ? "Nam" : "N???");
					txtNgaySinh.setDate(kh.getNgaySinh());
					txtEmail.setText(kh.getEmail().trim());
					txtDiaChi.setText(kh.getDiaChi().trim());
					txtMaKhachHang.setText(kh.getMaKH().trim());
					btnTaoGioHang.setEnabled(true);
				}
			} else {
				JOptionPane.showMessageDialog(this, "????y l?? kh??ch h??ng m???i. Welcome to our store!!!");
				String maKH;
				List<KhachHang> listKH = khachhang_dao.getTatCaKhachHang();
				if (listKH.size() == 0)
					maKH = "KH1001";
				else {
					String maKHCuoi = listKH.get(listKH.size() - 1).getMaKH().trim();
					int layMaSo = Integer.parseInt(maKHCuoi.substring(2, maKHCuoi.length()));
					maKH = "KH" + (layMaSo + 1);
				}
				txtMaKhachHang.setText(maKH);
				btnTaoGioHang.setEnabled(true);
			}
		}

		if (o.equals(btnTaoGioHang)) {
			// G??n r???ng cho c??c bi???n t???m
			if (!maHDMoiDat.equals("")) {
				maHDMoiDat = "";
				maKHDatGioHang = "";
			}
			// Ki???m tra th??ng tin kh??ch h??ng
			if (validInputKhachHang()) {
				// L???y th??ng tin kh??ch h??ng
				String tenKH = txtTenKhachHang.getText().trim();
				String cmnd = txtCMND.getText().trim();
				String sdt = cmbDanhSachSdt.getSelectedItem().toString();
				Date ngaySinh = txtNgaySinh.getDate();
				String maKH = txtMaKhachHang.getText().trim();
				String email = txtEmail.getText().trim();
				String diaChi = txtDiaChi.getText().trim();
				String gioiTinh = cmbGioiTinh.getSelectedItem().toString();
				java.sql.Date date = new java.sql.Date(ngaySinh.getYear(), ngaySinh.getMonth(), ngaySinh.getDate());

				// Ki???m tra c?? ph???i kh??ch h??ng c??
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy");
				List<KhachHang> listKH = khachhang_dao.getTatCaKhachHang();
				int flag = 0;
				for (KhachHang khachHang : listKH) {
					if (khachHang.getTenKH().trim().equals(tenKH) && khachHang.getCMND().trim().equals(cmnd)
							&& khachHang.getSDT().trim().equals(sdt)
							&& df.format(khachHang.getNgaySinh()).equals(df.format(ngaySinh))
							&& khachHang.isGioiTinh() == (cmbGioiTinh.getSelectedItem() == "Nam" ? true : false)) {
						flag = 1;
						maKHDatGioHang = khachHang.getMaKH().trim();
						break;
					}
				}

				// Th??m n???u l?? kh??ch h??ng m???i
				if (flag == 0) {
					maKHDatGioHang = maKH;
					KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh == "Nam" ? true : false, sdt, cmnd, date, diaChi,
							email, true);
					khachhang_dao.createGioHang(kh);
					JOptionPane.showMessageDialog(this, "Th??m kh??ch h??ng m???i v??o trong h??? th???ng th??nh c??ng. Welcome!");

					docDuLieuVaoCmbSDT();
					cmbDanhSachSdt.setSelectedIndex(cmbDanhSachSdt.getItemCount() - 1);
				}
				// T???o l???i gi??? h??ng
				else {
					KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh == "Nam" ? true : false, sdt, cmnd, date, diaChi,
							email, true);
					khachhang_dao.updateGioHang(kh);
				}
				// Th??m h??a ????n m???i
				String maHD;
				List<HoaDon> listHD = hoadon_dao.getTatCaHoaDon();

				if (listHD.size() == 0)
					maHD = "HD1001";
				else {
					String maHDCuoi = listHD.get(listHD.size() - 1).getMaHD().trim();
					int layMaSo = Integer.parseInt(maHDCuoi.substring(2, maHDCuoi.length()));
					maHD = "HD" + (layMaSo + 1);
				}

				HoaDon hd = new HoaDon(maHD, new KhachHang(maKHDatGioHang));

				if (banhang_dao.createGioHang(hd)) {
					maHDMoiDat = hd.getMaHD();
					JOptionPane.showMessageDialog(this, "T???o gi??? h??ng th??nh c??ng. Time to order!");
				}
				// C???p nh???t l???i c?? s??? d??? li???u v?? c??c giao di???n li??n quan

				docDuLieuVaoCmbGioHang();
				cmbGioHang.setSelectedIndex(cmbGioHang.getItemCount() - 1);

				FrmKhachHang.xoaHetDL();
				FrmKhachHang.docDuLieuDatabaseVaoTable();
				btnTaoGioHang.setEnabled(false);
			}
		}
		if (o.equals(cmbGioHang)) {

//			docDuLieuVaoCmbGioHang();
//			cmbGioHang.setSelectedIndex(cmbGioHang.getItemCount() - 1);
			// ko ch???c
			cmbGioHangXuongTable();
		}
		if (o.equals(btnCong)) {
			if (!validInputSoLuong())
				return;
			else {
				int row = tableLinhKien.getSelectedRow();
				// Ki???m tra ch???n gi??? h??ng v?? linh ki???n c???n ?????t ch??a
				Object giaTriCmb = cmbGioHang.getSelectedItem();
				if (giaTriCmb == null || giaTriCmb.toString().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "Vui l??ng ch???n gi??? h??ng", "L???i", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (row != -1 && giaTriCmb != null && !giaTriCmb.toString().trim().equals("")) {
					int soLuongCong = Integer.parseInt(txtSoLuong.getText());
					int soLuongHienTai = Integer.parseInt(modelLinhKien.getValueAt(row, 5).toString().trim());
					if (soLuongHienTai < soLuongCong) {
						JOptionPane.showMessageDialog(this, "Kh??ng ????? s??? l?????ng ????? ?????t", "L???i",
								JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						// L???y h??a ????n t??? sdt
						String temp = giaTriCmb.toString().trim();
						String sdtTrongCbo = temp.replaceAll("[^0-9]", "").trim();
						HoaDon hoadon = new HoaDon();

						List<HoaDon> listHD = hoadon_dao.getTatCaHoaDonChuaTinhTien();
						for (HoaDon hd : listHD) {
							if (hd.getMaKH().getSDT().equals(sdtTrongCbo)) {
								hoadon = hd;
								break;
							}
						}
						// L???y linh ki???n t??? m?? linh ki???n
						String maLK = modelLinhKien.getValueAt(row, 0).toString().trim();
						LinhKien linhkien = new LinhKien();

						List<LinhKien> listLK = linhkien_dao.getTatCaLinhKien();
						for (LinhKien lk : listLK) {
							if (lk.getMaLK().equals(maLK)) {
								linhkien = lk;
								break;
							}
						}
						String giaStr = tableLinhKien.getValueAt(row, 4).toString().trim();
						String[] gia = giaStr.split(",");
						String giaTien = "";
						for (int i = 0; i < gia.length; i++) {
							giaTien += gia[i];
						}
						ChiTietHoaDon cthd = new ChiTietHoaDon(hoadon, linhkien, soLuongCong,
								Double.parseDouble(giaTien));
						DecimalFormat df = new DecimalFormat("#,##0");
						int flag = 0;
						int soLuongCu = 0;
						int hangCanSua = 0;
						int rowTableGH = tableGioHang.getRowCount();
						// ktra linh ki???n n??y c?? trong gi??? h??ng ch??a
						for (int i = 0; i < rowTableGH; i++) {
							if (maLK.trim().equals(modelGioHang.getValueAt(i, 0).toString().trim())) {
								flag = 1; // c??
								soLuongCu = Integer.parseInt(modelGioHang.getValueAt(i, 5).toString());
								hangCanSua = i;
								break;
							}
						}
						if (flag == 1) {
							ChiTietHoaDon cthdDaco = new ChiTietHoaDon(hoadon, linhkien, soLuongCong + soLuongCu,
									Double.parseDouble(giaTien));
							cthd_dao.updateSoLuong(cthdDaco);
							modelGioHang.setValueAt(soLuongCong + soLuongCu, hangCanSua, 5);
							modelGioHang.setValueAt(df.format(cthdDaco.getThanhTien()), hangCanSua, 6);
						} else {
							cthd_dao.create(cthd);
							modelGioHang.addRow(new Object[] { cthd.getMaLinhKien().getMaLK().trim(),
									cthd.getMaLinhKien().getTenLK().trim(), cthd.getMaLinhKien().getLoaiHang().trim(),
									cthd.getMaLinhKien().getNhaCungCap().trim(),
									df.format(cthd.getMaLinhKien().getDonGia()), cthd.getSoLuong(),
									df.format(cthd.getThanhTien()) });
						}
						// Set l???i b???ng danh s??ch linh ki???n
						linhkien.setSoLuong(soLuongHienTai - soLuongCong);
						linhkien_dao.update(linhkien);
						tableLinhKien.setValueAt(soLuongHienTai - soLuongCong, row, 5);
						cmbGioHangXuongTable();
					}
				} else
					JOptionPane.showMessageDialog(this, "Vui l??ng ch???n linh ki???n", "L???i", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (o.equals(btnTru)) {
			if (!validInputSoLuong())
				return;
			else {
				int row = tableGioHang.getSelectedRow();
				// Ki???m tra ch???n gi??? h??ng v?? linh ki???n c???n ?????t ch??a
				Object giaTriCmb = cmbGioHang.getSelectedItem();
				if (giaTriCmb == null || giaTriCmb.toString().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "Vui l??ng ch???n gi??? h??ng", "L???i", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (row != -1 && giaTriCmb != null && !giaTriCmb.toString().trim().equals("")) {
					int soLuongTru = Integer.parseInt(txtSoLuong.getText());

					// L???y h??a ????n t??? sdt
					String temp = giaTriCmb.toString().trim();
					String sdtTrongCbo = temp.replaceAll("[^0-9]", "").trim();
					HoaDon hoadon = new HoaDon();

					List<HoaDon> listHD = hoadon_dao.getTatCaHoaDonChuaTinhTien();
					for (HoaDon hd : listHD) {
						if (hd.getMaKH().getSDT().equals(sdtTrongCbo)) {
							hoadon = hd;
							break;
						}
					}
					// L???y linh ki???n t??? m?? linh ki???n
					String maLK = modelGioHang.getValueAt(row, 0).toString().trim();
					LinhKien linhkien = new LinhKien();

					List<LinhKien> listLK = linhkien_dao.getTatCaLinhKien();
					for (LinhKien lk : listLK) {
						if (lk.getMaLK().equals(maLK)) {
							linhkien = lk;
							break;
						}
					}
					int soLuongHienTai = Integer.parseInt(tableGioHang.getValueAt(row, 5).toString());
					if (soLuongTru > soLuongHienTai) {
						JOptionPane.showMessageDialog(this, "L???i: S??? l?????ng h???y kh??ng ???????c nhi???u h??n s??? l?????ng ???? ?????t",
								"L???i", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String giaStr = tableGioHang.getValueAt(row, 4).toString().trim();
					String[] gia = giaStr.split(",");
					String giaTien = "";
					for (int i = 0; i < gia.length; i++) {
						giaTien += gia[i];
					}
					ChiTietHoaDon cthd = new ChiTietHoaDon(hoadon, linhkien, soLuongHienTai - soLuongTru,
							Double.parseDouble(giaTien));
					cthd_dao.updateSoLuong(cthd);

					DecimalFormat df = new DecimalFormat("#,##0");
					modelGioHang.setValueAt(soLuongHienTai - soLuongTru, row, 5);
					modelGioHang.setValueAt(df.format(cthd.getThanhTien()), row, 6);

					// Set l???i b???ng danh s??ch linh ki???n
					int soLuongLK_hientai = linhkien.getSoLuong();
					linhkien.setSoLuong(soLuongLK_hientai + soLuongTru);
					linhkien_dao.update(linhkien);
					xoaHetDLLinhKien();
					docDuLieuDatabaseVaoTableLinhKien();

					// Ktra soluong = 0 th?? x??a linh ki???n kh???i gi??? h??ng
					int soLuongMoi = Integer.parseInt(tableGioHang.getValueAt(row, 5).toString());
					if (soLuongMoi < 1) {
						cthd_dao.delete(linhkien.getMaLK(), hoadon.getMaHD());
						modelGioHang.removeRow(row);
						JOptionPane.showMessageDialog(this, "X??a linh ki???n " + " kh???i gi??? h??ng th??nh c??ng!");
					}
					// X??a gi??? h??ng
					if (modelGioHang.getRowCount() == 0) {
						if (khachhang_dao.huyGioHang(sdtTrongCbo, false)) {
							if (banhang_dao.delete(hoadon)) {
								JOptionPane.showMessageDialog(this, "X??a gi??? h??ng th??nh c??ng :((");
								cmbGioHang.removeAllItems();
								docDuLieuVaoCmbGioHang();
							} else
								JOptionPane.showMessageDialog(this, "X??a gi??? h??ng kh??ng th??nh c??ng", "L???i",
										JOptionPane.ERROR_MESSAGE);
						} else
							JOptionPane.showMessageDialog(this, "X??a gi??? h??ng kh??ng th??nh c??ng", "L???i",
									JOptionPane.ERROR_MESSAGE);

					}
				} else
					JOptionPane.showMessageDialog(this, "Vui l??ng ch???n linh ki???n trong gi??? h??ng", "L???i",
							JOptionPane.ERROR_MESSAGE);
				cmbGioHangXuongTable();
			}
		}
		if (o.equals(btnThanhToan)) {
			Object giaTriCmb = cmbGioHang.getSelectedItem();
			if (giaTriCmb == null || giaTriCmb.toString().trim().equals("") || modelGioHang.getRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n gi??? h??ng", "L???i", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (giaTriCmb != null && !giaTriCmb.toString().trim().equals("") || modelGioHang.getRowCount() != 0) {
				// L???y h??a ????n t??? sdt
				String temp = giaTriCmb.toString().trim();
				String sdtTrongCbo = temp.replaceAll("[^0-9]", "").trim();
				HoaDon hoadon_sdt = new HoaDon();

				List<HoaDon> listHD = hoadon_dao.getTatCaHoaDonChuaTinhTien();
				for (HoaDon hd : listHD) {
					if (hd.getMaKH().getSDT().equals(sdtTrongCbo)) {
						hoadon_sdt = hd;
						break;
					}
				}

				HoaDon hoadon = hoadon_dao.getHoaDonChuaTinhTienDeThanhToan(hoadon_sdt.getMaKH().getMaKH());

				// Get c??c null
				NhanVien nv = hoadon_dao.getNhanVienSuDung(FrmDangNhap.getTaiKhoan());
				String maNV = nv.getMaNV();
				String maHD = hoadon.getMaHD();

				Calendar calendar = Calendar.getInstance();
				Date date = calendar.getTime();
				hoadon.setNgayLapHoaDon(date);

				double tongTien = hoadon.tinhTongTien();

				if (banhang_dao.update(maHD, maNV, date, tongTien) == true) {
					JOptionPane.showMessageDialog(this, "Thanh to??n th??nh c??ng. Very good!");
					khachhang_dao.huyGioHang(sdtTrongCbo, false);

					cmbGioHang.removeAllItems();
					docDuLieuVaoCmbGioHang();
					xoaThongTinTrenTextField();
					FrmHoaDon.docDuLieuDatabaseVaoTable();
					new FrmChiTietHoaDon(hoadon_sdt.getMaKH().getTenKH(), nv.getTenNV(), maHD, date).setVisible(true);

				} else {
					JOptionPane.showMessageDialog(this, "Thanh to??n kh??ng th??nh c??ng");
				}
			}

			else {
				JOptionPane.showMessageDialog(this, "Thanh to??n kh??ng th??nh c??ng");
			}

		}
		if (o.equals(cmbChon)) {
			if (cmbChon.getSelectedIndex() == 0) {
				docMaLinhKienVaoCmbTim();
			} else if (cmbChon.getSelectedIndex() == 1) {
				docTenLinhKienVaoCmbTim();
			} else if (cmbChon.getSelectedIndex() == 2) {
				docLoaiHangLinhKienVaoCmbTim();
			} else if (cmbChon.getSelectedIndex() == 3) {
				docNhaCungCapLinhKienVaoCmbTim();
			} else if (cmbChon.getSelectedIndex() == 4) {
				docDonGiaLinhKienVaoCmbTim();
			} else if (cmbChon.getSelectedIndex() == 5) {
				docSoLuongTonLinhKienVaoCmbTim();
			}
		}
		if (o.equals(btnTim)) {
			DefaultTableModel model = (DefaultTableModel) tableLinhKien.getModel();
			model.setRowCount(0);
			DecimalFormat df = new DecimalFormat("#,##0");
			if (cmbTim.getSelectedIndex() == 0) {
				docDuLieuDatabaseVaoTableLinhKien();
			} else if (cmbChon.getSelectedIndex() == 0) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<LinhKien> list = linhkien_dao.getTatCaLinhKien();
				for (LinhKien lk : list) {
					if (lk.getMaLK().trim().equals(tim.trim())) {
						modelLinhKien.addRow(new Object[] { lk.getMaLK().trim(), lk.getTenLK().trim(), lk.getLoaiHang(),
								lk.getNhaCungCap().trim(), df.format(lk.getDonGia()), lk.getSoLuong() });
					}
				}
			}
			if (cmbChon.getSelectedIndex() == 1) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<LinhKien> list = linhkien_dao.getTatCaLinhKien();
				for (LinhKien lk : list) {
					if (lk.getTenLK().trim().equals(tim.trim())) {
						modelLinhKien.addRow(new Object[] { lk.getMaLK().trim(), lk.getTenLK().trim(), lk.getLoaiHang(),
								lk.getNhaCungCap().trim(), df.format(lk.getDonGia()), lk.getSoLuong() });
					}
				}
			}
			if (cmbChon.getSelectedIndex() == 2) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<LinhKien> list = linhkien_dao.getTatCaLinhKien();
				for (LinhKien lk : list) {
					if (lk.getLoaiHang().trim().equals(tim.trim())) {
						modelLinhKien.addRow(new Object[] { lk.getMaLK().trim(), lk.getTenLK().trim(), lk.getLoaiHang(),
								lk.getNhaCungCap().trim(), df.format(lk.getDonGia()), lk.getSoLuong() });
					}
				}
			}
			if (cmbChon.getSelectedIndex() == 3) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				List<LinhKien> list = linhkien_dao.getTatCaLinhKien();
				for (LinhKien lk : list) {
					if (lk.getNhaCungCap().trim().equals(tim.trim())) {
						modelLinhKien.addRow(new Object[] { lk.getMaLK().trim(), lk.getTenLK().trim(), lk.getLoaiHang(),
								lk.getNhaCungCap().trim(), df.format(lk.getDonGia()), lk.getSoLuong() });
					}
				}
			}
			if (cmbChon.getSelectedIndex() == 4) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				double d = Double.parseDouble(tim.replaceAll(",", "").trim());
				List<LinhKien> list = linhkien_dao.getTatCaLinhKien();
				for (LinhKien lk : list) {
					if (lk.getDonGia() == d) {
						modelLinhKien.addRow(new Object[] { lk.getMaLK().trim(), lk.getTenLK().trim(), lk.getLoaiHang(),
								lk.getNhaCungCap().trim(), df.format(lk.getDonGia()), lk.getSoLuong() });
					}
				}
			}
			if (cmbChon.getSelectedIndex() == 5) {
				String tim = cmbTim.getSelectedItem().toString().trim();
				int d = Integer.parseInt(tim.trim());
				List<LinhKien> list = linhkien_dao.getTatCaLinhKien();
				for (LinhKien lk : list) {
					if (lk.getSoLuong() == d) {
						modelLinhKien.addRow(new Object[] { lk.getMaLK().trim(), lk.getTenLK().trim(), lk.getLoaiHang(),
								lk.getNhaCungCap().trim(), df.format(lk.getDonGia()), lk.getSoLuong() });
					}
				}
			}
		}
		if (o.equals(btnHuy)) {
			xoaThongTinTrenTextField();
		}
	}

	private boolean validInputKhachHang() {
		// TODO Auto-generated method stub
		String maKH = txtMaKhachHang.getText();
		String tenKH = txtTenKhachHang.getText();
		String sdt = cmbDanhSachSdt.getSelectedItem().toString();
		String email = txtEmail.getText();
		String diaChi = txtDiaChi.getText();
		String cmnd = txtCMND.getText();

		if (tenKH.trim().length() > 0) {
			if (!(tenKH.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
				JOptionPane.showMessageDialog(this, "T??n kh??ch h??ng kh??ng ch???a k?? t??? ?????c bi???t", "L???i",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "T??n kh??ch h??ng kh??ng ???????c ????? tr???ng", "L???i", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (sdt.trim().length() > 0) {
			if (!(sdt.matches(
					"^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$"))) {
				JOptionPane.showMessageDialog(this, "S??? ??i???n tho???i kh??ng ????ng", "L???i", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "S??? ??i???n tho???i kh??ng ???????c ????? tr???ng", "L???i", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (cmnd.trim().length() > 0) {
			if (!(cmnd.matches("\\d{9}"))) {
				JOptionPane.showMessageDialog(this, "CMND kh??ng ????ng", "L???i", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "CMND kh??ng ???????c ????? tr???ng", "L???i", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (email.trim().length() > 0) {
			if (!(email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$"))) {
				JOptionPane.showMessageDialog(this, "Email kh??ng ????ng", "L???i", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Email kh??ng ???????c ????? tr???ng", "L???i", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (diaChi.trim().length() > 0) {
			if (!(diaChi.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
				JOptionPane.showMessageDialog(this, "?????a ch??? kh??ng ch???a k?? t??? ?????c bi???t", "L???i",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "?????a ch??? kh??ng ???????c ????? tr???ng", "L???i", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean validInputSoLuong() {
		String soLuong = txtSoLuong.getText();
		if (soLuong.trim().length() > 0) {
			try {
				int x = Integer.parseInt(soLuong);
				if (x <= 0) {
					JOptionPane.showMessageDialog(this, "S??? l?????ng ph???i l???n h??n 0", "L???i", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Error: S??? l?????ng ph???i nh???p s???", "L???i", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui l??ng nh???p s??? l?????ng!!", "L???i", JOptionPane.ERROR_MESSAGE);
			txtSoLuong.requestFocus();
			return false;
		}
		return true;
	}

	private void docDuLieuVaoCmbGioHang() {
		cmbGioHang.removeAllItems();
		List<KhachHang> list = banhang_dao.getKhachHangTheoGioHang(true);
		cmbGioHang.addItem("");
		for (KhachHang kh : list) {
			cmbGioHang.addItem(kh.getTenKH().trim() + ", " + kh.getSDT().trim());
		}
	}

	private void xoaHetDLGioHang() {
		DefaultTableModel dm = (DefaultTableModel) tableGioHang.getModel();
		dm.setRowCount(0);
	}

	public void xoaThongTinTrenTextField() {
		txtCMND.setText("");
		txtTenKhachHang.setText("");
		txtSoLuong.setText("");
		txtDiaChi.setText("");
		txtMaKhachHang.setText("");
		txtNgaySinh.setDate(new Date(1999 - 1900, 1 - 1, 1));
		txtEmail.setText("");
		cmbGioHang.setSelectedIndex(-1);
		cmbDanhSachSdt.setSelectedIndex(-1);
		cmbGioiTinh.setSelectedIndex(0);
	}

	public void cmbGioHangXuongTable() {
		Object giaTriCbo = cmbGioHang.getSelectedItem();
		if (giaTriCbo == null || giaTriCbo.toString().trim().equals("")) {

		} else {
			String temp = giaTriCbo.toString().trim();

			String sdtTrongCbo = temp.replaceAll("[^0-9]", "");
			if (giaTriCbo == null || giaTriCbo.toString().trim().equals("")) {
				xoaHetDLGioHang();
			} else {
				if (sdtTrongCbo.trim().equals("")) {

				} else {
					xoaHetDLGioHang();
					// T??m m?? h??a ????n
					String maHD = null;
					List<HoaDon> listHD = hoadon_dao.getTatCaHoaDonChuaTinhTien();
					for (HoaDon hd : listHD) {
						if (hd.getMaKH().getSDT().equals(sdtTrongCbo)) {
							maHD = hd.getMaHD();
							break;
						}
					}
					// Hi???n l??n b???ng v?? txt
					Double tongTien = 0.0;
					DecimalFormat df = new DecimalFormat("#,##0");
					List<ChiTietHoaDon> listHDDV = cthd_dao.getCTHDTheoMaHDLenTable(maHD);
					for (ChiTietHoaDon cthd : listHDDV) {
						modelGioHang.addRow(new Object[] { cthd.getMaLinhKien().getMaLK().trim(),
								cthd.getMaLinhKien().getTenLK().trim(), cthd.getMaLinhKien().getLoaiHang().trim(),
								cthd.getMaLinhKien().getNhaCungCap().trim(),
								df.format(cthd.getMaLinhKien().getDonGia()), cthd.getSoLuong(),
								df.format(cthd.getThanhTien()) });
						tongTien += cthd.getThanhTien();
					}
					if (tongTien == 0)
						txtTongTien.setText("0.0 VN??");
					else
						txtTongTien.setText(df.format(tongTien) + " VN??");
				}
				// ??i???n textfield
				List<KhachHang> list = khachhang_dao.getTatCaKhachHang();

				List<KhachHang> listKHTrungSDT = new ArrayList<KhachHang>();

				for (KhachHang khachHang : list) {
					if (khachHang.getSDT().trim().equals(sdtTrongCbo.trim())) {
						listKHTrungSDT.add(khachHang);
					}
				}

				if (listKHTrungSDT.size() == 1) {
					KhachHang kh = listKHTrungSDT.get(0);
					txtTenKhachHang.setText(kh.getTenKH().trim());
					txtCMND.setText(kh.getCMND().trim());
					cmbGioiTinh.setSelectedItem(kh.isGioiTinh() == true ? "Nam" : "N???");
					txtNgaySinh.setDate(kh.getNgaySinh());
					txtEmail.setText(kh.getEmail().trim());
					txtDiaChi.setText(kh.getDiaChi().trim());
					txtMaKhachHang.setText(kh.getMaKH().trim());
					btnTaoGioHang.setEnabled(true);
				}
			}
		}

	}
}
