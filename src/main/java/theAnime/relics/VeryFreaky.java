package theAnime.relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theAnime.AnimeMod;
import theAnime.TheAnime;
import theAnime.actions.SummonDummyAction;

public class VeryFreaky extends AbstractTodoRelic {
    public static final String ID = makeID("VeryFreaky");

    public VeryFreaky() {
        super(ID, RelicTier.BOSS, LandingSound.CLINK, TheAnime.Enums.LOCKSMITH_COLOR);
    }

    public void atBattleStart() {
        this.counter = 0;// 21
    }// 22

    public void atTurnStart() {
        ++this.counter;// 27

        if (this.counter % 2 == 0) {// 29
            this.flash();// 30
            this.addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));// 31
            this.addToBot(new SummonDummyAction(SummonDummyAction.DummyTypes.KEYS, 6));
        }

    }// 36

    public void onVictory() {
        this.counter = -1;// 39
    }// 41

    @Override
    public void obtain() {
        if (AbstractDungeon.player.hasRelic(FreeKey.ID)) {// 52
            for (int i = 0; i < AbstractDungeon.player.relics.size(); ++i) {// 53
                if (AbstractDungeon.player.relics.get(i).relicId.equals(FreeKey.ID)) {// 54
                    this.instantObtain(AbstractDungeon.player, i, true);// 55
                    break;// 56
                }
            }
        } else {
            super.obtain();// 60
        }
    }// 62

    @Override
    public boolean canSpawn() {
        return (AbstractDungeon.player.hasRelic(FreeKey.ID));
    }

    @Override
    public String getUpdatedDescription() {
        String name = (new FreeKey()).name;// 38
        StringBuilder sb = new StringBuilder();// 39
        String[] var3 = name.split(" ");

        for (String word : var3) {// 40
            sb.append("[#").append(AnimeMod.todoColor.toString()).append("]").append(word).append("[] ");// 41
        }

        sb.setLength(sb.length() - 1);// 43
        sb.append("[#").append(AnimeMod.todoColor.toString()).append("]");// 44
        return this.DESCRIPTIONS[0] + sb.toString() + this.DESCRIPTIONS[1];// 46
    }
}
