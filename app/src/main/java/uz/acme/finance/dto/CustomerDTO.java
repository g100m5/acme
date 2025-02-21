package uz.acme.finance.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import uz.acme.finance.model.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String patronym;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private BigDecimal balance;
    private Customer.GenderType genderType;
}
