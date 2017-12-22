package huydk.firstapp;

import java.io.Serializable;

/**
 * Created by Admin on 12/22/2017.
 */

public class NhanVien implements Serializable {
    private String tenNhanVien;
    private String thuBatDauCongTac;
    private int soNgayDuKienCongTac;

    @Override
    public String toString() {
        return "NhanVien{" +
                "tenNhanVien='" + tenNhanVien + '\'' +
                ", thuBatDauCongTac='" + thuBatDauCongTac + '\'' +
                ", soNgayDuKienCongTac=" + soNgayDuKienCongTac +
                '}';
    }

    public NhanVien() {
    }

    public NhanVien(String tenNhanVien, String thuBatDauCongTac, int soNgayDuKienCongTac) {

        this.tenNhanVien = tenNhanVien;
        this.thuBatDauCongTac = thuBatDauCongTac;
        this.soNgayDuKienCongTac = soNgayDuKienCongTac;
    }

    public String getTenNhanVien() {

        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getThuBatDauCongTac() {
        return thuBatDauCongTac;
    }

    public void setThuBatDauCongTac(String thuBatDauCongTac) {
        this.thuBatDauCongTac = thuBatDauCongTac;
    }

    public int getSoNgayDuKienCongTac() {
        return soNgayDuKienCongTac;
    }

    public void setSoNgayDuKienCongTac(int soNgayDuKienCongTac) {
        this.soNgayDuKienCongTac = soNgayDuKienCongTac;
    }
}
