package com.thachtaro.repository;

import org.springframework.stereotype.Repository;

import com.thachtaro.model.View;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ViewRepository extends JpaRepository<View, String> {}

