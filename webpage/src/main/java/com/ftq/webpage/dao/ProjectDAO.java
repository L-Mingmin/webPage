package com.ftq.webpage.dao;

import com.ftq.webpage.pojo.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectDAO extends JpaRepository<Project, Integer> {

    List<Project> findAllByCategory(String category);

    List<Project> findAllByReleasedateBetween(String start, String end);

}
