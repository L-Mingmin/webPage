package com.ftq.webpage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subscription")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int uid;
    private int kid;

}
