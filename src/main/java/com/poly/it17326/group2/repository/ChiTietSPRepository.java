/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group2.repository;

import com.poly.it17326.group2.config.HibernateConfig;
import com.poly.it17326.group2.domainmodel.ChiTietSP;
import com.poly.it17326.group2.domainmodel.DeGiay;
import com.poly.it17326.group2.domainmodel.MauSac;
import com.poly.it17326.group2.domainmodel.NhaCungCap;
import com.poly.it17326.group2.domainmodel.SanPham;
import com.poly.it17326.group2.domainmodel.KichThuoc;
import com.poly.it17326.group2.domainmodel.ThuongHieu;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author anhntnph27418
 */
public class ChiTietSPRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    public List<ChiTietSP> getAll() {
        Query query = session.createQuery("FROM ChiTietSP");
        return query.getResultList();
    }

    public List<SanPham> getSanPham() {
        Query query = session.createQuery("FROM SanPham");
        return query.getResultList();
    }

    public List<MauSac> getMau() {
        Query query = session.createQuery("FROM MauSac");
        return query.getResultList();
    }

    public List<NhaCungCap> getNCC() {
        Query query = session.createQuery("FROM NhaCungCap");
        return query.getResultList();
    }

    public List<ThuongHieu> getTH() {
        Query query = session.createQuery("FROM ThuongHieu");
        return query.getResultList();
    }

    public List<KichThuoc> getSize() {
        Query query = session.createQuery("FROM Size");
        return query.getResultList();
    }

    public List<DeGiay> getDeGiay() {
        Query query = session.createQuery("FROM DeGiay");
        return query.getResultList();
    }

    public Boolean add(ChiTietSP chiTietSP) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(chiTietSP);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.fillInStackTrace();
            return false;
        }
    }

    public Boolean delete(String id) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM ChiTietSP WHERE Id = :Id");
            query.setParameter("Id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public Boolean updateChitietSP(int soLuongTon, String id) {
//        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            Query query = session.createQuery("UPDATE ChiTietSP p set p.soLuongTon = :soLuong where p.id = :id");
//            query.setParameter("id", id);
//            query.setParameter("soLuong", soLuongTon);
//            query.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

    public ChiTietSP getById(String id) {
        try {
            Query query = session.createQuery("FROM ChiTietSP WHERE Id = :Id");
            query.setParameter("Id", id);
            return (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
        }
        return null;
    }

}
