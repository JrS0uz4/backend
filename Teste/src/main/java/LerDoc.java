import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class LerDoc {

	public LerDoc() {}
	
public static void main(String[] args) throws Exception {
		
		new LerDoc().ler();

	}
	
	public void ler() {
		
		try {
			
			FileInputStream file = new FileInputStream("memorando.docx");
			XWPFDocument doc = new XWPFDocument(file);
			
			List<XWPFParagraph> paragraphList = doc.getParagraphs();
			
			
			for(XWPFParagraph paragraph : paragraphList) {
				System.out.println(paragraph.getText());
			} 
				
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
				// TODO: handle exception
		}	
	}
}
