package com.ftq.webpage.controller;

import com.ftq.webpage.pojo.City;
import com.ftq.webpage.pojo.Province;
import com.ftq.webpage.pojo.User;
import com.ftq.webpage.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProjectController {

    @Autowired
    private UserService userService;
    @Autowired
    private CityService cityService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private KeywordService keywordService;
    @Autowired
    private SubscriptionService subscriptionService;


    @GetMapping(value = "/api/province/categories/{cid}/projects")
    @ResponseBody
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

    @PostMapping(value = "/api/province/searchByDate")
    @ResponseBody
    public List<Province> searchProvinceProjectsByDate(@RequestBody Map<String, String> dateRange) {
        return provinceService.getAllByDate(dateRange.get("start"), dateRange.get("end"));
    }

    @GetMapping(value = "/api/city/categories/{cid}/projects")
    @ResponseBody
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

    @PostMapping(value = "/api/city/searchByDate")
    @ResponseBody
    public List<City> searchCityProjectsByDate(@RequestBody Map<String, String> dateRange) {
        return cityService.getAllByDate(dateRange.get("start"), dateRange.get("end"));
    }

    @GetMapping(value = "/api/city/projects")
    @ResponseBody
    public List<City> getCityProjects() {
        Subject subject = SecurityUtils.getSubject();
        User user = userService.getUserByName(subject.getPrincipal().toString());
        List<Integer> kidList = subscriptionService.getCategoryId(user.getId());
        List<String> categories = keywordService.getCategories(kidList);
        return cityService.getAllByCategories(categories);
    }

    @GetMapping(value = "/api/province/projects")
    @ResponseBody
    public List<Province> getProvinceProjects() {
        Subject subject = SecurityUtils.getSubject();
        User user = userService.getUserByName(subject.getPrincipal().toString());
        List<Integer> kidList = subscriptionService.getCategoryId(user.getId());
        List<String> categories = keywordService.getCategories(kidList);
        return provinceService.getAllByCategories(categories);
    }

}
