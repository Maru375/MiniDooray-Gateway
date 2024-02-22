package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.domain.Project;
import com.nhnacademy.minidooray.gateway.domain.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WelcomeController {
    @GetMapping(value = {"/main", "/"})
    public String welcome(Model model) {
        Project project1 = new Project();
        Project project2 = new Project();
        Project project3 = new Project();
        project1.setProjectName("project1");
        project2.setProjectName("project2");
        project3.setProjectName("project3");
        List<Project> projects = List.of(project1, project2, project3);
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();
        task1.setTaskName("name1");
        task2.setTaskName("name2");
        task3.setTaskName("name3");
        task1.setTaskContent("11111");
        task2.setTaskContent("22222");
        task3.setTaskContent("33333");
        task1.setTaskId(1);
        task2.setTaskId(2);
        task3.setTaskId(3);
        List<Task> tasks = List.of(task1, task2, task3);

        model.addAttribute("projects", projects);
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", task1);
        return "main";
    }
}
