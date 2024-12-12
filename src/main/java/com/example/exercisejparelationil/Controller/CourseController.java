package com.example.exercisejparelationil.Controller;

import com.example.exercisejparelationil.ApiResponse.ApiResponse;
import com.example.exercisejparelationil.DTO.CourseDTO;
import com.example.exercisejparelationil.Model.Course;
import com.example.exercisejparelationil.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCourse(@RequestBody @Valid CourseDTO courseDTO) {
        courseService.addCourse(courseDTO);
        return ResponseEntity.status(201).body(new ApiResponse("Course added successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateCourse(@RequestBody @Valid CourseDTO courseDTO) {
        courseService.updateCourse(courseDTO);
        return ResponseEntity.ok(new ApiResponse("Course updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok(new ApiResponse("Course deleted successfully"));
    }
}