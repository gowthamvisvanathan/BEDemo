package com.sdd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppResponse {
	private int code;
	private String message;
	private Object data;
	private Object error;
}
