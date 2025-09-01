package com.example.novalearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.novalearn.entity.SiteOwner;

public interface SiteOwnerDao extends JpaRepository<SiteOwner, Long> {

}
