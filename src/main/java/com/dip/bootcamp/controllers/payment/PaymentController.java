package com.dip.bootcamp.controllers.payment;

import com.dip.bootcamp.utilities.InformationConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = ("/payment"))
public class PaymentController {

    @GetMapping(value = "/list")
    public String paymentList(Model model){
        String title = "Payment" + InformationConstant.websiteTitle;

        model.addAttribute("title", title);
        model.addAttribute("username", "Nanra");
        return "payment/list";
    }

}
