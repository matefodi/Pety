package com.Windir.Pety.service;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import com.Windir.Pety.exception.NotFoundException;
import com.Windir.Pety.mapper.DogMapper;
import com.Windir.Pety.model.Dog;
import com.Windir.Pety.model.DogDTO;
import com.Windir.Pety.repository.DogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;
/**
 * Service Implementation class for the Entity {@link Dog}
 */

@Service
public class DogServiceImpl implements DogService {

	private final DogRepository dogRepository;
	private DogMapper dogMapper;

	public DogServiceImpl(DogRepository dogRepository, final DogMapper dogMapper) {
		this.dogRepository = dogRepository;
		this.dogMapper = dogMapper;
	}

	@Override
	public List<DogDTO> getAllDogs() {
		final List<Dog> allDogs = dogRepository.findAll();
		return dogMapper.mapEntitiesToDTOs(allDogs);
	}

	@Override
	public DogDTO getDogById(final Long id) {

		Dog dog = dogRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(id, Dog.class));
		return dogMapper.mapEntityToDto(dog);
	}

	@Override
	public DogDTO createDog(final DogDTO dogDTO) {
		Dog dogToBeSaved = dogMapper.mapDtoToEntity(dogDTO);
		Dog savedDog = dogRepository.save(dogToBeSaved);
		return dogMapper.mapEntityToDto(savedDog);
	}

	@Override
	public DogDTO updateDog(final Long id, final DogDTO dogDTO) {
		Dog existingDog = dogRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(id, Dog.class));

		existingDog.setName(dogDTO.getName());
		existingDog.setAge(dogDTO.getAge());
		existingDog.setBreed(dogDTO.getBreed());

		Dog updatedDog = dogRepository.save(existingDog);
		return dogMapper.mapEntityToDto(updatedDog);
	}

	@Override
	public DogDTO patchDog(final Long id, final DogDTO dogDTO) {
		Dog existingDog = dogRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(id, Dog.class));

		BeanUtils.copyProperties(dogDTO, existingDog, getNullPropertyNames(dogDTO));

		Dog updatedDog = dogRepository.save(existingDog);

		return dogMapper.mapEntityToDto(updatedDog);
	}

	@Override
	public void deleteDog(final Long id) {
		if (!dogRepository.existsById(id)) {
			throw new NotFoundException(id, Dog.class);
		}
		dogRepository.deleteById(id);
	}

	private String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		PropertyDescriptor[] descriptors = src.getPropertyDescriptors();
		List<String> nullProperties = new ArrayList<>();

		for (PropertyDescriptor descriptor : descriptors) {
			String propertyName = descriptor.getName();
			if (src.getPropertyValue(propertyName) == null) {
				nullProperties.add(propertyName);
			}
		}

		return nullProperties.toArray(new String[0]);
	}
}
