package com.covidProject.covid19.Repositories;

import com.covidProject.covid19.entity.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State,Integer> {

}
