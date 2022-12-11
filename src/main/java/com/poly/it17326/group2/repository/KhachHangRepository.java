/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group2.repository;

import com.poly.it17326.group2.config.HibernateConfig;
import com.poly.it17326.group2.domainmodel.KhachHang;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DELL
 */
public class KhachHangRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    public List<KhachHang> getAll() {
        Query query = session.createQuery("FROM KhachHang");
        return query.getResultList();
    }

    public Boolean add(KhachHang khachHang) {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(khachHang);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.fillInStackTrace();
            return false;
        }
    }

    public List<KhachHang> getByTenKhachHang(String hoTen) {
        Query query = session.createQuery("Select p From KhachHang p where p.hoTen = :hoTen");
        query.setParameter("hoTen", hoTen);
        return query.getResultList();
    }
    
    public static void main(String[] args) {
        KhachHangRepository khachHangRepository = new KhachHangRepository();
        List<KhachHang> list = khachHangRepository.getByTenKhachHang("Khách Lẻ");
        for (KhachHang khachHang : list) {
            System.out.println(khachHang.getMaKhachHang());
        }
    }
}
