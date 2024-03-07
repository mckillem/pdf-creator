package com.example.pdfcreator;

import com.example.pdfcreator.DTO.Csfd;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
@AllArgsConstructor
public class CsfdService {

//	public ResponseEntity<byte[]> createPdf(Csfd data) {
//	public ResponseEntity<byte[]> createPdf(Csfd data) {
	public Document createPdf(Csfd data) {
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		// step 1: creation of a document-object
//		Document document = new Document();
//		// step 2:
//		// we create 3 different writers that listen to the document
//		PdfWriter pdf = PdfWriter.getInstance(document, baos);
//
//		// step 3: we open the document
//		document.open();
//		// step 4: we add a paragraph to the document
//		document.add(new Paragraph("Hello World"));
//		// we make references
//		Anchor pdfRef = new Anchor("see Hello World in PDF.");
//		pdfRef.setReference("./HelloWorldPdf.pdf");
//		Anchor rtfRef = new Anchor("see Hello World in RTF.");
//		rtfRef.setReference("./HelloWorldRtf.rtf");
//
//		// we add the references, but only to the HTML page:
//
//		pdf.pause();
//		document.add(pdfRef);
//		document.add(Chunk.NEWLINE);
//		document.add(rtfRef);
//		pdf.resume();
//
//		// step 5: we close the document
//		document.close();

		// step 1: creation of a document-object
		Document document = new Document();
		try {
			// step 2:
			// we create a writer that listens to the document
			// and directs a PDF-stream to a file
			PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));

			// step 3: we open the document
			document.open();
			// step 4: we add a paragraph to the document
			document.add(new Paragraph("Hello World"));
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		// step 5: we close the document
		document.close();
		return document;
	}
}
