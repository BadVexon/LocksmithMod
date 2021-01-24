package theAnime.relics;

import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theAnime.TheAnime;
import theAnime.actions.SummonDummyAction;
import theAnime.cards.Key;

public class EmptyKey extends AbstractTodoRelic {
    public static final String ID = makeID("EmptyKey");

    public EmptyKey() {
        super(ID, RelicTier.SHOP, LandingSound.CLINK, TheAnime.Enums.LOCKSMITH_COLOR);
    }

    @Override
    public void atBattleStartPreDraw() {
        this.addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));// 24
        this.addToBot(new MakeTempCardInHandAction(new Key()));// 25
    }

    @Override
    public void onEquip() {
        BaseMod.MAX_HAND_SIZE += 5;
    }

    @Override
    public void onUnequip() {
        BaseMod.MAX_HAND_SIZE -= 5;
    }

    @Override
    public int getPrice() {
        return super.getPrice() / 2;
    }
}
