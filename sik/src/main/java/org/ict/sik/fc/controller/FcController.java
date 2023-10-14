package org.ict.sik.fc.controller;

import org.ict.sik.fc.model.service.FcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FcController {
	@Autowired
	private FcService fcService;
	
}
