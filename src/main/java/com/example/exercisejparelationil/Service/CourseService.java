package com.example.exercisejparelationil.Service;


import com.example.exercisejparelationil.ApiResponse.ApiException;
import com.example.exercisejparelationil.DTO.CourseDTO;
import com.example.exercisejparelationil.Model.Course;
import com.example.exercisejparelationil.Model.Teacher;
import com.example.exercisejparelationil.Repository.CourseRepository;
import com.example.exercisejparelationil.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Integer id) {
        return courseRepository.findCourseById(id);
    }
    public void addCourse(CourseDTO courseDTO) {
        Course course = new Course();
        if (courseDTO.getTeacher_id() != null) {
            Teacher teacher = teacherRepository.findTeacherById(courseDTO.getTeacher_id());
            if (teacher == null) throw new ApiException("Teacher Not Found");
            course.setTeacher(teacher);
        }
        course.setName(courseDTO.getName());
        courseRepository.save(course);
    }
    public void updateCourse(CourseDTO courseDTO) {
        Course course = courseRepository.findCourseById(courseDTO.getId());
        if (course == null) throw new ApiException("Course Not Found");
        if (courseDTO.getTeacher_id() != null) {
            Teacher teacher = teacherRepository.findTeacherById(courseDTO.getTeacher_id());
            if (teacher == null) throw new ApiException("Teacher Not Found");
            course.setTeacher(teacher);
        }
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        courseRepository.save(course);
    }
    public void deleteCourse(Integer id) {
        if (courseRepository.findCourseById(id) == null) throw new ApiException("Course Not Found");
        courseRepository.deleteById(id);
    }
}
