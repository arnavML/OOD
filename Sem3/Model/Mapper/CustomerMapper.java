package Sem3.model.mapper;
import Sem3.model.dto.CustomerDTO;
import Sem3.model.domain.Customer;


public class CustomerMapper {
    
    public static CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(customer.getName(), customer.getCustomerNumber(), customer.getEmail(), BikeMapper.toDTO(customer.getBike()));
    }
}
