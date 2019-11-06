package com.redspace.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redspace.api.domain.CaptionFormat;
import com.redspace.api.domain.CaptionRequirements;
import com.redspace.api.repository.CaptionRequirementsRepository;


@RestController
@RequestMapping("/api")
public class PlatformResource {

	@Autowired
	private CaptionRequirementsRepository captionRequirementsRepository;
	
	@RequestMapping(value = "/caption-requirements/filtered", method = RequestMethod.GET)
	ResponseEntity<List<CaptionFormat>> getCaptionRequirements(@RequestParam String captionRequirementsName){
		
		List<CaptionFormat> captionFormats = new ArrayList();
		captionRequirementsRepository.findByNameIgnoreCaseContaining(captionRequirementsName).forEach(captionRequirement -> {
			CaptionFormat captionFormat = new CaptionFormat();
			captionFormat.setId(captionRequirement.getId());
			captionFormat.setName(captionRequirement.getName());
			captionFormats.add(captionFormat);
		});
		
        return  new ResponseEntity(captionFormats,HttpStatus.OK);
    }
	
	@RequestMapping(value = "/caption-requirements/add", method = RequestMethod.POST)
    ResponseEntity<CaptionFormat> addCaptionRequirementName(@RequestBody CaptionFormat captionFormat){
    	if(captionRequirementsRepository.existsByName(captionFormat.getName())){
    		return new ResponseEntity("Unable to save, name is Existing", HttpStatus.BAD_REQUEST);
    	} else {    		
    		CaptionRequirements captionRequirement = new CaptionRequirements();
    		captionRequirement.setName(captionFormat.getName());
    		captionRequirement = captionRequirementsRepository.save(captionRequirement);
    		captionFormat.setId(captionRequirement.getId());
            return new ResponseEntity<>(captionFormat, HttpStatus.CREATED);
    	}
        
    }
	
	@RequestMapping(value = "/caption-requirements", method = RequestMethod.GET)
	ResponseEntity<List<CaptionRequirements>> getAllCaptionRequirements(){
        return  new ResponseEntity(captionRequirementsRepository.findAll(),HttpStatus.OK);
    }
	
}
