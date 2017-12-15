package com.twjitm.test;

/**
 * Created by 文江 on 2017/12/5.
 */
public class Word {

    /**
     * 生成文
     * @param
     * @param
     */
  //  public static void generate(File inputFile, File outputFile)
//    {
//        InputStream templateStream = null;
//        try
//        {
//            // Get the template input stream from the application resources.
//            final URL resource = inputFile.toURI().toURL();
//
//            // Instanciate the Docx4j objects.
//            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
//            XHTMLImporterImpl XHTMLImporter = new XHTMLImporterImpl(wordMLPackage);
//
//            // Load the XHTML document.
//            wordMLPackage.getMainDocumentPart().getContent().addAll(XHTMLImporter.convert(resource));
//
//            // Save it as a DOCX document on disc.
//            wordMLPackage.save(outputFile);
//            // Desktop.getDesktop().open(outputFile);
//
//        }
//        catch (Exception e)
//        {
//            throw new RuntimeException("Error converting file " + inputFile, e);
//
//        }
//        finally
//        {
//            if (templateStream != null)
//            {
//                try
//                {
//                    templateStream.close();
//                }
//                catch (Exception ex)
//                {
//                    System.out.println("error");
//
//                }
//            }
//        }
//
//    }

    public static void main(String[] args) {
        //generate(new File("G:\\ftmp_121_ub\\index.html"),new File("G:\\index.doc"));
    }
}
