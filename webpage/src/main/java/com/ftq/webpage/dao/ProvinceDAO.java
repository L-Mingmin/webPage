package com.ftq.webpage.dao;

import com.ftq.webpage.pojo.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinceDAO extends JpaRepository<Province, Integer> {

    List<Province> findAllByCategoryOrderByReleasedateDesc(String category);

    List<Province> findAllByReleasedateBetweenOrderByReleasedateDesc(String start, String end);

    List<Province> findAllByCategoryInOrderByReleasedateDesc(List<String> categories);
}
