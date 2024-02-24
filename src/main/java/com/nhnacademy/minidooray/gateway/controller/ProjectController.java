package com.nhnacademy.minidooray.gateway.controller;

import com.nhnacademy.minidooray.gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.minidooray.gateway.domain.Member;
import com.nhnacademy.minidooray.gateway.domain.Project;
import com.nhnacademy.minidooray.gateway.domain.Task;
import com.nhnacademy.minidooray.gateway.request.TaskRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProjectController {
    private final ProjectAdaptor projectAdaptor;

    @GetMapping("/task")
    public String main(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        List<Project> projects = projectAdaptor.getProjects(member.getMemberId());

        model.addAttribute("projects", projects);
        return "task/task_menu";
    }

    @GetMapping("/task/{projectId}")
    public String viewProject(@PathVariable Integer projectId, Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        List<Project> projects = projectAdaptor.getProjects(member.getMemberId());
        List<Task> tasks = projectAdaptor.getProject(member.getMemberId(), projectId);

        model.addAttribute("projects", projects);
        model.addAttribute("tasks", tasks);
        return "task/task_list";
    }

    @GetMapping("/task/list")
    public String list(Integer projectId, Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        List<Project> projects = projectAdaptor.getProjects(member.getMemberId());
        List<Task> tasks = projectAdaptor.getProject(member.getMemberId(), projectId);

        model.addAttribute("projects", projects);
        model.addAttribute("tasks", tasks);
        return "task/task_list";
    }

    @GetMapping("/task/{projectId}/{taskId}")
    public String viewTask(@PathVariable Integer projectId, @PathVariable Integer taskId, Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        List<Project> projects = projectAdaptor.getProjects(member.getMemberId());
        List<Task> tasks = projectAdaptor.getProject(member.getMemberId(), projectId);

        model.addAttribute("projects", projects);
        model.addAttribute("projects", projects);
        model.addAttribute("tasks", tasks);
        return "task/task_info";
    }

    @GetMapping("/task/write")
    public String writeProjectForm(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        List<Project> projects = projectAdaptor.getProjects(member.getMemberId());

        model.addAttribute("member", member);
        model.addAttribute("projects", projects);
        model.addAttribute("taskRequest", new TaskRequest());
        return "task/task_write_form";
    }

    @PostMapping("/task/write")
    public String writeProject(TaskRequest taskRequest) {
        log.debug(taskRequest.getTitle());
        return "redirect:/task";
    }
}
