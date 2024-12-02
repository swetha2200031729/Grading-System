package com.jfsd.sdp.grade_management_system.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfsd.sdp.grade_management_system.DTO.CreateCourseDTO;
import com.jfsd.sdp.grade_management_system.dao.UserRepository;
import com.jfsd.sdp.grade_management_system.entity.CourseEntity;
import com.jfsd.sdp.grade_management_system.entity.UserEntity;
import com.jfsd.sdp.grade_management_system.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/list")
    public String getAllCourses(Model model) {
    // here get the currently logged in user and fetch user by username
    	// then find enrolled courses and display them 
    	String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserEntity user = userRepository.findByUsername(username);
		 if (user == null) {
	            throw new RuntimeException("User not found: " + username);
	        }
		 
        model.addAttribute("courses", user.getEnrolledCourses());
        return "course-list";
    }

    
    @GetMapping("/showCreateCourseForm")
    public String showCreateCourseForm(Model model) {
        model.addAttribute("course", new CreateCourseDTO());
        return "add-course"; 
    }

   
    @PostMapping
    public String createCourse(@ModelAttribute CreateCourseDTO course  ) throws IOException {
        courseService.createCourse(course.toEntity());
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

    @GetMapping("/image/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
       CourseEntity entity = courseService.findById(id);
        byte[] imageData = entity.getCourseImage();

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // Set correct MIME type
                .body(imageData);
    }
    
    // Handle deleting a course
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable long id) {
        courseService.deleteById(id);
        return "redirect:/courses/list"; // Redirect to list of courses after deletion
    }
    
    
}
