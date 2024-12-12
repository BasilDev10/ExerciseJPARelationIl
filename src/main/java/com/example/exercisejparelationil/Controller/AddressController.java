package com.example.exercisejparelationil.Controller;

import com.example.exercisejparelationil.ApiResponse.ApiResponse;
import com.example.exercisejparelationil.DTO.AddressDTO;
import com.example.exercisejparelationil.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addAddress(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(201).body(new ApiResponse("Address added successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateAddress(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return ResponseEntity.ok(new ApiResponse("Address updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok(new ApiResponse("Address deleted successfully"));
    }
}