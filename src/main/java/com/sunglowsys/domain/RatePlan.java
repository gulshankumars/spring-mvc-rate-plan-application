package com.sunglowsys.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class RatePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id ;
    private String name ;
    private Integer hotelId ;
    private Integer roomTypeId ;

    public RatePlan(){
        System.out.println("RatePlan object is created :");
    }

    public RatePlan(Integer id, String name, Integer hotelId, Integer roomTypeId) {
        this.id = id;
        this.name = name;
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatePlan ratePlan = (RatePlan) o;
        return Objects.equals(id, ratePlan.id) && Objects.equals(name, ratePlan.name) && Objects.equals(hotelId, ratePlan.hotelId) && Objects.equals(roomTypeId, ratePlan.roomTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hotelId, roomTypeId);
    }

    @Override
    public String toString() {
        return "RatePlan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hotelId=" + hotelId +
                ", roomTypeId=" + roomTypeId +
                '}';
    }
}
