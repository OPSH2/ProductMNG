package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class GUI_NhanVien extends JFrame implements ActionListener, MouseListener {
	private JLabel lblThoiGian;
	private JLabel txtThoiGian;
	private JLabel lblDangXuat;
	private JLabel lblMaNhanVien;
	private JLabel txtMaNhanVien;

	public GUI_NhanVien() {
		setTitle("PHẦN MỀM QUẢN LÝ BÁN LINH KIỆN");
//		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(NORMAL);
		setSize(1500, 700);
		setLocationRelativeTo(null);	
		add(createTabbedPane());
	}

	/**
	 * create a JTabbedPane contain tabs
	 */
	public JTabbedPane createTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setUI(new BasicTabbedPaneUI() {
			@Override
			protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
				return 80;
			}
			@Override
			protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
				return 200;
			}
		});
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 13));

		FrmBanHang frmBanHang= new FrmBanHang();
		FrmHoaDon frmHoaDon = new FrmHoaDon();
		FrmNhanVien frmNhanVien = new FrmNhanVien();
		FrmKhachHang frmKhachHang = new FrmKhachHang();
		FrmSanPham frmSanPham = new FrmSanPham();
		

		/* create JPanel, which is content of tabs */
		JPanel pnlTrangChu = createPanelTrangChu();
		JPanel pnlHoaDon = frmHoaDon.createPanelHoaDon();
		JPanel pnlBanHang = frmBanHang.createPanelBanHang();
		JPanel pnlNhanVien = frmNhanVien.createPanelNhanVien();
		JPanel pnlKhachHang = frmKhachHang.createPanelKhachHang();
		JPanel pnlSanPham = frmSanPham.createPanelSanPham();

		/* add tab with JPanel */
		tabbedPane.addTab("TRANG CHỦ", new ImageIcon(""), pnlTrangChu, "TRANG CHỦ");
		tabbedPane.addTab("BÁN HÀNG", new ImageIcon(""), pnlBanHang, "BÁN HÀNG");
		tabbedPane.addTab("NHÂN VIÊN", new ImageIcon(""), pnlNhanVien, "NHÂN VIÊN");
		tabbedPane.addTab("KHÁCH HÀNG", new ImageIcon(""), pnlKhachHang, "KHÁCH HÀNG");
		tabbedPane.addTab("SẢN PHẨM", new ImageIcon(""), pnlSanPham, "SẢN PHẨM");
		tabbedPane.addTab("HÓA ĐƠN", new ImageIcon(""), pnlHoaDon, "HÓA ĐƠN");
		
		
		return tabbedPane;
	}

	public JPanel createPanelTrangChu() {
		JPanel pnlContentPane = new JPanel();
//		pnlContentPane.setBackground(new Color(0,0,200));
		pnlContentPane.setLayout(null);
		
		JPanel pnlTitle = new JPanel();
		pnlContentPane.add(pnlTitle);

		
		JLabel lblTitle = new JLabel("PHẦN MỀM QUẢN LÝ BÁN LINH KIỆN ĐIỆN TỬ");
		lblTitle.setBounds(300, 0, 600, 50);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setForeground(Color.RED);
		pnlContentPane.add(lblTitle);

	
		
		ImageIcon imageIcon = new ImageIcon("image/hinhnen.png");
		Image image = imageIcon.getImage();
		Image imageResize = image.getScaledInstance(1250, 500, Image.SCALE_SMOOTH);
		JLabel lblHinhNen = new JLabel(new ImageIcon(imageResize));
		lblHinhNen.setBounds(10, 0, 1250, 600);
		pnlContentPane.add(lblHinhNen);
		
		lblDangXuat = new JLabel("<HTML><U>ĐĂNG XUẤT</U></HTML>");
		lblDangXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDangXuat.setFont(new Font("Arial", Font.ITALIC, 15));
		lblDangXuat.setBounds(1150, 0, 150, 42);
		pnlContentPane.add(lblDangXuat);
		
		lblMaNhanVien = new JLabel("MÃ NHÂN VIÊN: ");
		lblMaNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMaNhanVien.setFont(new Font("Arial", Font.BOLD, 20));
		lblMaNhanVien.setBounds(50, 550, 200, 42);
		txtMaNhanVien = new JLabel("123");
		txtMaNhanVien.setBounds(140, 550, 200, 42);
		txtMaNhanVien.setHorizontalAlignment(JLabel.CENTER);
        txtMaNhanVien.setFont(new Font("Arial", Font.BOLD, 20));
        pnlContentPane.add(lblMaNhanVien);
        pnlContentPane.add(txtMaNhanVien);
        
        lblMaNhanVien = new JLabel("TÊN NHÂN VIÊN: ");
		lblMaNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMaNhanVien.setFont(new Font("Arial", Font.BOLD, 20));
		lblMaNhanVien.setBounds(50, 600, 200, 42);
		txtMaNhanVien = new JLabel("123");
		txtMaNhanVien.setBounds(140, 600, 200, 42);
		txtMaNhanVien.setHorizontalAlignment(JLabel.CENTER);
        txtMaNhanVien.setFont(new Font("Arial", Font.BOLD, 20));
        pnlContentPane.add(lblMaNhanVien);
        pnlContentPane.add(txtMaNhanVien);
		
		lblThoiGian = new JLabel("THỜI GIAN HIỆN TẠI:");
		lblThoiGian.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblThoiGian.setFont(new Font("Arial", Font.ITALIC, 15));
		lblThoiGian.setBounds(900, 600, 150, 42);
		txtThoiGian = new JLabel();
		txtThoiGian.setBounds(1050, 600, 200, 42);
        txtThoiGian.setHorizontalAlignment(JLabel.CENTER);
        txtThoiGian.setFont(new Font("Arial", Font.ITALIC, 15));
        
        Timer t = new Timer(1000, new ActionListener() {
           public void actionPerformed(ActionEvent e) {
             txtThoiGian.setText(DateFormat.getDateTimeInstance().format(new Date()));
           }
        });
        t.setRepeats(true);
        t.setCoalesce(true);
        t.setInitialDelay(0);
        t.start();
        pnlContentPane.add(lblThoiGian);
        pnlContentPane.add(txtThoiGian);
		

		lblDangXuat.addMouseListener(this);
		return pnlContentPane;

	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
	}

	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(lblDangXuat)) {
			int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "?!",
					JOptionPane.YES_NO_OPTION);
			if (result == 0) {
				FrmDangNhap frmDN = new FrmDangNhap();
				frmDN.setVisible(true);
				frmDN.setLocationRelativeTo(null);
				dispose();
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
	public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_NhanVien().setVisible(true);
            }
        });
	}
	
}
