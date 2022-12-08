package com.poly.it17326.group2.repository;

import com.poly.it17326.group2.config.HibernateConfig;
import com.poly.it17326.group2.domainmodel.ChucVu;
import com.poly.it17326.group2.domainmodel.TaiKhoan;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
//hocnvph27417
public class TaiKhoanRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    public List<TaiKhoan> getAll() {
        Query query = session.createQuery("FROM TaiKhoan");
        return query.getResultList();
    }

    public List<ChucVu> getChucVu() {
        Query query = session.createQuery("FROM ChucVu");
        return query.getResultList();
    }

    public Boolean add(TaiKhoan taiKhoan) {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(taiKhoan);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.fillInStackTrace();
            return false;
        }
    }

    public Boolean delete(String id) {
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM TaiKhoan WHERE Id = :Id");
            query.setParameter("Id", id);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public TaiKhoan getLogin(String user, String pass) {
        try {
            Query query = session.createQuery("FROM TaiKhoan WHERE TenTaiKhoan = :TenTaiKhoan and MatKhau = :MatKhau");
            query.setParameter("TenTaiKhoan", user);
            query.setParameter("MatKhau", pass);
            return (TaiKhoan) query.getSingleResult();
        } catch (Exception e) {
        }
        return null;
    }
}
