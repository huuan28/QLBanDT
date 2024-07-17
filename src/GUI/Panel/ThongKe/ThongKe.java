package GUI.Panel.ThongKe;

import BUS.ThongKeBUS;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Tran Nhat Sinh
 */
public final class ThongKe extends JPanel {

    JTabbedPane tabbedPane;
    JPanel tongquan, nhacungcap, khachhang, doanhthu;
    ThongKeTonKho nhapxuat;
    Color BackgroundColor = new Color(240, 247, 250);
    ThongKeBUS thongkeBUS = new ThongKeBUS();
    ThongKeNhap thongkenhap;
    ThongKeDoanhThuTuNgayDenNgay thongkedoanhthutungaydenngay;

    public ThongKe() {
        initComponent();
    }

    public void initComponent() {
        this.setLayout(new GridLayout(1, 1));
        this.setBackground(BackgroundColor);
        thongkedoanhthutungaydenngay = new ThongKeDoanhThuTuNgayDenNgay(thongkeBUS);
        tongquan = new ThongKeTongQuan(thongkeBUS);
        nhapxuat = new ThongKeTonKho(thongkeBUS);
        khachhang = new ThongKeKhachHang(thongkeBUS);
        nhacungcap = new ThongKeNhaCungCap(thongkeBUS);
        doanhthu = new ThongKeDoanhThu(thongkeBUS);
        thongkenhap = new ThongKeNhap(thongkeBUS);
        tabbedPane = new JTabbedPane();
        tabbedPane.setOpaque(false);
        //tabbedPane.addTab("Tổng quan", tongquan);
        //tabbedPane.addTab("Tồn kho", nhapxuat);
        tabbedPane.addTab("Thống kê bán ra", thongkedoanhthutungaydenngay);
        tabbedPane.addTab("Thống kê nhập hàng", thongkenhap);
        //tabbedPane.addTab("Nhà cung cấp", nhacungcap);
        //tabbedPane.addTab("Khách hàng", khachhang);

        this.add(tabbedPane);
    }
}
