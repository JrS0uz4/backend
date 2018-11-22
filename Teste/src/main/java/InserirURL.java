import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class InserirURL {

	public InserirURL() {}
	
	public static void main(String[] args) throws Exception {
		
		ArrayList<String> cont = new ArrayList<String>();
		cont = new InserirURL().ler();
		new InserirURL().inserir(cont);

	}
	
	public ArrayList<String> ler() {
		
		try {
			
			FileInputStream file = new FileInputStream("Doc.docx");
			XWPFDocument doc = new XWPFDocument(file);
			
			List<XWPFParagraph> paragraphList = doc.getParagraphs();
			ArrayList<String> conteudo = new ArrayList<String>(); 
			
			for(XWPFParagraph paragraph : paragraphList) {
				conteudo.add(paragraph.getText());
			}
			
		/*	for(int i = 0 ; i < conteudo.size() ; i++) {
				System.out.println(conteudo.get(i));
			} */
			
			return conteudo;
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		
		}catch (Exception e) {
				// TODO: handle exception
		}
		
		return null;
	}
	
	public void inserir(ArrayList<String> conteudo) {
		
		try {
			
			FileOutputStream file = new FileOutputStream("Doc.docx");
			XWPFDocument doc = new XWPFDocument();
			
			ArrayList<String> conteudo2 = conteudo;
			
			XWPFParagraph t1 = doc.createParagraph();
			t1.setAlignment(ParagraphAlignment.BOTH);
			
			XWPFRun url = t1.createRun();
			
			for(int i = 0 ; i < conteudo2.size() ; i++) {
				url.setText(conteudo2.get(i));	
			}
			
			url.setText("https://www.google.com/");
			
			for(int i = 0 ; i < conteudo2.size() ; i++) {
				System.out.println(conteudo2.get(i));
			} 
			
			doc.write(file);
			file.close();
			doc.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		
		}catch (Exception e) {}
	}
	
}