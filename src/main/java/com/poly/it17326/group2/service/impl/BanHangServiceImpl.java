package com.poly.it17326.group2.service.impl;

import com.poly.it17326.group2.domainmodel.ChiTietSP;
import com.poly.it17326.group2.domainmodel.HoaDon;
import com.poly.it17326.group2.domainmodel.HoaDonChiTiet;
import com.poly.it17326.group2.domainmodel.SanPham;
import com.poly.it17326.group2.domainmodel.TaiKhoan;
import com.poly.it17326.group2.domainmodel.TrangThai;
import com.poly.it17326.group2.repository.BanHangRepository;
import com.poly.it17326.group2.repository.ChiTietSPRepository;
import com.poly.it17326.group2.repository.HoaDonChiTietRepository;
import com.poly.it17326.group2.repository.HoaDonRepository;
import com.poly.it17326.group2.repository.SanPhamRepository;
import com.poly.it17326.group2.repository.TaiKhoanRepository;
import com.poly.it17326.group2.repository.TrangThaiRepository;
import com.poly.it17326.group2.response.ViewChiTietSPResponse;
import com.poly.it17326.group2.response.ViewHoaDonChiTietResponse;
import com.poly.it17326.group2.response.ViewHoaDonResponse;
import com.poly.it17326.group2.service.BanHangService;
import java.util.ArrayList;
import java.util.List;

public class BanHangServiceImpl implements BanHangService {

    private BanHangRepository banHangRepository = new BanHangRepository();

    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();

    private HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepository();

    private HoaDonRepository hoaDonRepository = new HoaDonRepository();

    private TrangThaiRepository trangThaiRepository = new TrangThaiRepository();

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    private TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();

    @Override
    public List<ViewChiTietSPResponse> getAllChiTietSP() {
        List<ViewChiTietSPResponse> response = new ArrayList<>();
        List<ChiTietSP> list = chiTietSPRepository.getAll();
        for (ChiTietSP chiTietSP : list) {
            ViewChiTietSPResponse viewChiTietSPResponse = new ViewChiTietSPResponse(chiTietSP);
            response.add(viewChiTietSPResponse);
        }
        return response;
    }

    @Override
    public List<ViewHoaDonChiTietResponse> getHoaDonChiTietByHoaDon(String id) {
        List<ViewHoaDonChiTietResponse> response = new ArrayList<>();
        List<HoaDonChiTiet> list = banHangRepository.getHDCTByHoaDon(id);
        for (HoaDonChiTiet hoaDonChiTiet : list) {
            ViewHoaDonChiTietResponse viewHoaDonChiTietResponse = new ViewHoaDonChiTietResponse(hoaDonChiTiet);
            response.add(viewHoaDonChiTietResponse);
        }
        return response;
    }

    @Override
    public List<ViewHoaDonResponse> getHoaDonByUser(String id) {
        List<ViewHoaDonResponse> response = new ArrayList<>();
        List<HoaDon> list = banHangRepository.getHoaDonByUser(id);
        for (HoaDon hoaDon : list) {
            if (hoaDon.getTaiKhoan().getTenTaiKhoan().equals(id)) {
                ViewHoaDonResponse viewHoaDonResponse = new ViewHoaDonResponse(hoaDon);
                response.add(viewHoaDonResponse);
            }
        }
        return response;
    }

    @Override
    public Boolean createHDCT(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.add(hoaDonChiTiet);
    }

    @Override
    public Boolean createHD(HoaDon hoaDon) {
        return hoaDonRepository.add(hoaDon);
    }

    @Override
    public Boolean updateChiTietSP(ChiTietSP chiTietSP) {
        return chiTietSPRepository.add(chiTietSP);
    }


    @Override
    public List<TrangThai> getAllTrangThai() {
        return trangThaiRepository.getAll();
    }

    @Override
    public List<HoaDon> getAllHoaDon() {
        return hoaDonRepository.getAll();
    }

    @Override
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.getAll();
    }

    @Override
    public List<HoaDonChiTiet> getAllHDCT() {
        return hoaDonChiTietRepository.getAll();
    }

    @Override
    public List<TaiKhoan> getAllTaiKhoans() {
        return taiKhoanRepository.getAll();
    }

    @Override
    public HoaDon getByMaHD(String maHD) {
        return banHangRepository.getByMaHD(maHD);
    }

    @Override
    public Boolean updateSLSP(ChiTietSP chiTietSP, String id) {
        return banHangRepository.updateSLSP(chiTietSP, id);
    }

    @Override
    public List<ViewChiTietSPResponse> getSanPham(String tenSP) {
        List<ViewChiTietSPResponse> response = new ArrayList<>();
        List<ChiTietSP> list = banHangRepository.getAll();
        for (ChiTietSP chiTietSP : list) {
            if (chiTietSP.getSanPham().getTen().contains(tenSP)) {
                ViewChiTietSPResponse viewChiTietSPResponse = new ViewChiTietSPResponse(chiTietSP);
                response.add(viewChiTietSPResponse);
            }
        }
        return response;
    }

    @Override
    public Boolean updateHD(HoaDon hoaDon, String id) {
        return banHangRepository.updateHD(hoaDon, id);
    }

    @Override
    public Boolean updateHDCT(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.add(hoaDonChiTiet);
    }

    @Override
    public Boolean huyDon(ChiTietSP chiTietSP, String id) {
       return banHangRepository.huyDon(chiTietSP, id);
    }

}
