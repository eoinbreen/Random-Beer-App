package com.random.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Beer implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
    
    // Alcohol percentage
    @Column(nullable = false)
    private Float abv;

    @Column(nullable = false)
    private String location;
    
  
    protected Beer() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }

    public Beer(String name, String description, Float abv, String location) {
        this.name = name;
        this.description = description;
        this.abv = abv;
        this.location = location;
        
    }

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getAbv() {
		return abv;
	}

	public void setAbv(Float abv) {
		this.abv = abv;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
