/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group2.repository;

import com.poly.it17326.group2.config.HibernateConfig;
import com.poly.it17326.group2.domainmodel.ThuongHieu;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author PC chiendqph25320
 */
public class ThuongHieuRepository {

    public List<ThuongHieu> getList() {
        List<ThuongHieu> list;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<ThuongHieu> query = session.createQuery("select d from ThuongHieu d", ThuongHieu.class);
            list = query.getResultList();
        }
        return list;

    }

    public Boolean them(ThuongHieu thuongHieu) {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(thuongHieu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean xoa(String id) {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE ThuongHieu d WHERE d.id = : id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
