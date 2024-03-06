package com.example.pdfcreator;

import com.example.pdfcreator.DTO.Csfd;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/csfd")
@AllArgsConstructor
public class CsfdController {
	private final CsfdService csfdService;

//	@PostMapping(path="/...", produces = {MediaType.APPLICATION_PDF_VALUE})
	@PostMapping(produces = {MediaType.APPLICATION_PDF_VALUE})
	public String dataFromApi(@RequestBody Csfd csfd) {
//		return csfdService.createPdf(csfd);
		return "anoddddddd";
	}
}
