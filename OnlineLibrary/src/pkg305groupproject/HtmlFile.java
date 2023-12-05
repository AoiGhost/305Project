
package pkg305groupproject;

import java.util.Date;

public class HtmlFile {
    Date expirationDate;
    String pdfUrl; 

    public HtmlFile() {
    }

    public HtmlFile(Date expirationDate, String pdfUrl) {
        this.expirationDate = expirationDate;
        this.pdfUrl = pdfUrl;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
    
    
}
