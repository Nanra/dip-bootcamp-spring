package com.dip.bootcamp.controllers.payment;

import com.dip.bootcamp.models.Payment;
import com.dip.bootcamp.services.PaymentService;
import com.dip.bootcamp.utilities.InformationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;

@Controller
@RequestMapping(value = ("/payment"))
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/list")
    public String paymentList(Model model) throws Exception {
        String title = "Payment" + InformationConstant.websiteTitle;


        Payment payment = new Payment();
        payment.setId("1");
        paymentService.documentPaymentStream(payment);

        model.addAttribute("title", title);
        model.addAttribute("username", "Nanra");
        return "payment/list";
    }

@GetMapping(value = "/download")
    public ResponseEntity downloadInvoice() throws Exception {
    ByteArrayInputStream in = null;

    Payment payment = new Payment();
    payment.setId("1");
    in = paymentService.documentPaymentStream(payment);

    HttpHeaders headers = new HttpHeaders();
    String headerValue = "attachment; filename=" + "Surat-Tagihan" + ".pdf";
    headers.add("Content-Disposition", headerValue);

    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    headers.setContentType(MediaType.parseMediaType("application/pdf"));

    return ResponseEntity.ok()
            .headers(headers)
            .body(new InputStreamResource(in));
}

}
