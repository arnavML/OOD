package Sem3.Model.Mapper;
import Sem3.Model.DTOs.BikeDTO;
import Sem3.Model.Domain.Bike;

public class BikeMapper {
    public static BikeDTO toDTO(Bike bike) {
        return new BikeDTO(bike.getBrand(), bike.getModel(), bike.getSerialNumber(), bike.getOwnerNumber());
    }
}
