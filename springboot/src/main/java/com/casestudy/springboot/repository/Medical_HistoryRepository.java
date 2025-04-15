package com.casestudy.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.springboot.model.Medical_History;

public  interface Medical_HistoryRepository  extends JpaRepository<	Medical_History, Integer> {

}
