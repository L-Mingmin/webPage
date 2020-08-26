package com.ftq.webpage.service;

import com.ftq.webpage.dao.SubscriptionDAO;
import com.ftq.webpage.entity.SubscriptionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionDAO subscriptionDAO;

    public void deleteAllByUid(int uid) {
        subscriptionDAO.deleteByUid(uid);
    }

    public void add(SubscriptionEntity subscriptionEntity) {
        subscriptionDAO.save(subscriptionEntity);
    }

    public List<Integer> getCategoryId(int uid) {
        List<Integer> categoryIds = new LinkedList<>();
        for (SubscriptionEntity entity : subscriptionDAO.getAllByUid(uid)) {
            categoryIds.add(entity.getKid());
        }
        return categoryIds;
    }

}
