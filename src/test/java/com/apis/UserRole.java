package com.apis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRole {
	
	private int id;
    private String role;
    private String name;
    private String status;
    private String created_at;
    private String updated_at;
    private Pivot pivot;
	

}
