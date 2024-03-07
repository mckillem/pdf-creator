package com.example.pdfcreator;

import com.example.pdfcreator.DTO.Csfd;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/csfd")
@AllArgsConstructor
public class CsfdController {
	private final CsfdService csfdService;

//	@PostMapping(path="/...", produces = {MediaType.APPLICATION_PDF_VALUE})
	@PostMapping(produces = {MediaType.APPLICATION_PDF_VALUE})
//	public ResponseEntity<byte[]> dataFromApi(@RequestBody Csfd csfd) {
	public Document dataFromApi(@RequestBody Csfd csfd) {
		return csfdService.createPdf(csfd);
	}


	@RequestMapping(value="/getpdf", method= RequestMethod.POST)
	public ResponseEntity<byte[]> getPDF(@RequestBody Csfd json) {
		// convert JSON to Employee
		Employee emp = convertSomehow(json);

		// generate the file
		showHelp(emp);

		// retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
		byte[] contents = (...);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		// Here you have to set the actual filename of your pdf
		String filename = "output.pdf";
		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
		return response;
	}

	public static Document showHelp(Employee emp) throws Exception {
		Document document = new Document();

		PdfWriter.getInstance(document, new FileOutputStream("C:/tmp/report.pdf"));
		document.open();
		document.add(new Paragraph("table"));
		document.add(new Paragraph(new Date().toString()));
		PdfPTable table=new PdfPTable(2);

		PdfPCell cell = new PdfPCell (new Paragraph ("table"));

		cell.setColspan (2);
		cell.setHorizontalAlignment (Element.ALIGN_CENTER);
		cell.setPadding (10.0f);
		cell.setBackgroundColor (new BaseColor (140, 221, 8));

		table.addCell(cell);
		ArrayList<String[]> row=new ArrayList<String[]>();
		String[] data=new String[2];
		data[0]="1";
		data[1]="2";
		String[] data1=new String[2];
		data1[0]="3";
		data1[1]="4";
		row.add(data);
		row.add(data1);

		for(int i=0;i<row.size();i++) {
			String[] cols=row.get(i);
			for(int j=0;j<cols.length;j++){
				table.addCell(cols[j]);
			}
		}

		document.add(table);
		document.close();

		return document;
	}
}
