package com.example.back_end.Service;

import com.example.back_end.Model.Address;
import com.example.back_end.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // Lấy tất cả địa chỉ
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    // Lấy địa chỉ theo id
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    // Tạo địa chỉ mới
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    // Cập nhật địa chỉ
    public Address updateAddress(Long id, Address addressDetails) {
        Optional<Address> addressOpt = addressRepository.findById(id);
        if (addressOpt.isPresent()) {
            Address address = addressOpt.get();
            address.setCity(addressDetails.getCity());
            address.setProvince(addressDetails.getProvince());
            address.setDistrict(addressDetails.getDistrict());
            address.setPostalCode(addressDetails.getPostalCode());
            // Cập nhật các trường khác nếu có

            return addressRepository.save(address);
        } else {
            throw new RuntimeException("Address not found with id " + id);
        }
    }

    // Xóa địa chỉ theo id
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
