package com.poly.it17326.group2.service;

import com.poly.it17326.group2.domainmodel.ChucVu;
import com.poly.it17326.group2.domainmodel.TaiKhoan;
import com.poly.it17326.group2.response.ViewTaiKhoanResponse;
import java.util.List;

public interface TaiKhoanService {

    List<ViewTaiKhoanResponse> getAll();

    Boolean add(TaiKhoan taiKhoan);

    Boolean update(TaiKhoan taiKhoan);

    Boolean delete(String id);
    
    List<ChucVu> getChucVu();
    
    TaiKhoan login(String user, String pass);
}
