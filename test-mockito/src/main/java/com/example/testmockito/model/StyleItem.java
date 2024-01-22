package com.example.testmockito.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scm_settings_style_item")
// @Builder
public class StyleItem extends AuditModel {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scm_settings_style")
  @SequenceGenerator(
          name = "scm_settings_style",
          sequenceName = "scm_settings_style",
          initialValue = 1,
          allocationSize = 1)
  private Long id;
  @Column(unique = true)
  private String itemName;

  @Column(unique = true)
  private String itemCode;

  private String itemDescription;
  private String itemUnit;
  private double consumption;
  private String itemColour;
  private String gmtColour;
  private String gmtSize;
  private String gsm;
  private String wastage;
  private boolean status;
}
