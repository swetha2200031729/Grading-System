package com.jfsd.sdp.grade_management_system.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jfsd.sdp.grade_management_system.entity.CourseEntity;
import com.jfsd.sdp.grade_management_system.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
   
    
    @GetMapping("/list")
    public String getAllCourses(Model model) {
    	
        model.addAttribute("courses", courseService.findAll());
        return "course-list";
    }

    
    @GetMapping("/showCreateCourseForm")
    public String showCreateCourseForm(Model model) {
        model.addAttribute("course", new CourseEntity());
        return "add-course"; 
    }

   
    @PostMapping
    public String createCourse(@ModelAttribute("course") CourseEntity course) {
        courseService.createCourse(course.getCourseName());
        return "redirect:/courses/list"; 
    }

   
    @GetMapping("/edit/{courseName}")
    public String showUpdateCourseForm(@PathVariable String courseName, Model model) {
        CourseEntity course = courseService.findCourseByCourseName(courseName);
        if (course == null) {
            throw new RuntimeException("Course not found with name: " + courseName);
        }
        model.addAttribute("course", course);
        return "add-course"; 
    }

    
    
    // Handle deleting a course
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable long id) {
        courseService.deleteById(id);
        return "redirect:/courses/list"; // Redirect to list of courses after deletion
    }
}
