package com.example.weather.entity;

import java.io.Serializable;

public class Weather    implements Serializable{
	private String city;
    private Double temperature;
    private Integer humidity;
    
    public Weather()
    {
    	
    }
    
    
	public Weather(String city, Double temperature, Integer humidity) {
		super();
		this.city = city;
		this.temperature = temperature;
		this.humidity = humidity;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

    
    
    
}
