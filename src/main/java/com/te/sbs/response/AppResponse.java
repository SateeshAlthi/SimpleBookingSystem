package com.te.sbs.response;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppResponse {

		private boolean error;
		private String message;
		private Object data;
		private Integer status;
		private LocalDate date;
		
}
