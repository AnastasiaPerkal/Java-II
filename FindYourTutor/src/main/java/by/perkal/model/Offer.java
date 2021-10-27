package by.perkal.model;

import by.perkal.validator.ContactNumber;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Offers")
@Data
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int duration;

    @Column
    private double rating;

    @Column
    private double price;

    @Size(max = 255, message = "Description can't be longer that 255 characters")
    @Column
    private String description;

    @NotEmpty(message = "Number can't be NULL")
    @Size(min = 12, max = 12, message = "Number can't be longer that 12 characters")
    @ContactNumber(message = "{valid.contactnumber.contactnumber}")
    @Column
    private String contactNumber;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subjectEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User tutorEntity;

    @Column
    private Date date;
}