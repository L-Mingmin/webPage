package com.ftq.webpage.dao;

import com.ftq.webpage.entity.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SubscriptionDAO extends JpaRepository<SubscriptionEntity, Integer> {

    @Modifying
    @Transactional
    public void deleteByUid(int uid);

    public List<SubscriptionEntity> getAllByUid(int uid);

}
