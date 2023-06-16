package com.Windir.Pety.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for Entity {@link Dog}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DogDTO {
	private Long id;
	private String name;
	private byte age;
	private String breed;
}