package az.company.accounts.mapper;

import az.company.accounts.dao.entity.AccountsEntity;
import az.company.accounts.model.request.AccountsRequest;
import az.company.accounts.model.response.AccountsResponse;
import liquibase.util.StringUtil;
import org.apache.logging.log4j.util.Strings;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

@Mapper
public interface AccountsMapper {
    AccountsMapper MAP = Mappers.getMapper(AccountsMapper.class);

    default AccountsEntity requestToEntity(AccountsRequest request) {
        return AccountsEntity.builder()
                .accountType(request.getAccountType())
                .customerId(request.getCustomerId())
                .branchAddress(request.getBranchAddress())
                .balance(request.getBalance())
                .build();
    }

    default AccountsResponse entityToResponse(AccountsEntity account) {
        return AccountsResponse.builder()
                .createdAt(account.getCreatedAt())
                .customerId(account.getCustomerId())
                .accountType(account.getAccountType())
                .branchAddress(account.getBranchAddress())
                .balance(account.getBalance())
                .build();
    }

    default void updateDesiredEntityField(AccountsEntity account, AccountsRequest request) {
        if (Strings.isNotEmpty(request.getAccountType()) &&
                Strings.isNotBlank(request.getAccountType()))
            account.setAccountType(request.getAccountType());

        if (Strings.isNotEmpty(request.getBranchAddress()) &&
                Strings.isNotBlank(request.getBranchAddress()))
            account.setBranchAddress(request.getBranchAddress());

        if (request.getCustomerId() != null)
            account.setCustomerId(request.getCustomerId());

        if (request.getBalance() != null &&
            request.getBalance().compareTo(BigDecimal.valueOf(0)) > 0)
            account.setBalance(request.getBalance());
    }
}
