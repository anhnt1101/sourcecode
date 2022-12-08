/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group2.service.impl;

import com.poly.it17326.group2.domainmodel.Size;
import com.poly.it17326.group2.repository.SizeRepository;
import com.poly.it17326.group2.response.ViewSizeReponse;
import com.poly.it17326.group2.service.ICommon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haodqph27423
 */
public class SizeServiceImpl implements ICommon<ViewSizeReponse, Size> {

    private SizeRepository sizeRepository = new SizeRepository();

    @Override
    public List<ViewSizeReponse> getAll() {
        List<ViewSizeReponse> listReponse = new ArrayList<>();
        List<Size> listSize = sizeRepository.getListFromDB();// lấy dữ liệu từ repository
        for (Size size : listSize) {
            ViewSizeReponse viewSizeReponse = new ViewSizeReponse(size);
            listReponse.add(viewSizeReponse);
        }
        return listReponse;
    }

    @Override
    public Boolean create(Size y) {
        return sizeRepository.addNew(y);
    }

    @Override
    public Boolean update(Size y) {
        return sizeRepository.upDate(y);
    }

    @Override
    public Boolean delete(String id) {
        return sizeRepository.delete(id);
    }

}
