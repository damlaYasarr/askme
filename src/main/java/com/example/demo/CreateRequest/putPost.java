package com.example.demo.CreateRequest;

import lombok.Data;

@Data
public class putPost {
   String title;
   String text;
   
public putPost() {

}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
 
}
