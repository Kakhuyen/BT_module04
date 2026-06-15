package controller;

import model.Customer;
import service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    private ICustomerService customerService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {

        ModelAndView modelAndView =
                new ModelAndView("create");

        modelAndView.addObject(
                "customer",
                new Customer()
        );

        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(
            @ModelAttribute("customer") Customer customer
    ) {

        boolean result =
                customerService.saveWithStoredProcedure(customer);

        ModelAndView modelAndView =
                new ModelAndView("create");

        modelAndView.addObject(
                "customer",
                new Customer()
        );

        if (result) {
            modelAndView.addObject(
                    "message",
                    "New customer created successfully"
            );
        } else {
            modelAndView.addObject(
                    "message",
                    "Error exists!"
            );
        }

        return modelAndView;
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Controller OK";
    }


}
