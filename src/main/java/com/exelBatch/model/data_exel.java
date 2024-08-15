package com.exelBatch.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="data_exel")
public class data_exel implements Serializable {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String periode;
    private String tgl_generate;
    private String barang_masuk;
    private String barang_keluar;
    private String Pendapatan;
  
}
