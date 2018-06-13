import java.io.*;

/**
 * @author Dr. Ikeda
 *
 */
public class FileNameChanger {

	/**
	 * "NewDecPDF(Very Important)"の中には各国20言語ごとのフォルダーがあり、その中には各国ＩＤと番号が付いたPDFファイルが入っている。
	 * その番号は35種類の製品ごととなっている。
	 * なお、日付は21/04/2018（認証期日）
	 * 
	 */
//	製品種別ごとの製品名（使用していない）
	private String fullFaceFileName[] = {"CF01","CX01","GX01","FS01"};
	private String halfFileName[] = {"RX01","RS01","RS01S"};
	private String particleFileName[] = {"P3R","P2R","CC-P3R","CP-P3R"};
	private String gasFileName[] = {"CA-A1","CA-A2","CA-K1","CA-ABEK1",
			"CA-AX","CC-A2","CC-ABEK2","CA-A2-P2RC","CA-A1-P2RC","CA-K1-P2RC",
			"CA-ABEK1-P2RC","CA-AX-P2RC","CA-A2-P3RC","CA-A1-P3RC","CA-K1-P3RC",
			"CA-ABEK1-P3RC","CA-AX-P3RC","CC-A2P3R","CC-B2P3R","CC-ABEK2P3R",
			"CC-AXP3NR"};
	private String paprFileName[] ={"Sync01VP3","Sync01VA1P3","Sync01VABE1P3"};
	
//	当社CE製品の３５製品名
	private String newFileName[] = {"CF01","CX01","GX01","FS01","RS01","RS01S","RX01",
			"P3R","P2R","CC-P3R","CP-P3R","CA-A1","CA-A2","CA-K1","CA-ABEK1",
			"CA-AX","CC-A2","CC-ABEK2","CA-A2-P2RC","CA-A1-P2RC","CA-K1-P2RC",
			"CA-ABEK1-P2RC","CA-AX-P2RC","CA-A2-P3RC","CA-A1-P3RC","CA-K1-P3RC",
			"CA-ABEK1-P3RC","CA-AX-P3RC","CC-A2P3R","CC-B2P3R","CC-ABEK2P3R",
			"CC-AXP3NR","Sync01VP3","Sync01VA1P3","Sync01VABE1P3"};
//	国名
	private String country[] = {"BG","DK","DE","GR","EN","ES","EE","FI","FR","HU","IT","NO",
			"NL","PL","PT","RO","SK","SI","SE","TR"};
//	言語
	private String sLang[] = {"bg","da","de","el","en","es","et","fi","fr","hu",
			"it","nb","nl","pl","pt","ro","sk","sl","sv","tr"};
//	ディレクトリ名
	private String sDir[] = {"CA", "CF01", "P3R", "RX01", "Sync01"};
//	コピー元の製品種別名
	private String orgFileName[] = {"CF01", "RX01", "P3R", "CA", "Sync01"};
//	PDFファイル名に付属させる日付YYYY/MM/DD
	private String cDate = "20180421";
	
	private int productCount[] = {4, 3, 4, 21, 3};
	
	public FileNameChanger() throws Exception {
		// TODO Auto-generated constructor stub
		String baseDir = "C:\\temp\\";
//		String fileName = "NewDoC(en)\\" + sLang[count] + "-" + lang[count] +
//				"\\" + lang[count] + "-";
//		String fileName = "NewDoC(en)20180418\\" + sDir[4] + "\\" + sDir[4];
		String fileName = "NewDecPDF(Very Important)\\";
		String newDirectory = fileName + "xProducts\\";
		String extensions = ".pdf";
		String formatStr = "-%02d";
//		int fileNameNum = 0;
//		国ごとのループ
		for (int countryNum = 0; countryNum < country.length; countryNum++) {
//			if (productNum == 3) formatStr = "-%02d";
//			else formatStr = "-%1d";
			String countryAndLang = sLang[countryNum] + "-" + country[countryNum] + "\\";
//			製品番号でのループ
			for (int i = 0; i < newFileName.length; i++) {
//				for (int j = 0; j < 20; j++) {
//					入力ファイルパス名
					String inFn = baseDir + fileName + countryAndLang + country[countryNum] + 
							String.format(formatStr, i + 1)	+ extensions;
//					出力ファイルパス名
					String outFn = baseDir + newDirectory + newFileName[i] + "_" + country[countryNum].toUpperCase() + "_"
							+ cDate + extensions;
					// System.out.printf("input: %s, output: %s\n", inFn, outFn);
					// copyFile(new File(inFn), new File(outFn));
					fileCopy(inFn, outFn);
					System.out.printf("input: %s, output: %s\n", inFn, outFn);
//				}
			}
		}
	}
	
    public static void copyFile(File in, File out) throws Exception {
        FileInputStream fis  = new FileInputStream(in);
        FileOutputStream fos = new FileOutputStream(out);
        try {
            byte[] buf = new byte[1024];
            int i = 0;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if (fis != null) fis.close();
            if (fos != null) fos.close();
        }
    }
    
    public void fileCopy(String inFile, String outFile) throws IOException {
        int bf;

		System.out.printf("input: %s, output: %s\n", inFile, outFile);
        BufferedInputStream  src  = new BufferedInputStream(new FileInputStream(inFile));
        BufferedOutputStream dest = new BufferedOutputStream(new FileOutputStream(outFile));

        while ((bf = src.read()) >= 0){
          dest.write(bf);
        }
        dest.flush();
        src.close();
        dest.close();
    }
    
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		FileNameChanger work = new FileNameChanger();
//		RenameFilesInDir w = new RenameFilesInDir();

	}

}
