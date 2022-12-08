/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group2.repository;

import com.poly.it17326.group2.config.HibernateConfig;
import com.poly.it17326.group2.domainmodel.MauSac;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author phuongktph26630
 */
public class MauSacRepository {

    public List<MauSac> getListFromDB() {
        List<MauSac> list;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<MauSac> query = session.createQuery("SELECT p FROM MauSac p", MauSac.class);
            list = query.getResultList();
        }
        return list;
    }

    public Boolean addNew(MauSac mauSac) {
        try(Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean upDate(MauSac mauSac) {
       try(Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean delete(String id) {
        try (Session session = HibernateConfig.getFACTORY().openSession()){
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE MauSac p WHERE p.id = : id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }


    }

}
