package net.proselute.customerdemo.rest;

import net.proselute.customerdemo.model.Customer;
import net.proselute.customerdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;

@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerRestControlerV1 {

    @Autowired
    private CustomerService customerService;
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> getCustumer(@PathVariable("id") Long customerId){
        if(customerId == null){
            return  new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }

        Customer customer = this.customerService.getByID(customerId);

        if (customer == null){
            return  new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
             return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> saveCustomer(@RequestBody  @Validated Customer customer){
        HttpHeaders heders = new HttpHeaders();

        if (customer == null){
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }

        this.customerService.save(customer);
        return   new ResponseEntity<Customer>(customer,heders,HttpStatus.CREATED);

    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> updateCustomer(Customer customer, UriComponentsBuilder bilder) {
        HttpHeaders headers = new HttpHeaders();

        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }

        this.customerService.save(customer);
        return  new ResponseEntity<>(customer,headers,HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
        Customer customer = this.customerService.getByID(id);
        if (customer == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.customerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customers = this.customerService.getAll();

        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
}
