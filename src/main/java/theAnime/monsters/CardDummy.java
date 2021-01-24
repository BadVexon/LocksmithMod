package theAnime.monsters;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;
import theAnime.powers.PlayCardOnDeathPower;

public class CardDummy extends AbstractDummy {
    public static String ID = AnimeMod.makeID("CardDummy");
    private AbstractCard myCard;

    public CardDummy(float x, float y, int hp, AbstractCard card) {
        super(ID, x, y, hp);
        myCard = card;
        myColor = AbstractDungeon.player.getCardTrailColor().cpy();
    }

    @Override
    public void usePreBattleAction() {
        applyToSelf(new PlayCardOnDeathPower(this, myCard));
    }

    @Override
    public AbstractMonster makeCopy() {
        return new CardDummy(x2, y2, basehp, myCard);
    }
}
