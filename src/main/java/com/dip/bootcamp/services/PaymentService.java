package com.dip.bootcamp.services;

import com.aspose.words.Document;
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

    public List<Payment> getAllPayment(Payment dataParam) {
        return repository.listPayment(dataParam);
    }

    public ByteArrayInputStream documentPaymentStream() throws Exception {

//        String parentPath = ResourceHelper.getResourcePath();
        String pathFile = ResourceHelper.getFilePathFromResource("template-surat-tagihan", ".docx");

        Document doc = new Document(pathFile);

        System.out.print(doc);

        return null;
    }

}
