package com.onnftverse.v1.develop;


import com.nftverse.nftversejavasdk.dto.AppTokenMasterDto;
import com.nftverse.nftversejavasdk.dto.AssetsDto;
import com.nftverse.nftversejavasdk.dto.ExternalUserWalletSetupDto;
import com.nftverse.nftversejavasdk.dto.UserBlockchainAccountDto;
import com.nftverse.nftversejavasdk.services.APICallHelper;
import com.nftverse.nftversejavasdk.services.SdkService;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;
import java.util.concurrent.CompletableFuture;

@Service
public class DevelopService {
    public APICallHelper apiCallHelper;
    public Environment env;
    private SdkService sdkService=new SdkService(env);

    public AssetsDto getAssetDetails(String externalAssetId, AppTokenMasterDto appTokenMasterDto) throws Exception {
        return this.sdkService.getAssetDetails(externalAssetId,appTokenMasterDto);
    }

    public CompletableFuture<UserBlockchainAccountDto> getOrSetupExternalWallet(ExternalUserWalletSetupDto externalUserWalletSetupDto, AppTokenMasterDto appTokenMasterDto) {
        return this.sdkService.getOrSetupExternalWallet(externalUserWalletSetupDto, appTokenMasterDto);
    }

}
