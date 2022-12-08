/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group2.response;

import com.poly.it17326.group2.domainmodel.NhaCungCap;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ViewNhaCungCapResponse {

    private String id;
    private String ma;
    private String ten;
    private String sdt;
    private String diaChi;

    public ViewNhaCungCapResponse() {
    }

    public ViewNhaCungCapResponse(String id, String ma, String ten, String sdt, String diaChi) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public ViewNhaCungCapResponse(NhaCungCap nhaCungCap) {
        this.id = nhaCungCap.getId();
        this.ma = nhaCungCap.getMa();
        this.ten = nhaCungCap.getTen();
        this.sdt = nhaCungCap.getSdt();
        this.diaChi = nhaCungCap.getDiaChi();
    }

}
