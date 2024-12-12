package com.example.exercisejparelationil.Service;

import com.example.exercisejparelationil.ApiResponse.ApiException;
import com.example.exercisejparelationil.DTO.AddressDTO;
import com.example.exercisejparelationil.Model.Address;
import com.example.exercisejparelationil.Model.Teacher;
import com.example.exercisejparelationil.Repository.AddressRepository;
import com.example.exercisejparelationil.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public void addAddress(AddressDTO addressDTO) {

        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (teacher == null) throw new ApiException("Error: teacher not found");

        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);

        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO) {

        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (teacher == null) throw new ApiException("Error: teacher not found");

        Address address = new Address();

        address.setId(addressDTO.getTeacher_id());
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setTeacher(teacher);


        addressRepository.save(address);
    }

    public void deleteAddress(Integer id) {
        Address address = addressRepository.findAddressById(id);
        if (address == null) throw new ApiException("Error: address not found");
        addressRepository.deleteById(id);
    }

}