package com.twjitm.utils;

import org.docx4j.convert.in.xhtml.XHTMLImporterImpl;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by 文江 on 2017/12/2.
 */
public class HtmlUtils {
    private static String getDefautCss() {
        String css = "/*\n" +
                "\n" +
                "Skin: Default\n" +
                "Colors: White, Blue, Dark Grey\n" +
                "\n" +
                "*/\n" +
                "\n" +
                "@import url(http://fonts.googleapis.com/css?family=Open+Sans:400);\n" +
                "@import url(http://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic);\n" +
                "\n" +
                "/*-------------------------------------------------------------------\n" +
                "  Usually changes global style: colors, backgrounds, fonts, etc.\n" +
                "-------------------------------------------------------------------*/\n" +
                "\n" +
                "body {\n" +
                "  background: url(../../img/patterns/project_papper.png)\n" +
                "}\n" +
                "\n" +
                "#container {\n" +
                "  background: url(../../img/patterns/alternative_light.png) repeat;\n" +
                "}\n" +
                "\n" +
                "body,\n" +
                ".ribbon em, .ribbon2 em, .ribbon3 em {\n" +
                "  font-family: 'Droid Serif', georgia, times, serif; /* Primary font */\n" +
                "}\n" +
                "\n" +
                ".ribbon,\n" +
                "article .section-title,\n" +
                ".portfolio h2,\n" +
                ".subtitle,\n" +
                ".wrap-footer,\n" +
                ".wrap-footer a,\n" +
                ".markup footer {\n" +
                "  font-family: 'Open Sans', arial, sans-serif; /* Alternative font */\n" +
                "}\n" +
                "\n" +
                ".wrap-header h1 span {\n" +
                "  color: #00A0C6;         /* Primary color */\n" +
                "}\n" +
                "\n" +
                ".wrap-header h1,\n" +
                ".wrap-header p {\n" +
                "  color: #555;            /* Title color */\n" +
                "}\n" +
                "\n" +
                "article .section-title,\n" +
                ".portfolio h2 {\n" +
                "  background: #00A0C6;    /* Primary color */\n" +
                "}\n" +
                "\n" +
                ".row-inversed {\n" +
                "  background: #353535;    /* Inversed color */\n" +
                "}\n" +
                "\n" +
                "/* Link Style */\n" +
                "#container .column .subtitle a,\n" +
                ".reference a,\n" +
                "a {\n" +
                "  color: #007BAA;\n" +
                "  border-bottom: 1px dotted #ccc;\n" +
                "  text-decoration: none;\n" +
                "}\n" +
                "\n" +
                "a:hover {\n" +
                "  border-bottom-style: solid;\n" +
                "  color: #999 !important;\n" +
                "}\n" +
                "\n" +
                ".row-contact {\n" +
                "  display: none;\n" +
                "}\n" +
                "\n" +
                "article .section-title,\n" +
                ".portfolio h2 {\n" +
                "  text-shadow: 0 -1px 0 rgba(51, 51, 51, 0.2);\n" +
                "  font-weight: 400;\n" +
                "  color: #fff;\n" +
                "  padding: 6px 14px;\n" +
                "  letter-spacing: 1px;\n" +
                "  box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.1);\n" +
                "}\n" +
                "\n" +
                ".column .subtitle {\n" +
                "  color: #999;\n" +
                "}\n" +
                "\n" +
                ".row {\n" +
                "  border-top: 1px dashed #ccc;\n" +
                "}\n" +
                "\n" +
                ".row-inversed {\n" +
                "  border-top: 0 none;\n" +
                "}\n" +
                "\n" +
                ".row-icon {\n" +
                "  border-top: 1px solid #444;\n" +
                "}\n" +
                "\n" +
                ".row-inversed a:hover {\n" +
                "  color: #F6F6E7 !important;\n" +
                "}\n" +
                "\n" +
                ".row-inversed .profile-pic {\n" +
                "  border: 0 none;\n" +
                "}\n" +
                "\n" +
                ".row-inversed .info td,\n" +
                ".row-inversed .info th,\n" +
                ".row-inversed .info a {\n" +
                "  color: #F6F6E7;\n" +
                "  text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.9);\n" +
                "}\n" +
                "\n" +
                ".row-inversed .info th {\n" +
                "  color: #999;\n" +
                "}\n" +
                "\n" +
                ".wrap-footer,\n" +
                ".wrap-footer a {\n" +
                "  color: #888;\n" +
                "  text-shadow: 0 1px 0 rgba(255, 255, 255, 0.4);\n" +
                "  font-size: 11px;\n" +
                "  text-transform: none;\n" +
                "}\n" +
                "\n" +
                ".row-profile {\n" +
                "  box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.2);\n" +
                "}\n" +
                "\n";
        return css;
    }

    private static String getUserCss() {
        return "article, aside, details, figcaption, figure, footer, header, hgroup, nav, section { display: block; }\n" +
                "html { font-size: 100%; overflow-y: scroll; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; }\n" +
                "body { margin: 0; line-height: 1; text-rendering: optimizelegibility; }\n" +
                "body, button, input, select, textarea { font-family: sans-serif; color: #222; }\n" +
                "body {\n" +
                "  font: normal 100% georgia, serif;\n" +
                "  color: #111;\n" +
                "  background: #ccc;\n" +
                "}\n" +
                "del {\n" +
                "  text-decoration: line-through;\n" +
                "  color: #ccc;\n" +
                "}\n" +
                "textarea,\n" +
                ".wrap-header article,\n" +
                ".row article {\n" +
                "  width: 90%;\n" +
                "  margin: 0 auto;\n" +
                "  overflow: hidden;\n" +
                "  position: relative;\n" +
                "  padding: 3.125em 0;\n" +
                "  zoom: 1;\n" +
                "}\n" +
                "\n" +
                ".row article > :last-child {\n" +
                "  margin-bottom: 0;\n" +
                "}\n" +
                "\n" +
                ".wrap-header article {\n" +
                "  overflow: visible;\n" +
                "}\n" +
                ".wrap-header article p,\n" +
                ".row p {\n" +
                "  clear: both;\n" +
                "}\n" +
                "\n" +
                ".column {\n" +
                "  width: 37%;\n" +
                "  margin: 0 3% 0 0;\n" +
                "  padding: 0 0 0 90px;\n" +
                "  float: left;\n" +
                "  position: relative;\n" +
                "}\n" +
                "\n" +
                ".oldie .column {\n" +
                "  width: 36%;\n" +
                "  margin: 0 10px 0 0;\n" +
                "}\n" +
                "\n" +
                ".column-no-logo {\n" +
                "  padding-left: 0;\n" +
                "  width: 47%;\n" +
                "  margin-right: 6%;\n" +
                "}\n" +
                "\n" +
                ".column-no-logo a.logo {\n" +
                "  display: none;\n" +
                "}\n" +
                "\n" +
                ".column-row {\n" +
                "  clear: both;\n" +
                "  margin: 40px 0 0;\n" +
                "  overflow: hidden;\n" +
                "  zoom: 1;\n" +
                "}\n" +
                "\n" +
                ".column-row .column:last-child {\n" +
                "  margin-right: 0;\n" +
                "}\n" +
                ".wrap-header h1 {\n" +
                "  font-weight: normal;\n" +
                "  font-size: 1.125em;\n" +
                "  line-height: 1em;\n" +
                "  margin: 0 0 5px;\n" +
                "}\n" +
                "\n" +
                ".wrap-header h1 span {\n" +
                "  font-size: 1.666666667em;\n" +
                "  padding: 0 0 0 5px;\n" +
                "  letter-spacing: -0.05em;\n" +
                "}\n" +
                "\n" +
                ".wrap-header p {\n" +
                "  margin: 0;\n" +
                "  font-size: 1.125em;\n" +
                "  color: #666;\n" +
                "}\n" +
                "\n" +
                ".wrap-title {\n" +
                "   text-align:center;\n" +
                "}\n" +
                "\n" +
                "/* sharing tools & ribbons */\n" +
                "\n" +
                ".wrap-ribbons {\n" +
                "  float: right;\n" +
                "  margin: -3.125em 0 0 0;\n" +
                "  padding: 0 0 10px 30px;\n" +
                "}\n" +
                "\n" +
                ".social-services {\n" +
                "  position: absolute;\n" +
                "  right: 0;\n" +
                "  top: 0;\n" +
                "  width: 500px;\n" +
                "}\n" +
                "\n" +
                ".section-title,\n" +
                ".portfolio h2 {\n" +
                "  margin: 0 0 2.2em;\n" +
                "  padding: 9px 18px 8px;\n" +
                "  font-family: arial, sans-serif;\n" +
                "  text-transform: uppercase;\n" +
                "  float: left;\n" +
                "  font-weight: normal;\n" +
                "  font-size: 0.875em;\n" +
                "}\n" +
                "\n" +
                ".smaller-text p {\n" +
                "  line-height: 1.5em;\n" +
                "  font-size: 0.875em;\n" +
                "}\n" +
                "\n" +
                ".reference {\n" +
                "  font-size: 0.75em;\n" +
                "}\n" +
                "\n" +
                ".reference a {\n" +
                "  font-size: 1.16em;\n" +
                "  color: inherit;\n" +
                "}\n" +
                "\n" +
                ".column h3 {\n" +
                "  font-size: 1.3125em;\n" +
                "  font-weight: normal;\n" +
                "  color: #222;\n" +
                "  margin: 0;\n" +
                "}\n" +
                "\n" +
                ".column .subtitle {\n" +
                "  font-size: 0.75em;\n" +
                "  color: #666;\n" +
                "  margin: 0 0 1.166666667em;\n" +
                "}\n" +
                "\n" +
                ".column .subtitle a {\n" +
                "  color: #666;\n" +
                "}\n" +
                ".markup p {\n" +
                "  line-height: 1.6875em;\n" +
                "}\n" +
                "\n" +
                ".markup li {\n" +
                "  margin-bottom: 0.3125em;\n" +
                "}\n" +
                "\n" +
                ".markup h1, .markup h2, .markup h3, .markup h4, .markup h5, .markup h6 {\n" +
                "  font-weight: normal;\n" +
                "}\n" +
                "\n" +
                ".markup :last-child {\n" +
                "  margin-bottom: 0;\n" +
                "}\n" +
                "\n" +
                ".portfolio li .border {\n" +
                "  border: 10px solid #fff;\n" +
                "  overflow: hidden;\n" +
                "}\n" +
                "\n" +
                ".portfolio li:hover div {\n" +
                "  opacity: 1;\n" +
                "}\n" +
                "\n" +
                ".portfolio img {\n" +
                "  width: 100%;\n" +
                "  height: auto;\n" +
                "}\n" +
                "\n" +
                "\n";
    }

    public static String getHead(String title) {
        String head = "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0; maximum-scale=1.0\">\n" +
                "\n" +
                "  <title>河北大学 2018 " + title + "卷</title>\n" +
                "  \n" +
                "</head>\n";
        return head;
    }

    public static String getStyle() {
        String style = "<style type=\"text/css\">\n" +
                "    \n" + getDefautCss() +
                "    \n" + getUserCss() +
                "</style>";
        return style;
    }

    /**
     * html 转Word
     * @param html
     * @param word
     */
    public static void htmlToWord(File html, File word) {
        InputStream templateStream = null;
        try {
            // Get the template input stream from the application resources.
            final URL resource = html.toURI().toURL();

            // Instanciate the Docx4j objects.
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
            XHTMLImporterImpl XHTMLImporter = new XHTMLImporterImpl(wordMLPackage);
            // Load the XHTML document.
            wordMLPackage.getMainDocumentPart().getContent().addAll(XHTMLImporter.convert(resource));
            // Save it as a DOCX document on disc.
            wordMLPackage.save(word);
            // Desktop.getDesktop().open(outputFile);
        } catch (Exception e) {
            throw new RuntimeException("Error converting file " + html, e);
        } finally {
            if (templateStream != null) {
                try {
                    templateStream.close();
                } catch (Exception ex) {
                    System.out.println("error");

                }
            }
        }
    }

}
