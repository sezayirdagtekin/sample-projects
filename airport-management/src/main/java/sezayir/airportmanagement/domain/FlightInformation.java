package sezayir.airportmanagement.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document("flights")
public class FlightInformation {
    @Id
    private String id;

    @Field("departure")
    @TextIndexed
    private String departureCity;

    @Field("destination")
    @TextIndexed
    private String destinationCity;

    @TextIndexed(weight = 2)
    private String description;

    private FlightType type;
    private boolean isDelayed;
    private int durationMin;
    private LocalDate departureDate;
    
    private Aircraft aircraft;
    
    private List<Crew>  crew;

    @Transient
    private LocalDate createdAt;

    public FlightInformation() {
        this.createdAt = LocalDate.now();
  
    }


}
