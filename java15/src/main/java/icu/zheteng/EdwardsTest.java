package icu.zheteng;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.EdECPoint;
import java.security.spec.EdECPublicKeySpec;
import java.security.spec.NamedParameterSpec;

/**
 * @author yancy
 */

public class EdwardsTest {

    public static void main(String[] args) throws Exception {
        byte[] msg = "20221111".getBytes(StandardCharsets.UTF_8);
        // example: generate a key pair and sign
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
        KeyPair kp = kpg.generateKeyPair();
        // algorithm is pure Ed25519
        Signature sig = Signature.getInstance("Ed25519");
        sig.initSign(kp.getPrivate());
        sig.update(msg);
        byte[] s = sig.sign();
        System.out.println(new String(s));

        System.out.println("-------");

        KeyFactory kf = KeyFactory.getInstance("EdDSA");
        boolean xOdd = true;
        BigInteger y = BigInteger.valueOf(1);
        NamedParameterSpec paramSpec = new NamedParameterSpec("Ed25519");
        EdECPublicKeySpec pubSpec = new EdECPublicKeySpec(paramSpec, new EdECPoint(xOdd, y));
        PublicKey pubKey = kf.generatePublic(pubSpec);
        System.out.println(pubKey);
    }
}
