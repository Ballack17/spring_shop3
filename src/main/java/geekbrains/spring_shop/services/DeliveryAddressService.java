package geekbrains.spring_shop.services;

import geekbrains.spring_shop.entities.DeliveryAddress;
import geekbrains.spring_shop.repositories.DeliveryAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressService {

    private DeliveryAddressRepository deliveryAddressRepository;

    @Autowired
    public void setDeliveryAddressRepository(DeliveryAddressRepository deliveryAddressRepository) {
        this.deliveryAddressRepository = deliveryAddressRepository;
    }

    public List<DeliveryAddress> getUserAddresses(Long userId) {
        return deliveryAddressRepository.findAllByUserId(userId);
    }
}
