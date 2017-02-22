package com.group.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compact_discs")
public class CompactDisc implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "title")
	private String title;
	@Column(name = "artist")
	private String artist;
	@Column(name = "tracks")
	private Integer tracks;
	@Column(name = "price")
	private Double price;
	
	public CompactDisc()
	{
		
	}
	
	public CompactDisc(Integer id, String title, String artist, Integer tracks, Double price) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.tracks = tracks;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public Integer getTracks() {
		return tracks;
	}
	public void setTracks(Integer tracks) {
		this.tracks = tracks;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}


}
