package eTicaretOdev.core;

import eTicaretOdev.validator.EDevletValidatorManager;

public class EDevletValidatorManagerAdapter implements ValidatorService {

	@Override
	public void validateSystem(String message) {
		EDevletValidatorManager manager = new EDevletValidatorManager();
		manager.validate(message);
	
	}

}
