package DTO.ThongKe;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author robot
 */
public class ThongKeNhapDTO{
    private Date ngay;
    private int chiphi;

    public ThongKeNhapDTO(Date ngay, int chiphi) {
        this.ngay = ngay;
        this.chiphi = chiphi;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public int getChiphi() {
        return chiphi;
    }

    public void setChiphi(int chiphi) {
        this.chiphi = chiphi;
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.ngay);
        hash = 29 * hash + this.chiphi;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ThongKeNhapDTO other = (ThongKeNhapDTO) obj;
        if (this.chiphi != other.chiphi) {
            return false;
        }
        return Objects.equals(this.ngay, other.ngay);
    }

    @Override
    public String toString() {
        return "ThongKeTungNgayTrongThangDTO{" + "ngay=" + ngay + ", tiennhap=" + chiphi +  '}';
    }
    
    
    
}
