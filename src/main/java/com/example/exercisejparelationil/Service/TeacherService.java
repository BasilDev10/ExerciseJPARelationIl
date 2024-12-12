package com.example.exercisejparelationil.Service;

import com.example.exercisejparelationil.ApiResponse.ApiException;
import com.example.exercisejparelationil.Model.Address;
import com.example.exercisejparelationil.Model.Teacher;
import com.example.exercisejparelationil.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final AddressService addressService;


    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Integer id){
        return teacherRepository.findTeacherById(id);
    }

    public void addTeacher(Teacher teacher){

        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id,Teacher teacher){
        if (teacherRepository.findTeacherById(id) == null ) throw new ApiException("Error: teacher not found");
        teacher.setId(id);
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null ) throw new ApiException("Error: teacher not found");
        Address address = teacher.getAddress();
        if (address != null){
            teacher.setAddress(null);
            teacherRepository.deleteById(id);
            addressService.deleteAddress(address.getId());
        } else teacherRepository.deleteById(id);



    }


}
