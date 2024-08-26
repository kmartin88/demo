This project has the purpose to demonstrate how disabling the credentials erasure in an AuthenticationManager is not working.

There is a controller with one GET method which returns the password of the authenticated user. If there is no password in the Authentication object, it returns "no credentials" instead.

Two test classes doing the same test (checking if the returned string from the controller is the password of the given user) but using different SecurityConfigurations:

WorkingSecurityConfig autowires the AuthenticationManagerBuilder and sets eraseCredentials to false.
NotWorkingSecurityConfig creates an AuthenticationManagerBean which is a ProviderManager with eraseCredentialsAfterAuthentication set to false.

Both versions can be found in the official Spring Security documentation: https://docs.spring.io/spring-security/reference/6.2/servlet/authentication/passwords/index.html#customize-global-authentication-manager (also correct for the current version https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html#customize-global-authentication-manager but as this link might point to another version of the documentation in the future I prefer to refer to the one with a version in the URL).

Both tests should pass, but the one with NotWorkingSecurityConfig is failing because the credentials get erased after authentication.