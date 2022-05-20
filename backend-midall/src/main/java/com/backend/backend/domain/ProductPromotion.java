package com.backend.backend.domain;

import com.backend.backend.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of={"id"})
public class ProductPromotion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate finalDate;
    
    private Boolean isActive;
    
    private String typePromotion;
    
    private Double discount;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "PROMOTION_PRODUCT",
            joinColumns = @JoinColumn(name = "productPromotion_id"),
            inverseJoinColumns = @JoinColumn(name = "Product_id")
    )
    private List<Product> products = new ArrayList<>();

    public ProductPromotion(Integer id,LocalDate startDate, LocalDate finalDate, Boolean isActive, String typePromotion, Double discount) {
        this.id = id;
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.isActive = isActive;
        this.typePromotion =typePromotion;
        this.discount = discount;
    }
}
