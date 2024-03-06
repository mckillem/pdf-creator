package com.example.pdfcreator.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Csfd {
	private String fileName;
	private String description;
	private String[] actors;
	private int year;
	private String director;
}
