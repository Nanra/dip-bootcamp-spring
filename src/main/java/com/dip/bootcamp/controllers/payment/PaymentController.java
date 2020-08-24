package com.dip.bootcamp.controllers.payment;

import com.dip.bootcamp.services.PaymentService;
import com.dip.bootcamp.utilities.InformationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = ("/payment"))
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/list")
    public String paymentList(Model model) throws Exception {
        String title = "Payment" + InformationConstant.websiteTitle;


        paymentService.documentPaymentStream();

        model.addAttribute("title", title);
        model.addAttribute("username", "Nanra");
        return "payment/list";
    }

}
