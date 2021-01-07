package net.proselute.customerdemo.repositoru;

import net.proselute.customerdemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer,Long> {

}
