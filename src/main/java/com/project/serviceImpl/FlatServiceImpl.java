package com.project.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Flat;
import com.project.repository.FlatRepository;
import com.project.service.FlatService;
@Service
public class FlatServiceImpl implements FlatService{

	@Autowired
    private FlatRepository flatRepository;

    public List<Flat> getAllFlats() {
        return flatRepository.findAll();
    }

    public Flat getFlatById(Long id) {
        return flatRepository.findById(id).orElse(null);
    }

	@Override
	public Flat addFlat(Flat flat) {
		// TODO Auto-generated method stub
		return flatRepository.save(flat) ;
	}

	@Override
	public Flat updateFlat(Flat updatedFlat) {
		// TODO Auto-generated method stub
	Optional<Flat> flaat= flatRepository.findById(updatedFlat.getId());
	          
          	return updatedFlat;
	}

	@Override
	public void deleteFlat(Long id) {
		// TODO Auto-generated method stub
		flatRepository.deleteById(id);
	
	}

	public void updateDateColumn(Long id, String newDate) {
        Optional<Flat> optionalEntity = flatRepository.findById(id);
        optionalEntity.ifPresent(entity -> {
            entity.setCreateDate(newDate);
            flatRepository.save(entity);
        });
	}

	
}
