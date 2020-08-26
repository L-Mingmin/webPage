package com.ftq.webpage.service;

import com.ftq.webpage.dao.CityDAO;
import com.ftq.webpage.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityDAO cityDAO;

    public List<City> getAllByCategory(String category) {
        return cityDAO.findAllByCategoryOrderByReleasedateDesc(category);
    }

    public List<City> getAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "releasedate");
        return cityDAO.findAll(sort);
    }

    public List<City> getAllByDate(String start, String end) {
        return cityDAO.findAllByReleasedateBetweenOrderByReleasedateDesc(start, end);
    }

    public List<City> getAllByCategories(List<String> categories) {
        return cityDAO.findAllByCategoryInOrderByReleasedateDesc(categories);
    }

}
