import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.lang.JoseException;

public class JwtTest {
    public static void main(String[] args) throws JoseException {
        RsaJsonWebKey rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
        final String publicKeyString = rsaJsonWebKey.toJson(JsonWebKey.OutputControlLevel.PUBLIC_ONLY);
        final String privateKeyString = rsaJsonWebKey.toJson(JsonWebKey.OutputControlLevel.INCLUDE_PRIVATE);
        System.out.println(publicKeyString);
        System.out.println(privateKeyString);

        // 公钥
        // {"kty":"RSA","n":"rZiy-p9LTdtUzRvlhihy-7fhEuUCUNUd0bdaqYoFGZg5GpumqEQyHgpzBNQVXjaGHimlKbdcMa7XGR-PV1d4xgp4OOWooR8VDOTyT1Q8feCDeBFKwE4YYopJ4LK1L1jRgSavMXIc5x9qY0vK7LmyMgA5eSssiiIJ-UD442w9aNhhu8BGmiKXUvCLul7digV24nOsmOyI1Ma-S_2tJwexbSQ7G0-qfPwqPfkg2aL6REx2m5RBzR5hW78lpPZw7CD_MVZhlQVjH5WLeZt-2U4Rd-mOALQcut6X7ZKE_6DdUj6eCroj4yQHyiPN_hxwqGE_0dGvlHrhVcwWmKXXrkiQKw","e":"AQAB"}
        // 私钥
        // {"kty":"RSA","n":"rZiy-p9LTdtUzRvlhihy-7fhEuUCUNUd0bdaqYoFGZg5GpumqEQyHgpzBNQVXjaGHimlKbdcMa7XGR-PV1d4xgp4OOWooR8VDOTyT1Q8feCDeBFKwE4YYopJ4LK1L1jRgSavMXIc5x9qY0vK7LmyMgA5eSssiiIJ-UD442w9aNhhu8BGmiKXUvCLul7digV24nOsmOyI1Ma-S_2tJwexbSQ7G0-qfPwqPfkg2aL6REx2m5RBzR5hW78lpPZw7CD_MVZhlQVjH5WLeZt-2U4Rd-mOALQcut6X7ZKE_6DdUj6eCroj4yQHyiPN_hxwqGE_0dGvlHrhVcwWmKXXrkiQKw","e":"AQAB","d":"ThS4MBUVFGxaTLVG_BxWd5UB9fMuovfwpSLw8v_jAlufF7I5-EZQOoXdrSbNg6ZHleqKYOSZ4bjwA9tXqGPuLTmJUKIvwmTOHZIe0QKlAMNKrucsNaoKusvTpe8LosOy3AHv2_AlQum0-vucxvRRS78hGriKHIlp7gREzlohlvW5awIZpkSvR0rge5LKW1fMi1kDqJREjUj_sbuvShbM2OvIXnr-ltX4h0QJnaxcl2xbJKd46E5lhyJLYsdn2OgtA6gBn_5UFjq7AFb_cxUZ-ZP0m5n9vKmjhalSscilYuArlTOSGPdjZxD9geoVIpQFVNPljaw8WphhWzqF8IvPcQ","p":"uUhzVVLqZLTdtTlY_aRnIIbiCfY50R-f1HAHXScnHdfe5YXLOdHOKJ11c9gg3zziVdg2ox7YubVZ6SeejgWmDsyrc0H3uca4LjOQ4fXRm2A0HF8IYulg0UkPf2giGwF_h7WbZfLDH7ZCqj8bIKpuIERF85tmPk6C7-CHMWVytPs","q":"79pi8G6-mZu0p82UXzh2u3QnijoINkAVUrOxWRTLFken0Kat5TjAQ8RMc5cZuSNcreevBABehTKswg_0OsSt-qNeyU-KdVfiiu6l_9X2vWVYYwp5v1hATOvQSjZOqqmpwhxHMk7NR0G-YzoZh229oIDF7kToWF5Wifl1k5TmypE","dp":"jAUzm7yQhFCm6AiRtwUiJlOoyOx6Hw7uI4YSGpS3G_eCbCQjQ-vJB6qPE1-2393MEiHWkImEMTva2bdmPGAKcU69Fto4kv2ZPNkdWZYCtJAMcZBj7xP9Zcv32Unh1FTagr181ZuTWAjN8ojEQHhrxxixYHsE1ntQumUM5giLmjc","dq":"3Z6xKq15KZ_IdgArZyxZ8Ozrl_n1GoNt8GOeq8vdtvFwqwdHyHP-mt8nMOrd1sZI3VskyJK6w2JGZG2vYhnXE66eZ246ZiBVb8AA2_pMqUWaPLEyO04E485EQD4bw-9Ors_ILUDIxl2F2FOXwR3yR_qUaIt9ECHi3kwEit_bvDE","qi":"PC61Py6bbPleUeD0b8c8rsmyE1E-xcnQ-Pdl_4iup3KwsQ2_zBKxoMJyx9Pnmlfv4Xcz50BBSqciS9vDLcG-FZs5XoSNkRRbOeC8g530OHBfEPhHuMBPLFNWqdVofOW1zaIsZkpHEUU-9wpcDAdFqIM0QGuidKGZ-IcwWtxdYXg"}

    }
}
