/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group2.repository;

import com.poly.it17326.group2.config.HibernateConfig;
import com.poly.it17326.group2.domainmodel.Size;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author haodqph27423
 */
public class SizeRepository {

    public List<Size> getListFromDB() {
        List<Size> list;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Size> query = session.createQuery("SELECT p FROM Size p", Size.class);
            list = query.getResultList();
        }
        return list;
    }

    public Boolean addNew(Size size) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(size);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean upDate(Size size) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(size);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean delete(String id) {
        try ( Session se = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = se.beginTransaction();
            Query query = se.createQuery("DELETE Size p WHERE p.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
