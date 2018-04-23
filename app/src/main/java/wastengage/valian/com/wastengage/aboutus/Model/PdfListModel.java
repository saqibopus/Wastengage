package wastengage.valian.com.wastengage.aboutus.Model;

/**
 * Created by emxcel on 10/3/18.
 */

public class PdfListModel {

    private int id;
    private String pdfName;
    private String pdfImage;
    private String pdfUrl;

    public PdfListModel(int id, String pdfName, String pdfImage, String pdfUrl) {
        this.id = id;
        this.pdfName = pdfName;
        this.pdfImage = pdfImage;
        this.pdfUrl = pdfUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public String getPdfImage() {
        return pdfImage;
    }

    public void setPdfImage(String pdfImage) {
        this.pdfImage = pdfImage;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
