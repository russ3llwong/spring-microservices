package com.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.exception.CurrencyNotFoundException;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// to get the port while application is running
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		from = from.toUpperCase();
		to = to.toUpperCase();
		
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		
		if (exchangeValue == null) {
			throw new CurrencyNotFoundException("Conversion for this currency is not supported.");
		} else {
			exchangeValue.setPort(
					Integer.parseInt(environment.getProperty("local.server.port")));
			
			logger.info("{}", exchangeValue);
			
			return exchangeValue;
		}
	}
	
	
	
}
