package com.ftq.webpage.service;

import com.ftq.webpage.dao.ProvinceDAO;
import com.ftq.webpage.pojo.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {

    @Autowired
    ProvinceDAO provinceDAO;

    public List<Province> getAllByCategory(String category) {
        return provinceDAO.findAllByCategoryOrderByReleasedateDesc(category);
    }

    public List<Province> getAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "releasedate");
        return provinceDAO.findAll(sort);
    }

    public List<Province> getAllByDate(String start, String end) {
        return provinceDAO.findAllByReleasedateBetweenOrderByReleasedateDesc(start, end);
    }

    public List<Province> getAllByCategories(List<String> categories) {
        return provinceDAO.findAllByCategoryInOrderByReleasedateDesc(categories);
    }
}
