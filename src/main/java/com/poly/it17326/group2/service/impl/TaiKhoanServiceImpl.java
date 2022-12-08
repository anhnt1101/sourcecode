package com.poly.it17326.group2.service.impl;

import com.poly.it17326.group2.domainmodel.ChucVu;
import com.poly.it17326.group2.domainmodel.TaiKhoan;
import com.poly.it17326.group2.repository.TaiKhoanRepository;
import com.poly.it17326.group2.response.ViewChucVuResponse;
import com.poly.it17326.group2.response.ViewTaiKhoanResponse;
import com.poly.it17326.group2.service.TaiKhoanService;
import java.util.ArrayList;
import java.util.List;
//hocnvph27417
public class TaiKhoanServiceImpl implements TaiKhoanService{

    private TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();
    
    @Override
    public List<ViewTaiKhoanResponse> getAll() {
        List<ViewTaiKhoanResponse> response = new ArrayList<>();
        List<TaiKhoan> list = taiKhoanRepository.getAll();
        for (TaiKhoan taiKhoan : list) {
            ViewTaiKhoanResponse viewTaiKhoanResponse = new ViewTaiKhoanResponse(taiKhoan);
            response.add(viewTaiKhoanResponse);
        }
        return response;
    }

    @Override
    public Boolean add(TaiKhoan taiKhoan) {
        return taiKhoanRepository.add(taiKhoan);
    }

    @Override
    public Boolean update(TaiKhoan taiKhoan) {
        return taiKhoanRepository.add(taiKhoan);
    }

    @Override
    public Boolean delete(String id) {
        return taiKhoanRepository.delete(id);
    }

    @Override
    public List<ChucVu> getChucVu() {
        return taiKhoanRepository.getChucVu();
    }

    @Override
    public TaiKhoan login(String user, String pass) {
        return taiKhoanRepository.getLogin(user, pass);
    }

}
