package com.my_projects.Tea_Manager.api;

import com.my_projects.Tea_Manager.common.ApiResponse;
import com.my_projects.Tea_Manager.common.exception.ResourceNotFoundException;
import com.my_projects.Tea_Manager.dto.TeaPickingRecordInputDTO;
import com.my_projects.Tea_Manager.service.TeaPickingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teaPickingRecord")
public class TeaPickingRecordAPI {
    TeaPickingService teaPickingService;
    public TeaPickingRecordAPI(TeaPickingService teaPickingService){this.teaPickingService = teaPickingService;}

    @PostMapping
    public ResponseEntity saveTeaPickingRecord(@RequestBody TeaPickingRecordInputDTO dto){
        try{
            Boolean save = teaPickingService.SaveTeaPickingRecord(dto);
            ApiResponse<Boolean> response = new ApiResponse<>(
                    HttpStatus.CREATED.toString(),
                    "Tea Picking Record Saved Successfully",
                    save
            );
            return ResponseEntity.ok(response);
        }
        catch (ResourceNotFoundException ex){
            ApiResponse<Object> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.toString(),
                    ex.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        catch (Exception ex) {
            ApiResponse<Object> response = new ApiResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "An Unexpected error occurred.",
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
