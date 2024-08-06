package com.txrental.tool.controller;


import com.txrental.tool.exception.CustomToolRentalException;
import com.txrental.tool.entity.Tool;
import com.txrental.tool.entity.ToolRental;
import com.txrental.tool.model.Checkout;
import com.txrental.tool.model.RentalAgreement;
import com.txrental.tool.repository.ToolRentalRepository;
import com.txrental.tool.repository.ToolRepository;
import com.txrental.tool.service.ToolRentalService;
import com.txrental.tool.validator.ToolRentalValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller having API's to Get Tool, ToolRentals and Generate Rental Agreement
 */
@RestController
class ToolRentalController {

  @Autowired
  private ToolRepository toolRepository;

	@Autowired
	private ToolRentalRepository toolRentalRepository;

	@Autowired
	private ToolRentalService toolRentalService;

	@Autowired
	ToolRentalValidator Validator;

	private static final Logger log = LoggerFactory.getLogger(ToolRentalController.class);

	/**
	 *  To return all available tools
	 * @return
	 */
	@GetMapping("/tools")
	public List<Tool> listAllToools() {
		return toolRentalService.listAllToools();
	}

	/**
	 * To return tool by code
	 * @param toolCode
	 * @return
	 */
	@GetMapping("/toolByCode")
	public Tool findToolByCode(@RequestParam String toolCode) {
		return toolRentalService.findToolByCode(toolCode);
	}

	/**
	 * To return all tool rentals list
	 * @return
	 */
	@GetMapping("/toolrentals")
	public List<ToolRental> listAllRentals() {
		return toolRentalRepository.findAll();
	}

	/**
	 *  To checkout and generate Rental Agreement for renting tool
	 * @param checkout
	 * @return
	 */
	@PostMapping("/checkout")
	public RentalAgreement checkout(@RequestBody Checkout checkout) throws CustomToolRentalException {
		log.info(checkout.toString());
        return toolRentalService.generateRentalAgreement(checkout);
	}



}
