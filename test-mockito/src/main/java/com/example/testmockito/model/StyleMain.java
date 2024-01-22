package com.example.testmockito.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "scm_settings_style_main")
public class StyleMain extends AuditModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scm_settings_style")
    @SequenceGenerator(
            name = "scm_settings_style",
            sequenceName = "scm_settings_style",
            initialValue = 1,
            allocationSize = 1)
    Long id;
    private boolean status;


    @Column(name = "styleNo", unique = true) // Added unique constraint on styleNo
    private String styleNo;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = StyleItem.class)
    @JoinColumn(name = "style_fk", referencedColumnName = "id")
    private List<StyleItem> styleItem;

}
