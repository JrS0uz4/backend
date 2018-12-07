import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class ValidacaoHumana {

	public ValidacaoHumana() {}

	public static void main(String[] args) {
		
		try {
			
			int j = 0;
			String doc =  "memorando.docx";			
			FileInputStream file = new FileInputStream(doc);
			
			XWPFDocument docx = new XWPFDocument(file);			
			List<XWPFParagraph> paragraphList = docx.getParagraphs();
			
			ArrayList<String>alParagrafos = new ArrayList<String>();
			
			for(int i = 3 ; i < paragraphList.size() ; i++) {
				
				XWPFParagraph paragraph = paragraphList.get(i);
				
				//System.out.println("amot");

				if(!paragraph.getText().isEmpty()) {
					
					alParagrafos.add(paragraph.getText())  ;
					System.out.println(alParagrafos.get(j));
					j++;
				}
				//System.out.println(vet[i]);
				
			}
			System.out.println("qtn parag \n" + j);
			
			  int y = (int) (Math.random() * alParagrafos.size());
			  String[] vet2 = new String[alParagrafos.size()];
			  
			  
			  vet2 =  alParagrafos.get(y).split(" ");
			  int x = (int) (Math.random() *  vet2.length);
			 
			  System.out.println(vet2[x]);
			  System.out.println("numero do y = "+ y);
			  System.out.println("numero do x = "+ x);
			    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
