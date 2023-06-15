package com.Windir.Pety.service;

import java.util.List;

import com.Windir.Pety.model.DogDTO;

public interface DogService {

	public List<DogDTO> getAllDogs();

	public DogDTO getDogById(Long id);

	public DogDTO createDog(DogDTO dog);

	public DogDTO updateDog(Long id, DogDTO dog);

	public DogDTO patchDog(Long id, DogDTO dog);

	public void deleteDog(Long id);
}
