package theAnime.relics;

import com.megacrit.cardcrawl.cards.AbstractCard;
import theAnime.AnimeMod;
import theAnime.TheAnime;

public class MeanKey extends AbstractTodoRelic {
    public static final String ID = makeID("MeanKey");

    public MeanKey() {
        super(ID, RelicTier.UNCOMMON, LandingSound.MAGICAL, TheAnime.Enums.LOCKSMITH_COLOR);
    }

    @Override
    public float atDamageModify(float damage, AbstractCard c) {
        return c.hasTag(AnimeMod.KEY) ? damage + 2.0F : damage;// 20 21
    }
}
