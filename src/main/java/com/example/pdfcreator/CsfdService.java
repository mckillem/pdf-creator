package com.example.pdfcreator;

import com.example.pdfcreator.DTO.Csfd;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CsfdService {

	public Object createPdf(Csfd data) {
		return data;
	}
}
