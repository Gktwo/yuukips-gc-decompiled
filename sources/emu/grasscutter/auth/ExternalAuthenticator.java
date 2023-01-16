package emu.grasscutter.auth;

import emu.grasscutter.auth.AuthenticationSystem;

/* loaded from: grasscutter.jar:emu/grasscutter/auth/ExternalAuthenticator.class */
public interface ExternalAuthenticator {
    void handleLogin(AuthenticationSystem.AuthenticationRequest authenticationRequest);

    void handleAccountCreation(AuthenticationSystem.AuthenticationRequest authenticationRequest);

    void handlePasswordReset(AuthenticationSystem.AuthenticationRequest authenticationRequest);
}
