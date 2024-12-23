package com.my_projects.Tea_Manager.api;

import com.my_projects.Tea_Manager.Exception.ResourceNotFoundException;
import com.my_projects.Tea_Manager.dto.TeaPickingRecordDTO;
import com.my_projects.Tea_Manager.service.TeaPickingRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teaPicking")
public class TeaPickingRecordAPI {

    TeaPickingRecordService teaPickingRecordService;
    public TeaPickingRecordAPI(TeaPickingRecordService teaPickingRecordService){
        this.teaPickingRecordService = teaPickingRecordService;
    }

    @PostMapping
    public ResponseEntity saveTeaPickingRecord(@RequestBody TeaPickingRecordDTO teaPickingRecordDTO){
        TeaPickingRecordDTO save = teaPickingRecordService.save(teaPickingRecordDTO);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTeaPickingRecord(@PathVariable("id") Long id){
        try {
            TeaPickingRecordDTO teaPickingRecordDTO = teaPickingRecordService.get(id);
            return ResponseEntity.ok(teaPickingRecordDTO);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    @PatchMapping
    public ResponseEntity updateTeaPickingRecord(@RequestBody TeaPickingRecordDTO teaPickingRecordDTO){
        TeaPickingRecordDTO save = teaPickingRecordService.update(teaPickingRecordDTO);
        if(save != null){
            return ResponseEntity.ok(save);
        }
        return ResponseEntity.status(404).build();
    }

}
