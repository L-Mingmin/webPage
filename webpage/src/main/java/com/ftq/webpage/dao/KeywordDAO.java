package com.ftq.webpage.dao;

import com.ftq.webpage.pojo.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordDAO extends JpaRepository<Keyword, Integer> {

    public Keyword getById(int id);
    public Keyword getByKeyword(String keyword);

}
