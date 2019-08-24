package com.johnny.simulationexperimentservice.controller;

import com.johnny.simulationexperimentservice.dto.UserDTO;
import com.johnny.simulationexperimentservice.service.impl.UserServiceImpl;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserServiceImpl myService;

    @RequestMapping(value = "/{pageNumber}/{pageSize}/{userRole}", method = RequestMethod.GET)
    public UnifiedResponse findList(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize, @PathVariable("userRole") String userRole){
        return myService.findList(pageNumber, pageSize, userRole);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UnifiedResponse find(@PathVariable("id") int id){
        return myService.find(id);
    }

    @RequestMapping(value = "/login/{cellphone}/{password}", method = RequestMethod.GET)
    public UnifiedResponse login(@PathVariable("cellphone") String cellphone, @PathVariable("password") String password){
        return myService.login(cellphone, password);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody UserDTO dto){
        return myService.add(dto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody UserDTO dto){
        return myService.change(dto);
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.PUT)
    public UnifiedResponse changePassword(@RequestBody UserDTO dto){
        return myService.changePassword(dto);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return myService.delete(id);
    }

}
