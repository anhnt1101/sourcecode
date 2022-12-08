/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group2.response;

import com.poly.it17326.group2.domainmodel.HoaDon;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author tuannvph27467
 */
@Getter
@Setter
@ToString
public class ViewHoaDonResponse {

    private String maHD;
    private String ngayTao;
    private String tenTaiKhoan;
    private Integer trangThai;

    public ViewHoaDonResponse() {
    }

    public ViewHoaDonResponse(HoaDon hoaDon) {
        this.maHD = hoaDon.getMa();
        this.ngayTao = hoaDon.getNgayTao();
        this.tenTaiKhoan = hoaDon.getTaiKhoan().getTenTaiKhoan();
        this.trangThai = hoaDon.getTrangThai().getTenTrangThai();
    }

    public String htTrangThai() {
        if (this.trangThai == 1) {
            return "Đã thanh toán";
        } else if (this.trangThai == 0) {
            return "Đã hủy";
        }
        return "Chờ thanh toán";
    }
}
