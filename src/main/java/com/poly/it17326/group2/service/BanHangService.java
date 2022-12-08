package com.poly.it17326.group2.service;

import com.poly.it17326.group2.domainmodel.ChiTietSP;
import com.poly.it17326.group2.domainmodel.HoaDon;
import com.poly.it17326.group2.domainmodel.HoaDonChiTiet;
import com.poly.it17326.group2.domainmodel.SanPham;
import com.poly.it17326.group2.domainmodel.TaiKhoan;
import com.poly.it17326.group2.domainmodel.TrangThai;
import com.poly.it17326.group2.response.ViewChiTietSPResponse;
import com.poly.it17326.group2.response.ViewHoaDonChiTietResponse;
import com.poly.it17326.group2.response.ViewHoaDonResponse;
import java.util.List;

public interface BanHangService {

    List<ViewChiTietSPResponse> getAllChiTietSP();

    List<ViewChiTietSPResponse> getSanPham(String tenSP);

    
    List<ViewHoaDonChiTietResponse> getHoaDonChiTietByHoaDon(String id);

    List<ViewHoaDonResponse> getHoaDonByUser(String id);

    Boolean createHDCT(HoaDonChiTiet hoaDonChiTiet);

    Boolean createHD(HoaDon hoaDon);

    Boolean updateHD(HoaDon hoaDon, String id);

    Boolean updateChiTietSP(ChiTietSP chiTietSP);

    Boolean updateHDCT(HoaDonChiTiet hoaDonChiTiet);

    List<TrangThai> getAllTrangThai();

    List<HoaDon> getAllHoaDon();

    List<SanPham> getAllSanPham();

    List<HoaDonChiTiet> getAllHDCT();

    List<TaiKhoan> getAllTaiKhoans();

    HoaDon getByMaHD(String maHD);

    Boolean updateSLSP(ChiTietSP chiTietSP, String id);

    Boolean huyDon(ChiTietSP chiTietSP, String id);
}
