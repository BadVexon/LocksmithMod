package theAnime.relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theAnime.TheAnime;
import theAnime.actions.SummonDummyAction;

public class FreeKey extends AbstractTodoRelic {
    public static final String ID = makeID("FreeKey");

    public FreeKey() {
        super(ID, RelicTier.STARTER, LandingSound.CLINK, TheAnime.Enums.LOCKSMITH_COLOR);
    }

    public void atBattleStartPreDraw() {
        this.addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));// 24
        this.addToBot(new SummonDummyAction(SummonDummyAction.DummyTypes.KEYS, 6));
    }// 26
}
