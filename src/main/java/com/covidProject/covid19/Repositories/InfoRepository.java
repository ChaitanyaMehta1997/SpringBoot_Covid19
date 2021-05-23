package com.covidProject.covid19.Repositories;

import com.covidProject.covid19.entity.Information;
import org.springframework.data.repository.CrudRepository;

public interface InfoRepository extends CrudRepository<Information,Integer> {

}
