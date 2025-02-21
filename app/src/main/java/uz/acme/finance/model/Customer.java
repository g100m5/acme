package uz.acme.finance.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.TimestampJdbcType;
import org.hibernate.type.descriptor.jdbc.UUIDJdbcType;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customer", schema = "acme_app")
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcType(UUIDJdbcType.class)
    private UUID id;

    private String firstName;
    private String lastName;
    private String patronym;
    private BigDecimal balance;

    private LocalDate dob;

    @Column(name = "gender_type")
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();


    @Column
    private String createdBy;

    @Column(name = "deleted_at")
    @JdbcType(TimestampJdbcType.class)
    private LocalDate deletedAt;

    public Customer(String firstName, String lastName, String patronym, BigDecimal balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronym = patronym;
        this.balance = balance;
    }

    public enum GenderType {
        MALE,
        FEMALE,
        UNKNOWN
    }
}