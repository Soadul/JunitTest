package com.example.testmockito.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// @Builder
@Table(name = "scm_settings_supllier_contact")
public class SupplierContact extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scm_settings_supplier_contact")
    @SequenceGenerator(
            name = "scm_settings_supplier_contact",
            sequenceName = "scm_settings_supplier_contact",
            initialValue = 1,
            allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String contactPersonName;

    @Column(unique = true)
    private String contactPersonEmail;

    @Column(unique = true)
    private String contactPersonContactNo;

    private String contactItem;

    private boolean status;

    //private Long mainId;

/*  @ManyToOne(cascade = CascadeType.ALL, targetEntity = SupplierMain.class)
  @JoinColumn(name = "main_contact_fk", referencedColumnName = "id")
  private SupplierMain supplierMain;*/
}
