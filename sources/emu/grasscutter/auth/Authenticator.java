package emu.grasscutter.auth;

import emu.grasscutter.auth.AuthenticationSystem;

/* loaded from: grasscutter.jar:emu/grasscutter/auth/Authenticator.class */
public interface Authenticator<T> {
    T authenticate(AuthenticationSystem.AuthenticationRequest authenticationRequest);
}
