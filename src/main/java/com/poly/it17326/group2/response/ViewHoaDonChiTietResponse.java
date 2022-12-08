/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group2.response;

import com.poly.it17326.group2.domainmodel.HoaDonChiTiet;
import java.math.BigDecimal;
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
public class ViewHoaDonChiTietResponse {
    
    private String maSP;
    private String tenSP;
    private int soLuong;
    private int size;
    private Double gia;
    private Double tongTien;

    public ViewHoaDonChiTietResponse() {
    }

    public ViewHoaDonChiTietResponse(HoaDonChiTiet hoaDonChiTiet) {
        this.maSP = hoaDonChiTiet.getMaSp();
        this.tenSP = hoaDonChiTiet.getTenSp();
        this.soLuong = hoaDonChiTiet.getSoLuong();
        this.size = hoaDonChiTiet.getSize();
        this.gia = hoaDonChiTiet.getGia();
        this.tongTien = hoaDonChiTiet.getSoLuong() * hoaDonChiTiet.getGia();
    }    
}
