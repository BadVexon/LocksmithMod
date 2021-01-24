package theAnime.relics;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardBrieflyEffect;
import theAnime.TheAnime;
import theAnime.cards.AbstractTodoCard;

import java.util.ArrayList;

public class AntiKey extends AbstractTodoRelic {
    public static final String ID = makeID("AntiKey");

    public AntiKey() {
        super(ID, RelicTier.BOSS, LandingSound.CLINK, TheAnime.Enums.LOCKSMITH_COLOR);
    }

    @Override
    public void onEquip() {
        AbstractDungeon.player.energy.energyMaster++;
    }

    @Override
    public void onUnequip() {
        AbstractDungeon.player.energy.energyMaster--;
    }

    @Override
    public void atBattleStartPreDraw() {
        flash();
        ArrayList<AbstractCard> possCardsList = new ArrayList<>(AbstractDungeon.player.drawPile.group);
        for (int i = 0; i < 3; i++) {
            AbstractCard r = possCardsList.get(AbstractDungeon.cardRandomRng.random(possCardsList.size() - 1));
            AbstractTodoCard.lockme(r, 3, true);
            AbstractDungeon.effectList.add(new ShowCardBrieflyEffect(r.makeStatEquivalentCopy()));
        }
    }
}
