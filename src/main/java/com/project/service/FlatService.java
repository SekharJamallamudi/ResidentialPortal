package com.project.service;

import java.util.List;

import com.project.entity.Flat;

public interface FlatService {
     
	 public List<Flat> getAllFlats();
	 
	 public Flat getFlatById(Long id);

	public Flat addFlat(Flat flat);

	public Flat updateFlat(Flat updatedFlat);

	public void deleteFlat(Long id);

	public void updateDateColumn(Long id, String newDate);
}
