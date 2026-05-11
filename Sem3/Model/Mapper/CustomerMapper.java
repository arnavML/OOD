package Sem3.Model.Mapper;
import Sem3.Model.DTOs.CustomerDTO;
import Sem3.Model.Domain.Customer;


public class CustomerMapper {
    public static CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(customer.getName(), customer.getCustomerNumber(), customer.getEmail(), BikeMapper.toDTO(customer.getBike()));
    }
}
