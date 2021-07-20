package com.kumar.registrationService.cqrs.command.interceptor;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.kumar.registrationService.cqrs.command.CreateSellerCommand;
import com.kumar.registrationService.entity.SellerLookUpEntity;
import com.kumar.registrationService.repository.SellerLookUpRepository;

@Component
public class CreateSellerCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

	private final SellerLookUpRepository sellerLookUpRepository;

	public CreateSellerCommandInterceptor(SellerLookUpRepository sellerLookUpRepository) {
		this.sellerLookUpRepository = sellerLookUpRepository;
	}

	@Override
	public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(
			List<? extends CommandMessage<?>> messages) {
		// TODO Auto-generated method stub
		return (index, command) -> {
			if (CreateSellerCommand.class.equals(command.getPayloadType())) {
				CreateSellerCommand createSellerCommand = (CreateSellerCommand) command.getPayload();
				Optional<SellerLookUpEntity> findById = sellerLookUpRepository.findById(createSellerCommand.getId());
				if (findById.isPresent()) {
					throw new IllegalStateException(
							String.format("Product id %s is already present", createSellerCommand.getId()));
				}
				if (StringUtils.isEmpty(createSellerCommand.getEmailId())) {
					throw new IllegalArgumentException("Email Invalid");
				}
			}
			return command;
		};
	}

}
