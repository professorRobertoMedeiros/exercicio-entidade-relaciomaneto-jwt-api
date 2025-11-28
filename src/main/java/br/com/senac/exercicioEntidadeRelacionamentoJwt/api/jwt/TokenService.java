package br.com.senac.exercicioEntidadeRelacionamentoJwt.api.jwt;

import br.com.senac.exercicioEntidadeRelacionamentoJwt.api.entidades.Usuarios;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    private String secret = "exercicio-relacionamento-jwt";
    private String withIssuer = "exercicio-relacionamento-jwt-api";

    public String gerarToken(Usuarios usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String tokenJwt =
                    JWT.create()
                            .withIssuer(withIssuer)
                            .withSubject(usuario.getEmail())
                            .withExpiresAt(this.gerarDataValidaToken())
                            .sign(algorithm);
            return tokenJwt;

        } catch (Exception e) {
            throw new RuntimeException("Erro na geração do token!");
        }
    }

    public String validarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(withIssuer)
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (Exception e) {
            return null;
        }
    }

    private Instant gerarDataValidaToken() {
        return LocalDateTime
                .now()
                .plusHours(1)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
