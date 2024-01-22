package com.example.testmockito.service.serviceImpl;


import com.example.testmockito.dto.SupplierContactRequestDTO;
import com.example.testmockito.dto.response.Response;
import com.example.testmockito.model.SupplierContact;
import com.example.testmockito.repository.SupplierContactRepository;
import com.example.testmockito.service.ISupplierContactService;
import com.example.testmockito.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SupplierContactService implements ISupplierContactService {

    private final SupplierContactRepository supplierContactRepository;


    //@Autowired
    private final ModelMapper modelMapper;

    @Override
    public List<SupplierContact> getAllSupplierContacts() {
        return supplierContactRepository.findAll();
    }

    @Override
    public Optional<SupplierContact> getSupplierContactById(Long id) {
        return supplierContactRepository.findById(id);
    }


    @Override
    @Transactional
    public SupplierContact createSupplierContact(SupplierContactRequestDTO requestDTO) {
        SupplierContact supplierContact = mapToSupplierContact(requestDTO);
        return supplierContactRepository.save(supplierContact);
    }


    @Override
    @Transactional
    public Response<SupplierContact> updateSupplierContact(Long id, SupplierContactRequestDTO requestDTO) {
        Optional<SupplierContact> optionalSupplierContact = supplierContactRepository.findById(id);

        if (optionalSupplierContact.isPresent()) {
            SupplierContact supplierContact = optionalSupplierContact.get();

            // Update fields with values from the requestDTO
            supplierContact.setContactPersonName(requestDTO.getContactPersonName());
            supplierContact.setContactPersonEmail(requestDTO.getContactPersonEmail());
            supplierContact.setContactPersonContactNo(requestDTO.getContactPersonContactNo());
            supplierContact.setContactItem(requestDTO.getContactItem());

            // Save the updated supplierContact
            SupplierContact updatedSupplierContact = supplierContactRepository.save(supplierContact);

            // Return a Response object with additional details
            return new Response<>(Integer.parseInt(StatusCode.OK), true, "Supplier Contact Updated", updatedSupplierContact);
        } else {
            // Return a Response object indicating that the supplierContact with the given ID was not found
            return new Response<>(Integer.parseInt(StatusCode.NOT_FOUND), false, "Supplier Contact not found", null);
        }
    }

    @Override
    @Transactional
    public Response<Void> deleteSupplierContact(Long id) {
        Optional<SupplierContact> optionalSupplierContact = supplierContactRepository.findById(id);

        if (optionalSupplierContact.isPresent()) {
            try {
                supplierContactRepository.deleteById(id);
                return new Response<>(Integer.parseInt(StatusCode.OK), true, "Supplier Contact Deleted", null);
            } catch (Exception e) {
                return new Response<>(Integer.parseInt(StatusCode.INTERNAL_SERVER_ERROR), false, "Error deleting Supplier Contact", null);
            }
        } else {
            return new Response<>(Integer.parseInt(StatusCode.NOT_FOUND), false, "Supplier Contact not found", null);
        }
    }

    private SupplierContact mapToSupplierContact(SupplierContactRequestDTO requestDTO) {

        SupplierContact supplierContact = this.modelMapper.map(requestDTO, SupplierContact.class);

        supplierContact.setContactPersonName(requestDTO.getContactPersonName());
        supplierContact.setContactPersonEmail(requestDTO.getContactPersonEmail());
        supplierContact.setContactPersonContactNo(requestDTO.getContactPersonContactNo());
        supplierContact.setContactItem(requestDTO.getContactItem());

        return supplierContact;
    }
}
