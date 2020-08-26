package com.ftq.webpage.dao;

import com.ftq.webpage.pojo.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityDAO extends JpaRepository<City, Integer> {

    List<City> findAllByCategoryOrderByReleasedateDesc(String category);

    List<City> findAllByReleasedateBetweenOrderByReleasedateDesc(String start, String end);

    List<City> findAllByCategoryInOrderByReleasedateDesc(List<String> categories);

}
