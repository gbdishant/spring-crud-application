package com.springcrud.controller;

import com.springcrud.dto.Student;
import com.springcrud.user.UserEntity;
import com.springcrud.user.UserEntityRepository;
import com.springcrud.user.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class NavController {

    private final UserEntityService userEntityService;
    private final UserEntityRepository userEntityRepository;

    @GetMapping("/")
    public String home() {
        return "datatable";
    }

    @GetMapping("/edit-form/{id}")
    public String home(@PathVariable Integer id, Model model) {
        UserEntity optionalUserEntity = userEntityRepository.findById(id).get();
        model.addAttribute("user", optionalUserEntity);
        return "editForm";
    }


    @ResponseBody
    @PostMapping("/datatable")
    public DataTablesOutput<UserEntity> listPOST(@RequestBody DataTablesInput input) {
        return userEntityRepository.findAll(input);
    }


    @ResponseBody
    @PostMapping("/formData")
    public Object home1(@RequestBody Student object) {
        System.out.println("object: " + object);

        return object;
    }

    @ResponseBody
    @PostMapping("/editForm")
    public String home2(@ModelAttribute UserEntity object) {
        System.out.println("object: " + object);
        userEntityRepository.save(object);
        return object.getEmail();
    }
}
