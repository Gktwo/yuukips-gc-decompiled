package emu.grasscutter.auth;

import emu.grasscutter.auth.AuthenticationSystem;

/* loaded from: grasscutter.jar:emu/grasscutter/auth/OAuthAuthenticator.class */
public interface OAuthAuthenticator {

    /* loaded from: grasscutter.jar:emu/grasscutter/auth/OAuthAuthenticator$ClientType.class */
    public enum ClientType {
        DESKTOP,
        MOBILE
    }

    void handleLogin(AuthenticationSystem.AuthenticationRequest authenticationRequest);

    void handleRedirection(AuthenticationSystem.AuthenticationRequest authenticationRequest, ClientType clientType);

    void handleTokenProcess(AuthenticationSystem.AuthenticationRequest authenticationRequest);
}
