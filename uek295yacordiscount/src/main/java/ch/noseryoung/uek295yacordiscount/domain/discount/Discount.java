package ch.noseryoung.uek295yacordiscount.domain.discount;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Entity
@Getter
@Setter
@Table (name = "discounts")
public class Discount {

    @Id
    @Column (name = "discount_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer discountId;

    @Column
    @Size(min = 6, max = 13)
    private String code;

    @Column(name = "discount")
    @NotNull(message = "Discount must contain a value.")
    @DecimalMax(value = "100")
    @DecimalMin(value = "0.0")
    private double discountInPercent;

    @Column (name = "id_client")
    private Integer clientId;

    @PrePersist
    public void generateCode() {
        String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int index = random.nextInt(alphanumeric.length());
            sb.append(alphanumeric.charAt(index));
        }
        this.code = sb.toString();
    }

}
