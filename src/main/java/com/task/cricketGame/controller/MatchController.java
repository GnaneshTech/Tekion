package com.task.cricketGame.controller;

import com.task.cricketGame.WebModel.MatchesWebModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.cricketGame.Response;
import com.task.cricketGame.service.MatchService;

@RestController
@RequestMapping("api/matches")
public class MatchController {
	
	@Autowired
	MatchService matchService;
	
	@PostMapping("/startMatch")
	public ResponseEntity<?> startMatch(@RequestBody MatchesWebModel matchesWebModel){
		try {
			return matchService.startMatch(matchesWebModel);
		}catch(Exception e) {
			e.printStackTrace();
			 return ResponseEntity.ok(new Response("Exception in Controller",e.getMessage()));
		}
	}

}
