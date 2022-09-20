package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmHoaDon extends JFrame{

	private DefaultTableModel modelHoaDon;
	private JTable tblHoaDon;
	private JTextField txtTim;
	private JLabel lblTim;
	private JButton btnTim;
	private JPanel p;
	private JPanel pNorth;

	public JPanel createPanelHoaDon() {
		// TODO Auto-generated constructor stub
		
		setTitle("FrmHoaDon");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		p=new JPanel();
		pNorth=new JPanel();
		
		Box b=Box.createVerticalBox();
		Box bThongtin=Box.createHorizontalBox();
		Box btim=Box.createHorizontalBox();
		
		JLabel lblTieuDe;
		lblTieuDe = new JLabel("THÔNG TIN HÓA ĐƠN");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 30));
		lblTieuDe.setForeground(Color.blue);
		
		txtTim=new JTextField(40);
		lblTim=new JLabel("Nhập thông tin bạn muốn tìm   ");
		btnTim=new JButton("Tìm");
		
		
		String[] colHeader = { "Mã Hóa Đơn", "Tên Khách Hàng", "Tên Nhân Viên", "Ngày Lập Hóa Đơn", "Giảm Giá", "Tổng Tiền"};
		modelHoaDon = new DefaultTableModel(colHeader, 0);
		tblHoaDon=new JTable(modelHoaDon);
		JScrollPane tblscroll=new JScrollPane(tblHoaDon);
		tblHoaDon.setPreferredScrollableViewportSize(new Dimension(1200,500));
		
		add(p);
		p.add(pNorth,BorderLayout.NORTH);
		pNorth.add(b);
		b.add(bThongtin);
		bThongtin.add(lblTieuDe);
		
		b.add(btim);
		btim.add(lblTim);
		btim.add(txtTim);
		btim.add(btnTim);
		
		p.add(tblscroll,BorderLayout.CENTER);
		return p;
		
		
	}
	public static void main(String[] args) {
		new GUI_NhanVien().setVisible(true);
	}
}
