package com.example.testmockito.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// @Builder
@Table(name = "scm_settings_supllier_main")
public class SupplierMain extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scm_settings_supplier_main")
    @SequenceGenerator(
            name = "scm_settings_supplier_main",
            sequenceName = "scm_settings_supplier_main",
            initialValue = 1,
            allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String supplierName;


    //@Pattern(regexp = "^[0-9]*$", message = "Supplier contact must contain only numeric characters")
    private String supplierContact;


    @Column(unique = true)
    private String supplierEmail;

    @Column(unique = true)
    private String supplierWeb;

    private String supplierDetails;
    private boolean status;


    @OneToMany(cascade = CascadeType.ALL, targetEntity = SupplierContact.class)
    @JoinColumn(name = "main_contact_fk", referencedColumnName = "id")
    private List<SupplierContact> supplierContacts;
}
