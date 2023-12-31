package com.Windir.Pety.controller;

import java.util.List;

import com.Windir.Pety.model.DogDTO;
import com.Windir.Pety.service.DogService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for the Entity: {@link com.Windir.Pety.model.Dog}
 */
@RestController
@RequestMapping("/dog")
public class DogController {

	private DogService dogService;

	public DogController(final DogService dogService) {
		this.dogService = dogService;
	}

	@GetMapping
	@Operation(summary = "Retrieves all Dogs")
	public List<DogDTO> getAllDogs() {
		return dogService.getAllDogs();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Retrieves a Dog by id")
	public DogDTO getDogById(@PathVariable Long id) {
		return dogService.getDogById(id);
	}

	@PostMapping
	@Operation(summary = "Create a Dog")
	public DogDTO createDog(@RequestBody DogDTO dogDTO) {
		return dogService.createDog(dogDTO);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update a Dog (requires all fields)")
	public DogDTO updateDog(@PathVariable Long id, @RequestBody DogDTO dogDTO) {
		return dogService.updateDog(id, dogDTO);
	}

	@PatchMapping("/{id}")
	@Operation(summary = "Patch a Dog (Doesn't require all fields)")
	public DogDTO patchDog(@PathVariable Long id, @RequestBody DogDTO dogDTO) {
		return dogService.patchDog(id, dogDTO);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a dog by id")
	public void deleteDog(@PathVariable Long id) {
		dogService.deleteDog(id);
	}
}
