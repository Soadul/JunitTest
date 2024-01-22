package com.example.testmockito.service.serviceImpl;


import com.example.testmockito.dto.SupplierMainRequestDTO;
import com.example.testmockito.dto.SupplierRequestDTO;
import com.example.testmockito.dto.response.Response;
import com.example.testmockito.model.SupplierMain;
import com.example.testmockito.model.UserDTO;
import com.example.testmockito.repository.SupplierContactRepository;
import com.example.testmockito.repository.SupplierMainRepository;
import com.example.testmockito.service.ISupplierMainService;
import com.example.testmockito.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;



@RequiredArgsConstructor
@Service
public class SupplierMainService implements ISupplierMainService {

    private final SupplierMainRepository supplierMainRepository;
    private final SupplierContactRepository supplierContactRepository;
    private final ModelMapper modelMapper;

    // ============Get the Supplier ============
    @Override
    public Response<List<SupplierMain>> getAllSuppliers() {
        try {
            List<SupplierMain> suppliers = supplierMainRepository.findAll();
            return new Response<>(Integer.parseInt(StatusCode.OK), true, "Supplier List Retrieved", suppliers);
        } catch (Exception e) {
            return new Response<>(Integer.parseInt(StatusCode.INTERNAL_SERVER_ERROR), false, "Error retrieving Supplier List", null);
        }
    }

    @Override
    public List<SupplierMain> getAllSuppliersEdited() {
        return null;
    }


    /*   @Override
       public List<SupplierMain> getAllSuppliersEdited() {

           return supplierMainRepository.getJoinInformation();
       }
   */
    @Override
    public Response<Optional<SupplierMain>> getSupplierById(Long id) {
        try {
            Optional<SupplierMain> supplier = supplierMainRepository.findById(id);

            if (supplier.isPresent()) {
                return new Response<>(Integer.parseInt(StatusCode.OK), true, "Supplier Found", supplier);
            } else {
                return new Response<>(Integer.parseInt(StatusCode.NOT_FOUND), false, "No Supplier found for id " + id, Optional.empty());
            }
        } catch (Exception e) {
            return new Response<>(Integer.parseInt(StatusCode.INTERNAL_SERVER_ERROR), false, "Error retrieving Supplier", Optional.empty());
        }
    }





    // ============= This method is for create a new supplier============

    @Override
    public SupplierMain createSupplier(SupplierRequestDTO request) {
        // Convert SupplierRequestDTO to SupplierMain
        SupplierMain supplierMain = convertToEntity(request);

        if (supplierMainRepository.existsBySupplierName(request.getSupplierName())) {
           // throw new CustomDataIntegrityViolationException("Supplier Name already exists");
        } else if (supplierMainRepository.existsBySupplierContact(request.getSupplierContact())) {
            //throw new CustomDataIntegrityViolationException("Supplier Contact already exists");
        } else if (supplierMainRepository.existsBySupplierEmail(request.getSupplierEmail())) {
            //throw new CustomDataIntegrityViolationException("Supplier Email already exists");
        }

        for (int i = 0; i < request.getSupplierContacts().size(); i++) {
            if (supplierContactRepository.existsByContactPersonName(request.getSupplierContacts().get(i).getContactPersonName())) {
              //  throw new CustomDataIntegrityViolationException("Contact Person Already Exists");
            } else if (supplierContactRepository.existsBycontactPersonContactNo(request.getSupplierContacts().get(i).getContactPersonContactNo())) {
              //  throw new CustomDataIntegrityViolationException("Contact Person's Phone No.  Already Exists");
            } else if (supplierContactRepository.existsBycontactPersonEmail(request.getSupplierContacts().get(i).getContactPersonEmail())) {
                //throw new CustomDataIntegrityViolationException("Contact Person's Email Already Exists");
            }
        }

        try {
            supplierMainRepository.save(supplierMain);
        } catch (Exception e) {
           // throw new CustomDataIntegrityViolationException("Unable to save supplier: " + e.getMessage());
        }

        return supplierMain;
    }

@Override
public Response<SupplierMain> updateSupplier(Long id, SupplierMainRequestDTO requestDTO) {
    // Check if the supplier with the given ID exists
    Optional<SupplierMain> optionalSupplier = supplierMainRepository.findById(id);

    if (optionalSupplier.isPresent()) {
        // Supplier with the given ID exists
        SupplierMain existingSupplier = optionalSupplier.get();
        //UserDTO userDTO = getUserInfoFromRequestHeader();

        // Update fields with values from the requestDTO
        existingSupplier.setSupplierName(requestDTO.getSupplierName());
        existingSupplier.setSupplierContact(requestDTO.getSupplierContact());
        existingSupplier.setSupplierEmail(requestDTO.getSupplierEmail());
        existingSupplier.setSupplierWeb(requestDTO.getSupplierWeb());
        existingSupplier.setSupplierDetails(requestDTO.getSupplierDetails());
       // existingSupplier.setUpdatedBy(userDTO.getId());

        // Save the updated supplier
        SupplierMain updatedSupplier = supplierMainRepository.save(existingSupplier);

        return new Response<>(Integer.parseInt(StatusCode.OK), true, "Supplier Updated Successfully", updatedSupplier);
    } else {
        // Supplier with the given ID not found
        throw new NoSuchElementException("Supplier not found with id: " + id);
    }
}

    @Override
    public Response<Void> deleteSupplier(Long id) {
        // Check if the supplier with the given ID exists
        Optional<SupplierMain> optionalSupplier = supplierMainRepository.findById(id);

        if (optionalSupplier.isPresent()) {
            // Supplier with the given ID exists, delete it
            supplierMainRepository.deleteById(id);
            return new Response<>(Integer.parseInt(StatusCode.OK), true, "Supplier Deleted Successfully", null);
        } else {
            // Supplier with the given ID not found
            throw new NoSuchElementException("Supplier not found with id: " + id);
        }
    }


    private SupplierMain convertToEntity(SupplierRequestDTO requestDTO) {

        SupplierMain supplierMain = this.modelMapper.map(requestDTO, SupplierMain.class);

       // UserDTO userDTO = getUserInfoFromRequestHeader();

        supplierMain.setUpdatedAt(new Date());
       // supplierMain.setCreatedBy(userDTO.getId());

        return supplierMain;
    }

        @Override
        public Response<List<SupplierMain>> searchSupplierMain(String supplierName) {
            try {
                List<SupplierMain> searchResults = supplierMainRepository.searchBySupplierNameOrEmailOrWeb(supplierName.toLowerCase());

                if (!searchResults.isEmpty()) {
                    return new Response<>(Integer.parseInt(StatusCode.OK), true, "Search Results Found", searchResults);
                } else {
                    return new Response<>(Integer.parseInt(StatusCode.NOT_FOUND), false, "No Search Results Found", null);
                }
            } catch (Exception e) {
                return new Response<>(Integer.parseInt(StatusCode.INTERNAL_SERVER_ERROR), false, "Error during search", null);
            }
        }

    @Override
    public Response<SupplierMain> getById(Long id) {
        Optional<SupplierMain> supplierMain = supplierMainRepository.findById(id);
        if(supplierMain.isEmpty()){
            return new Response<SupplierMain>(Integer.parseInt(StatusCode.NO_CONTENT), false, "No supplier found", null);
        }
        return new Response<SupplierMain>(Integer.parseInt(StatusCode.OK), true, "Supplier found", supplierMain.get());

    }
}
