package com.yasser.SpringDemo.controller;


import com.yasser.SpringDemo.dao.UsersDao;
import com.yasser.SpringDemo.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersDao usersDao;
	
	@GetMapping("/allUsers")
	public List<Users> getUsers(){
		return (List<Users>)usersDao.findAll();
	}

    @GetMapping("/{id}")
    public Optional<Users> getUser(@PathVariable(value = "id") int id){
        Optional<Users> user = usersDao.findById(id);
        return user;
    }
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody List<Users> users) {
		usersDao.saveAll(users);
		return users.size() + " User(s) Saved";
	}

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {
        usersDao.deleteById(id);
        return "User Deleted";
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody Users user) {
            Optional<Users> user1 = usersDao.findById(user.getId());
        if(user1.isPresent()){
            usersDao.save(user);
            return "User Updated";
        }
        else{
            return "User not found";
        }

    }
}
