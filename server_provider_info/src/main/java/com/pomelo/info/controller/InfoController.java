package com.pomelo.info.controller;

import com.pomelo.info.repository.InfoRepository;
import com.pomelo.info.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName InfoController
 * @Description
 * @Author Mr.Jangni
 * @Date 2018/12/8 20:57
 * @Version 1.0
 **/
@RestController
public class InfoController {

    @Autowired
    private InfoRepository infoRepository;

    @GetMapping("/info/{id}")
    public Info getInfo(@PathVariable("id")Integer id){
        return infoRepository.findOne(id);
    }

    @GetMapping("/save/{title}/{context}")
    public String saveInfo(@PathVariable("title")String title,@PathVariable("context")String context){
        Info info = new Info();
        info.setTitle(title);
        info.setContext(context);
        infoRepository.save(info);
        return "save success";
    }

}