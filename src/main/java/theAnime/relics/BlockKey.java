package theAnime.relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theAnime.TheAnime;
import theAnime.actions.SummonDummyAction;

public class BlockKey extends AbstractTodoRelic {
    public static final String ID = makeID("BlockKey");

    public BlockKey() {
        super(ID, RelicTier.COMMON, LandingSound.FLAT, TheAnime.Enums.LOCKSMITH_COLOR);
    }

    public void atBattleStartPreDraw() {
        this.addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));// 24
        this.addToBot(new SummonDummyAction(SummonDummyAction.DummyTypes.BLOCK, 12, 8));
    }// 26
}
