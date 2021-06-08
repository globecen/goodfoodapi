package org.goodfood2.utils;

import io.smallrye.jwt.build.Jwt;

import org.wildfly.security.password.PasswordFactory;
import org.wildfly.security.password.interfaces.BCryptPassword;
import org.wildfly.security.password.util.ModularCrypt;
import org.wildfly.security.password.Password;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Outils lies a la securite.
 */
public class SecurityUtils {

    /**
     * Genere un token pour un utilisateur.
     * 
     * @param duration La duree de validite du token.
     * @param email    Le mail de l utilisateur.
     * @param id       L id de l utilisateur.
     * @param role     Les droits de l utilisateur.
     * @return Le token.
     * @throws Exception
     */
    public static String generateTokenSmallRye(Long duration, String email, int id, String role) throws Exception {
        String token = Jwt.issuer("https://localhost:8080/issuer").upn(email).expiresIn(duration)
                .groups(new HashSet<>(Arrays.asList(role))).claim("duration", duration).claim("email", email)
                .claim("id", id).claim("role", role).sign();
        return token;
    }

    /**
     * Verifie la correspondance d un mot de passe et d un hash.
     * 
     * @param originalPwd  Le mot de passe a verifier.
     * @param encryptedPwd Le mot de passe hash.
     * @return True si les deux correspondent.
     * @throws Exception
     */
    public static boolean verifyPassword(String originalPwd, String encryptedPwd) throws Exception {
        Password rawPassword = ModularCrypt.decode(encryptedPwd);
        PasswordFactory factory = PasswordFactory.getInstance(BCryptPassword.ALGORITHM_BCRYPT);
        BCryptPassword restored = (BCryptPassword) factory.translate(rawPassword);
        return factory.verify(restored, originalPwd.toCharArray());
    }

}
