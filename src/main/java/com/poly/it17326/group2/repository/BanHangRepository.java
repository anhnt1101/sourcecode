/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group2.repository;

import com.poly.it17326.group2.config.HibernateConfig;
import com.poly.it17326.group2.domainmodel.ChiTietSP;
import com.poly.it17326.group2.domainmodel.HoaDon;
import com.poly.it17326.group2.domainmodel.HoaDonChiTiet;
import com.poly.it17326.group2.view.ViewBanHang;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author tuannvph27467
 */
public class BanHangRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    public List<ChiTietSP> getAll() {
        Query query = session.createQuery("FROM ChiTietSP", ChiTietSP.class);

        return query.getResultList();
    }

    public List<HoaDon> getHoaDonByMa(String ma) {
        Query query = session.createQuery("Select p From HoaDon p where p.nhanVien.ma = :ma and p.trangThai.tenTrangThai = 1", HoaDon.class);
        query.setParameter("ma", ma);
        return query.getResultList();
    }

    public List<HoaDonChiTiet> getHDCTByHoaDon(String ma) {
        Query query = session.createQuery("Select p from HoaDonChiTiet p where p.hoaDon.ma = :ma", HoaDonChiTiet.class);
        query.setParameter("ma", ma);
        return query.getResultList();
    }

    public HoaDon getByMaHD(String maHD) {
        try {
            Query query = session.createQuery("FROM HoaDon WHERE Ma = :Ma");
            query.setParameter("Ma", maHD);
            return (HoaDon) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean updateSLSP(ChiTietSP chiTietSP, String id) {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE ChiTietSP p SET p.soLuongTon = :soLuongTon WHERE p.id = :id");
            query.setParameter("soLuongTon", chiTietSP.getSoLuongTon());
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean huyDon(ChiTietSP chiTietSP, String id) {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE ChiTietSP p SET p.soLuongTon = :soLuongTon + p.soLuongTon WHERE p.id = :id");
            query.setParameter("soLuongTon", chiTietSP.getSoLuongTon());
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean thanhToan(HoaDon hoaDon, String id) {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE HoaDon p SET p.trangThai = :trangThai WHERE p.id = :id");
            query.setParameter("trangThai", hoaDon.getTrangThai());
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateKhach(HoaDon hoaDon, String id) {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE HoaDon p SET p.khachHang.id = :idKhachHang WHERE p.id = :id");
            query.setParameter("idKhachHang", hoaDon.getKhachHang().getId());
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean tangSL(HoaDonChiTiet hoaDonChiTiet, String idHD) {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE HoaDonChiTiet p SET p.soLuong = :soLuong + p.soLuong WHERE p.hoaDon.id = :idHD");;
            query.setParameter("soLuong", hoaDonChiTiet.getSoLuong());
            query.setParameter("idHD", idHD);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean giamSL(HoaDonChiTiet hoaDonChiTiet, String idHD) {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE HoaDonChiTiet p SET p.soLuong = p.soLuong - :soLuong WHERE p.hoaDon.id = :idHD");
            query.setParameter("soLuong", hoaDonChiTiet.getSoLuong());
            query.setParameter("idHD", idHD);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean upadteTangSP(ChiTietSP chiTietSP, String id) {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE ChiTietSP p SET p.soLuongTon = :soLuongTon + p.soLuongTon WHERE p.id = :id");
            query.setParameter("soLuongTon", chiTietSP.getSoLuongTon());
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean upadteGiamSP(ChiTietSP chiTietSP, String id) {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE ChiTietSP p SET p.soLuongTon = p.soLuongTon - :soLuongTon  WHERE p.id = :id");
            query.setParameter("soLuongTon", chiTietSP.getSoLuongTon());
            query.setParameter("id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        BanHangRepository banHangRepository = new BanHangRepository();
        List<HoaDonChiTiet> chiTiet = banHangRepository.getHDCTByHoaDon("HD1");
//        chiTiet.setSoLuong(2);
//        banHangRepository.tangSL(chiTiet, "9FCAECA9-3CAF-4610-B1C0-9C1605188F92");
        for (HoaDonChiTiet chiTietSP : chiTiet) {
            System.out.println(chiTietSP.getSoLuong());
        }
    }

}
