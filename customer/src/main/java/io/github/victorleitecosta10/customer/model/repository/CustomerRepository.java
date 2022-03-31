package io.github.victorleitecosta10.customer.model.repository;

import io.github.victorleitecosta10.customer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
