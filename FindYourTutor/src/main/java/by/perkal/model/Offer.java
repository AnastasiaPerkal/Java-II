package by.perkal.model;

import by.perkal.validator.ContactNumber;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    @Max(value = 255, message = "Description can't be longer that 255 characters")
    @Column
    private String description;

    @NotNull(message = "Number can't be NULL")
    @Max(value = 12, message = "Number can't be longer that 12 characters")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Subject getSubjectEntity() {
        return subjectEntity;
    }

    public void setSubjectEntity(Subject subjectEntity) {
        this.subjectEntity = subjectEntity;
    }

    public User getTutorEntity() {
        return tutorEntity;
    }

    public void setTutorEntity(User tutorEntity) {
        this.tutorEntity = tutorEntity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}