package com.Windir.Pety.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.Windir.Pety.model.Dog;
import com.Windir.Pety.model.DogDTO;
import org.springframework.stereotype.Component;
/**
 * Mapper class for the Entity {@link Dog}
 */
@Component
public class DogMapper {

	public Dog mapDtoToEntity(DogDTO dogDTO) {
		return Dog.builder()
				.name(dogDTO.getName())
				.age(dogDTO.getAge())
				.breed(dogDTO.getBreed())
				.build();
	}

	public DogDTO mapEntityToDto(Dog dog) {
		return DogDTO.builder()
				.id(dog.getId())
				.name(dog.getName())
				.age(dog.getAge())
				.breed(dog.getBreed())
				.build();
	}

	public List<DogDTO> mapEntitiesToDTOs(List<Dog> dogs) {
		return dogs.stream()
				.map(this::mapEntityToDto)
				.collect(Collectors.toList());
	}
}