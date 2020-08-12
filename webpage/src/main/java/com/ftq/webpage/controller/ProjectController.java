package com.ftq.webpage.controller;

import com.ftq.webpage.pojo.Project;
import com.ftq.webpage.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @CrossOrigin
    @GetMapping(value = "/api/index")
    public List<Project> projects() throws Exception{
        return projectService.getAll();
    }

    @CrossOrigin
    @GetMapping(value = "/api/categories/{cid}/projects")
    public List<Project> projects(@PathVariable("cid") int cid) throws Exception{
        Map<Integer, String> categoryMap= new HashMap<Integer, String>(){{
            put(0, "全部");
            put(1, "教育");
            put(2, "公安");
            put(3, "法院");
        }};
        if (0 == cid)   return projectService.getAll();
        else return projectService.getAllByCategory(categoryMap.get(cid));
    }

    @CrossOrigin
    @PostMapping(value = "/api/searchByDate")
    public List<Project> searchByDate(@RequestBody Map<String, String> dateRange) {
        return projectService.getAllByDate(dateRange.get("start"), dateRange.get("end"));
    }

}
