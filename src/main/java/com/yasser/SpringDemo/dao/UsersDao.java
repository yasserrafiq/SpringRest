package com.yasser.SpringDemo.dao;

import com.yasser.SpringDemo.dto.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersDao extends CrudRepository<Users, Integer>{

}
