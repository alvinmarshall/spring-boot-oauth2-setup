package com.cheise_proj.authorizationserver.repository;

import com.cheise_proj.authorizationserver.domain.model.AppClient;
import org.springframework.lang.Nullable;

public interface ClientRepository {
    void save(AppClient var1);

    @Nullable
    AppClient findById(String var1);

    @Nullable
    AppClient findByClientId(String var1);
}
