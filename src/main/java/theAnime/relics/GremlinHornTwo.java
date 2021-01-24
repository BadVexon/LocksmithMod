package theAnime.relics;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.TheAnime;

public class GremlinHornTwo extends AbstractTodoRelic {
    public static final String ID = makeID("GremlinHornTwo");

    public GremlinHornTwo() {
        super(ID, RelicTier.BOSS, LandingSound.CLINK, TheAnime.Enums.LOCKSMITH_COLOR);
    }

    public void onMonsterDeath(AbstractMonster m) {
        if (m.currentHealth == 0 && !AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {// 42
            this.flash();// 43
            this.addToBot(new RelicAboveCreatureAction(m, this));// 44
            this.addToBot(new GainEnergyAction(1));// 45
            this.addToBot(new DrawCardAction(AbstractDungeon.player, 1));// 46
        }
    }
}
