package com.ftq.webpage.service;

import com.ftq.webpage.dao.ProjectDAO;
import com.ftq.webpage.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectDAO projectDAO;

    public List<Project> getAllByCategory(String category) {
        return projectDAO.findAllByCategory(category);
    }

    public List<Project> getAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return projectDAO.findAll(sort);
    }

    public List<Project> getAllByDate(String start, String end) {
        return projectDAO.findAllByReleasedateBetween(start, end);
    }

}
