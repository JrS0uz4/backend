import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

public class InserirURL {

	public InserirURL() {}
	
	public static void main(String[] args) throws Exception {
			
		new InserirURL().rodape();

	}
	
	public void rodape() {
		
		try {
			
			String doc =  "memorando.docx";
			File docxFile = new File(doc);
			
			FileInputStream out = new FileInputStream(doc);
			XWPFDocument docx = new XWPFDocument(out);
		
			CTSectPr sectPr = docx.getDocument().getBody().addNewSectPr();
			XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(docx,sectPr);
		
			CTP ctpFooter = CTP.Factory.newInstance();
			CTR ctrFooter = ctpFooter.addNewR();
		
			CTText ctFooter = ctrFooter.addNewT();
			String footerText = "Teste !!!";
		
			ctFooter.setStringValue(footerText);
			XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter,docx);
		
			XWPFParagraph[] parsFooter = new XWPFParagraph[1];
			parsFooter[0] = footerParagraph;
		
			policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT,parsFooter);
			FileOutputStream in = new FileOutputStream(docxFile);
			
			docx.write(in);
			in.close();
		
			JOptionPane.showMessageDialog(null, "Arquivo Modificado Com sucesso");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}