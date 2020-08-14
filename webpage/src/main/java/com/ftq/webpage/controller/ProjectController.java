package com.ftq.webpage.controller;

import com.ftq.webpage.pojo.City;
import com.ftq.webpage.pojo.Province;
import com.ftq.webpage.service.CityService;
import com.ftq.webpage.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProjectController {

    @Autowired
    CityService cityService;
    @Autowired
    ProvinceService provinceService;

    @CrossOrigin
    @GetMapping(value = "/api/province")
    public List<Province> getProvinceProjects() throws Exception{
        return provinceService.getAll();
    }

    @CrossOrigin
    @GetMapping(value = "/api/province/categories/{cid}/projects")
    public List<Province> getProvinceProjects(@PathVariable("cid") int cid) throws Exception{
        Map<Integer, String> categoryMap= new HashMap<Integer, String>(){{
            put(0, "全部");
            put(1, "教育");
            put(2, "公安");
            put(3, "法院");
        }};
        if (0 == cid)   return provinceService.getAll();
        else return provinceService.getAllByCategory(categoryMap.get(cid));
    }

    @CrossOrigin
    @PostMapping(value = "/api/province/searchByDate")
    public List<Province> searchProvinceProjectsByDate(@RequestBody Map<String, String> dateRange) {
        return provinceService.getAllByDate(dateRange.get("start"), dateRange.get("end"));
    }

    @CrossOrigin
    @GetMapping(value = "/api/city")
    public List<City> getCityProjects() throws Exception{
        return cityService.getAll();
    }

    @CrossOrigin
    @GetMapping(value = "/api/city/categories/{cid}/projects")
    public List<City> getCityProjects(@PathVariable("cid") int cid) throws Exception{
        Map<Integer, String> categoryMap= new HashMap<Integer, String>(){{
            put(0, "全部");
            put(1, "教育");
            put(2, "公安");
            put(3, "法院");
        }};
        if (0 == cid)   return cityService.getAll();
        else return cityService.getAllByCategory(categoryMap.get(cid));
    }

    @CrossOrigin
    @PostMapping(value = "/api/city/searchByDate")
    public List<City> searchCityProjectsByDate(@RequestBody Map<String, String> dateRange) {
        return cityService.getAllByDate(dateRange.get("start"), dateRange.get("end"));
    }

}
