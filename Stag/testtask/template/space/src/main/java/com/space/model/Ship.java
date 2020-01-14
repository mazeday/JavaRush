package com.space.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ship")
@JsonPropertyOrder({ "id", "name", "planet", "shipType", "prodDate", "isUsed", "speed", "crewSize", "rating" })
public class Ship {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude
    Long id; //ID корабля

    @Column(name = "name")
    @JsonInclude
    String name; //Название корабля (до 50 знаков включительно)

    @Column(name = "planet")
    @JsonInclude
    String planet; //Планета пребывания (до 50 знаков включительно)

    @Column(name = "shipType")
    @Enumerated(EnumType.STRING)
    @JsonInclude
    ShipType shipType; //Тип корабля

    @Column(name = "prodDate")
    @Temporal(TemporalType.DATE)
    @JsonInclude
    Date prodDate; //Дата выпуска.  Диапазон значений года 2800..3019 включительн

    @Column(name = "isUsed")
    @JsonInclude
    Boolean isUsed; //Использованный / новый

    @Column(name = "speed")
    @JsonInclude
    Double speed; //Максимальная скорость корабля. Диапазон значений 0,01..0,99 включительно. Используй математическое округление до сотых.

    @Column(name = "crewSize")
    @JsonInclude
    Integer crewSize; //Количество членов экипажа. Диапазон значений 1..9999 включительно.

    @Column(name = "rating")
    @JsonInclude
    Double rating; //Рейтинг корабля. Используй математическое округление до сотых.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public Date getProdDate() {
        return prodDate;
    }

    public void setProdDate(Date prodDate) {
        this.prodDate = prodDate;
    }

    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean used) {
        isUsed = used;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(Integer crewSize) {
        this.crewSize = crewSize;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating() {
        double k = 1;
        if (this.isUsed) k = 0.5;
        this.rating = Math.round(((80 * this.speed * k) / (3020 - (this.getProdDate().getYear() + 1900))) * 100.0) / 100.0 ;
    }
}
