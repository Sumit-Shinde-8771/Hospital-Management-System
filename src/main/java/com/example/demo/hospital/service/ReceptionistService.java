package com.example.demo.hospital.service;
//
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.hospital.entity.Receptionist;
//import com.example.demo.hospital.repository.ReceptionistRepository;
//
//@Service
//public class ReceptionistService {
//
//    @Autowired
//    private ReceptionistRepository receptionistRepository;
//
//    public List<Receptionist> getAllReceptionists() {
//        return receptionistRepository.findAll();
//    }
//
//    public Optional<Receptionist> getReceptionistById(Long id) {
//        return Optional.ofNullable(receptionistRepository.findById(id).orElse(null));
//
//    }
//
//    public Receptionist createReceptionist(Receptionist receptionist) {
//        return receptionistRepository.save(receptionist);
//    }
//
//    public void updateReceptionist(Long id, Receptionist receptionistDetails) {
//        Receptionist receptionist = getReceptionistById(id).orElseThrow(() -> new RuntimeException("Receptionist not found"));
//        receptionist.setName(receptionistDetails.getName());
//        receptionist.setEmail(receptionistDetails.getEmail());
//        receptionist.setPhone(receptionistDetails.getPhone());
//        receptionistRepository.save(receptionist);
//    }
//
//    public void deleteReceptionist(Long id) {
//        receptionistRepository.deleteById(id);
//    }
//
//    public void saveReceptionist(Receptionist receptionist) {
//        receptionistRepository.save(receptionist);
//
//}
//}
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.hospital.entity.Receptionist;
//import com.example.demo.hospital.repository.ReceptionistRepository;
//
//@Service
//public class ReceptionistService {
//    @Autowired
//    private ReceptionistRepository receptionistRepository;
//
//    public List<Receptionist> getAllReceptionists() {
//        return receptionistRepository.findAll();
//    }
//
//    public Receptionist getReceptionistById(Long id) {
//        return receptionistRepository.findById(id).orElse(null);
//    }
//
//    public void saveReceptionist(Receptionist receptionist) {
//        receptionistRepository.save(receptionist);
//    }
//
//    public void deleteReceptionist(Long id) {
//        receptionistRepository.deleteById(id);
//    }
//}
//

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hospital.entity.Receptionist;
import com.example.demo.hospital.repository.ReceptionistRepository;

@Service
public class ReceptionistService {

    @Autowired
    private ReceptionistRepository receptionistRepository;
    
  public List<Receptionist> getAllReceptionists() {
  return receptionistRepository.findAll();
}

public Optional<Receptionist> getReceptionistById(Long id) {
  return Optional.ofNullable(receptionistRepository.findById(id).orElse(null));

}

public Receptionist createReceptionist(Receptionist receptionist) {
  return receptionistRepository.save(receptionist);
}

public void updateReceptionist(Long id, Receptionist receptionistDetails) {
  Receptionist receptionist = getReceptionistById(id).orElseThrow(() -> new RuntimeException("Receptionist not found"));
  receptionist.setName(receptionistDetails.getName());
  receptionist.setEmail(receptionistDetails.getEmail());
  receptionist.setPhone(receptionistDetails.getPhone());
  receptionistRepository.save(receptionist);
}

public void deleteReceptionist(Long id) {
  receptionistRepository.deleteById(id);
}
public void saveReceptionist(Receptionist receptionist) {
receptionistRepository.save(receptionist);

}


    public List<Receptionist> findAll() {
        return receptionistRepository.findAll();
    }

    public Receptionist save(Receptionist receptionist) {
        return receptionistRepository.save(receptionist);
    }

    public Receptionist findById(Long id) {
        return receptionistRepository.findById(id).orElse(null);
    }
}

