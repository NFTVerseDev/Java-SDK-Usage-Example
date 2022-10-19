package com.onnftverse.v1.develop.controller;

import com.amazonaws.services.inspector2.model.BadRequestException;
import com.nftverse.nftversejavasdk.dto.*;
import com.nftverse.nftversejavasdk.services.SdkService;
import com.onnftverse.v1.develop.DevelopService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping
public class DevelopController {

    private final DevelopService developService;

    public DevelopController(DevelopService developService) {
        this.developService = developService;
    }

    @GetMapping(path = "/v1/testing/asset/{externalAssetId}")
    @ResponseBody
    public AssetsDto getAssetDetails(@PathVariable String externalAssetId, @CurrentlyLoggedUser AppTokenMasterDto appTokenMasterDto) throws Exception, BadRequestException {
        return this.developService.getAssetDetails(externalAssetId, appTokenMasterDto);
    }
    @PostMapping(path = "/v1/testing/user/wallet")
    @ResponseBody
    public CompletableFuture<UserBlockchainAccountDto> getOrSetupExternalWallet(@RequestBody ExternalUserWalletSetupDto externalUserWalletSetupDto, @CurrentlyLoggedUser AppTokenMasterDto appTokenMasterDto) throws Exception {
        //external call validator
        return this.developService.getOrSetupExternalWallet(externalUserWalletSetupDto, appTokenMasterDto);
    }
}
