package com.example.docboxservice.service;
import com.example.docboxservice.entities.Box;
import com.example.docboxservice.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoxService {

    private final BoxRepository boxRepository;

    @Autowired
    public BoxService(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    public Box create(Box box) {
        return boxRepository.save(box);
    }

    public Box getById(Long id) {
        return boxRepository.getById(id);
    }

    public Box delete(Long id) {
        Box box = boxRepository.getById(id);
        boxRepository.delete(box);

        return box;
    }

    public List<Box> getAll() {
        return boxRepository.findAll();
    }


    @Transactional
    public Box update(Box box) {
//        Box box1 = boxRepository.findById(box.getBox_id()).get();
        // закрепить Optional - почему возвращает null -???
        Optional<Box> b = boxRepository.findById( box.getBox_id() );
        Box box1 = null;
        if (!b.isPresent()) {return new Box();}
      box1 = b.get();
            box1.setName( box.getName() );
            box1.setBarcode( box.getBarcode() );
            return boxRepository.save( box1 );



    }

}
