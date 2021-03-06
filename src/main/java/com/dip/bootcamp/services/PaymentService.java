package com.dip.bootcamp.services;

import com.aspose.words.Document;
import com.aspose.words.MailMergeCleanupOptions;
import com.aspose.words.SaveFormat;
import com.dip.bootcamp.models.Payment;
import com.dip.bootcamp.repository.PaymentRepository;
import com.dip.bootcamp.utilities.ResourceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository repository;

    // Get All Data Payment
    public List<Payment> getAllPayment(Payment dataParam) {
        return repository.listPayment(dataParam);
    }

    // Generate Document Report Payment Invoice
    public ByteArrayInputStream documentPaymentStream(Payment dataParam) throws Exception {

        // Get Data Row / ById From Database
        Payment paymentObject = repository.listPayment(dataParam).get(0);

        // Setup Path Folder for Reading Resource
        String parentPath = ResourceHelper.getResourcePath();
        String pathFile = ResourceHelper.getFilePathFromResource("template-surat-tagihan", ".docx");

        // Config/Init Document Aspose Library
        Document doc = new Document(pathFile);
        System.out.println("IO Address : " + doc);

        doc.getMailMerge().setTrimWhitespaces(true);
        doc.getMailMerge().setCleanupOptions(MailMergeCleanupOptions.REMOVE_UNUSED_FIELDS | MailMergeCleanupOptions.REMOVE_CONTAINING_FIELDS
                | MailMergeCleanupOptions.REMOVE_EMPTY_PARAGRAPHS);

        String[] toMerge = {
                "PAYER", "INVOICENUMBER", "AMOUNT", "STATUS", "CREATEDATE", "CREATEBY", "COMPANY"
        };

        doc.getMailMerge().execute(toMerge, new Object[]{
                paymentObject.getPayer() == null ? "-" : paymentObject.getPayer(),
                paymentObject.getInvoiceNumber() == null ? "-" : paymentObject.getInvoiceNumber(),
                paymentObject.getAmount() == null ? "-" : paymentObject.getAmount(),
                paymentObject.getStatus() == null ? "-" : paymentObject.getStatus(),
                paymentObject.getCreateDate() == null ? "-" : paymentObject.getCreateDate(),
                paymentObject.getCreateBy() == null ? "-" : paymentObject.getCreateBy(),
                "PT. Daya Indosa Pratama"
        });

        String generatedFileName = "Surat_Tagihan_"+paymentObject.getInvoiceNumber();

        String finalFileName = parentPath + "/" + generatedFileName;
        String tmpWordDoc = finalFileName + ".docx";
        String wordDoc = finalFileName + ".docx";
        String pdfDoc = finalFileName + ".pdf";

        doc.save(wordDoc);
        doc.save(tmpWordDoc);

        // save As PDF from Word
        doc.save(pdfDoc, SaveFormat.PDF);
        byte[] bFile = ResourceHelper.readBytesFromFile(pdfDoc);
        return new ByteArrayInputStream(bFile);
    }

}
