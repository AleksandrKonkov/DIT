package com.example.docboxservice.controller;

import com.example.docboxservice.entities.Box;
import com.example.docboxservice.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class BoxController {

    private final BoxService boxService;

    @Autowired
    public BoxController(BoxService boxService) {
        this.boxService = boxService;
    }

    @GetMapping("/getAllBoxes")
    public ResponseEntity<List<Box>> getAllBoxes(){
        return ResponseEntity.ok(boxService.getAll());
    }

    @GetMapping("/getBoxById/{id}")
    public ResponseEntity<Box> getBoxById(@PathVariable Long id){
        Box box1 = boxService.getById(id);
        Box box2 = new Box();
        box2.setBarcode(box1.getBarcode());
        box2.setName(box1.getName());
        box2.setBox_id(box1.getBox_id());
        box2.setDocuments(box1.getDocuments());
        return ResponseEntity.ok(box2);
    }

    @PostMapping("/createBox")
    public ResponseEntity<Box> createBox(@RequestBody Box box){
        return ResponseEntity.ok(boxService.create(box));
    }

    @PutMapping("/updateBoxById")
    public ResponseEntity<Box> updateBox(@RequestBody Box box){
        return ResponseEntity.ok(boxService.update(box));
    }

    @DeleteMapping("/deleteBoxById/{id}")
    public void deleteBox(@PathVariable Long id){
        boxService.delete(id);
    }

}

