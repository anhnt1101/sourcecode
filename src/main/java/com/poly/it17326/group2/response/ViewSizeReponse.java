/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group2.response;

import com.poly.it17326.group2.domainmodel.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author haodqph27423
 */

@Getter
@Setter
@ToString
public class ViewSizeReponse {
    private String id;
    private String ma;
    private int ten;

    public ViewSizeReponse() {
    }
    // maping dữ liệu
    public ViewSizeReponse(Size size) {
        this.id = size.getId();
        this.ma = size.getMa();
        this.ten = size.getTen();
    }
}
