package emu.grasscutter.auth;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.auth.DefaultAuthenticators;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.game.Account;
import emu.grasscutter.server.http.objects.ComboTokenResJson;
import emu.grasscutter.server.http.objects.LoginResultJson;
import emu.grasscutter.utils.Language;

/* loaded from: grasscutter.jar:emu/grasscutter/auth/DefaultAuthentication.class */
public final class DefaultAuthentication implements AuthenticationSystem {
    private Authenticator<LoginResultJson> passwordAuthenticator;
    private Authenticator<LoginResultJson> tokenAuthenticator = new DefaultAuthenticators.TokenAuthenticator();
    private Authenticator<ComboTokenResJson> sessionKeyAuthenticator = new DefaultAuthenticators.SessionKeyAuthenticator();
    private ExternalAuthenticator externalAuthenticator = new DefaultAuthenticators.ExternalAuthentication();
    private OAuthAuthenticator oAuthAuthenticator = new DefaultAuthenticators.OAuthAuthentication();

    public DefaultAuthentication() {
        if (Configuration.ACCOUNT.EXPERIMENTAL_RealPassword) {
            this.passwordAuthenticator = new DefaultAuthenticators.ExperimentalPasswordAuthenticator();
        } else {
            this.passwordAuthenticator = new DefaultAuthenticators.PasswordAuthenticator();
        }
    }

    @Override // emu.grasscutter.auth.AuthenticationSystem
    public void createAccount(String username, String password) {
    }

    @Override // emu.grasscutter.auth.AuthenticationSystem
    public void resetPassword(String username) {
    }

    @Override // emu.grasscutter.auth.AuthenticationSystem
    public Account verifyUser(String details) {
        Grasscutter.getLogger().info(Language.translate("messages.dispatch.authentication.default_unable_to_verify", new Object[0]));
        return null;
    }

    @Override // emu.grasscutter.auth.AuthenticationSystem
    public Authenticator<LoginResultJson> getPasswordAuthenticator() {
        return this.passwordAuthenticator;
    }

    @Override // emu.grasscutter.auth.AuthenticationSystem
    public Authenticator<LoginResultJson> getTokenAuthenticator() {
        return this.tokenAuthenticator;
    }

    @Override // emu.grasscutter.auth.AuthenticationSystem
    public Authenticator<ComboTokenResJson> getSessionKeyAuthenticator() {
        return this.sessionKeyAuthenticator;
    }

    @Override // emu.grasscutter.auth.AuthenticationSystem
    public ExternalAuthenticator getExternalAuthenticator() {
        return this.externalAuthenticator;
    }

    @Override // emu.grasscutter.auth.AuthenticationSystem
    public OAuthAuthenticator getOAuthAuthenticator() {
        return this.oAuthAuthenticator;
    }
}
