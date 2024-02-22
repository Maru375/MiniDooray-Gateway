package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.domain.Project;
import com.nhnacademy.minidooray.gateway.domain.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProjectController {
    @GetMapping("/task/main")
    public String welcome(Model model) {
        Project project1 = new Project();
        Project project2 = new Project();
        Project project3 = new Project();
        project1.setProjectName("project1");
        project2.setProjectName("project2");
        project3.setProjectName("project3");
        project1.setProjectId(1);
        project2.setProjectId(2);
        project3.setProjectId(3);
        List<Project> projects = List.of(project1, project2, project3);
//        Task task1 = new Task();
//        Task task2 = new Task();
//        Task task3 = new Task();
//        task1.setTaskName("name1");
//        task2.setTaskName("name2");
//        task3.setTaskName("name3");
//        task1.setTaskContent("11111");
//        task2.setTaskContent("22222");
//        task3.setTaskContent("33333");
//        task1.setTaskId(1);
//        task2.setTaskId(2);
//        task3.setTaskId(3);
//        List<Task> tasks = List.of(task1, task2, task3);

        model.addAttribute("projects", projects);
//        model.addAttribute("tasks", tasks);
//        model.addAttribute("task", task1);
        return "task/taskmain";
    }

    @GetMapping("/task/{projectId}")
    public String viewProject(@PathVariable Integer projectId, Model model) {
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
        model.addAttribute("tasks", tasks);
        return "task/tasklist";
    }

    @GetMapping("/task/list")
    public String list(Integer projectId, Model model) {
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
        model.addAttribute("tasks", tasks);
        return "task/taskmain";
    }

    @GetMapping("/task/{projectId}/{taskId}")
    public String viewTask(@PathVariable Integer projectId, Model model) {
        Task task1 = new Task();

        task1.setTaskName("name1");

        task1.setTaskContent("11111");

        task1.setTaskId(1);

        model.addAttribute("task", task1);
        return "task/taskinfo";
    }
}
