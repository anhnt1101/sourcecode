/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group2.repository;

import com.poly.it17326.group2.config.HibernateConfig;
import com.poly.it17326.group2.domainmodel.ChiTietSP;
import com.poly.it17326.group2.domainmodel.HoaDon;
import com.poly.it17326.group2.domainmodel.HoaDonChiTiet;
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
    
    public List<HoaDon> getHoaDonByUser(String id) {
        Query query = session.createQuery("Select p From HoaDon p where p.taiKhoan.tenTaiKhoan = :id", HoaDon.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<HoaDonChiTiet> getHDCTByHoaDon(String id) {
        Query query = session.createQuery("Select p from HoaDonChiTiet p where p.hoaDon.ma = :id", HoaDonChiTiet.class);
        query.setParameter("id", id);
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

    public Boolean updateHD(HoaDon hoaDon, String id) {
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

   
}
