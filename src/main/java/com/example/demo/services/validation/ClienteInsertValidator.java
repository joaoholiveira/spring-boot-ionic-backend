package com.example.demo.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.demo.domain.enums.TipoCliente;
import com.example.demo.dto.ClienteNewDTO;
import com.example.demo.resources.exception.FieldMessage;
import com.example.demo.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Override 
    public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) { 
 
        List<FieldMessage> list = new ArrayList<>();        
        
        if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpf_ou_cnpj())) {
			list.add(new FieldMessage("cpf_ou_cnpj", "CPF inválido!")); 
		}
        
        if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpf_ou_cnpj())) {
			list.add(new FieldMessage("cpf_ou_cnpj", "CNPJ inválido!")); 
		}
        
        for (FieldMessage e : list) {
        	context.disableDefaultConstraintViolation();
        	context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();         
        }
        
        
        
        return list.isEmpty();     
    } 
	
	
	} 
